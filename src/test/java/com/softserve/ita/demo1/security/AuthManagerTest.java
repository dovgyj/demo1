package com.softserve.ita.demo1.security;

import com.google.gson.Gson;
import com.softserve.ita.demo1.entities.User;
import com.softserve.ita.demo1.services.AuntificationService;
import com.softserve.ita.demo1.services.UserService;
import com.softserve.ita.demo1.services.UserServiceImpl;
import com.softserve.ita.demo1.util.security.AuthManager;
import com.softserve.ita.demo1.util.security.SecurityManager;
import org.mockito.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.mockito.Matchers.eq;

public class AuthManagerTest {

    private AuthManager authManagerSpy;

    @Mock
    private SecurityManager securityManagerMock;

    @Mock
    private UserService userServiceMock;

    @Mock
    private AuntificationService auntificationServiceMock;

    @Mock
    private HttpSession sessionMock;

    @Mock
    private HttpServletRequest httpServletRequestMock;

    @Mock
    private HttpServletResponse httpServletResponseMock;

    private User testUser = new User();

    @BeforeMethod
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        testUser.setId(1);
        testUser.setName("Test user");
        testUser.setEmail("test@gmail.com");
        testUser.setPassword("pswHash");

        Mockito.when(sessionMock.getAttribute("auntificatedUser")).thenReturn(testUser);

        authManagerSpy = Mockito.spy(new AuthManager(sessionMock, httpServletResponseMock, httpServletRequestMock));
        authManagerSpy.setUserService(userServiceMock);
        authManagerSpy.setAuntificationService(auntificationServiceMock);
        authManagerSpy.setSecurityManager(securityManagerMock);

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testLoginWithNull(){
        authManagerSpy.login(null);
    }

    @Test
    public void testLoginWithValidUser(){
        authManagerSpy.login(testUser);
        Mockito.verify(sessionMock).setAttribute("auntificatedUser",testUser);
    }

    @Test
    public void testGuestReturnFalse(){
        boolean guest = authManagerSpy.guest();
        Assert.assertFalse(guest);
    }

    @Test
    public void testGuestReturnTrue(){
        try{
            Method setUserMethod = AuthManager.class.getDeclaredMethod("setUser", User.class);
            setUserMethod.setAccessible(true);
            setUserMethod.invoke(authManagerSpy, new Object[]{null});
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e){
            System.out.println(e);
        }
        boolean guest = authManagerSpy.guest();
        Assert.assertTrue(guest);
    }

    @Test
    public void testLogout(){
        Mockito.doNothing().when(authManagerSpy).deleteCookieFromClient();
        Mockito.doNothing().when(authManagerSpy).deleteCookieFromDatabase();

        authManagerSpy.logout();
        Mockito.verify(sessionMock).removeAttribute("auntificatedUser");
    }

    @Test
    public void testTryLoginWithSuccess(){

        Mockito.doReturn(testUser).when(userServiceMock).getByEmail("test@gmail.com");
        Mockito.doReturn(true).when(securityManagerMock).checkPass("plainPassword","pswHash");
        Mockito.doNothing().when(authManagerSpy).login(testUser);

        boolean success = authManagerSpy.tryLogin("plainPassword", "test@gmail.com");

        Assert.assertTrue(success);
    }

    @Test
    public void testTryLoginWithFail(){
        Mockito.doReturn(null).when(userServiceMock).getByEmail("test@gmail.com");

        boolean success = authManagerSpy.tryLogin("plainPassword", "test@gmail.com");

        Assert.assertFalse(success);
    }


}
