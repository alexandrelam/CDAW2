function validate_iban(iban) {
  const ibanRegex = new RegExp(
    /[A-Z]{2}\d{2} ?\d{4} ?\d{4} ?\d{4} ?\d{4} ?[\d]{0,2}/,
    "g"
  );
  return ibanRegex.test(iban);
}

module.exports = validate_iban;
