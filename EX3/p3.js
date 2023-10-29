document.addEventListener("DOMContentLoaded", function() {
document.getElementById("myForm").addEventListener("submit", function(event) {
    const selectedPlanet = document.getElementById("planet").value;
    const planetImg = document.getElementById('planetImg');

    if (selectedPlanet === "") {
        // Display error message and prevent form submission
        alert("Please select a planet");

    }
    else if(selectedPlanet === "mercury")
    {
        event.preventDefault();
        planetImg.innerHTML = '<img src="mercury.jpg" alt="">';
    }
    else if(selectedPlanet === "venus")
    {
        event.preventDefault();
        planetImg.innerHTML = '<img src="venus.jpg" alt="">';
    }
    else if(selectedPlanet === "earth")
    {
        event.preventDefault();
        planetImg.innerHTML = '<img src="earth.jpg" alt="">';
    }
    else if(selectedPlanet === "mars")
    {
        event.preventDefault();
        planetImg.innerHTML = '<img src="mars.jpg" alt="">';
    }
    else if(selectedPlanet === "jupiter")
    {
        event.preventDefault();
        planetImg.innerHTML = '<img src="jupiter.jpg" alt="">';
    }
    else if(selectedPlanet === "saturn")
    {
        event.preventDefault();
        planetImg.innerHTML = '<img src="saturn.jpg" alt="">';
    }
    else if(selectedPlanet === "uranus")
    {
        event.preventDefault();
        planetImg.innerHTML = '<img src="uranus.jpg" alt="">';
    }
    else if(selectedPlanet === "neptune")
    {
        event.preventDefault();
        planetImg.innerHTML = '<img src="neptune.jpg" alt="">';
    }
});
});