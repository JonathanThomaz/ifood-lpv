<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/css.css">

        <title>Ifood-LPV</title>
    </head>
    <body>
        <header>
            <h1><a class="paginaInicialLink" href="#" onclick="PaginaInicial()">Ifood-LPV</a></h1>
        </header>
        <section>
            <nav>
                <ul>
                    <li><a class="menuItem" href="#" onclick="MostrarCadastrarUsuario()">
                            <h5>Cadastrar Consumidor</h5>
                        </a></li>
                        <li><a class="menuItem" href="#" onclick="MostrarLogin()">
                            <h5>Login</h5>
                        </a ></li>
                </ul>
            </nav>

            <div class="conteudo">
                <span id="header"></span>
                <div id="contend">
                    <h1>Bem-Vindo</h1>
                </div>
            </div>
        </section>
        <footer>
            <p>Footer</p>
        </footer>
        <script language="javascript" src="./js/functions.js"></script>
    </body>
</html>