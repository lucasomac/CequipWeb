<%-- 
    Document   : FormEquip
    Created on : 06/10/2015, 09:19:53
    Author     : lomacedo
--%>
<%@page import="model.Setor"%>
<%@page import="model.Dispositivo"%>
<%@page import="model.SetorDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro Dispositivo</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link rel="icon" type="imagem/png" href="../includes/icon.png" />
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <h2>Cadastro Dispositivo</h2>
        <%Dispositivo dispositivo = (Dispositivo) request.getAttribute("dispositivo");%>
        <form role="form" method="post" action="DispositivoControle?acao=Cadastrar">
            <div class="form-group">
                <label for="patrimonio">Patrimônio:</label>
                <input type="text" name="patrimonio" id="patrimonio" maxlength="10" value="<%=dispositivo.getPatrimonio()%>" class="form-control">
            </div>
            <div class="form-group">
                <label for="serie">Número de Série:</label>
                <input type="text" name="serie" id="serie" maxlength="20" value="<%=dispositivo.getSerie()%>" class="form-control">
            </div>
            <div class="form-group">
                <label for="tipo">Tipo:</label>
                <input type="text" name="tipo" id="tipo" maxlength="15" value="<%=dispositivo.getTipo()%>" class="form-control">
            </div>
            <div class="form-group">
                <label for="marca">Marca:</label>
                <input type="text" name="marca" id="marca" maxlength="15" value="<%=dispositivo.getMarca()%>" class="form-control">
            </div>
            <div class="form-group">
                <label for="modelo">Modelo:</label>
                <input type="text" name="modelo" id="modelo" maxlength="15" value="<%=dispositivo.getModelo()%>" class="form-control">
            </div>
            <div class="form-group">
                <label for="setor">Setor:</label>
                <input type="text" name="setor" id="setor" maxlength="15" value="<%=dispositivo.getSetor()%>" class="form-control">
            </div>
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" name="nome" id="nome" maxlength="20" value="<%=dispositivo.getNome()%>" class="form-control">
            </div>
            <div class="form-group">
                <label for="usuario">Usuario:</label>
                <input type="text" name="usuario" id="usuario" maxlength="15" value="<%=dispositivo.getUsuario()%>" class="form-control">
            </div>
            <button type="submit" name="Salvar" id="Salvar" class="btn btn-success">Cadastrar</button>
            <button type="reset" name="Limpar" id="Limpar" class="btn btn-danger">Limpar</button>
        </form>
    </body>
</body>
</html>