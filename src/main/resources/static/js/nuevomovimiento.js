// Call the dataTables jQuery plugin
$(document).ready(function () {
  verificarlogin();
  colocarnombre();
  if(sessionStorage.idmovimiento>=1){
    actualizarmovimiento();
  }
});
function verificarlogin() {
  if (localStorage.nombrecompleto == "null") {
    location.href = "login.html";
  }
}

async function nuevoMovimiento() {
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

async function actualizarmovimiento(){   

  const request = await fetch('api/listarmovimientos/'+sessionStorage.idmovimiento, {
    method: 'PATCH',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(sessionStorage.idmovimiento)
  });
  const usuarios = await request.json();
  console.log(usuarios);
  document.getElementById("txtMonto").value=usuarios[0];
  document.getElementById("txtConcepto").value=usuarios[1];
  
}

async function actmovimiento() {
  movimiento = {};
  movimiento.idmovimiento=sessionStorage.idmovimiento;
  movimiento.monto = document.getElementById('txtMonto').value;
  movimiento.tipomovimiento = document.getElementById('txtTipo').value;
  movimiento.conceptomovimiento = document.getElementById('txtConcepto').value;
  movimiento.empid = localStorage.idempleado

  console.log(movimiento);

  if (movimiento.monto == "" || movimiento.tipomovimiento == "") {
    alert("Ingrese todos los datos!")
    return
  }

  const request = await fetch('api/traermovimiento/'+sessionStorage.idmovimiento, {
    method: 'PATCH',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': localStorage.token,
    },
    body: JSON.stringify(movimiento)
  });
  location.href = "movimientos.html";
  sessionStorage.clear();
}