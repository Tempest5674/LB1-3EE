package classes.beans;

import classes.User;
import services.DaoService;

import javax.ejb.Stateless;

@Stateless
public class MyChecker {
    public Boolean checkPassword(String login, String password){
        User user = DaoService.userDAO.findByLogin(login);;
        return user!=null&&user.getPassword().equals(password);
    }
}

