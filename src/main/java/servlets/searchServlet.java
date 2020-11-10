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

public class searchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tableName = req.getParameter("tableName");
        String inputValue = req.getParameter("searchInput");
        String inputOption = req.getParameter("searchOption");


        List<String> columnNames = new ArrayList<>();
        List<String> placeHolderNames = new ArrayList<>();

        try {
            switch (tableName) {
                case "Client": {
                    List<Client> searchList =  DaoService.clientDAO.search(Client.getFieldName(inputOption), inputValue);
                    DaoService.clientDAO.setCurrentObjects(searchList);
                    columnNames = Client.getColumnNames();
                    placeHolderNames = Client.getPlaceHolderNames();
                }
                break;
                case "Car": {
                    List<Car> searchList =  DaoService.carDAO.search(inputOption, inputValue);
                    DaoService.carDAO.setCurrentObjects(searchList);
                    columnNames = Car.getColumnNames();
                    placeHolderNames = Car.getPlaceHolderNames();
                }
                break;
                case "Rent": {
                    List<Rent> searchList =  DaoService.rentDAO.search(inputOption, inputValue);
                    DaoService.rentDAO.setCurrentObjects(searchList);
                    columnNames = Rent.getColumnNames();
                    placeHolderNames = Rent.getPlaceHolderNames();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        req.setAttribute("chosenTable", tableName);
        req.setAttribute("columnNames", columnNames);
        req.setAttribute("placeHolderNames", placeHolderNames);

        req.getRequestDispatcher("table.jsp").forward(req, resp);
    }
}
