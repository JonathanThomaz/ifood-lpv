package action.consumidor;

import action.loja.SalvarLojaAction;
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
import model.Consumidor;
import model.Contato;
import model.Endereco;
import model.usuario.Conta;
import model.usuario.TipoContaConsumidor;
import persistence.ConsumidorDAO;
import persistence.ContaDAO;
import persistence.ContatoDAO;
import persistence.EnderecoDAO;

public class SalvarConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");

        String nome = request.getParameter("txtNome");
        String dataNascimento = request.getParameter("txtNascimento");
        String cpf = request.getParameter("txtCpf");

        String telefone = request.getParameter("txtTel");
        String ddd = request.getParameter("txtDDD");
        String email = request.getParameter("txtEmail");
        String telefoneComplementar = request.getParameter("txtTelCompl");

        String cep = request.getParameter("txtCep");
        String rua = request.getParameter("txtRua");
        String numero = request.getParameter("txtNum");
        String complemento = request.getParameter("txtComplemento");
        String bairro = request.getParameter("txtBairro");
        String cidade = request.getParameter("txtCidade");
        String estado = request.getParameter("txtEstado");
        String pais = request.getParameter("txtPais");

        try {
            TipoContaConsumidor tipoConta = new TipoContaConsumidor();
            
            Conta conta = new Conta();
            conta.setLogin(login).setSenha(senha).setTipoConta("Consumidor");
            conta = ContaDAO.getInstance().save(conta);
        
            
            Contato contato = new Contato();
            contato.setEmail(email).setTelefone(telefone).setDdd(ddd).setEmail(email)
                    .setTelefoneComplementar(telefoneComplementar).setConta(conta);
            ContatoDAO.getInstance().save(contato);
            
            Endereco endereco = new Endereco();
            endereco.setBairro(bairro).setRua(rua).setCep(cep).setNumero(numero)
                    .setComplemento(complemento).setCidade(cidade).setEstado(estado).setPais(pais).setConta(conta);
            EnderecoDAO.getInstance().save(endereco);
            
            Consumidor consumidor = new Consumidor();
            consumidor = consumidor.setNome(nome).setCpf(cpf).setNascimento(dataNascimento).setConta(conta);
            ConsumidorDAO.getInstance().save(consumidor);

            
            HttpSession sessao = request.getSession();
            sessao.invalidate();

            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalvarConsumidorAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SalvarLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
