package imt.nord.europe.hibernate.listener;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import imt.nord.europe.hibernate.model.AccountModel;
import imt.nord.europe.hibernate.repository.AccountRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class AccountListener{
    @Autowired
    AccountRepository accountRepository;

    @RabbitListener(queues = "account-create-queue")
    public void listen(String in) {
        System.out.println("Message read from myQueue : " + in);
        JsonObject map = new Gson().fromJson(in, JsonObject.class);
        AccountModel newAccount = new AccountModel(map.get("iban").getAsString(), map.get("amountInCents").getAsInt());
        accountRepository.save(newAccount);
    }

}
