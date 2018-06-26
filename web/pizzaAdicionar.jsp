<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <title>Cadastro de Pedidos</title>
    </head>

    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Entrega Mais</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                    </ul>
                </div>
            </div>
        </nav>
        <div id="main" class="container-fluid">
            <h3 class="page-header">Cadastro de Pizza</h3>

            <form action="FrontController?action=GravarPizza" method="post">
                <input type="hidden" required="" name="idCliente" value="${cliente.id}"/>
                <input type="hidden" required="" name="nome" value="${cliente.nome}"/>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="campo1">Nome</label>
                        <input type="text" class="form-control" id="campo2" name="txtNome"/>  
                    </div>
                    <div class="form-group col-md-4">
                        <label for="campo2">Ingrediente</label>
                        <input type="text" class="form-control" id="campo3" name="txtIngrediente"/>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="campo3">Preço Media</label>
                        <input type="text" class="form-control" id="campo1" name="txtPrecoMedia"/>
                    </div> 
                    
                    <div class="form-group col-md-6">
                        <label for="campo3">Preço Família</label>
                        <input type="text" class="form-control" id="campo1" name="txtPrecoFamilia"/>
                    </div> 
                </div>
                <hr>
                <div id="actions" class="row">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary">Salvar</button>
                    </div>
                </div>
                <br>

            </form>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
