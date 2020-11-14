package action.conta;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Consumidor;
import model.Produto;
import model.categoria.Categoria;
import model.usuario.Conta;
import model.pedido.Pedido;
import persistence.ConsumidorDAO;

public class LogarContaConsumidor implements LogarConta {

    @Override
    public void logar(HttpServletRequest request, HttpServletResponse response, Conta conta) {
        Consumidor consumidor = ConsumidorDAO.getInstance().getByConta(conta.getId());
        HttpSession session = request.getSession();
        ArrayList<Produto> produtos = null;
        try {
            session.setAttribute("id", consumidor.getId());
            session.setAttribute("tipo", conta.getTipoConta());
            session.setAttribute("login", conta.getLogin());
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println(ex);
        }
    }

}
