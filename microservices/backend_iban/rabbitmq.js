const validate_iban = require("./validate.js");
const amqp = require("amqplib/callback_api");

console.log("starting iban validate rabbitmq");

amqp.connect("amqp://rabbitmq", function (error0, connection) {
  if (error0) {
    throw error0;
  }

  connection.createChannel(function (error1, channel) {
    if (error1) {
      throw error1;
    }

    channel.assertQueue("transaction-validate-queue", {
      durable: false,
    });

    channel.assertQueue("account-validate-queue", {
      durable: false,
    });

    channel.consume(
      "transaction-validate-queue",
      function (msg) {
        const payload = JSON.parse(msg.content.toString());

        console.log(" [x] Received %s", msg.content.toString());
        if (
          validate_iban(payload.sender_iban) &&
          validate_iban(payload.receiver_iban)
        ) {
          channel.sendToQueue(
            "transaction-create-queue",
            Buffer.from(JSON.stringify(payload))
          );
          console.log("iban valid! sending message to create account");
        } else {
          console.log("payload not valid!");
        }
      },
      {
        noAck: true,
      }
    );

    channel.consume(
      "account-validate-queue",
      function (msg) {
        const payload = JSON.parse(msg.content.toString());
        console.log(" [x] Received %s", msg.content.toString());
      },
      {
        noAck: true,
      }
    );
  });
});
