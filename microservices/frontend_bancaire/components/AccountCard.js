export default function CardAccount({ id, iban, amount }) {
  return (
    <div>
      <h3>{id}</h3>
      <div>{iban}</div>
      <div>{amount}</div>
    </div>
  );
}
