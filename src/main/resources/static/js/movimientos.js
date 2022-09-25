// Call the dataTables jQuery plugin
$(document).ready(function () {
  verificarlogin();
  cargarUsuarios();
  $('#movimientos').DataTable();
  colocarnombre();
});

function verificarlogin() {
  if (localStorage.nombrecompleto == "null") {
    location.href = "login.html";
  }
}

async function cargarUsuarios() {

  const request = await fetch('api/listarmovimientos', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const usuarios = await request.json();

  let listadoHtml = '';
  let ingresos = 0;
  let egresos = 0;
  let total = 0;

  for (let usuario of usuarios) {
    if (usuario[2] == "Ventas") {
      ingresos = ingresos + usuario[1];
    }
    if (usuario[2] == "Gastos") {
      egresos = egresos + usuario[1];
    }

    let btneliminar = '<a href="#" onclick="eliminar(' + usuario[0] + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let usuarioHtml = '<tr><td>' + usuario[0] + '</td><td>' + usuario[1] + '</td><td>' + usuario[2] + '</td><td>' + usuario[3] + '</td><td>' + usuario[4] + '</td><td>' + btneliminar + '</td></tr>';
    listadoHtml += usuarioHtml;
  }

  document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
  total = ingresos - egresos;
  console.log(total,ingresos,egresos);
  let totalesHtml = '<tr><td>' + ingresos + '</td><td>' + egresos + '</td><td>' + total + '</td></tr>';
  document.querySelector('#totales tbody').outerHTML=totalesHtml;
}

async function eliminar(id) {

  if (localStorage.rol == "2") {
    alert('Su Perfil Rol no tiene permisos para esta funcion')
    location.href = "movimientos.html";
  }

  if (!confirm('¿Desea Eliminar este Movimiento de Dinero del Sistema?')) {
    return
  }

  const request = await fetch('api/listarmovimientos/' + id, {
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