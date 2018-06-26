<%-- 
    Document   : clienteLogadoMenu
    Created on : 23/06/2018, 15:26:34
    Author     : Ramon
--%>
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
        <title>Menu Cliente</title>
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
        <form action="FrontController?action=PrepararEditarCliente" method="post">
            <input type="hidden" required="" name="idCliente" value="${cliente.id}" />
            <input type="hidden" required="" name="nome" value="${cliente.nome}" />
            <button  class="btn btn-primary" >Editar meus dados pessoais</button>
        </form>
        <form action="FrontController?action=PrepararPedidoCliente" method="post">
            <input type="hidden" required="" name="idCliente" value="${cliente.id}" />
            <input type="hidden" required="" name="nome" value="${cliente.nome}" />
            <button  class="btn btn-primary" >Fazer Pedido</button>
        </form>
        <form action="FrontController?action=PrepararHistoricoCliente" method="post">
            <input type="hidden" required="" name="idCliente" value="${cliente.id}" />
            <input type="hidden" required="" name="nome" value="${cliente.nome}" />
            <button  class="btn btn-primary" >Ver Pedidos Anteriores</button>
        </form>
    </body>
</html>
