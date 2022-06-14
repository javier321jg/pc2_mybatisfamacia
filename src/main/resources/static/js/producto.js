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
                        "<tr><td>" + (i + 1) + "</td><td>" 
                        + x[i].idproducto + "</td><td>" 
                        + x[i].descripcion + "</td><td>" 
                        + x[i].stock + "</td><td>" 
                        + x[i].precio + "</td><td>"
                        + x[i].registrosanitario + "</td><td>" 
                        + x[i].fechavencimiento + "</td><td><a href='#' onclick='editar("  
                        + x[i].idproducto + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idproducto + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
            }
        }
    }); 
    
}
function editar(id) {
    $.ajax({
        url: "/producto/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_descripcion").val(w.descripcion);
            $("#editar_stock").val(w.stock);
            $("#editar_precio").val(w.precio);
            $("#editar_registrosanitario").val(w.registrosanitario);
            $("#editar_fechavencimiento").val(w.fechavencimiento);
            $("#idproducto").val(w.idproducto);
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
    var descripcion = $("#descripcion").val();
    var stock = $("#stock").val();
    var precio = $("#precio").val();
    var registrosanitario = $("#registrosanitario").val();
    var fechavencimiento = $("#fechavencimiento").val();
  
    $.ajax({
        url: "/laboratorio/add",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'descripcion': descripcion, 'stock': stock, 'precio': precio, 'registrosanitario': registrosanitario, 'fechavencimiento': fechavencimiento}),
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
   
    var descripcion = $("#editar_descripcion").val();
    var stock = $("#editar_stock").val();
    var precio = $("#editar_precio").val();
    var registrosanitario = $("#editar_registrosanitario").val();
    var fechavencimiento = $("#editar_fechavencimiento").val();
    var id = $("#idproducto").val();
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
                    data: JSON.stringify({'idproducto': id, 'descripcion': descripcion, 'stock': stock, 'precio': precio, 'registrosanitario': registrosanitario, 'fechavencimiento': fechavencimiento}),
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

