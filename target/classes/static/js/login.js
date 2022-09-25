// Call the dataTables jQuery plugin
$(document).ready(function() {
  localStorage.clear();
  localStorage.nombrecompleto='null';
  localStorage.idempleado='null';

    //on ready
  });
  
async function iniciarSesion(){
let datos={};
datos.email=document.getElementById('txtEmail').value;
datos.password=document.getElementById('txtPassword').value;
const request = await fetch('api/login', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body:JSON.stringify(datos)
    });

    
    const respuesta = await request.json();
    console.log(respuesta);
    if(respuesta[0] !='FAIL'){
      localStorage.token=respuesta[0];
      localStorage.nombrecompleto=respuesta[1];
      localStorage.idempleado=respuesta[2];
      localStorage.rol=respuesta[3];
      window.location.href = "movimientos.html"
    }

    else {
    alert("Usuario o contraseña invalidas, Intentemoslo nuevamente")
    }
}