package net.javaguides.hibernate.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguides.hibernate.dao.PrenotazioneDao;
import net.javaguides.hibernate.dao.UserDao;
import net.javaguides.hibernate.model.Auto;
import net.javaguides.hibernate.model.Prenotazione;
import net.javaguides.hibernate.dao.AutoDao;
import net.javaguides.hibernate.model.User;


@WebServlet(name = "PrenotazioneController", value="/prenotazione")
public class PrenotazioneController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PrenotazioneDao prenotazioneDao;
    private AutoDao autoDao;
    private UserDao userDao;


    public void init() {
        autoDao = new AutoDao();
        prenotazioneDao = new PrenotazioneDao();
        userDao = new UserDao();
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
                case "conferma":
                    confermaPrenotazione(request, response);
                    break;
                case "update":
                    updatePrenotazione(request, response);
                    break;
                case "listauto":
                    listAutoByCalendar(request, response);
                    break;
                default:
                    listPrenotazione(request, response);
                    break;
            }
        } catch (SQLException | ParseException ex) {
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



    private void listAutoByCalendar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ParseException {
        String dateStart = request.getParameter("dateStart");
        String dateEnd = request.getParameter("dateEnd");


        Date dateS = new SimpleDateFormat("yyyy-MM-dd").parse(dateStart);
        Date dateE = new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd);

        List <Auto> listAutoByCalendar = prenotazioneDao.getAutoByPrenotazioni(dateS,dateE);
            request.setAttribute("listAutoByCalendar", listAutoByCalendar);
            request.setAttribute("dataInizio", dateStart);
            request.setAttribute("dataFine", dateEnd);
            RequestDispatcher dispatcher = request.getRequestDispatcher("prenotazione-list-auto.jsp");
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
    private void confermaPrenotazione(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int stato = Integer.parseInt(request.getParameter("stato"));

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setId(id);
        prenotazione.setStato(stato);


        prenotazioneDao.updatePrenotazione(prenotazione);
        response.sendRedirect("prenotazione");
    }

    private void insertPrenotazione(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {
        String dateStart = request.getParameter("dateStart");
        String dateEnd = request.getParameter("dateEnd");

        HttpSession currentSession = request.getSession();
        String username = (String) currentSession.getAttribute("customer");
        User user = userDao.getByUsername(username);

        int autoId = Integer.parseInt(request.getParameter("auto_id"));
        Auto auto = autoDao.getAuto(autoId);

        Date dateS = new SimpleDateFormat("yyyy-MM-dd").parse(dateStart);
        Date dateE =new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd);

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDateStart(dateS);
        prenotazione.setDateEnd(dateE);
        prenotazione.setAuto(auto);
        prenotazione.setUser(user);


        prenotazioneDao.savePrenotazione(prenotazione);
        response.sendRedirect("prenotazione");
    }

    private void updatePrenotazione(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        String dateStart = request.getParameter("dateStart");
        String dateEnd = request.getParameter("dateEnd");

        Date dateS = new SimpleDateFormat("yyyy-MM-dd").parse(dateStart);
        Date dateE =new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd);

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setId(id);
        prenotazione.setDateStart(dateS);
        prenotazione.setDateEnd(dateE);

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