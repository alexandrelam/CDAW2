import { useRouter } from "next/router";

export default function AccountCard({ id, iban, amount }) {
  const router = useRouter();
  return (
    <div className="account-card">
      <div className="title">{id}</div>
      <div>IBAN : {iban}</div>
      <div>Solde : {amount} €</div>
      <button onClick={() => router.push(`/${id}?iban=${iban}`)}>
        See transaction
      </button>
    </div>
  );
}
