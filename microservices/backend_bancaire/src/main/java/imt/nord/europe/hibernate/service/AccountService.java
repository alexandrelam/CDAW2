package imt.nord.europe.hibernate.service;

import com.google.gson.Gson;
import imt.nord.europe.hibernate.model.AccountModel;
import imt.nord.europe.hibernate.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {
    @Autowired
    private final AccountRepository accountRepository;

    public Iterable<AccountModel> findAll() {
        return accountRepository.findAll();
    }

    public String create(AccountModel accountModel) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("iban", accountModel.getIban());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        String uri = "http://app-iban:8085/verify/iban";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(uri, requeteHttp, String.class);
        Gson gson = new Gson();
        Map parsedResponse = gson.fromJson(response, Map.class);
        System.out.println(parsedResponse);
        if (parsedResponse.get("isValid").equals(false)) {
            accountRepository.save(accountModel);
            return "Account with id " + accountModel.getAccountId() +  " created!";
        }
        return "Account not created";
    }
}
