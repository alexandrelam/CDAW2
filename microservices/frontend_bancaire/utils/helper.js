export const makeTransaction = (sender_iban, receiver_iban, amountInCents) => {
  return new Promise((resolve, reject) => {
    fetch("http://localhost:8086/transaction", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ sender_iban, receiver_iban, amountInCents }),
    })
      .then(resolve)
      .catch(reject);
  });
};

export const centsToPrice = (priceInCents) => priceInCents / 100;

export const priceToCents = (price) => price * 100;
