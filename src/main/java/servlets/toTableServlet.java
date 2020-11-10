package servlets;

import classes.Car;
import classes.Client;
import classes.Rent;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class toTableServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String chosenTable = "default";
        List<String> columnNames = new ArrayList<>();
        List<String> placeHolderNames = new ArrayList<>();

        String btnValue = req.getParameter("button");
        switch (btnValue) {
            case "buttonClients": {
                chosenTable = "Client";
                columnNames = Client.getColumnNames();
                placeHolderNames = Client.getPlaceHolderNames();
            }
            break;

            case "buttonCars": {
                chosenTable = "Car";
                columnNames = Car.getColumnNames();
                placeHolderNames = Car.getPlaceHolderNames();
            }
            break;

            case "buttonRent": {
                chosenTable = "Rent";
                columnNames = Rent.getColumnNames();
                placeHolderNames = Rent.getPlaceHolderNames();
            }
            break;
        }

        req.setAttribute("chosenTable", chosenTable);
        req.setAttribute("columnNames", columnNames);
        req.setAttribute("placeHolderNames", placeHolderNames);

        req.getRequestDispatcher("table.jsp").forward(req, resp);
    }
}
