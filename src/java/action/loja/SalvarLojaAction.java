package action.loja;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Contato;
import model.Loja;
import model.Endereco;
import model.categoria.Categoria;
import model.usuario.Conta;
import model.usuario.TipoContaLoja;
import persistence.ContaDAO;
import persistence.ContatoDAO;
import persistence.EnderecoDAO;
import persistence.LojaDAO;

public class SalvarLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        TipoContaLoja tipoConta = new TipoContaLoja();
        
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");

        String nome = request.getParameter("txtNome");
        String cnpj = request.getParameter("txtCnpj");
        String descricao = request.getParameter("txtDescricao");
        String imagem = request.getParameter("txtImagem");

        String cep = request.getParameter("txtCep");
        String rua = request.getParameter("txtRua");
        String numero = request.getParameter("txtNum");
        String complemento = request.getParameter("txtComplemento");
        String bairro = request.getParameter("txtBairro");
        String cidade = request.getParameter("txtCidade");
        String estado = request.getParameter("txtEstado");
        String pais = request.getParameter("txtPais");

        String telefone = request.getParameter("txtTel");
        String ddd = request.getParameter("txtDDD");
        String email = request.getParameter("txtEmail");
        String telefoneComplementar = request.getParameter("txtTelCompl");

        try {
            Conta conta = new Conta();
            conta = conta.setLogin(login).setSenha(senha).setTipoConta("Loja");
            conta = ContaDAO.getInstance().save(conta);
            
            Endereco endereco = new Endereco();
            endereco.setBairro(bairro).setRua(rua).setCep(cep).setNumero(numero)
                    .setComplemento(complemento).setCidade(cidade).setEstado(estado).setPais(pais).setConta(conta);
            EnderecoDAO.getInstance().save(endereco);
            System.out.println(endereco.getCep());
            System.out.println(endereco.getCidade());
            System.out.println(endereco.getRua());
            Contato contato = new Contato();
            contato.setEmail(email).setTelefone(telefone).setDdd(ddd).setEmail(email)
                    .setTelefoneComplementar(telefoneComplementar).setConta(conta);
            ContatoDAO.getInstance().save(contato);
            
            
            Loja loja = new Loja();
            loja = loja.setNome(nome).setCnpj(cnpj).setDescricao(descricao).setImagem(imagem).setConta(conta);
            LojaDAO.getInstance().save(loja);

            HttpSession sessao = request.getSession();
            sessao.invalidate();

            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalvarLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SalvarLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
