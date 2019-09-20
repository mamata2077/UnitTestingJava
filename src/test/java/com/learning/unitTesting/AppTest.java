package com.learning.unitTesting;

import static org.junit.Assert.assertEquals;
//import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    @Test
    public void shouldReturnTheSumOfTwoNumbers() {
        App app = new App();
        int sum = app.addition(4, 5);
        assertEquals(9, sum);
    }

    
}