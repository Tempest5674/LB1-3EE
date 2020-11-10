package servlets;

import classes.*;
import com.sun.org.apache.regexp.internal.RE;
import services.DaoService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class deleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tableName = req.getParameter("tableName");
        String btnRValue = req.getParameter("remove");
        List<String> columnNames = new ArrayList<>();
        List<String> placeHolderNames = new ArrayList<>();
        switch (tableName) {
            case "Client": {
                DaoService.clientDAO.delete(DaoService.clientDAO.getById(Integer.parseInt(btnRValue)));
                columnNames = Client.getColumnNames();
                placeHolderNames = Client.getPlaceHolderNames();
            }
            break;
            case "Car": {
                DaoService.carDAO.delete(DaoService.carDAO.getById(Integer.parseInt(btnRValue)));
                columnNames = Car.getColumnNames();
                placeHolderNames = Car.getPlaceHolderNames();
            }
            break;
            case "Rent": {
                DaoService.rentDAO.delete(DaoService.rentDAO.getById(Integer.parseInt(btnRValue)));
                columnNames = Rent.getColumnNames();
                placeHolderNames = Rent.getPlaceHolderNames();
            }
        }
        req.setAttribute("chosenTable", tableName);
        req.setAttribute("columnNames", columnNames);
        req.setAttribute("placeHolderNames", placeHolderNames);

        req.getRequestDispatcher("table.jsp").forward(req, resp);
    }
}
