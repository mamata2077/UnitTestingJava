package com.learning.unitTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserCreatorTest {
    private static String validUser_;
    private static String validPassword_;

    @BeforeClass
    public static void beforeClass() {
        validUser_ = "David";
        validPassword_ = "Password12";
    }

    @Test
    public void shouldReturnSuccessMessageOnCreationOfUser() {
        UserCreator userCreator = new UserCreator();
        String result = userCreator.createUser(validUser_, validPassword_);

        assertEquals("User created successfully", result);
    }

    @Test
    public void shouldReturnFailureMessageIfUserNameContainsOtherThanLetters() {
        UserCreator userCreator = new UserCreator();
        String result = userCreator.createUser("David11", validPassword_);

        assertEquals("User creation failed", result);
    }

    @Test
    public void userListShouldNotBeNullEvenIfNoUserCreated() {
        UserCreator userCreator = new UserCreator();

        assertNotNull(userCreator.getUsers());
    }

    @Test
    public void shouldIncreaseTheUserCountInListOnUserCreation() {
        UserCreator userCreator = new UserCreator();
        userCreator.createUser(validUser_, validPassword_);

        assertEquals(1, userCreator.getUsers().size());
    }

    @Test
    public void shouldNotIncreaseTheUserCountInListOnUserCreationFailure() {
        UserCreator userCreator = new UserCreator();
        userCreator.createUser("David1", validPassword_);

        assertEquals(0, userCreator.getUsers().size());
    }

    @Test
    public void shouldReturnFailureMessageIfPasswordIsShorterThanSixCharacters() {
        UserCreator userCreator = new UserCreator();
        String result = userCreator.createUser(validUser_, "abc");

        assertEquals("User creation failed", result);
    }

    @Test
    public void shouldReturnFailureMessageIfPasswordDoesNotContainAtLeastOneAlphabet() {
        UserCreator userCreator = new UserCreator();
        String result = userCreator.createUser(validUser_, "1234567");

        assertEquals("User creation failed", result);
    }

    @Test
    public void ShouldReturnFailureMessageIfPasswordDoesNotContainAtLeastOneNumber() {
        UserCreator userCreator = new UserCreator();
        String result = userCreator.createUser(validUser_, "abcdefg");

        assertEquals("User creation failed", result);
    }
}