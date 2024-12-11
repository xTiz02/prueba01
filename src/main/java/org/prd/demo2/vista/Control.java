
package org.prd.demo2.vista;

import org.prd.demo2.servicio.ServicioCesta;
import org.prd.demo2.servicio.ServicioMatricula;
import org.prd.demo2.servicio.ServicioCursos;
import org.prd.demo2.servicio.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {
    private Presentador pres;
    private ServicioCesta servCes;
    private ServicioMatricula Servicio;
    private Utils utils;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acc=request.getParameter("acc");
        if(acc.equals("Ingresar")){
            pres=new Presentador();
            servCes=new ServicioCesta();
            servCes.nuevaCesta();
            request.getSession().setAttribute("pres",pres);
            System.out.println(pres.toString());
            response.sendRedirect("Vista2.jsp");
        }
        if(acc.equals("Lista de Cursos")){
            List lis= ServicioCursos.listar();
            pres.setLis(lis);
            request.getSession().setAttribute("lis",lis);
            response.sendRedirect("Vista3.jsp");
        }
        if(acc.equals("Agregar Curso")){
            String cod=request.getParameter("cod");
            String nom=request.getParameter("nom");
            String cre=request.getParameter("cre");
            servCes.agregarCurso(cod, nom, cre);
            pres.setLis(servCes.getCesta());
            response.sendRedirect("Vista2.jsp");
        }
        if(acc.equals("Quitar Curso")){
            String cod=request.getParameter("cod");
            servCes.quitarCurso(cod);
            pres.setLis(servCes.getCesta());
            response.sendRedirect("Vista2.jsp");
        }
        if(acc.equals("Crear Matricula")){
            Object[]com= ServicioMatricula.nuevaMatricula();
            pres.setComp(com);
            pres.setLis(servCes.getCesta());
            response.sendRedirect("Vista4.jsp");
        }
        if ("Grabar Matricula".equals(acc)) {
            String num = request.getParameter("num");
            String nom = request.getParameter("nom");
            String totalStr = request.getParameter("total");

            List<Object[]> detalle = new ArrayList<>();
            for (int i = 0; request.getParameter("codigo_" + i) != null; i++) {
                String codigo = request.getParameter("codigo_" + i);
                String nombre = request.getParameter("nombre_" + i);
                int cantidad = Integer.parseInt(request.getParameter("cantidad_" + i));

                if (utils.isNotEmpty(codigo) && utils.isNotEmpty(nombre) && cantidad > 0) {
                    detalle.add(new Object[]{codigo, nombre, cantidad});
                }
            }

            String msg = Servicio.grabarMatricula(num,nom,Integer.parseInt(totalStr));
            pres.setMsg(msg);
            Servicio.grabarDetalleMatricula(detalle, num);
            response.sendRedirect("Vista4.jsp");
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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