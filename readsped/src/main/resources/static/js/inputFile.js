

    $(document).ready(function() {
        $("#file").on("change", adicionaAruivosNaTela);

        $( "#button-ler-arquivo" ).click(function() {
            uploadFile(new FormData($("#upload-file-form")[0]));
        });

        
        liberaMemoria();

        //$( "#index-home" ).click(function() {
       //     window.location.reload();
       // });
    });


function liberaMemoria() {
    
    $.ajax({
        url: window.location + "/clear",
        type: "POST",
        data: { process: "clear" },
        success: function (data) {
        },
        error: function () {

        }
    });
}

function ajaxParaAsPaginas(url)
{
    $.ajax({
        url: url,
        type: "POST",
        success: function (data) {
        },
        error: function () {

        }
    });
}
function adicionaAruivosNaTela()
{
    var files = $(this)[0].files;
    $(files).each(function( index ) {
        var iSize = (this.size / 1024);
        iSize = Math.round(iSize);
        $('#msg-qtd').css("color","Black"); 
        $('#msg-qtd').text("Qtd de Arquivos : " + files.length);
       
        $('#table-arquivos').append("<tr class='linhas-table'>" +
            "<td class='left-column'>"+this.name+"</td>" +
            "<td class='rigth-column'>"+iSize+" KB </td>" +
            "</tr>");
    });
}

function uploadFile(formData) {
    iniciaLoading();
    //console.log(new FormData($("#upload-file-form")[0]));
    $.ajax({
        url: window.location + "/upload",
        type: "POST",
        data: formData,
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
        cache: false,
        success: function (data) {
            //console.log(data);
            
            if(data === "Nenhum Arquivo encontrado"){
             msgNenhumArquivoUpload(); 
             
              setTimeout(function(){ 
                finalizaLoading();
            }, 3000);
            
            }
            else{
            
            $('#msg-qtd').html("");
            $('#msg-qtd').append("  <i class='fas fa-check'></i> Arquivos lidos com sucesso ...");
            $('#msg-qtd').css("color","#0E7905"); 
            setTimeout(function(){ 
                finalizaLoading();
            }, 8000);
        }
        },
        error: function (msg) {
            $('#msg-qtd').html("");
            $('#msg-qtd').append("  <i class='fas fa-times'></i> Erro ao ler os Arquivos...");
            $('#msg-qtd').css("color","#cc0000"); 
            $('.linhas-table').remove();
            $("#file").val("");
             liberaMemoria();
            setTimeout(function(){ 
                finalizaLoading();
            }, 8000);
        }
    });
}


function iniciaLoading() {
    $('#msg-qtd').css("color","Black"); 
    $('#msg-qtd').html("");
    $('#msg-qtd').append(" <i class='fa fa-spinner fa-spin fa-fw icone-load-arquivo'></i> lendo os arquivos ...");
    
    
    //$('.load').css("display","block");
}

function finalizaLoading() {
    $('#msg-qtd').html("");
}

function msgNenhumArquivoUpload()
{
     $('#msg-qtd').html("");
    $('#msg-qtd').append("Nenhum Arquivo encontrado");
    $('#msg-qtd').css("color","#DC143C"); 
     
}