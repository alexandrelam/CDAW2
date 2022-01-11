const express = require("express");

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
  const ibanRegex = new RegExp(
    /[A-Z]{2}\d{2} ?\d{4} ?\d{4} ?\d{4} ?\d{4} ?[\d]{0,2}/,
    "g"
  );
  if (!payload.iban) {
    return res.status(400).send({
      message: "Payload not valid! Should have 'iban' key.",
    });
  }
  if (ibanRegex.test(payload.iban)) {
    response.isValid = true;
  }
  return res.json(response);
});

app.listen(PORT, HOST);
console.log(`Running on http://${HOST}:${PORT}`);
