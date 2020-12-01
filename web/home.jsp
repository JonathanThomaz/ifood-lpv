<%-- 
    Document   : home
    Created on : 30/11/2020, 14:34:48
    Author     : admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem-Vindo</title>
        <%@ include file="./shared/head.jsp" %>
    </head>
    <body>
        <header class="title-top">
            <h1>Bem Vindo</h1>
        </header>
        <%@ include file="./shared/navbar.jsp" %>
        <div class="conteudo">
            <c:forEach items="${produtos}" var="produto">
                <div class="verProduto">
                    <div>
                        <img src="${produto.imagem}" alt="product images" style="max-height: 105px; max-width: 109px;">
                    </div>
                    <div>
                        <div>
                            <h4><a href="FrontController?action=AdicionarCarrinhoConsumidor&id=${produto.id}">${produto.nome}</a></h4>
                            <span>R$ ${produto.getPrecoDeVenda()}</span>
                        </div>
                        <div>
                            <div>
                                <p>${produto.descricao}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <%@ include file="./shared/footer.jsp" %>
    </body>
</html>
