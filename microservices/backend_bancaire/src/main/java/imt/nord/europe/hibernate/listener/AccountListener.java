package imt.nord.europe.hibernate.listener;

import com.google.gson.Gson;
import imt.nord.europe.hibernate.model.AccountModel;
import imt.nord.europe.hibernate.repository.AccountRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AccountListener {
    @Autowired
    AccountRepository accountRepository;

    @RabbitListener(queues = "account-create-queue")
    public void listen(String in) {
        System.out.println("Message read from myQueue : " + in);
        Gson gson = new Gson();
        Map map = gson.fromJson(in, Map.class);
        AccountModel newAccount = new AccountModel(map.get("iban").toString(), Integer.parseInt(map.get("amountInCents").toString()));
        accountRepository.save(newAccount);
    }

}
