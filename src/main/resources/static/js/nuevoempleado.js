// Call the dataTables jQuery plugin
$(document).ready(function () {
  verificarlogin();
  cargardatos();
  cargarrol();

  if(sessionStorage.idempleado>=1){
    actualizarempleado();
  }

});

function verificarlogin() {
  if (localStorage.nombrecompleto == "null") {
    location.href = "login.html";
  }
  if(localStorage.rol=="2"){    
    alert('Su Perfil Rol no tiene permisos para esta funcion')
    location.href = "movimientos.html";
  }
}

async function cargardatos() {

  const request = await fetch('api/listarempresas', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const usuarios = await request.json();

  let listadoHtml = '';
  for (let usuario of usuarios) {
    let usuarioHtml = '<option value=' + usuario[0] + '>' + usuario[1] + '</option>';
    listadoHtml += usuarioHtml;
  }

  document.querySelector('#listempresas').outerHTML = listadoHtml;

}

async function cargarrol() {

  const request = await fetch('api/listarrol', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const usuarios = await request.json();

  let listadoHtml = '';
  for (let usuario of usuarios) {
    let usuarioHtml = '<option value=' + usuario[0] + '>' + usuario[1] + '</option>';
    listadoHtml += usuarioHtml;
  }

  document.querySelector('#listrol').outerHTML = listadoHtml;

}

async function nuevoEmpleado() {
  empleado = {};
  empleado.nombrecompleto = document.getElementById('txtNombre').value;
  empleado.email = document.getElementById('txtEmail').value;
  empleado.password = document.getElementById('txtPassword').value;
  empleado.rolid = parseInt(document.getElementById('rol').value, 10);
  empleado.empresaid = parseInt(document.getElementById('emp').value, 10);
  let rpassword = document.getElementById('txtRPassword').value;

  console.log(empleado);

  if (empleado.password != rpassword) {
    alert("Las contraseñas no coinciden!")
    return
  }

  if (empleado.nombrecompleto == "" || empleado.email == "" || empleado.password == "" || empleado.rolid == "" || empleado.empresaid == "") {
    alert("Ingrese todos los datos!")
    return
  }

  const request = await fetch('api/listarempleados', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(empleado)
  });
  location.href = "empleados.html";
  const respuesta = await request.text();


}

async function actualizarempleado(){   

  console.log(sessionStorage.idempleado)
  const request = await fetch('api/listarempleados/'+sessionStorage.idempleado, {
    method: 'PATCH',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(sessionStorage.idempleado)
  });
  const usuarios = await request.json();
  document.getElementById('txtNombre').value=usuarios[0];
  document.getElementById('txtEmail').value=usuarios[1];
}


async function actempleado(){   

  empleado = {};
  empleado.idempleado=sessionStorage.idempleado;
  empleado.nombrecompleto = document.getElementById('txtNombre').value;
  empleado.email = document.getElementById('txtEmail').value;
  empleado.password = document.getElementById('txtPassword').value;
  let rpassword = document.getElementById('txtRPassword').value;
  empleado.rolid = parseInt(document.getElementById('rol').value, 10);
  empleado.empresaid = parseInt(document.getElementById('emp').value, 10);

  console.log(empleado);

  if (empleado.password != rpassword) {
    alert("Las contraseñas no coinciden!")
    return
  }

  if (empleado.nombrecompleto == "" || empleado.email == "" || empleado.password == "" || empleado.rolid == "" || empleado.empresaid == "") {
    alert("Ingrese todos los datos!")
    return
  }

  const request = await fetch('api/traerempleado/'+sessionStorage.idempleado, {
    method: 'PATCH',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(empleado)
  });
  location.href = "empleados.html";
  sessionStorage.clear();
 }