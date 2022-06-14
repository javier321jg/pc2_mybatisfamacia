$(document).ready(function () {
    listar();

});
function listar() {
    $.ajax({
        url: "/cliente/all",
        type: 'GET',
        success: function (x) {
            $("#tablita tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita").append(
                        "<tr><td>" + (i + 1) + "</td><td>" 
                        + x[i].idcliente + "</td><td>" 
                        + x[i].nombres + "</td><td>" 
                        + x[i].apellidos + "</td><td>" 
                        + x[i].sexo + "</td><td>"
                        + x[i].dni + "</td><td>" 
                        + x[i].telefono + "</td><td>"  
                        + x[i].ruc + "</td><td>" 
                        + x[i].email + "</td><td>"                
                        + x[i].direccion + "</td><td><a href='#' onclick='editar("
                        + x[i].idcliente + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idcliente + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
            }
        }
    });
}
function editar(id) {
    $.ajax({
        url: "/cliente/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_nombres").val(w.nombres);
            $("#editar_apellidos").val(w.apellidos);
            $("#editar_sexo").val(w.sexo);
            $("#editar_dni").val(w.dni);
            $("#editar_telefono").val(w.telefono);
            $("#editar_ruc").val(w.ruc);
            $("#editar_email").val(w.email);
            $("#editar_direccion").val(w.direccion);            
            $("#idcliente").val(w.idcliente);
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
                    url: "/cliente/" + id,
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
    var nom = $("#nombres").val();
    var ap = $("#apellidos").val();
    var sexo = $("#sexo").val();
    var dni = $("#dni").val();
    var tel = $("#telefono").val();
    var ruc = $("#ruc").val();
    var mail = $("#email").val();
    var dir = $("#direccion").val();
    
    $.ajax({
        url: "/cliente/add",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'nombres': nom, 'apellidos': ap, 'sexo': sexo, 'dni': dni, 'telefono': tel, 'ruc': ruc, 'email': mail, 'direccion': dir}),
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
    $("#nombres").val("");
    $("#apellidos").val("");
    $("#sexo").val("");
    $("#dni").val("");
    $("#telefono").val("");
    $("#ruc").val("");
    $("#email").val("");
    $("#direccion").val("");    
}
$("#modificar").click(function () {
    var nom = $("#editar_nombres").val();
    var ap = $("#editar_apellidos").val();
    var sexo = $("#editar_sexo").val();
    var dni = $("#editar_dni").val();
    var tel = $("#editar_telefono").val();
    var ruc = $("#editar_ruc").val();
    var mail = $("#editar_email").val();
    var dir = $("#editar_direccion").val();    
    var id = $("#idcliente").val();
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
                    url: "/cliente/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'idcliente': id, 'nombres': nom, 'apellidos': ap, 'sexo': sexo, 'dni': dni, 'telefono': tel, 'ruc': ruc, 'email': mail, 'direccion': dir}),
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