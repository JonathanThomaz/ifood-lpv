package action.conta;

import controller.Action;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MainFactory;
import model.usuario.Conta;
import model.usuario.TipoConta;
import persistence.ContaDAO;

public class LogarContaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");
        
        Conta conta;
        RequestDispatcher view = null;
        try {            
            conta = ContaDAO.getInstance().get(login);
            
            if (conta != null && conta.getLogin().equals(login) && conta.getSenha().equals(senha)) {
                TipoConta tipo = conta.getTipoConta();
                LogarConta lc = (LogarConta) MainFactory.getObject("action.conta.LogarConta" + tipo.getTipo());
                lc.logar(request, response, conta);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            view = request.getRequestDispatcher("index.jsp");
        }
    }
}
