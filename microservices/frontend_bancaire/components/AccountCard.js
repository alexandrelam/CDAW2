import Link from "next/link";

export default function AccountCard({ id, iban, amount }) {
  return (
    <Link href={`/${id}?iban=${iban}`}>
      <div className="account-card">
        <div className="account-title">{id}</div>
        <div>IBAN : {iban}</div>
        <div>Solde : {amount} €</div>
      </div>
    </Link>
  );
}
