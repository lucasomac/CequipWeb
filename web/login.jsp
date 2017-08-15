<%-- 
    Document   : login
    Created on : 14/08/2017, 10:51:59
    Author     : lomacedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LOGIN</title>
        <script language = “Javascript”>
            function Validate() {
                var user = document.frm.login;
                var pass = document.frm.senha;
                if ((login.value === null) || (login.value === "")) {
                    alert("LOGIN NÃO INFORMADO");
                    user.focus();
                    return false;
                }
                if ((senha.value === null) || (senha.value === "")) {
                    alert("SENHA NÃO INFORMADA");
                    pass.focus();
                    return false;
                }
                return true;
            }
        </script>

        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link rel="icon" type="imagem/png" href="includes/icon.png" />
    </head>
    <body>
        <h3 align="center">CONTROLE DE EQUIPAMENTOS DO SERGIPE PREVIDÊNCIA</h3>
        <!--<h2 align="center" >Cadastro Setor</h2>-->
        <form role="form" method="post" action="Logar" onsubmit="return Validate()">
            <div class="form-group" align="center">
                <label for="login">Login:</label>
                <input type="text" name="login" id="login" maxlength="10" value="" class="form-control" >
            </div>
            <div class="form-group" align="center">
                <label for="senha">Descrição</label>
                <input type="password" name="senha" id="senha" maxlength="20" value="" class="form-control">
            </div>
            <div align="center">
                <button type="submit" name="Salvar" id="Entrar" class="btn btn-success">Entrar</button>
                <button type="reset" name="Limpar" id="Limpar" class="btn btn-danger">Limpar</button>
            </div>
        </form>    
    </body>
</html>
