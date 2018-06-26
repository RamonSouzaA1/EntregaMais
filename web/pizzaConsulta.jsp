<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <title>Consulta Veículo</title>
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
                        <li><a href="index.jsp">Início</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div id="main" class="container-fluid">
            <h3 class="page-header">Consulta de Pizzas</h3>
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <tr>
                        <td><stong>Cod.</stong></td>
                        <td><stong>Nome</stong></td>
                        <td><stong>Ingredientes</stong></td>
                        <td><stong>Preço Média</stong></td>
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

            </div>

            <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="pizzaAdicionar.jsp" class="btn btn-primary">Adicionar</a>
                    <a href="pizzaEditar.jsp" class="btn btn-success">Editar</a>
                    <a href="pizzaApagar.jsp" class="btn btn-danger">Apagar</a>
                    <a href="index.jsp" class="btn btn-warning">Fechar</a>
                </div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
