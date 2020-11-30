function MostrarCadastrarUsuario() {
    let conteudo = `
                    <form action="FrontController?action=SalvarConsumidor" method="post">
                        
                    <h3 class="mb-3 mt-5">Dados</h3>
                        <div class="form-group">
                            <label for="txtLogin">Login</label>
                            <input type="text" class="form-control" id="txtLogin" name="txtLogin">
                        </div>
                        <div class="form-group">
                            <label for="txtSenha">Senha</label>
                            <input type="password" class="form-control" id="txtSenha" name="txtSenha">
                        </div>
                        <div class="form-group">
                            <label for="txtNome">Nome</label>
                            <input type="text" class="form-control" id="txtNome" name="txtNome">
                        </div>
                        <div class="form-group">
                            <label for="txtNascimento">Data de nascimento</label>
                            <input 
                            type="date" class="form-control" 
                            id="txtNascimento" 
                            name="txtNascimento"
                            >
                        </div>
                        <div class="form-group">
                            <label for="txtCpf">CPF</label>
                            <input 
                            type="text"
                            maxlength=11 
                            class="form-control" 
                            id="txtCpf" 
                            name="txtCpf"
                            >
                        </div>
                    
                    <h3 class="mb-3 mt-5">Contato</h3>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-3">
                                    <label for="txtDDD">DDD</label>
                                    <input type="text" class="form-control" id="txtDDD" name="txtDDD">
                                </div>
                                <div class="col-md-9">
                                    <label for="txtTel">Telefone</label>
                                    <input type="text" class="form-control" id="txtTel" name="txtTel">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-3">
                                </div>
                                <div class="col-md-9">
                                    <label for="txtTelCompl">Telefone complementar</label>
                                    <input type="text" class="form-control" id="txtTelCompl" name="txtTelCompl">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="txtEmail">Email</label>
                            <input type="text" class="form-control" id="txtEmail" name="txtEmail">
                        </div>
                    
                    <h3 class="mb-3 mt-5">Endereço</h3>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="txtRua">Rua</label>
                                    <input type="text" name="txtRua" id="txtRua" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="txtNum">Numero</label>
                                    <input type="text" name="txtNum" id="txtNum" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group ">
                                    <label for="txtComplemento">Complemento</label>
                                    <input type="text" name="txtComplemento" id="txtComplemento" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group ">
                                    <label for="txtBairro">Bairro</label>
                                    <input type="text" name="txtBairro" id="txtBairro" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group ">
                                    <label for="txtCidade">Cidade</label>
                                    <input type="text" name="txtCidade" id="txtCidade" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group ">
                                    <label for="txtEstado">Estado</label>
                                    <input type="text" name="txtEstado" id="txtEstado" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group ">
                                    <label for="txtPais">Pais</label>
                                    <input type="text" name="txtPais" id="txtPais" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group ">
                                    <label for="txtCep">CEP</label>
                                    <input type="text" name="txtCep" id="txtCep" class="form-control"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group text-right">
                            <button type="submit" class="btn btn-lg btn-success">Cadastrar</button>
                        </div>
                    </form>
    `;
    document.getElementById("header").innerHTML = `<h3>Cadastrar Consumidor</h3>`;
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
                <td><input type="text" name="txtSenha" /></td>
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