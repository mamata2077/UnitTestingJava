package com.learning.unitTesting;

public class LoginHelper {

    private UserCreator userCreator;

    public LoginHelper(UserCreator userCreator) {
        this.userCreator = userCreator;
    }

    public String login(String userName, String password) {
        if(userName.isEmpty())
        {
            throw new IllegalArgumentException("Username empty");
        }

        if(password.isEmpty())
        {
            throw new IllegalArgumentException("Password empty");
        }
        if (userCreator.getUsers().containsKey(userName)) {
            if (userCreator.getUsers().get(userName).equals(password)) {
                return "Login Successful";
            }
        }
        return "Login Failed";
    }
}