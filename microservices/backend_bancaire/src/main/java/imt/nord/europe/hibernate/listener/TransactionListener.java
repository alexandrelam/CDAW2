package imt.nord.europe.hibernate.listener;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import imt.nord.europe.hibernate.model.AccountModel;
import imt.nord.europe.hibernate.model.TransactionModel;
import imt.nord.europe.hibernate.repository.AccountRepository;
import imt.nord.europe.hibernate.repository.TransactionRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TransactionListener {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransactionRepository transactionRepository;

    @RabbitListener(queues = "transaction-create-queue")
    public void listen(String in) {
        System.out.println("Message read from myQueue : " + in);
        JsonObject map = new Gson().fromJson(in, JsonObject.class);
        AccountModel sender = accountRepository.findFirstByIban(map.get("sender_iban").getAsString());
        AccountModel receiver = accountRepository.findFirstByIban(map.get("receiver_iban").getAsString());
        TransactionModel newTransaction = new TransactionModel(sender, receiver, map.get("amountInCents").getAsInt());
        System.out.println(sender);
        System.out.println(receiver);
        System.out.println(map.get("amountInCents").getAsInt());
        transactionRepository.save(newTransaction);
    }

}
