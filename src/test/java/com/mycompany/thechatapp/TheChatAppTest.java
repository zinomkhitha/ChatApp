/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.thechatapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class TheChatAppTest {
    
    TheChatApp auth = new TheChatApp();

    @Test
    public void testUsernameCorrect() {
        assertTrue(auth.checkUserName("ky_1"));
    }

    @Test
    public void testUsernameIncorrect() {
        assertFalse(auth.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testPasswordSuccess() {
        assertTrue(auth.checkPasswordComplexity("Ch0p7@778"));
    }

    @Test
    public void testPasswordFailure() {
        assertFalse(auth.checkPasswordComplexity("password"));
    }
}
