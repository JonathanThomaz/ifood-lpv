<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <title>FoodQueen - Editar dados</title>

    </head>
    <body>
        <h2 class="bradcaump-title">Editar dados - Usuário</h2>

        <a href="FrontController?action=PrepararDadosConsumidor">Início</a>
        <span>Editar dados pessoais</span>

        <form action="FrontController?action=EditarDadosConsumidor" method="post">
                                
            <label for="txtNome">Nome</label>
            <input type="text" class="form-control"  <c:if test="${consumidor.nome != null}">
                value="${consumidor.nome}"</c:if> id="txtNome" name="txtNome">

            <label for="txtNascimento">Data de nascimento</label>
            <input type="text" class="form-control" <c:if test="${consumidor.nascimento != null}">
                value="${consumidor.nascimento}"</c:if> id="txtNascimento" name="txtNascimento">

            <label for="txtCpf">CPF</label>
            <input type="text" class="form-control" <c:if test="${consumidor.cpf != null}">
                value="${consumidor.cpf}"</c:if> id="txtCpf" name="txtCpf">
            <button type="submit">Salvar</button>
            <a  href="FrontController?action=PrepararHomeConsumidor">Cancelar</a>

        </form>

    </body>
</html>
