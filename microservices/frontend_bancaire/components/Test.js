import React, { useState, useEffect } from "react";
import { centsToPrice, makeTransaction } from "../utils/helper";

export default function Test() {
  useEffect(() => {
    fetch("http://localhost:8084/api/v1/account")
      .then((res) => res.json())
      .then((val) => setresponse(val));
  }, []);

  const [response, setresponse] = useState([]);

  const handleTransaction = () => {
    makeTransaction(
      "FR7620041010169876543210921",
      "FR7630003035409876543210925",
      2000
    ).then((res) => {
      console.log(res);
    });
  };

  return (
    <>
      <button onClick={handleTransaction}>make transaction</button>
      <ul>
        {response.map((account, index) => (
          <li key={index}>
            {account.iban} - amount : {centsToPrice(account.amountInCents)}€
          </li>
        ))}
      </ul>
    </>
  );
}
