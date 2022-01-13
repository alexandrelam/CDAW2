package imt.nord.europe.hibernate.service;

import com.google.gson.Gson;
import imt.nord.europe.hibernate.model.AccountModel;
import imt.nord.europe.hibernate.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class AccountService {
    @Autowired
    private final AccountRepository accountRepository;

    private final RabbitTemplate rabbitTemplate;

    public Iterable<AccountModel> findAll() {
        return accountRepository.findAll();
    }

    public String create(AccountModel accountModel) {
        /*
         * MultiValueMap<String, String> map = new LinkedMultiValueMap<String,
         * String>();
         * map.add("iban", accountModel.getIban());
         * HttpHeaders headers = new HttpHeaders();
         * headers.setContentType(MediaType.APPLICATION_JSON);
         * HttpEntity<MultiValueMap<String, String>> requeteHttp = new
         * HttpEntity<MultiValueMap<String, String>>(map, headers);
         * String uri = "http://app-iban:8085/verify/iban";
         * RestTemplate restTemplate = new RestTemplate();
         * String response = restTemplate.postForObject(uri, requeteHttp, String.class);
         * Gson gson = new Gson();
         * Map parsedResponse = gson.fromJson(response, Map.class);
         * System.out.println(parsedResponse);
         * if (parsedResponse.get("isValid").equals(false)) {
         * accountRepository.save(accountModel);
         * return "Account with id " + accountModel.getAccountId() + " created!";
         * }
         * return "Account not created";
         */

        Map<String, String> payload = new HashMap<>();
        payload.put("iban", accountModel.getIban());
        payload.put("amountInCents", accountModel.getAmountInCents().toString());

        Gson gson = new Gson();

        String output = gson.toJson(payload);

        rabbitTemplate.convertAndSend("account-validate-queue", output.toString());

        return "creating account...";
    }


}
