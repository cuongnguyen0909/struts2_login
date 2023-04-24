package Controller;

import Model.SQLConnection;
import Model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

public class LoginController extends ActionSupport {
    private static long serialVersionUID = 1L;
    private User user;
    private static SQLConnection sQLConnection = new SQLConnection();
    @Override
    public String execute() throws Exception {
        getSQLConnection().connect();
        boolean b = getSQLConnection().checkLogin(getUser().getUsername(), getUser().getPassword());
        //call Service class to store userBean's state in database
        if (b) {
            Map session = ActionContext.getContext().getSession();
            session.put("user", user.getUsername());
            return SUCCESS;
        }
        addActionError("Invalid username or password!");
        return ERROR;
    }
    public LoginController() {
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
