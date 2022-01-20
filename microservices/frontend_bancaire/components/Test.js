import { makeTransaction } from "../utils/helper";

export default function Test() {
  const handleTransaction = () => {
    makeTransaction(
      "FR7620041010169876543210921",
      "FR7630003035409876543210925",
      2000
    )
      .then((res) => {
        console.log(res);
      })
      .catch(console.log);
  };

  return (
    <>
      <button onClick={handleTransaction}>make transaction</button>
    </>
  );
}
