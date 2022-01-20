import { useState } from "react";
import { centsToPrice, makeTransaction } from "../utils/helper";

export default function TransactionForm() {
  const handleTransaction = () => {
    makeTransaction(sender, receiver, centsToPrice(montant))
      .then((res) => {
        console.log(res);
      })
      .catch(console.log);
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
      <label>Montant</label>
      <input type="number" onChange={(e) => setMontant(e.target.value)} />
      <button onClick={handleTransaction}>Créer transaction</button>
    </div>
  );
}
