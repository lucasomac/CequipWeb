<%-- 
    Document   : FormListaDisp
    Created on : 06/10/2015, 12:20:01
    Author     : lomacedo
--%>

<%@page import="model.Dispositivo"%>
<%@page import="java.util.List"%>
<%@page import="model.DispositivoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function confirmaExclusao(serie) {
                if (window.confirm("Tem certeza que deseja excluir o registro \"" + serie + "\""))
                {
                    location.href = "DispositivoControle?acao=Excluir&serie=\"" + serie + "\"";
                }
            }
        </script>    
        <title>Lista de Dispositivos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link rel="icon" type="imagem/png" href="includes/icon.png" />
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <table class="table table-hover table-striped">
            <caption>LISTA DE DISPOSITIVOS</caption>
            <thead>
                <tr class="success">
                    <th>Patrimonio</th>
                    <th>Série</th>
                    <th>Tipo</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Setor</th>
                    <th>Nome</th>
                    <th>Usúario</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
                <%
                    DispositivoDao dispositivoDao = new DispositivoDao();
                    List<Dispositivo> lista = dispositivoDao.getLista();
                    //Recebimento do request no Controle (ScriptLet)
                    //List<Usuario> lista = (List<Usuario> ) request.getAttribute("lista");
                    for (Dispositivo dispositivo : lista) {
                %>
                <tr>
                    <td><%=dispositivo.getPatrimonio()%></td>
                    <td><%=dispositivo.getSerie()%></td>
                    <td><%=dispositivo.getTipo()%></td>
                    <td><%=dispositivo.getMarca()%></td>
                    <td><%=dispositivo.getModelo()%></td>
                    <td><%=dispositivo.getSetor().getNome()%></td>
                    <td><%=dispositivo.getNome()%></td>
                    <td><%=dispositivo.getUsuario()%></td>
                    <td>
                        <a href="javascript:confirmaExclusao(<%=dispositivo.getSerie()%>)">Excluir</a>
                        |
                        <a href="DispositivoControle?acao=Alterar&serie=<%=dispositivo.getSerie()%>">Alterar</a>
                    </td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>