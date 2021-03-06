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
        <title>Consulta Pedido</title>
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
            <h3 class="page-header">Consulta de Coquetéis</h3>
            <div class="table-responsive"> 
                <table class="table table-bordered table-hover">
                    <tr>
                        <td><strong>id</strong></td>
                        <td><strong>hora</strong></td>
                        <td><strong>dataPedido</strong></td>
                        <td><strong>valorPedido</strong></td>
                        <td><strong>Drink</strong></td>
                    </tr>

                    <c:forEach items="${pedidos}" var="pedido">
                        <tr>
                            <td><c:out value="${pedido.id}"></c:out></td>
                            <td><c:out value="${pedido.hora}"></c:out></td>
                            <td><c:out value="${pedido.dataPedido}"></c:out></td>
                            <td><c:out value="${pedido.valorPedido}"></c:out></td>
                            <td><c:out value="${pedido.drink}"></c:out></td>
                            </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
