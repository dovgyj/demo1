package com.softserve.ita.demo1.security;

import com.softserve.ita.demo1.entities.User;
import com.softserve.ita.demo1.services.UserService;
import com.softserve.ita.demo1.services.UserServiceImpl;
import com.softserve.ita.demo1.util.security.AuthManager;
import com.softserve.ita.demo1.util.security.SecurityManager;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Matchers.eq;

public class AuthManagerTest {

    private AuthManager authManagerMock;
    private User testUser;

    private HttpServletResponse httpServletResponseMock;
    private HttpServletRequest httpServletRequestMock;
    private HttpSession sessionMock;

    @BeforeTest
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        testUser = new User();
        testUser.setName("test testUser");
        testUser.setEmail("test@gmail.com");
        testUser.setPassword("passwordHash");
        testUser.setId(23);

        sessionMock = Mockito.mock(HttpSession.class);
        Mockito.when(sessionMock.getAttribute("auntificatedUser")).thenReturn(testUser);

        httpServletRequestMock = Mockito.mock(HttpServletRequest.class);
        httpServletResponseMock = Mockito.mock(HttpServletResponse.class);
        authManagerMock = Mockito.spy(new AuthManager(sessionMock,httpServletResponseMock,httpServletRequestMock));

    }
    @Test
    public void testGuest() {
        Assert.assertFalse(authManagerMock.guest());
    }

    @Test
    public void testGetUser(){
        Assert.assertEquals(authManagerMock.getUser(), testUser);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testLoginWithNull(){
        authManagerMock.login(null);
    }


    public void testLoginWithValidUser(){
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        Mockito.doNothing().when(sessionMock).setAttribute(eq("auntificatedUser"),userArgumentCaptor.capture());
        authManagerMock.login(testUser);
        Assert.assertEquals(testUser,userArgumentCaptor.getValue());
    }

    @InjectMocks
    UserService userService = new UserServiceImpl();

    @InjectMocks
    SecurityManager securityManager = new SecurityManager();

    @Test
    public void testTryLogin(){
        Mockito.when(userService.getByEmail("test@gmail.com")).thenReturn(testUser);
        Mockito.when(securityManager.checkPass("testpassword", "passwordHash")).thenReturn(true);
        Mockito.doNothing().when(authManagerMock).login(testUser);
        Boolean resault = authManagerMock.tryLogin("testpassword", "test@gmail.com");

        Assert.assertTrue(resault);

    }
}
