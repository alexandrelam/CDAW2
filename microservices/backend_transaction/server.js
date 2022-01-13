const express = require("express");
amqp = require("amqplib/callback_api");

// Constants
const PORT = 8086;
const HOST = "0.0.0.0";

// App
const app = express();

app.use(express.json());
app.use(
  express.urlencoded({
    extended: true,
  })
);

app.post("/transaction", (req, res) => {
  const payload = req.body;

  if (!payload.sender || !payload.receiver || !payload.amountInCents)
    return res.status(400).send("incorrect payload");

  amqp.connect("amqp://rabbitmq", function (error0, connection) {
    if (error0) {
      throw error0;
    }
    connection.createChannel(function (error1, channel) {
      if (error1) {
        throw error1;
      }
      const queue = "make_transaction";

      channel.assertQueue(queue, {
        durable: false,
      });

      channel.sendToQueue(queue, Buffer.from(JSON.stringify(payload)));
      console.log(" [x] Sent %s", payload);
    });
  });

  return res.send("making transaction...");
});

app.listen(PORT, HOST);
console.log(`Running on http://${HOST}:${PORT}`);
