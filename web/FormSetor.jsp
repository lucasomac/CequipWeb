<%-- 
    Document   : FormSetor
    Created on : 05/10/2015, 09:28:28
    Author     : lomacedo
--%>

<%@page import="model.Setor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro Setor</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link rel="icon" type="imagem/png" href="includes/icon.png" />
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <h2>Cadastro Setor</h2>
        <%Setor setor = (Setor) request.getAttribute("setor");%>
        <form role="form" method="post" action="SetorControle?acao=Cadastrar">
            <div class="form-group">
                <label for="codigo">Codigo:</label>
                <input type="text" readonly="readonly" name="codigo" id="codigo" maxlength="8" value="<%=setor.getCodigo()%>" class="form-control">
            </div>
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" name="nome" id="nome" maxlength="20" value="<%=setor.getNome()%>" class="form-control">
            </div>
            <div class="form-group">
                <label for="descricao">Descrição</label>
                <input type="text" name="descricao" id="login" maxlength="40" value="<%=setor.getDescricao()%>" class="form-control">
            </div>
            <button type="submit" name="Salvar" id="Salvar" class="btn btn-success">Salvar</button>
            <button type="reset" name="Limpar" id="Limpar" class="btn btn-danger">Limpar</button>
        </form>
    </body>
</html>
