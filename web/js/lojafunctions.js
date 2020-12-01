function dadosDaLoja() {
    let conteudo = `
           <p>Aqui tera um formulario</p>   
    `;
    document.getElementById("titulo").innerHTML = `<h3>Dados Loja:</h3>`;
    document.getElementById("contend").innerHTML = conteudo;
}

function cadastrarProdutos() {
    let conteudo = `
        <p>Aqui tera um formulario</p>
                    
    `;
    document.getElementById("titulo").innerHTML = `<h3>Cadastrar Produtos:</h3>`;
    document.getElementById("contend").innerHTML = conteudo;
}

function PaginaInicialLoja() {
    window.location.href = "/ifood-lpv/loja/index";
}
