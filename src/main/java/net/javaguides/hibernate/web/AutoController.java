
package net.javaguides.hibernate.web;

import net.javaguides.hibernate.dao.AutoDao;
import net.javaguides.hibernate.model.Auto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet(name = "AutoController", value="/auto")
public class AutoController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AutoDao autoDao;

    public void init() {
        autoDao = new AutoDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = "";
        if (request.getParameter("pathAuto") != null){
            action = request.getParameter("pathAuto");
        }

        try {
            switch (action) {
                case "new":
                    showNewFormA(request, response);
                    break;
                case "insert":
                    insertAuto(request, response);
                    break;
                case "delete":
                    deleteAuto(request, response);
                    break;
                case "edit":
                    showEditFormA(request, response);
                    break;
                case "update":
                    updateAuto(request, response);
                    break;
                default:
                    listAuto(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listAuto(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List <Auto> listAuto = autoDao.getAllAuto();
        request.setAttribute("listAuto", listAuto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("auto-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormA(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Auto auto = new Auto();
        RequestDispatcher dispatcher = request.getRequestDispatcher("auto-form.jsp");
        request.setAttribute("auto", auto);
        dispatcher.forward(request, response);


    }

    private void showEditFormA(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Auto existingAuto = autoDao.getAuto(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("auto-form.jsp");
        request.setAttribute("auto", existingAuto);
        dispatcher.forward(request, response);

    }

    private void insertAuto(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String targa = request.getParameter("targa");
        String modello = request.getParameter("modello");
        String marca = request.getParameter("date");


        Auto auto = new Auto();
        auto.setTarga(targa);
        auto.setModello(modello);
        auto.setMarca(marca);

        autoDao.saveAuto(auto);
        response.sendRedirect("auto");
    }

    private void updateAuto(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String targa = request.getParameter("targa");
        String modello = request.getParameter("modello");
        String marca = request.getParameter("date");

        Auto auto = new Auto();
        auto.setId(id);
        auto.setTarga(targa);
        auto.setModello(modello);
        auto.setMarca(marca);

        autoDao.updateAuto(auto);
        response.sendRedirect("auto");
    }

    private void deleteAuto(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Auto auto = new Auto();
        auto.setId(id);

        autoDao.deleteAuto(id);
        response.sendRedirect("auto");
    }

}
