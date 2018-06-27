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
        <title>Consulta Encomenda</title>
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
            <h3 class="page-header">Consulta de Encomenda</h3>
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <tr>
                        <td><strong>Id</strong></td>
                        <td><strong>Descrição</strong></td>
                        <td><strong>Id Cliente</strong></td>
                        <td><strong>Logradouro</strong></td>
                        <td><strong>nº</strong></td>
                        <td><strong>Bairro</strong></td>
                        <td><strong>Valor</strong></td>
                        <td><strong>Id Entregador</strong></td>
                        <td><strong>Data do Pedido</strong></td>
                        <td><strong>Data da Entrega</strong></td>
                        <td><strong>Situação</strong></td>
                        <td><strong>Acompanhamento</strong></td>
                        <td><strong>Voltar Situação</strong></td>
                    </tr>
                    <c:forEach items="${encomendas}" var="encomenda">
                        <tr>          
                            <td><c:out value="${encomenda.id}"></c:out></td>
                            <td><c:out value="${encomenda.descricao}"></c:out></td>
                            <td><c:out value="${encomenda.id_cliente}"></c:out></td>
                            <td><c:out value="${encomenda.logradouro}"></c:out></td>
                            <td><c:out value="${encomenda.numero}"></c:out></td>
                            <td><c:out value="${encomenda.bairro}"></c:out></td>
                            <td><c:out value="${encomenda.valor}"></c:out></td>
                            <td><c:out value="${encomenda.id_entregador}"></c:out></td>
                            <td><c:out value="${encomenda.data_pedido}"></c:out></td>
                            <td><c:out value="${encomenda.data_entrega}"></c:out></td>
                            <td><c:out value="${encomenda.situacao}"></c:out></td>
                            <td><c:out value="${encomenda.memento}"></c:out></td>
                            <td>
                                <form action="FrontController?action=MementoEncomenda&encomendaId=<c:out value="${encomenda.id}"></c:out>" method="post">
                                    <button>Desfazer</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div id="actions" class="row">
                <div class="col-md-12">
                    <form action="FrontController?action=PrepararGravarEncomenda&tipoCliente=CPF" method="post">
                        <button type="submit" class="btn btn-primary">Adicionar para cliente CPF</button>
                    </form>
                    <br>
                    <form action="FrontController?action=PrepararGravarEncomenda&tipoCliente=CNPJ" method="post">
                        <button type="submit" class="btn btn-primary">Adicionar para cliente CNPJ</button>
                    </form>
                    <br>
                    <a href="encomendaEditar.jsp" class="btn btn-success">Editar</a>
                    <a href="encomendaApagar.jsp" class="btn btn-danger">Apagar</a>
                    <a href="index.jsp" class="btn btn-warning">Fechar</a>  
                </div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
