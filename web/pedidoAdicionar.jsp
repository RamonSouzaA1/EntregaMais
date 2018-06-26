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
                        <form action="FrontController?action=PrepararMenuCliente" method="post">
                            <input type="hidden" required="" name="idCliente" value="${cliente.id}" />
                            <input type="text" required="" name="nome" value="${cliente.nome}" readonly/>
                            <button  class="btn btn-primary" >Início</button>
                        </form>
                    </ul>
                </div>
            </div>
        </nav>
        <div id="main" class="container-fluid">
            <h3 class="page-header">Cadastro de Pedidos</h3>

            <form action="FrontController?action=GravarPedido" method="post">
                <input type="hidden" required="" name="idCliente" value="${cliente.id}"/>
                <input type="hidden" required="" name="nome" value="${cliente.nome}"/>
                <div class="row">
                    <table class="table table-bordered table-hover">
                        <tr>
                            <td><stong>Cod.</stong></td>
                            <td><stong>Nome</stong></td>
                            <td><stong>Ingredientes</stong></td>
                            <td><stong>Preço Média</stong></td>
                            <td><stong>Preço Família</stong></td>
                            <td><stong>Preço Família</stong></td>
                        </tr>
                        <c:forEach items="${pizzas}" var="pizza">
                            <tr>
                                <td><c:out value="${pizza.id}"></c:out></td>
                                <td><c:out value="${pizza.nome}"></c:out></td>
                                <td><c:out value="${pizza.ingrediente}"></c:out></td>
                                <td><c:out value="${pizza.precoMedia}"></c:out></td>
                                <td><c:out value="${pizza.precoFamilia}"></c:out></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div class="form-group col-md-6">
                        <label for="campo1">Data Pedido</label>
                        <input type="text" class="form-control" id="campo2" name="txtDataPedido"/>  
                    </div>
                    <div class="form-group col-md-4">
                        <label for="campo2">Valor Pedido</label>
                        <input type="text" class="form-control" id="campo3" name="txtValorPedido"/>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="campo3">Hora</label>
                        <input type="text" class="form-control" id="campo1" name="txtHora"/>
                    </div>    
                </div>
                <hr>
                <div id="actions" class="row">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary">Salvar</button>
                    </div>
                </div>

            </form>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
