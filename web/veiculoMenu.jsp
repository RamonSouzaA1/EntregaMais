<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <title>Menu - Veiculo</title>

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
           <a class="navbar-brand" href="#">DPDelivery</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
           <ul class="nav navbar-nav navbar-right">
            <li><a href="index.jsp">Início</a></li>
           </ul>
          </div>
         </div>
        </nav>
        <div id="main" class="container-fluid">
         <h3 class="page-header">Menu Veiculos<h3>
        
        <button class="btn btn-primary" onclick="window.location.href='veiculoAdicionar.jsp'">Adicionar veiculo</button>
        <form action="FrontController?action=LerVeiculo" method="post">
            <button>Consultar Veiculos </button>
        </form>
        <button class="btn btn-primary" onclick="window.location.href='veiculoApagar.jsp'">Apagar veiculo</button>
        <button class="btn btn-primary" onclick="window.location.href='veiculoEditar.jsp'">Editar veiculo</button>
        </div>
        </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
