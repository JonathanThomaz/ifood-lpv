function dadosDaLoja() {
    let conteudo = `
              
    `;
    document.getElementById("titulo").innerHTML = `<h3>Dados Loja:</h3>`;
    document.getElementById("contend").innerHTML = conteudo;
}

function cadastrarProdutos() {
    let conteudo = `
                    
    `;
    document.getElementById("titulo").innerHTML = `<h3>Cadastrar Produtos:</h3>`;
    document.getElementById("contend").innerHTML = conteudo;
}

function MostrarLogin() {
    let conteudo = `
       <form action="FrontController?action=LogarConta" method="post">
            <table>
              <tr>
                <td>Login</td>
                <td><input type="text" name="txtLogin" /></td>
              </tr>
              <tr>
                <td>Senha</td>
                <td><input type="password" name="txtSenha" /></td>
              <tr>
                <td><input type="submit" value="Logar" /></td>
              </tr>
            </table>
        </form>
    `;
    document.getElementById("header").innerHTML = `<h3>Login</h3>`;
    document.getElementById("contend").innerHTML = conteudo;
}
function PaginaInicial() {
    window.location.href = "/ifood-lpv";
}