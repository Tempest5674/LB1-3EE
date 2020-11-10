package servlets;

import classes.Car;
import classes.Client;
import classes.Rent;
import dao.ClientDAO;
import services.DaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class editServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tableName = req.getParameter("tableName");
        int idToEdit = Integer.parseInt(req.getParameter("idToEdit"));
        List<String> columnNames = new ArrayList<>();
        List<String> placeHolderNames = new ArrayList<>();
        List<String> inputParameters = new ArrayList<>();

        switch (tableName) {
            case "Client": {
                columnNames = Client.getColumnNames();
                for (int i = 0; i < columnNames.size(); i++) {
                    inputParameters.add(req.getParameter("myInput" + (i + 1)));
                }
                Client tmp = DaoService.clientDAO.getById(idToEdit);
                tmp.firstName = inputParameters.get(0);
                tmp.secondName = inputParameters.get(1);
                tmp.phoneNumber = inputParameters.get(2);
                DaoService.clientDAO.update(tmp);
                placeHolderNames = Client.getPlaceHolderNames();
        }
        break;
        case "Car": {
            columnNames = Car.getColumnNames();
            for (int i = 0; i < columnNames.size(); i++) {
                inputParameters.add(req.getParameter("myInput" + (i + 1)));
            }
            Car tmp = DaoService.carDAO.getById(idToEdit);
            tmp.carModel = inputParameters.get(0);
            tmp.seats = Integer.parseInt(inputParameters.get(1));
            tmp.costPerDay = Integer.parseInt(inputParameters.get(2));
            DaoService.carDAO.update(tmp);
            placeHolderNames = Car.getPlaceHolderNames();
        }
        break;
        case "Rent": {
            columnNames = Rent.getColumnNames();
            for (int i = 0; i < columnNames.size(); i++) {
                inputParameters.add(req.getParameter("myInput" + (i + 1)));
            }
            Rent tmp = DaoService.rentDAO.getById(idToEdit);
            tmp.clientId= Integer.parseInt(inputParameters.get(0));
            tmp.rentCost = Integer.parseInt(inputParameters.get(1));
            tmp.rentLength = Integer.parseInt(inputParameters.get(2));
            tmp.rentTotal= Integer.parseInt(inputParameters.get(2));
            DaoService.rentDAO.update(tmp);
            placeHolderNames = Rent.getPlaceHolderNames();
        }
    }
        req.setAttribute("chosenTable",tableName);
        req.setAttribute("columnNames",columnNames);
        req.setAttribute("placeHolderNames",placeHolderNames);

        req.getRequestDispatcher("table.jsp").

    forward(req, resp);
}
}
