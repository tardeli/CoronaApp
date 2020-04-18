function showPosition() {
        if(navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {                
                document.getElementById("latitude").value = position.coords.latitude.toFixed(8);
                document.getElementById("longitude").value = position.coords.longitude.toFixed(8);
            });
        } else {
            alert("Navegador não suporte ou permite geolocalização!");
        }
    }