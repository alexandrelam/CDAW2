export const makeTransaction = (sender_iban, receiver_iban, amountInCents) => {
  return new Promise((resolve, reject) => {
    fetch("http://localhost:8086/transaction", {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      method: "POST",
      body: JSON.stringify({ sender_iban, receiver_iban, amountInCents }),
    })
      .then(resolve)
      .catch(reject);
  });
};

export const centsToPrice = (priceInCents) => priceInCents / 100;

export const priceToCents = (price) => price * 100;
