
package action.conta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.usuario.Conta;

public interface LogarConta {

    public void logar(HttpServletRequest request, HttpServletResponse response, Conta conta);
}
