const express = require("express");
const validate_iban = require("./validate.js");

// Constants
const PORT = 8085;
const HOST = "0.0.0.0";

// App
const app = express();

app.use(express.json());
app.use(
  express.urlencoded({
    extended: true,
  })
);

app.post("/verify/iban", (req, res) => {
  const payload = req.body;
  let response = { isValid: false };

  if (!payload.iban) {
    return res.status(400).send({
      message: "Payload not valid! Should have 'iban' key.",
    });
  }

  if (validate_iban(payload.iban)) {
    response.isValid = true;
  }
  return res.json(response);
});

app.listen(PORT, HOST);
console.log(`Running on http://${HOST}:${PORT}`);
