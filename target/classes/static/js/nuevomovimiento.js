// Call the dataTables jQuery plugin
$(document).ready(function () {
  verificarlogin();
  colocarnombre();
});
function verificarlogin() {
  if (localStorage.nombrecompleto == "null") {
    location.href = "login.html";
  }
}

async function nuevoEmpleado() {
  movimiento = {};
  movimiento.monto = document.getElementById('txtMonto').value;
  movimiento.tipomovimiento = document.getElementById('txtTipo').value;
  movimiento.conceptomovimiento = document.getElementById('txtConcepto').value;
  movimiento.empid = localStorage.idempleado

  console.log(movimiento);

  if (movimiento.monto == "" || movimiento.tipomovimiento == "") {
    alert("Ingrese todos los datos!")
    return
  }

  const request = await fetch('api/listarmovimientos', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': localStorage.token,
    },
    body: JSON.stringify(movimiento)
  });
  location.href = "movimientos.html";
  const respuesta = await request.text();
}

function colocarnombre() {
  document.querySelector('#emp').outerHTML = localStorage.nombrecompleto;

}