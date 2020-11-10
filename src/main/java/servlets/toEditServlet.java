package servlets;

import classes.Car;
import classes.Client;
import classes.Rent;
import services.DaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class toEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tableName = req.getParameter("tableName");
        String btnEditValue = req.getParameter("edit");
        int realId = 0;
        List<String> columnNames = new ArrayList<>();
        List<String> placeHolderNames = new ArrayList<>();


        switch (tableName) {
            case "Client": {
                columnNames = Client.getColumnNames();
                Client clientToEdit = DaoService.clientDAO.getById(Integer.parseInt(btnEditValue));
                realId = clientToEdit.getId();
                placeHolderNames.add(clientToEdit.firstName);
                placeHolderNames.add(clientToEdit.secondName);
                placeHolderNames.add(clientToEdit.phoneNumber);
            }
            break;
            case "Car": {
                columnNames = Car.getColumnNames();
                Car carToEdit = DaoService.carDAO.getById(Integer.parseInt(btnEditValue));
                realId = carToEdit.getId();
                placeHolderNames.add(carToEdit.getCarModel());
                placeHolderNames.add(String.valueOf(carToEdit.getSeats()));
                placeHolderNames.add(String.valueOf(carToEdit.getCostPerDay()));
            }
            break;
            case "Rent": {
                columnNames = Rent.getColumnNames();
                Rent rentToEdit = DaoService.rentDAO.getById(Integer.parseInt(btnEditValue));
                realId = rentToEdit.getCarId();
                placeHolderNames.add(String.valueOf(rentToEdit.getCarId()));
                placeHolderNames.add(String.valueOf(rentToEdit.getRentCost()));
                placeHolderNames.add(String.valueOf(rentToEdit.getRentLength()));
                placeHolderNames.add(String.valueOf(rentToEdit.getRentTotal()));
            }
        }
        req.setAttribute("idToEdit",realId);
        req.setAttribute("chosenTable", tableName);
        req.setAttribute("columnNames", columnNames);
        req.setAttribute("placeHolderNames", placeHolderNames);

        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }
}
