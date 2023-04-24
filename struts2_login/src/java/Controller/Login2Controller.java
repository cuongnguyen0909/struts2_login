/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.SQLConnection;
import Model.User;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

/**
 *
 * @author NQC
 */
public class Login2Controller {
    private static long serialVersionUID = 1L;
    private User user;
    private static SQLConnection sQLConnection = new SQLConnection();
    
    public String login() throws Exception {
        getSQLConnection().connect();
        boolean b = getSQLConnection().checkLogin(getUser().getUsername(), getUser().getPassword());
        //call Service class to store userBean's state in database
        if (b) {
            Map session = ActionContext.getContext().getSession();
            session.put("user", user.getUsername());
            return SUCCESS;
        }
        return ERROR;
    }
    public Login2Controller() {
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public static SQLConnection getSQLConnection() {
        return sQLConnection;
    }
    public static void setSQLConnection(SQLConnection aDbController) {
        sQLConnection = aDbController;
    }
}
