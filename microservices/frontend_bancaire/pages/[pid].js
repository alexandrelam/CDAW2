import { useRouter } from "next/router";
import { useState, useEffect } from "react";
import TransactionList from "../components/TransactionList";

export default function Transactions() {
  const router = useRouter();
  const { pid, iban } = router.query;
  const [isBadPid, setIsBadPid] = useState(false);
  useEffect(() => {
    fetch(`http://localhost:8084/api/v1/account/${pid}/transactions`)
      .then((res) => res.json())
      .then((res) => {
        if (res.status == 400) {
          setIsBadPid(true);
          router.push("/");
          throw new Error("bad pid");
        }
        return res;
      })
      .then((val) => {
        setTransactions(val);
        console.log(val);
      })
      .catch(console.log);
  }, []);
  const [transactions, setTransactions] = useState([]);
  return (
    <div>
      {isBadPid && <div>Reviens sur localhost:3000 stp</div>}
      <TransactionList iban={iban} transactions={transactions} />
    </div>
  );
}
