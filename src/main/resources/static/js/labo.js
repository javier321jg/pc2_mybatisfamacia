$(document).ready(function (){
  listar();
});
function listar(){
   $.ajax({
        url: "/laboratorio/all",
        type: 'GET',
        success: function (x) {
            $("#tablita tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita").append(
                        "<tr><td>" + (i + 1) + "</td><td>" + x[i].idlaboratorio + "</td><td>" + x[i].nombre
                        + "</td><td>" + x[i].direccion + "</td><td>" + x[i].telefono + "</td><td>" + x[i].estado + "</td><td><a href='#' onclick='editar("
                        + x[i].idlaboratorio + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idlaboratorio + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
            }
        }
    }); 
    
}
function editar(id) {
    $.ajax({
        url: "/laboratorio/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_nombre").val(w.nombre);
            $("#editar_direccion").val(w.direccion);
            $("#editar_telefono").val(w.telefono);
            $("#editar_estado").val(w.estado);
            $("#idlaboratorio").val(w.idlaboratorio);
        }
    });
    $("#modalEditar").modal('show');
}
function eliminar(id) {
    bootbox.confirm({
        message: "Realmente desea Eliminar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/laboratorio/" + id,
                    type: 'DELETE',
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro eliminado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        listar();
                    }
                });
            } else {
                bootbox.alert({
                    message: "Registro no eliminado!",
                    size: 'small'
                });
            }
        }
    });
}
$("#guardar").click(function () {
    var nombre = $("#nombre").val();
    var direccion = $("#direccion").val();
    var telefono = $("#estado").val();
    var estado = $("#estado").val();
    $.ajax({
        url: "/laboratorio/add",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'nombre': nombre, 'direccion': direccion, 'telefono': telefono, 'estado': estado}),
        cache: false,
        success: function (w) {
            bootbox.alert({
                message: "Registro guardado correctamente...!",
                callback: function () {
                    console.log('This was logged in the callback!');
                }
            });
            limpiar();
            listar();
        }
    });
    $("#modalGuardar").modal('hide');
});
function limpiar() {
    $("#titulo").val("");
    $("#descripcion").val("");
}
$("#modificar").click(function () {
    var nombre = $("#editar_nombre").val();
    var direccion = $("#editar_direccion").val();
    var telefono = $("#editar_telefono").val();
    var estado = $("#editar_estado").val();
    var id = $("#idlaboratorio").val();
    bootbox.confirm({
        message: "Realmente desea Modificar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/laboratorio/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'idlaboratorio': id, 'nombre': nombre, 'direccion': direccion, 'telefono': telefono, 'estado': estado}),
                    cache: false,
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro Modificado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        limpiar();
                        listar();
                    }
                });
                $("#modalEditar").modal('hide');
            } else {
                bootbox.alert({
                    message: "Registro no Modificado!",
                    size: 'small'
                });
            }
        }
    });
});

