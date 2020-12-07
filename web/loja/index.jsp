<%-- 
    Document   : index
    Created on : 30/11/2020, 22:39:34
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Document   : home
    Created on : 30/11/2020, 14:34:48
    Author     : admin
--%>
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
            <h1>${loja.getNome()}</h1>
        </header>
        <%@ include file="./shared/nav.jsp" %>
        <div class="conteudo">
            <div id="titulo"></div>
            <div  id="contend">             
                
            </div>
        </div>
        <%@ include file="./shared/footer.jsp" %>
    </body>
</html>
