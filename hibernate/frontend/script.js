//requete qui genere la liste des country
let countries;
fetch("http://localhost:8084/api/v1/country")
  .then(function (res) {
    return res.json();
  })
  .then(function (val) {
    countries = val;
    console.log(countries);
  });

const country = [
  {
    name: "France",
    president: "Macron",
    regions: [
      {
        name: "IDF",
        temperature: 46,
      },
      {
        name: "Moselle",
        temperature: -12,
      },
      {
        name: "Nord",
        temperature: -2,
      },
      {
        name: "Sud",
        temperature: 33,
      },
    ],
  },
  {
    name: "Allemagne",
    president: "Pas merkel",
    regions: [
      {
        name: "bretzel",
        temperature: -44,
      },
      {
        name: "Cassoulet",
        temperature: -4,
      },
    ],
  },
];

// génération du menu déroulant en fonction des pays renovyés par la requête
let list = document.getElementById("country-select");
for (let pays of country) {
  let option = document.createElement("option");
  option.value = pays.name;
  option.text = pays.name;
  list.add(option);
}

// refresh de la page en fonction du choix
list.addEventListener("change", function () {
  let selectedCountry = country[0]; //fetch en fct de selected-country
  let regionTableau = document.getElementById("tab-region");
  regionTableau.innerHTML = "";
  for (let region of selectedCountry.regions) {
    let regionCard = document.createElement("div");
    regionCard.classList.add("region");
    let nom = document.createElement("span");
    let temperature = document.createElement("span");
    nom.innerText = "Nom : " + region.name;
    temperature.innerText = " Il fait : " + region.temperature + "°C";
    regionCard.appendChild(nom);
    regionCard.appendChild(temperature);
    regionTableau.appendChild(regionCard);
  }
});
