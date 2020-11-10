package services;

import dao.CarDAO;
import dao.ClientDAO;
import dao.RentDAO;
import dao.UserDAO;

public class DaoService {
    public static ClientDAO clientDAO = new ClientDAO();
    public static CarDAO carDAO = new CarDAO();
    public static RentDAO rentDAO = new RentDAO();
    public static UserDAO userDAO = new UserDAO();
}
