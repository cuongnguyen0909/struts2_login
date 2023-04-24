/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author NQC
 */
public class LogoutController extends ActionSupport{
    public String execute(){
        Map session = ActionContext.getContext().getSession();
        session.remove("user");
        return SUCCESS;
    }
}
