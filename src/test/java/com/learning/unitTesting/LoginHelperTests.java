package com.learning.unitTesting;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginHelperTests {

    private static String validPassword_;
    private static String validUser_;

    @BeforeClass
    public static void beforeClass() {
        validPassword_ = "Password12";
        validUser_ = "David";
    }

    @Test
    public void shouldReturnSuccessMessageOnSuccessfulLogin() {
        UserCreator userCreator = new UserCreator();
        userCreator.createUser(validUser_, validPassword_);

        LoginHelper loginHelper = new LoginHelper(userCreator);
        String result = loginHelper.login(validUser_, validPassword_);

        assertEquals("Login Successful", result);
    }

    @Test
    public void shouldReturnFailureMessageOnInvalidUserName() {
        UserCreator userCreator = new UserCreator();
        userCreator.createUser(validUser_, validPassword_);

        LoginHelper loginHelper = new LoginHelper(userCreator);
        String result = loginHelper.login("Scooby", validPassword_);

        assertEquals("Login Failed", result);
    }

    @Test
    public void shouldReturnFailureMessageOnIncorrectPassword() {
        UserCreator userCreator = new UserCreator();
        userCreator.createUser(validUser_, validPassword_);

        LoginHelper loginHelper = new LoginHelper(userCreator);
        String result = loginHelper.login(validUser_, "WrongPassword");

        assertEquals("Login Failed", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ShouldThrowArgumentExceptionWhenUserNameIsEmpty() {

        LoginHelper loginHelper = new LoginHelper(new UserCreator());

        loginHelper.login("", validPassword_);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowArgumentExceptionWhenPasswordIsEmpty()
     {

        LoginHelper loginHelper = new LoginHelper(new UserCreator());

        loginHelper.login(validUser_, "");
    }


}