<%-- 
    Document   : nav
    Created on : 30/11/2020, 22:45:40
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<nav>
    <h5>Menu: </h5>
    <ul>
        <li><a href="#" onclick="dadosDaLoja()">Dados da Loja</a></li>
        <li><a href="FrontController?action=CadastrarProdutoLoja">Cadastrar produto</a></li>
        <li><a href="FrontController?action=PrepararProdutosLoja">Ver Meus Produtos</a></li>
        <li><a href="FrontController?action=PrepararPedidosLoja">Pedidos</a></li>
        <li><a href="FrontController?action=PrepararPromocoesLoja">Promoções</a></li>
        <li><a href="/ifood-lpv">Sair</a></li>
    </ul>
</nav>