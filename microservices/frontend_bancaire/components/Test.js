import React, { useState, useEffect } from "react";

export default function Test() {
  useEffect(() => {
    console.log("test");
    fetch("http://localhost:8084/api/v1/account")
      .then((res) => res.json())
      .then((val) => setresponse(val));
  }, []);

  const [response, setresponse] = useState([]);

  const convertPrice = (priceInCents) => priceInCents / 100;

  return (
    <ul>
      {response.map((account, index) => (
        <li key={index}>
          {account.iban} - amount : {convertPrice(account.amountInCents)}€
        </li>
      ))}
    </ul>
  );
}
