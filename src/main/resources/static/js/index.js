function irArriba(pxPantalla){
    window.addEventListener('scroll', () => {
        let scroll = document.documentElement.scrollTop;
        let botonArriba = document.getElementById('scroll')
        if(scroll > pxPantalla) {
          botonArriba.style.opacity=1;
          botonArriba.style.transform='scale(1)';
        }else {
          botonArriba.style.transform='scale(0)';
          botonArriba.style.opacity=0;
        }
    })
}irArriba(350);

document.addEventListener('DOMContentLoaded', function() {
  let btnAgregar = document.getElementById('btn-agregar');
  let btnCancelar = document.getElementById('btn-cancelar');
  let btnGuardar = document.getElementById('btn-guardar');

  // Función para mostrar el formulario y ocultar el botón "Agregar"
  function mostrarFormulario() {
    btnAgregar.style.display = 'none';
    btnCancelar.style.display = 'inline-block';
    btnGuardar.style.display = 'inline-block';
    habilitarFormulario();
  }

  // Función para ocultar el formulario y mostrar el botón "Agregar"
  function ocultarFormulario() {
    btnAgregar.style.display = 'inline-block';
    btnCancelar.style.display = 'none';
    btnGuardar.style.display = 'none';
    deshabilitarFormulario();
  }

  // Función para habilitar el formulario
  function habilitarFormulario() {
    let campos = formulario.querySelectorAll('input');
    campos.forEach(function(campo) {
      campo.disabled = false;
    });
  }

  // Función para deshabilitar el formulario
  function deshabilitarFormulario() {
    let formulario = document.getElementById('formulario');
    let campos = formulario.querySelectorAll('input');
    campos.forEach(function(campo) {
      campo.value = "";
      campo.disabled = true;
    });
    formulario.reset();
  }

  // Agregar evento al botón Agregar para mostrar el formulario
  btnAgregar.addEventListener('click', mostrarFormulario);

  // Agregar evento al botón Cancelar para ocultar el formulario
  btnCancelar.addEventListener('click', ocultarFormulario);

  let miformulario = document.getElementById('miFormulario');
  miformulario.addEventListener('submit', function(event) {

    // Verificar si alguno de los campos está vacío
    let local = document.getElementById('local').value.trim();
    let dni_afiliado = document.getElementById('dni_afiliado').value.trim();
    let fecha = document.getElementById('fecha').value.trim();
    let hora = document.getElementById('hora').value.trim();

    if (local === '' || dni_afiliado === '' || fecha === '' || hora === '') {
        event.preventDefault(); // Detener el envío del formulario
        alert('Todos los campos son obligatorios'); // Mostrar mensaje de error
    }
  });
});

function editarFila(filaId) {
  let fila = document.getElementById(filaId);
  let celdas = fila.getElementsByTagName('td');

  for (let i = 1; i < celdas.length - 1; i++) {
    let valor = celdas[i].innerText;  
    celdas[i].innerHTML = '<input type="text" value="' + valor + '">';
    celdas[i].style.paddingTop = '8px';
    celdas[i].style.paddingBottom = '8px';
  }

  let botones = fila.getElementsByTagName('button');
  botones[0].style.display = 'none';  // Ocultar botón Editar
  botones[1].style.display = 'none';  // Ocultar botón Eliminar
  botones[2].style.display = 'inline';  // Mostrar botón Guardar
  botones[3].style.display = 'inline';  // Mostrar botón Cancelar
}

function guardarFila(filaId) {
  let fila = document.getElementById(filaId);
  let celdas = fila.getElementsByTagName('td');

  for (let i = 1; i < celdas.length - 1; i++) {
    if (celdas[i].getElementsByTagName('input')[0].value.trim() == "") {
      alert("Los campos no pueden estar vacíos...");
      return;
    }
  }

  let visita = {
    id: filaId,
    local: celdas[1].getElementsByTagName('input')[0].value,
    dni_afiliado: celdas[2].getElementsByTagName('input')[0].value,
    fecha: celdas[3].getElementsByTagName('input')[0].value,
    hora: celdas[4].getElementsByTagName('input')[0].value
  };

  for (let i = 1; i < celdas.length - 1; i++) {
    let valor = celdas[i].getElementsByTagName('input')[0].value;
    celdas[i].innerHTML = valor;
  }

  let formData = new FormData();
  formData.append('id', visita.id);
  formData.append('local', visita.local);
  formData.append('dni_afiliado', visita.dni_afiliado);
  formData.append('fecha', visita.fecha);
  formData.append('hora', visita.hora);

  fetch('/visitas?id=', {
    method: 'put',
    body: formData
  })
  .then(response => {
    if (response.ok) {
      // La solicitud se realizó con éxito
      console.log("Recibido correctamente");
    } else {
      // Hubo un error en la solicitud
      console.log("Recibido pero pasó algo...");
      response.text().then(errorMessage => {
        alert(errorMessage); // Mostrar el mensaje de error en una alerta
      });
      window.location.reload();
    }
  })
  .catch(error => {
    // Maneja cualquier error de red u otro error
    console.log(error);
  });

  let botones = fila.getElementsByTagName('button');
  botones[0].style.display = 'inline';  // Mostrar botón Editar
  botones[1].style.display = 'inline';  // Mostrar botón Eliminar
  botones[2].style.display = 'none';  // Ocultar botón Guardar
  botones[3].style.display = 'none';  // Ocultar botón Cancelar
}

function cancelarEdicion(filaId) {
  let fila = document.getElementById(filaId);
  let celdas = fila.getElementsByTagName('td');

  for (let i = 1; i < celdas.length - 1; i++) {
    let valor = celdas[i].getElementsByTagName('input')[0].getAttribute('value');
    celdas[i].innerHTML = valor;
  }

  let botones = fila.getElementsByTagName('button');
  botones[0].style.display = 'inline';  // Mostrar botón Editar
  botones[1].style.display = 'inline';  // Mostrar botón Eliminar
  botones[2].style.display = 'none';  // Ocultar botón Guardar
  botones[3].style.display = 'none';  // Ocultar botón Cancelar
}