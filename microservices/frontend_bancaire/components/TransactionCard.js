import { centsToPrice } from "../utils/helper";
export default function TransactionCard({ iban, receiver, sender, amount }) {
  return (
    <div>
      {iban === receiver.iban ? (
        <div className="transaction credit">
          {sender.iban} --> {receiver.iban} : {centsToPrice(amount)} €
        </div>
      ) : (
        <div className="transaction debit">
          {sender.iban} --> {receiver.iban} : -{centsToPrice(amount)} €
        </div>
      )}
    </div>
  );
}
