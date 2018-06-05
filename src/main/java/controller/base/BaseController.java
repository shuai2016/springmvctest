package controller.base;

import org.springframework.beans.factory.annotation.Autowired;
import until.User;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    @Autowired
    HttpServletRequest request;

    protected User getCurrentUser(){
        return (User) request.getSession().getAttribute("currentUser");

    }
}
