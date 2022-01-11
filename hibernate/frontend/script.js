//requete qui genere la liste des country
let countries;
fetch("http://localhost:8084/api/v1/country")
  .then(function (res) {
    return res.json();
  })
  .then(function (val) {
    countries = val;
    generateSelect();
  });

// génération du menu déroulant en fonction des pays renovyés par la requête
function generateSelect() {
  let list = document.getElementById("country-select");
  for (let pays of countries) {
    let option = document.createElement("option");
    option.value = pays.name;
    option.text = pays.name;
    list.add(option);
  }
  list.addEventListener("change", refresh);
}

// refresh de la page en fonction du choix

function refresh() {
  let selectedCountry = countries[0]; //fetch en fct de selected-country : à corriger
  let regionTableau = document.getElementById("tab-region");
  regionTableau.innerHTML = "";
  for (let region of selectedCountry.regions) {
    let regionCard = document.createElement("div");
    regionCard.classList.add("region");
    let bouton = regionCard.appendChild(document.createElement("button"));
    bouton.classList.add("bouton");
    bouton.innerText = "-";
    bouton.addEventListener("click", () => {
      deleteRegion(region.regionId);
    });
    let nom = document.createElement("span");
    let temperature = document.createElement("span");
    nom.innerText = "Nom : " + region.name;
    temperature.innerText = " Il fait : " + region.temperature + "°C";
    regionCard.appendChild(nom);
    regionCard.appendChild(temperature);
    regionTableau.appendChild(regionCard);
  }
}

function deleteRegion(id) {
  fetch(`http://localhost:8084/api/v1/region/${id}`, {
    method: "DELETE",
  })
    .then((res) => res.text())
    .then((res) => console.log(res))
    .then(() => refresh()); // à corriger
}
