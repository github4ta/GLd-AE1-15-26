package com.amazon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

public class SignInTest extends BaseTest {
    private SigninPage signinPage;

    @BeforeEach
    public void setUp() {
        homePage.clickButtonSignin();
        signinPage = new SigninPage(driver);
    }

    @DisplayName("Check sighninpage is open")
    @Test
    public void testSignInPage() {
        Assertions.assertEquals("Sign in or create account", signinPage.getTextSigninTitle());
    }
}
