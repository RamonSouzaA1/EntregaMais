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
                    <a class="navbar-brand" href="clienteLogadoMenu.jsp">Entrega Mais</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><input type="number" required="" name="idCliente" value="${cliente.id}" readonly/></li>
                        <li><input type="text" required="" name="nome" value="${cliente.nome}" readonly/></li>
                        <li><a href="clienteLogadoMenu.jsp">Início</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <form action="FrontController?action=PrepararEditarCliente" method="post">
            <input type="number" required="" name="idCliente" value="${cliente.id}" invisible/>
            <input type="text" required="" name="nome" value="${cliente.nome}" invisible/>
            <button  class="btn btn-primary" >Editar meus dados pessoais</button>
        </form>

    </body>
</html>
