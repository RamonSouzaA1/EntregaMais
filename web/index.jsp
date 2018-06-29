<%-- 
    Document   : index
    Created on : 21/06/2018, 09:36:15
    Author     : Aluno
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
        <title>Entrega Mais</title>
    </head>
    <body background="img/Restaurante.jpg">
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
                    <a class="navbar-brand" href="#">Entrega Mais</a>
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

                        <button class="btn btn-primary" onclick="window.location.href = 'clienteAdicionar.jsp'">Cadastrar cliente</button>
                        <hr>
                        <button class="btn btn-primary" onclick="window.location.href = 'clienteCNPJAdicionar.jsp'">Cadastrar cliente cnpj</button>
                        <hr>
                        <button class="btn btn-primary" onclick="window.location.href = 'clienteLogin.jsp'">Login Cliente</button>
                        <hr>

                        
                                           
                        <button class="btn btn-warning" onclick="window.location.href = 'clienteLogin.jsp'">Login Cliente</button>
                        <br>

                        <br><br><br><br>
                        <br>
                        <button class="btn btn-warning" onclick="window.location.href = 'areaRestritaMenu.jsp'">Area Restrita</button>
                        <br>
                    </div>      
            </div> 
            
            <div class="row" style="text-align: center">
                <h2 style="text-align: center">Verificação</h2>
                <form action="FrontController?action=LerFuncionarioCozinha" method="post">
                    <button class="btn btn-success medio">Funções Funcionários</button>
                </form>

            </div>
           
            <br>
            
            
            <br>
            <br>
            <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
        </div>
    </div>
</div>

</body>
</html>
