package com.amazon;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HomeTest extends BaseTest {

    @DisplayName("Check homepage is open")
    @Test
    public void testCopyrights() {
        Assertions.assertEquals("© 1996-2026, Amazon.com, Inc. or its affiliates", homePage.getTextCopyrights() );
    }
}
