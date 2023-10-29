document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("telescopeForm").addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent the form from submitting initially for validation

        const calibrationAngle = parseFloat(document.getElementById("calibrationAngle").value);

        if (isNaN(calibrationAngle) || calibrationAngle < 0 || calibrationAngle > 360) {
            document.getElementById("calibrationError").style.display = "block"; // Display error message
        } else {
            document.getElementById("telescopeForm").submit(); 
        }
    });
});
