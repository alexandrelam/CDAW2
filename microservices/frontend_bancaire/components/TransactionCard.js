export default function TransactionCard({ iban, receiver, sender, amount }) {
  return (
    <div>
      {iban === receiver.iban ? (
        <div className="credit">
          {sender.iban} --> {receiver.iban} : {amount} €
        </div>
      ) : (
        <div className="debit">
          {sender.iban} --> {receiver.iban} : -{amount} €
        </div>
      )}
    </div>
  );
}
