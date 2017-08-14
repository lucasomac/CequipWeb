<%-- 
    Document   : FormListaSetor
    Created on : 05/10/2015, 11:10:33
    Author     : lomacedo
--%>

<%@page import="java.util.List"%>
<%@page import="model.Setor"%>
<%@page import="model.SetorDao" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function confirmaExclusao(codigo) {
                if (window.confirm("Tem certeza que deseja excluir o registro " + codigo))
                {
                    location.href = "SetorControle?acao=Excluir&codigo=" + codigo;
                }
            }
        </script>    
        <title>Lista de Setores</title>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link rel="icon" type="imagem/png" href="includes/icon.png" />
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <table class="table table-hover table-striped">
            <caption>LISTA DE SETORES</caption>
            <thead>
                <tr class="success">
                    <th>Codigo</th>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
                <%
                    SetorDao setorDao = new SetorDao();
                    List<Setor> lista = setorDao.getLista();
                    //Recebimento do request no Controle (ScriptLet)
                    //List<Usuario> lista = (List<Usuario> ) request.getAttribute("lista");
                    for (Setor setor : lista) {
                %>
                <tr>
                    <td><%=setor.getCodigo()%></td>
                    <td><%=setor.getNome()%></td>
                    <td><%=setor.getDescricao()%></td>
                    <td>
                        <a href="javascript:confirmaExclusao(<%=setor.getCodigo()%>)">Excluir</a>
                        |
                        <a href="SetorControle?acao=Alterar&codigo=<%=setor.getCodigo()%>">Alterar</a>
                    </td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>