package com.learning.unitTesting;

import java.util.HashMap;
import java.util.regex.Pattern;

public class UserCreator {

    HashMap<String, String> users_;

    public UserCreator() {
        users_ = new HashMap<String, String>();
    }

    public String createUser(String userName, String password) {
        boolean isLettersOnly = Pattern.matches("^[a-zA-Z]+$", userName);
        int passwordLength = password.length();
        char[] passwordCharArray = password.toCharArray();

        boolean atLeastOneChar = false;
        boolean atLeastOneNumber = false;

        for (char ch : passwordCharArray) {
            if (Character.isLetter(ch)) {
                atLeastOneChar = true;
            }
            if (Character.isDigit(ch)) {
                atLeastOneNumber = true;
            }
        }

        if (!isLettersOnly || passwordLength < 6 || !atLeastOneChar || !atLeastOneNumber) {
            return "User creation failed";
        }

        users_.put(userName, password);

        return "User created successfully";
    }

    public HashMap<String, String> getUsers() {
        return users_;
    }
}