console.log('Funcionando NICE');
$(document).ready(function (){
    $("tr #Cantidad").click(function (){
        var idp = $(this).parent().find("#idpro").val();
        var cantidad = $(this).part().find("#Cantidad").val();
        var url1="ServletControlador?accion=ActualizarCantidad";

        $ajax({
            type:'POST',
            url : url1,
            data:"idp="+idp+"&Cantidad"+cantidad,
            success: function (data,textStatus, jqXHR) {

            }
        });
    })
});
console.log('Fin');