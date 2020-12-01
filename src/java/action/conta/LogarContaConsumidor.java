package action.conta;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Consumidor;
import model.Produto;
import model.usuario.Conta;
import persistence.ConsumidorDAO;
import persistence.ProdutoDAO;

public class LogarContaConsumidor implements LogarConta {

    @Override
    public void logar(HttpServletRequest request, HttpServletResponse response, Conta conta) {
        Consumidor consumidor = ConsumidorDAO.getInstance().get(conta.getId());
        HttpSession session = request.getSession();
        ArrayList<Produto> produtos = null;
        
        try {
            produtos = ProdutoDAO.getInstance().getAll();
            session.setAttribute("idConsumidor", consumidor.getId());
            session.setAttribute("tipo", conta.getTipoConta());
            session.setAttribute("login", conta.getLogin());
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println(ex);
        }
    }

}
