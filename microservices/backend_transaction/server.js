const express = require("express");
amqp = require("amqplib/callback_api");

// Constants
const PORT = 8086;
const HOST = "0.0.0.0";

// App
const app = express();
var cors = require("cors");
app.use(cors());
app.use(express.json());
app.use(
  express.urlencoded({
    extended: true,
  })
);

const corsOptions = {
  origin: "http://localhost:3000",
  optionsSuccessStatus: 200, // some legacy browsers (IE11, various SmartTVs) choke on 204
};
app.post("/transaction", cors(corsOptions), (req, res) => {
  const payload = req.body;

  if (!payload.sender_iban || !payload.receiver_iban) {
    return res.status(400).send("incorrect payload");
  }

  if (!payload.amountInCents) payload.amountInCents = 0;

  amqp.connect("amqp://rabbitmq", function (error0, connection) {
    if (error0) {
      throw error0;
    }
    connection.createChannel(function (error1, channel) {
      if (error1) {
        throw error1;
      }
      const queue = "transaction-validate-queue";

      channel.assertQueue(queue, {
        durable: false,
      });

      channel.sendToQueue(queue, Buffer.from(JSON.stringify(payload)));
      console.log(" [x] Sent %s to be validated", payload);
    });
  });

  return res.send("making transaction...");
});

app.listen(PORT, HOST);
console.log(`Running on http://${HOST}:${PORT}`);
