<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <title>Apagar Pedido</title>
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
         <h3 class="page-header">Apagar Pedidos</h3>
        
        <form action="FrontController?action=ApagarPedido" method="post">

            <div class="row">
             <div class="form-group col-md-6">
               <label for="campo1">Digite o ID do pedido</label>
               <input type="text" class="form-control" id="campo1" name="textId"/>
             </div>
             </div>
             <hr />
              <div id="actions" class="row">
                <div class="col-md-12">
                  <button type="submit" class="btn btn-primary">Confirmar</button>
                </div>
              </div>

        </form>
      </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
