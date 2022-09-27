// Call the dataTables jQuery plugin
$(document).ready(function () {
  verificarlogin();
  if(sessionStorage.id>=1){
    actualizarempresa();
  }
  
  //on ready
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

async function nuevaEmpresa() {
  let datos = {};
  datos.nombre = document.getElementById('txtNombre').value;
  datos.direccion = document.getElementById('txtDireccion').value;
  datos.telefono = document.getElementById('txtTelefono').value;
  datos.nit = document.getElementById('txtNit').value;

  if (datos.nombre == "" || datos.direccion == "" || datos.telefono == "" || datos.nit == "") {
    alert("Ingrese todos los datos!")
    return
  }

  const request = await fetch('api/listarempresas', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  location.href = "empresas.html";
  const respuesta = await request.text();
}

async function actualizarempresa(){   

  const request = await fetch('api/listarempresas/'+sessionStorage.id, {
    method: 'PATCH',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(sessionStorage.id)
  });
  const usuarios = await request.json();
  console.log(usuarios.nombre);
  document.getElementById('txtNombre').value = usuarios.nombre;
  document.getElementById('txtDireccion').value = usuarios.direccion;
  document.getElementById('txtTelefono').value = usuarios.telefono;
  document.getElementById('txtNit').value = usuarios.nit;
}


async function actempresa(){   

  let datos = {};
  datos.idempresa=sessionStorage.id;
  datos.nombre = document.getElementById('txtNombre').value;
  datos.direccion = document.getElementById('txtDireccion').value;
  datos.telefono = document.getElementById('txtTelefono').value;
  datos.nit = document.getElementById('txtNit').value;
  
  
  if (datos.nombre == "" || datos.direccion == "" || datos.telefono == "" || datos.nit == "") {
    alert("Ingrese todos los datos!")
    return
  }

const request = await fetch('api/traerempresa', {
    method: 'PATCH',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  location.href = "empresas.html";  
  sessionStorage.clear();
 }