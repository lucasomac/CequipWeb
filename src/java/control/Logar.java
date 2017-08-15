package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;
import model.UsuarioDao;

/**
 *
 * @author neilton.barreto
 */
@WebServlet(name = "Logar", urlPatterns = {"/Logar"})
public class Logar extends HttpServlet {

    private Usuario usuRetorno = new Usuario();
    private UsuarioDao usuDao = new UsuarioDao();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Invalidando a sessao para a saida do sistema. Menu saida.
        HttpSession sessao = request.getSession(false);
        if (sessao != null) {
            sessao.invalidate();
        }
        //Finaliza e redireciona para a tela inicial.
        response.sendRedirect("login.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Captura dados da tela
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        //Constroi o objeto usuario para consulta
//        Usuario usu = new Usuario();
//        usu.setLogin(login);
//        usu.setSenha(senha);
        //busca no banco de dados
//        s
        usuRetorno = usuDao.getUsuario(login, senha);
        if (!usuRetorno.equals(null)) {
            //Criando session
            HttpSession sessao = request.getSession();
            sessao.setMaxInactiveInterval(3000);
            sessao.setAttribute("usuLogado", usuRetorno);
            //Encaminhando ao index
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
