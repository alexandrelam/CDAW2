import { useState } from "react";
import { priceToCents, makeTransaction } from "../utils/helper";

export default function TransactionForm() {
  const handleTransaction = (count) => {
    for (let i = 0; i < count; i++) {
      makeTransaction(sender, receiver, priceToCents(montant))
        .then((res) => {
          console.log(res);
        })
        .catch(console.log);
    }
  };

  const [sender, setSender] = useState("");
  const [receiver, setReceiver] = useState("");
  const [montant, setMontant] = useState(0);

  return (
    <div className="form">
      <label>Iban sender</label>
      <input type="text" onChange={(e) => setSender(e.target.value)} />
      <label>Iban receiver</label>
      <input type="text" onChange={(e) => setReceiver(e.target.value)} />
      <label>Montant (en €)</label>
      <input type="number" onChange={(e) => setMontant(e.target.value)} />
      <button onClick={() => handleTransaction(1)}>Créer transaction</button>
      <button onClick={() => handleTransaction(1000)}>
        Créer 1000 transaction
      </button>
    </div>
  );
}
