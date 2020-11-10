package servlets;

import classes.Car;
import classes.Client;
import classes.Rent;
import com.sun.org.apache.regexp.internal.RE;
import services.DaoService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class insertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tableName = req.getParameter("tableName");

        List<String> columnNames = new ArrayList<>();
        List<String> placeHolderNames = new ArrayList<>();
        List<String> inputParameters = new ArrayList<>();

        switch (tableName) {
            case "Client": {
                columnNames = Client.getColumnNames();
                for (int i = 0; i < columnNames.size(); i++) {
                    inputParameters.add(req.getParameter("myInput" + (i + 1)));
                }
                DaoService.clientDAO.save(new Client(0, inputParameters.get(0), inputParameters.get(1),
                        inputParameters.get(2)));
                placeHolderNames = Client.getPlaceHolderNames();
            }
            break;
            case "Car": {
                columnNames = Car.getColumnNames();
                for (int i = 0; i < columnNames.size(); i++) {
                    inputParameters.add(req.getParameter("myInput" + (i + 1)));
                }
                DaoService.carDAO.save(new Car(0, inputParameters.get(0), Integer.parseInt(inputParameters.get(1)),
                        Integer.parseInt(inputParameters.get(2))));
                placeHolderNames = Car.getPlaceHolderNames();
            }
            break;
            case "Rent": {
                columnNames = Rent.getColumnNames();
                for (int i = 0; i < columnNames.size(); i++) {
                    inputParameters.add(req.getParameter("myInput" + (i + 1)));
                }
                DaoService.rentDAO.save(new Rent(Integer.parseInt(inputParameters.get(0)),
                        Integer.parseInt(inputParameters.get(1)), Integer.parseInt(inputParameters.get(1)),
                        Integer.parseInt(inputParameters.get(2)), Integer.parseInt(inputParameters.get(1))));
                placeHolderNames = Rent.getPlaceHolderNames();
            }
        }
        req.setAttribute("chosenTable", tableName);
        req.setAttribute("columnNames", columnNames);
        req.setAttribute("placeHolderNames", placeHolderNames);

        req.getRequestDispatcher("table.jsp").forward(req, resp);
    }
}
