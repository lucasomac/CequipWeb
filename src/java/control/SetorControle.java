/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Setor;
import model.SetorDao;

/**
 *
 * @author lomacedo
 */
@WebServlet(name = "SetorControle", urlPatterns = {"/SetorControle"})
public class SetorControle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        System.out.println("Chamando Método GET");
        //Instancia do setor DAO
        SetorDao setorDao = new SetorDao();
        //Chama o request da acao
        String acao = request.getParameter("acao");
        //Aç?o de cadastrar
        if (acao != null && acao.equals("Cadastrar")) {
            //cria objetos para cadastrar
            Setor setor = new Setor();
            setor.setCodigo(0);
            setor.setNome("");
            setor.setDescricao("");
            //seta atributo no request
            request.setAttribute("setor", setor);
            //encaminha objeto usuario para tela
            RequestDispatcher saida = request.getRequestDispatcher("FormSetor.jsp");
            saida.forward(request, response);
            //redirecionando para o cliente a aç?o lista
            response.sendRedirect("SetorControle?acao=Lista");
        }
        //Ação Listar todos
        if (acao != null && acao.equals("Lista")) {
            //pede para DAO listar objeto no banco.
            List<Setor> lista = setorDao.getLista();
            //Encaminhamento para JSP
            request.setAttribute("Lista", lista); //guarda a lista no request
            RequestDispatcher saida = request.getRequestDispatcher("FormListaSetor.jsp");
            saida.forward(request, response);
        }
        //Ação alterar
        if (acao != null && acao.equals("Alterar")) {
            //Captura parametro da tela
            String codigo = request.getParameter("codigo");
            //cria objetos Alterar
            Setor setor = setorDao.getSetor(Integer.parseInt(codigo));
            //seta atributo no request
            request.setAttribute("setor", setor);
            //encaminha objeto usuario para tela
            RequestDispatcher saida = request.getRequestDispatcher("FormSetor.jsp");
            saida.forward(request, response);
            //redirecionando para o cliente a aç?o lista
            response.sendRedirect("SetorControle?acao=Lista");
        }
        //Aç?o de Excluir
        if (acao != null && acao.equals("Excluir")) {
            //Captura parametro da tela
            String codigo = request.getParameter("codigo");
            //cria objetos Excluir
            Setor setor = new Setor();
            setor.setCodigo(Integer.parseInt(codigo));
            //pede para DAO excluir objeto no banco.
            setorDao.remove(setor);
            //redirecionando para o cliente a aç?o lista
            response.sendRedirect("SetorControle?acao=Lista");
        }
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
        System.out.println("Chamando método POST");
        //Recebe dados da tela
        String codigo = request.getParameter("codigo");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        //cria objetos para cadastrar
        Setor setor = new Setor();
        if (codigo != null) {
            setor.setCodigo(Integer.parseInt(codigo));
        }
        setor.setNome(nome);
        setor.setDescricao(descricao);
        //pede para DAO cadastrar objeto no banco.
        SetorDao setorDao = new SetorDao();
        setorDao.salvar(setor);
        //Saida do Browser
        PrintWriter saida = response.getWriter();
        saida.println("Salvo com sucesso");
        //redirecionando para o cliente a aç?o lista
        response.sendRedirect("SetorControle?acao=Lista");

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
