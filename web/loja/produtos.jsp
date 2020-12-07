<%-- 
    Document   : produtos.jsp
    Created on : 07/12/2020, 10:13:32
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem-Vindo</title>
        <%@ include file="./shared/head.jsp" %>
    </head>
    <body>
        <header class="title-top">
            <h1>Ifood-LPV</h1>
        </header>
        <%@ include file="./shared/nav.jsp" %>
        <div class="conteudo">
            <div id="titulo"></div>
            <div  id="contend">             
                <table>
                    <thead>
                        <tr>
                            <th scope="col">Nome</th>
                            <th scope="col">Preço</th>
                            <th scope="col">Ação</th>
                        </tr>
                    </thead>
                    <tbody><c:forEach items="${produtos}" var="produto">
                            <tr>

                                <td>${produto.nome}</td>
                                <td>${produto.preco}</td>
                                <td><a href="FrontController?action=LerProdutoLoja&id=${produto.id}" >Editar</a>
                                    <a href="FrontController?action=DeletarProdutoLoja&id=${produto.id}">Deletar</a></td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
        <%@ include file="./shared/footer.jsp" %>
    </body>
</html>
