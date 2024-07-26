package com.afk.testdata;

import com.creditdatamw.zerocell.annotation.Column;

public class TestData {
    @Column(name = "testcasename", index=0)
    private String testcasename;

    @Column(name = "username", index=1)
    private String username;

    @Column(name = "password", index=2)
    private String password;

    @Column(name = "expectedTitle", index=3)
    private String expectedTitle;

    // Getters
    public String getTestcasename() {
        return testcasename;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getExpectedTitle() {
        return expectedTitle;
    }
}
