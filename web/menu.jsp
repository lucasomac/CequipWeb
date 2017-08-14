<%-- 
    Document   : index
    Created on : 02/10/2015, 21:03:32
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CEQUIP</title>
    </head>
    <body>
        <h3 align="center">CONTROLE DE EQUIPAMENTOS DO SERGIPE PREVIDÊNCIA</h3>
        <!-- Incluindo o jQuery que é requisito do JavaScript do Bootstrap -->
        <script src="http://code.jquery.com/jquery-latest.js"></script>

        <!-- Incluindo o JavaScript do Bootstrap -->
        <script src="js/bootstrap.min.js"></script>
        <hr>
        <div class="navigation">
            <ul class="nav nav-pills nav-justified">
                <li class="dropdown">
                    <a class="dropdown-toggle"
                       data-toggle="dropdown"
                       href="#">SETOR
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu nav-justified">
                        <!-- links -->
                        <li><a tabindex="-1" href="SetorControle?acao=Cadastrar">CADASTRAR</a></li>
                        <li><a tabindex="-1" href="SetorControle?acao=Lista">EXCLUIR</a></li>
                        <li><a tabindex="-1" href="SetorControle?acao=Lista">ATUALIZAR</a></li>
                        <li><a tabindex="-1" href="SetorControle?acao=Lista">LISTAR</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle"
                       data-toggle="dropdown"
                       href="#">EQUIPAMENTO
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu nav-justified">
                        <!-- links -->
                        <li><a tabindex="-1" href="DispositivoControle?acao=Cadastrar">CADASTRAR</a></li>
                        <li><a tabindex="-1" href="DispositivoControle?acao=Lista">EXCLUIR</a></li>
                        <li><a tabindex="-1" href="DispositivoControle?acao=Lista">ATUALIZAR</a></li>
                        <li><a tabindex="-1" href="DispositivoControle?acao=Lista">LISTAR</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle"
                       data-toggle="dropdown"
                       href="#">MOVIMENTAÇÃO
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu nav-justified">
                        <!-- links -->
                        <li><a tabindex="-1" href="#">CADASTRAR</a></li>
                        <li><a tabindex="-1" href="#">EXCLUIR</a></li>
                        <li><a tabindex="-1" href="#">ATUALIZAR</a></li>
                        <li><a tabindex="-1" href="#">LISTAR</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <hr>
    </body>
</html>
