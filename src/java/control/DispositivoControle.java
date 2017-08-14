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
import model.Dispositivo;
import model.DispositivoDao;
import model.Setor;
import model.SetorDao;

/**
 *
 * @author lomacedo
 */
@WebServlet(name = "DispositivoControle", urlPatterns = {"/DispositivoControle"})
public class DispositivoControle extends HttpServlet {

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
        DispositivoDao dispositivoDao = new DispositivoDao();
        //Chama o request da acao
        String acao = request.getParameter("acao");
        //Aç?o de cadastrar
        if (acao != null && acao.equals("Cadastrar")) {
            //cria objetos para cadastrar
            Dispositivo dispositivo = new Dispositivo();
            dispositivo.setPatrimonio(0);
            dispositivo.setSerie("");
            dispositivo.setTipo("");
            dispositivo.setMarca("");
            dispositivo.setModelo("");
            dispositivo.setSetor(null);
            dispositivo.setNome("");
            dispositivo.setUsuario("");
            //seta atributo no request
            request.setAttribute("dispositivo", dispositivo);
            //encaminha objeto usuario para tela
            RequestDispatcher saida = request.getRequestDispatcher("FormDisp.jsp");
            saida.forward(request, response);
            //redirecionando para o cliente a aç?o lista
            response.sendRedirect("DispositivoControle?acao=Lista");
        }
        //Ação listar todos
        if (acao != null && acao.equals("Lista")) {
            //pede para DAO listar objeto no banco.
            List<Dispositivo> lista = dispositivoDao.getLista();
            //Encaminhamento para JSP
            request.setAttribute("Lista", lista); //guarda a lista no request
            RequestDispatcher saida = request.getRequestDispatcher("FormListaDisp.jsp");
            saida.forward(request, response);
        }
        //Ação alterar
        if (acao != null && acao.equals("Alterar")) {
            //Captura parametro da tela
            String serie = request.getParameter("serie");
            //cria objetos Alterar
            Dispositivo dispositivo = dispositivoDao.getDispositivo(serie.toString());
            //seta atributo no request
            request.setAttribute("dispositivo", dispositivo);
            //encaminha objeto usuario para tela
            RequestDispatcher saida = request.getRequestDispatcher("FormDispositivo.jsp");
            saida.forward(request, response);
            //redirecionando para o cliente a aç?o lista
            response.sendRedirect("DispositivoControle?acao=Lista");
        }
        //Aç?o de Excluir
        if (acao != null && acao.equals("Excluir")) {
            //Captura parametro da tela
            String serie = request.getParameter("serie");
            //cria objetos Excluir
            Dispositivo dispositivo = new Dispositivo();
            dispositivo.setSerie(serie);
            //pede para DAO excluir objeto no banco.
            dispositivoDao.remove(dispositivo);
            //redirecionando para o cliente a aç?o lista
            response.sendRedirect("DispositivoControle?acao=Lista");
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
        int patrimonio = Integer.parseInt(request.getParameter("patrimonio"));
        String serie = request.getParameter("serie");
        String tipo = request.getParameter("tipo");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        Setor setor = new SetorDao().getSetor((request.getParameter("setor")));
        String nome = request.getParameter("nome");
        String usuario = request.getParameter("usuario");
        Dispositivo dispositivo = new Dispositivo();
        //cria objetos para cadastrar
        dispositivo.setPatrimonio(patrimonio);
        dispositivo.setSerie(serie);
        dispositivo.setTipo(tipo);
        dispositivo.setMarca(marca);
        dispositivo.setModelo(modelo);
        dispositivo.setSetor(setor);
        dispositivo.setNome(nome);
        dispositivo.setUsuario(usuario);
        //pede para DAO cadastrar objeto no banco.
        DispositivoDao dispositivoDao = new DispositivoDao();
        dispositivoDao.adiciona(dispositivo);
        //Saida do Browser
        PrintWriter saida = response.getWriter();
        saida.println("Salvo com sucesso");
        //redirecionando para o cliente a aç?o lista
        response.sendRedirect("DispositivoControle?acao=Lista");
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
