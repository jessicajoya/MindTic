// Call the dataTables jQuery plugin
$(document).ready(function () {
  sessionStorage.clear()
  verificarlogin();
  cargarUsuarios();
  $('#empresas').DataTable();
  colocarnombre();
});

function verificarlogin() {
  if (localStorage.nombrecompleto == "null") {
    location.href = "login.html";
  }
  if(localStorage.rol=="2"){
    if(localStorage.rol=="2"){    
      alert('Su Perfil Rol no tiene permisos para esta funcion')
      location.href = "movimientos.html";
    }
  }
}

async function cargarUsuarios() {

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
    let btneliminar = '<a href="#" onclick="eliminar(' + usuario[0] + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let btnactualizar ='<a href="#" onclick="actualizar(' + usuario[0] + ')" class="btn btn-info btn-circle btn-sm"><i class="fas fa-info-circle"></i></a>';
    let usuarioHtml = '<tr><td>' + usuario[0] + '</td><td>' + usuario[1] + '</td><td>' + usuario[2] + '</td><td>' + usuario[3] + '</td><td>' + usuario[4] + '</td><td>' + btneliminar + '' + btnactualizar + '</td></tr>';
    listadoHtml += usuarioHtml;
  }

  document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

}

async function eliminar(id) {
  if (!confirm('¿Desea Eliminar esta Empresa del Sistema?')) {
    return
  }

  const request = await fetch('api/listarempresas/' + id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  location.reload()
}

function colocarnombre() {
  document.querySelector('#txtNombreCompleto').outerHTML = localStorage.nombrecompleto;

}

function actualizar(id) {
  sessionStorage.idempleado=id;
  location.href = "actempresa.html";
}

