package com.afk.pages;

import com.afk.driver.DriverManager;

public class HomePageSwaglab {
    public String getHomePageTitle(){
        return DriverManager.getDriver().getTitle();

}}
