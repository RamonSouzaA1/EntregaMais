<%-- 
    Document   : index
    Created on : 24/04/2018, 01:07:26
    Author     : Ramon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <title>DP Delivery</title>
    </head>
    <body>
        <style>
            .pequeno {
                width: 10%;
            }

            .medio {
                width: 20%;
            }
        </style>
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
            <h1 style="text-align: center" class="page-header"><strong>Sistema DPDelivery</strong></h1>

            <div class="row" style="text-align: center">

                <h2 style="text-align: center">Cadastro</h1>

                    <div class="col-md-12">      
                        <form action="FrontController?action=LerCliente" method="post">
                            <button class="btn btn-success medio">Clientes</button>
                        </form>
                        <hr>
                        <form action="FrontController?action=LerClienteCNPJ" method="post">
                            <button class="btn btn-success medio">Clientes CNPJ</button>
                        </form>
                        <hr>
                        <form action="FrontController?action=LerEntregador" method="post">
                            <button class="btn btn-success medio">Entregadores</button>
                        </form>
                        <hr>
                        <form action="FrontController?action=LerMontador" method="post">
                            <button class="btn btn-success medio">Montadores</button>
                        </form>
                        <hr>
                        <form action="FrontController?action=LerVeiculo" method="post">
                            <button class="btn btn-success medio">Veiculos</button>
                        </form>
                        <hr>
                        <form action="FrontController?action=LerEncomenda" method="post">
                            <button class="btn btn-success medio">Encomendas</button>
                        </form>
                        <hr>
                    </div>      
            </div> 
            <div class="row" style="text-align: center">
                <h2 style="text-align: center">Verificação</h2>
                <form action="FrontController?action=LerFuncionario" method="post">
                    <button class="btn btn-success medio">Funções Funcionários</button>
                </form>

            </div>
            <br>
            <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
        </div>
    </div>
</div>

</body>
</html>
