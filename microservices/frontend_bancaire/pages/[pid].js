import { useRouter } from "next/router";
import { useEffect } from "react";

export default function Transactions() {
  let transactions;
  const router = useRouter();
  const { pid } = router.query;
  useEffect(() => {
    fetch(`http://localhost:8084/api/v1/account/${pid}/transactions`)
      .then((res) => res.json())
      .then((val) => (transactions = val))
      .then(() => {
        console.log(transactions);
      });
  });

  return <div>val</div>;
}
