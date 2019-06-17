package com.softserve.ita.demo1.util;

import com.softserve.ita.demo1.entities.User;
import com.softserve.ita.demo1.services.UserService;
import com.softserve.ita.demo1.services.UserServiceImpl;

import javax.servlet.http.HttpSession;

public class AuthManager {
    private SecurityManager securityManager;
    private UserService userService;

    private User user;
    private HttpSession session;

    public AuthManager(HttpSession session) {
        this.securityManager = new SecurityManager();
        this.userService = new UserServiceImpl();
        this.session = session;

        Object user = this.session.getAttribute("auntificatedUser");

        if(user != null){
            this.user = (User) user;
        }

    }

    public boolean tryLogin(String password, String email) {
        String hashPassword = securityManager.hashPassword(password);

        User user = userService.getByEmail(email);

        if (user != null && securityManager.checkPass(password,hashPassword)) {
            this.login(user);
            return true;
        }

        return false;
    }

    public void login(User user){
        if(user == null){
            throw new IllegalArgumentException("User cannot be null");
        }
        this.user = user;
        this.session.setAttribute("auntificatedUser",user);
    }

    public void logout() {
        this.user = null;
        this.session.removeAttribute("auntificatedUser");
    }

    public User getUser() {
        return user;
    }

    public boolean guest(){
        return this.user == null;
    }

    public void loginUsingId(Integer id){
        User user = userService.getById(id);
        this.login(user);
    }
}
