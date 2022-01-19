import AccountCard from "./AccountCard";
import { useState, useEffect } from "react";

export default function AccountList() {
  useEffect(() => {
    fetch("http://localhost:8084/api/v1/account")
      .then((res) => res.json())
      .then((val) => setResponse(val));
  }, []);

  const [response, setResponse] = useState([]);

  return (
    <div>
      {response.map((compte) => {
        return (
          <AccountCard
            key={compte.accountId}
            id={compte.accountId}
            iban={compte.iban}
            amount={compte.amountInCents}
          />
        );
      })}
    </div>
  );
}
