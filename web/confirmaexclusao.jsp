<%-- 
    Document   : confirmaexclusao
    Created on : 02/11/2020, 14:02:14
    Author     : Note
--%>

<%@page import="negocio.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirma exclusão</title>
    </head>
    <body>

        <h1>Confirma a exclusão do produto ${produtoSelecionado.getNome()} ?</h1>
        <form method="post" action="ProdutoController">
            <input type="hidden" name="tela" value="confirmaexclusao"/>
            <input type="hidden" value="${produtoSelecionado.getCodproduto()}" name="codproduto"/>
            <input type="submit" value="Excluir produto"/>
        </form>

    </body>
</html>