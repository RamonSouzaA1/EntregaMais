<%@page contentType="text/html" pageEncoding="windows-1252"%>
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
        <title>Cadastro de Encomenda</title>
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
                        <li><a href="index.jsp">In�cio</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div id="main" class="container-fluid">
            <h3 class="page-header">Cadastro de Encomenda</h3>

            <form action="FrontController?action=GravarEncomenda" method="post">
                <input type="text" class="form-control" id="campo12" value="${tipoCliente}" name="tipoCliente" readonly/>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="campo1">Descri��o</label>
                        <input type="text" class="form-control" id="campo1" name="txtDescricao"/>
                    </div>

                    <div class="form-group col-md-3">
                        <label for="campo2">Peso</label>
                        <input type="text" class="form-control" id="campo2" name="txtPeso"/>
                    </div>

                    <div class="form-group col-md-2">
                        <label for="campo4">Id Cliente: </label>
                        <select class="form-control" id="campo4" name="txtId_cliente">
                            <c:forEach items="${clientes}" var="cliente">
                                <option value="${cliente.id}">${cliente.nome}</option>
                            </c:forEach>
                        </select>
                    </div> 
                    
                    <div class="form-group col-md-3">
                        <label for="campo2">Id entregador</label>
                        <input type="text" class="form-control" id="campo2" name="txtId_entregador"/>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="campo5">Logradouro</label>
                        <input type="text" class="form-control" id="campo5" name="txtLogradouro"/>
                    </div> 

                    <div class="form-group col-md-4">
                        <label for="campo6">N�mero</label>
                        <input type="text" class="form-control" id="campo6" name="txtNumero"/>
                    </div> 

                    <div class="form-group col-md-4">
                        <label for="campo7">Bairro</label>
                        <input type="text" class="form-control" id="campo7" name="txtBairro"/>
                    </div>    

                    <div class="form-group col-md-4">
                        <label for="campo8">Cep</label>
                        <input type="text" class="form-control" id="campo8" name="txtCep"/>
                    </div> 

                    

                    <div class="form-group col-md-6">
                        <label for="campo10">Data Pedido</label>
                        <input type="text" class="form-control" id="campo10" name="txtData_pedido"/>
                    </div> 

                    <div class="form-group col-md-6">
                        <label for="campo11">Data Entrega</label>
                        <input type="text" class="form-control" id="campo11" name="txtData_entrega"/>
                    </div>
                </div>     

                <hr/>
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
