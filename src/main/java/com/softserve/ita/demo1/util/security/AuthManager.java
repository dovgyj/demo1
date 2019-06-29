package com.softserve.ita.demo1.util.security;

import com.google.gson.Gson;
import com.softserve.ita.demo1.DAO.exception.DAOException;
import com.softserve.ita.demo1.entities.Auntification;
import com.softserve.ita.demo1.entities.User;
import com.softserve.ita.demo1.services.interfaces.AuntificationService;
import com.softserve.ita.demo1.services.impl.AuntificationServiceImpl;
import com.softserve.ita.demo1.services.interfaces.UserService;
import com.softserve.ita.demo1.services.impl.UserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthManager {
    private SecurityManager securityManager;
    private UserService userService;
    private AuntificationService auntificationService;

    private User user;
    private HttpSession session;
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private Gson gson;

    public AuthManager(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        this.session = session;
        this.httpServletRequest = request;
        this.httpServletResponse = response;

        this.securityManager = new SecurityManager();
        this.userService = new UserServiceImpl();
        this.auntificationService = new AuntificationServiceImpl();
        this.gson = new Gson();

        Object user = this.session.getAttribute("auntificatedUser");

        if (user != null) {
            this.setUser((User) user);
        }

    }

    public boolean tryLogin(String password, String email) throws DAOException {

        User user = userService.getByEmail(email);

        if (user != null && securityManager.checkPass(password, user.getPassword())) {
            this.login(user);
            return true;
        }
        return false;
    }

    public void login(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        this.setUser(user);
        this.session.setAttribute("auntificatedUser", user);
    }

    public void logout() throws DAOException{
        this.setUser(null);
        this.session.removeAttribute("auntificatedUser");
        this.deleteCookieFromDatabase();
        this.deleteCookieFromClient();
    }

    public User getUser() {
        return user;
    }

    private void setUser(User user){
        this.user = user;
    }

    public boolean guest() {
        return this.user == null;
    }

    public void tryLoginByCookie(RememberMeCookie rememberMeCookie) throws DAOException {
        if (rememberMeCookie != null) {
            Auntification auntification = this.auntificationService.getBySelector(rememberMeCookie.getSelector());
            if (auntification != null) {
                if (this.securityManager.checkRememberMeToken(auntification.getValidator(), rememberMeCookie.getValidator())) {
                    User user = this.userService.getById(auntification.getUserId());
                    this.login(user);
                }
            }
        }
    }

    public void deleteCookieFromDatabase() throws DAOException {
        Gson gson = new Gson();
        Cookie[] reqCookies = this.httpServletRequest.getCookies();
        if (reqCookies != null) {
            for (Cookie cookie : reqCookies) {
                if (cookie.getName().equals("remember-me")) {
                    RememberMeCookie rememberMeCookie = gson.fromJson(cookie.getValue(), RememberMeCookie.class);
                    this.auntificationService.delete(rememberMeCookie.getSelector());
                }
            }
        }
    }

    public void setRememberMeCookie() throws DAOException {
        String selector = this.securityManager.generateSelector();
        String validator = this.securityManager.generateRememberMeToken();
        String hasedValidator = this.securityManager.hashRememberMeToken(validator);

        RememberMeCookie rememberMeCookie = new RememberMeCookie(selector, hasedValidator);

        Auntification auntification = new Auntification();
        auntification.setUserId(this.getUser().getId());
        auntification.setSelector(selector);
        auntification.setValidator(validator);

        auntificationService.add(auntification);

        Cookie cookie = new Cookie("remember-me", this.gson.toJson(rememberMeCookie));

        cookie.setPath("/");
        cookie.setDomain(this.httpServletRequest.getServerName());
        cookie.setMaxAge(60 * 60 * 24 * 30);
        this.httpServletResponse.addCookie(cookie);
    }

    public void deleteCookieFromClient() {
        Cookie cookie = new Cookie("remember-me", "");
        cookie.setDomain(this.httpServletRequest.getServerName());
        cookie.setPath("/");
        cookie.setMaxAge(0);
        this.httpServletResponse.addCookie(cookie);
    }

    public void setSecurityManager(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setAuntificationService(AuntificationService auntificationService) {
        this.auntificationService = auntificationService;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

}
