//requete qui genere la liste des country
let countries;
let countryId = -1;
fetchCountriesInitial();
const allCountriesButton = document.getElementById("pays-normal");
allCountriesButton.addEventListener("click", fetchCountriesInitial);
const hotCountriesButton = document.getElementById("pays-chaud");
hotCountriesButton.addEventListener("click", fetchHotCountries);
const addRegionButton = document.getElementById("pays-chaud");
hotCountriesButton.addEventListener("click", fetchHotCountries);

function fetchCountriesInitial() {
  fetch("http://localhost:8084/api/v1/country")
    .then(function (res) {
      return res.json();
    })
    .then(function (val) {
      countries = val;
      generateSelect();
    });
}
function fetchHotCountries() {
  fetch("http://localhost:8084/api/v1/region/minTemp/12/country")
    .then(function (res) {
      return res.json();
    })
    .then(function (val) {
      countries = val;
      generateSelect();
    });
}
function fetchCountries() {
  fetch("http://localhost:8084/api/v1/country")
    .then(function (res) {
      return res.json();
    })
    .then(function (val) {
      countries = val;
    })
    .then(() => refresh());
}

// génération du menu déroulant en fonction des pays renovyés par la requête
function generateSelect() {
  countryId = -1;
  let list = document.getElementById("country-select");
  list.innerHTML =
    "<option value='' disabled selected>Choisir un pays</option>";
  let regionTableau = document.getElementById("tab-region");
  regionTableau.innerHTML = "";
  for (let pays of countries) {
    let option = document.createElement("option");
    option.value = pays.countryId;
    option.text = pays.name;
    list.add(option);
  }
  list.addEventListener("change", function (event) {
    countryId = event.target.value;
    refresh(event.target.value);
  });
}

// refresh de la page en fonction du choix
function refresh() {
  let regions;
  fetch(`http://localhost:8084/api/v1/country/${countryId}/region`)
    .then(function (res) {
      return res.json();
    })
    .then(function (val) {
      regions = val;
    })
    .then(function () {
      let regionTableau = document.getElementById("tab-region");
      regionTableau.innerHTML = "";
      for (let region of regions) {
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
    });
}
function deleteRegion(idRegion) {
  fetch(`http://localhost:8084/api/v1/region/${idRegion}`, {
    method: "DELETE",
  })
    .then((res) => res.text())
    .then((res) => console.log(res))
    .then(() => fetchCountries());
}

document.getElementById("create-region").onsubmit = function (event) {
  event.preventDefault();
  if (countryId === -1) {
    alert("Sélectionnez un pays");
  } else {
    const name = document.getElementById("input-name").value;
    const temp = document.getElementById("input-temp").value;
    if (name == "" || temp == "") {
      alert("Remplissez le formulaire");
    } else {
      let payload = {
        name: name,
        temperature: temp,
        country: { countryId: parseInt(countryId) },
      };
      fetch(`http://localhost:8084/api/v1/region`, {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify(payload),
      }).then(() => refresh());
    }
  }
};
