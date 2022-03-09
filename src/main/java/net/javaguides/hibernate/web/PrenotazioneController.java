package net.javaguides.hibernate.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.hibernate.dao.PrenotazioneDao;
import net.javaguides.hibernate.model.Prenotazione;




@WebServlet(name = "PrenotazioneController", value="/prenotazione")
public class PrenotazioneController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PrenotazioneDao prenotazioneDao;

    public void init() {
        prenotazioneDao = new PrenotazioneDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = "";
        if (request.getParameter("pathPrenotazione") != null){
            action = request.getParameter("pathPrenotazione");
        }

        try {
            switch (action) {
                case "new":
                    showNewFormP(request, response);
                    break;
                case "insert":
                    insertPrenotazione(request, response);
                    break;
                case "delete":
                    deletePrenotazione(request, response);
                    break;
                case "edit":
                    showEditFormP(request, response);
                    break;
                case "update":
                    updatePrenotazione(request, response);
                    break;
                default:
                    listPrenotazione(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listPrenotazione(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List <Prenotazione> listPrenotazione = prenotazioneDao.getAllPrenotazione();
        request.setAttribute("listPrenotazione", listPrenotazione);
        RequestDispatcher dispatcher = request.getRequestDispatcher("prenotazione-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormP(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Prenotazione prenotazione = new Prenotazione();
        RequestDispatcher dispatcher = request.getRequestDispatcher("prenotazione-form.jsp");
        request.setAttribute("prenotazione",prenotazione);
        dispatcher.forward(request, response);


    }

    private void showEditFormP(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Prenotazione existingPrenotazione = prenotazioneDao.getPrenotazione(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("prenotazione-form.jsp");
        request.setAttribute("prenotazione", existingPrenotazione);
        dispatcher.forward(request, response);

    }

    private void insertPrenotazione(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String dateStart = request.getParameter("dateStart");
        String dateEnd = request.getParameter("dateEnd");
        String targa = request.getParameter("targa");


        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDateStart(dateStart);
        prenotazione.setDateEnd(dateEnd);
        prenotazione.setTarga(targa);

        prenotazioneDao.savePrenotazione(prenotazione);
        response.sendRedirect("prenotazione");
    }

    private void updatePrenotazione(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String dateStart = request.getParameter("dateStart");
        String dateEnd = request.getParameter("dateEnd");
        String targa = request.getParameter("targa");


        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setId(id);
        prenotazione.setDateStart(dateStart);
        prenotazione.setDateEnd(dateEnd);
        prenotazione.setTarga(targa);

        prenotazioneDao.updatePrenotazione(prenotazione);
        response.sendRedirect("prenotazione");
    }

    private void deletePrenotazione(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setId(id);

        prenotazioneDao.deletePrenotazione(id);
        response.sendRedirect("prenotazione");
    }


}