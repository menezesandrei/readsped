

$(document).ready(function() {
   processar();
});

function processar() {
iniciaLoadingProcessar();

    $.ajax({
        url: window.location + "/processar",
        type: "POST",
        data: { process: "contrib" },
        success: function (data) {
            //console.log(data);
           percorrerRetornoProcessamento(data);
           FinalizaLoadingProcessar();
        },
        error: function () {
FinalizaLoadingProcessar();
        }
    });
}

function percorrerRetornoProcessamento(array)
{
Object.entries(array).forEach(([k, v]) => {    
    var cliente = k.split("|");
    $('.msg-nada-mostrar').css("display","none");
    $('.fiscal-centro-body').append("<div class='card' id='"+cliente[1]+cliente[2]+"'> <div class='cabecalho-card' > <div class='cliente-nome'>  <h2>"+cliente[0]+"</h2>  <p>"+formatarCnpj(cliente[1])+"</p>     </div>     <div class='sped-periodo' style=''>  <i class='material-icons'>insert_invitation</i>  <span>"+tratarDataParaVisualizacao(cliente[2])+"</span> </div> </div> <div  class='card-body'> </div> </div>");
Object.entries(v).forEach(([key, value]) => {
      var registro =  key.substring(9);
$('#'+cliente[1]+cliente[2]+' .card-body').append("<div id='"+registro+"' class='card-detalhe'><div class='card-detalhe-header' >"+key+"</div><div class='card-detalhe-body'> <table><tbody id='teste'> <tr><th>CST</th><th>CFOP</th> <th>VLR_ITEM</th><th>VLR_BC</th></tr></tbody></table></div></div>");
value.sort(function(a, b){return a.cst - b.cst});
$(value).each(function( index,mov ) {
     
     $('#'+cliente[1]+cliente[2]+' #'+registro+' tbody').append("<tr>  <td>"+mov.cst+"</td>    <td>"+mov.cfop+"</td>   <td>R$ "+mov.valor+"</td>   <td>R$ "+mov.valorBc+"</td>  </tr>");

});    
}); 

});   
}

function formatarCnpj(cnpj)
{
    var cnpjFormatado = cnpj.substring(0, 2)+"."+cnpj.substring(2, 5)+"."+cnpj.substring(5, 8)+"/"+cnpj.substring(8, 12)+"-"+cnpj.substring(12);
    return cnpjFormatado;
    
}
function tratarDataParaVisualizacao(data)
{
    
    var mes =  data.substring(2, 4);
    var ano =  data.substring(4);
    
    switch (mes) {
  case '01':
    return "Janeiro "+ano;
    break;
  case '02':
    return "Fevereiro "+ano;
    break;
  case '03':
    return "Março "+ano;
    break;
      case '04':
    return "Abril "+ano;
    break;
      case '05':
    return "Maio "+ano;
    break;
      case '06':
    return "Junho "+ano;
    break;
      case '07':
    return "Julho "+ano;
    break;
      case '08':
    return "Agosto "+ano;
    break;
      case '09':
    return "Setembro "+ano;
    break;
    case '10':
    return "Outubro "+ano;
    break;
    case '11':
    return "Novembro "+ano;
    break;
    case '12':
    return "Dezembro "+ano;
    break;
  default:
   return data;
}

}

function iniciaLoadingProcessar()
{
    $(".msg-nada-mostrar").html("");
    $(".msg-nada-mostrar").append("<i class='fa fa-spinner fa-spin fa-5x fa-fw'></i>");
    $(".msg-nada-mostrar").css("color","#0E7905");
}

function FinalizaLoadingProcessar()
{
    $(".msg-nada-mostrar").html("");
    $(".msg-nada-mostrar").append("Sem Informações para Mostar");
    $(".msg-nada-mostrar").css("color","black");
}