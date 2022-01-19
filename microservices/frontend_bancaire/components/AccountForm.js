import { useState } from "react";

export default function AccountForm() {
  function createAccount() {
    const account = { iban: iban, amountInCents: balance };
    fetch(`http://localhost:8084/api/v1/account`, {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(account),
    });
  }
  const [iban, setIban] = useState("");
  const [balance, setBalance] = useState(0);
  return (
    <div>
      <label>Account IBAN</label>
      <input type="text" onChange={(e) => setIban(e.target.value)} />
      <label>Account balance</label>
      <input type="number" onChange={(e) => setBalance(e.target.value)} />
      <button onClick={createAccount}>Créer</button>
    </div>
  );
}
