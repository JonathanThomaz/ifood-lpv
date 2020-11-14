package action.conta;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.pedido.Pedido;
import model.categoria.Categoria;
import model.Consumidor;
import model.usuario.Conta;
import model.Loja;
import model.MainFactory;
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
                String tipo = conta.getTipoConta();
                LogarConta lc = (LogarConta) MainFactory.getObject("action.conta.LogarConta" + tipo);
                lc.logar(request, response, conta);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            view = request.getRequestDispatcher("index.jsp");
        }
    }
}
