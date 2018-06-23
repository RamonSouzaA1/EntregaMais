<%-- 
    Document   : clienteLogadoEditar
    Created on : 23/06/2018, 14:57:02
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
        <title>Editar Cliente</title>
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
                    <a class="navbar-brand" href="clienteLogadoMenu">DPDelivery</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="clienteLogadoMenu.jsp">Início</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div id="main" class="container-fluid">
            <h3 class="page-header">Editar Cliente</h3>

            <form action="FrontController?action=EditarCliente" method="post">
                <input type="number" required="" name="idCliente" value="${cliente.id}" readonly/>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="campo1">Nome</label>
                        <input type="text" class="form-control" id="campo1" name="txtNome"/>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="campo2">Logradouro</label>
                        <input type="text" class="form-control" id="campo2" name="txtLogradouro"/>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="campo3">Bairro</label>
                        <input type="text" class="form-control" id="campo3" name="txtBairro"/>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="campo4">Número</label>
                        <input type="text" class="form-control" id="campo4" name="txtNumero"/>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="campo5">CEP</label>
                        <input type="text" class="form-control" id="campo5" name="txtCep"/>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="campo6">Telefone</label>
                        <input type="text" class="form-control" id="campo6" name="txtTelefone"/>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="campo7">Celular</label>
                        <input type="text" class="form-control" id="campo7" name="txtCelular"/>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="campo8">Cpf</label>
                        <input type="text" class="form-control" id="campo8" name="txtDoc"/>
                    </div>

                </div>

                <hr />
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
