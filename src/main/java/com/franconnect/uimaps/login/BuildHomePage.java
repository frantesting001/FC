package com.franconnect.uimaps.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuildHomePage {
	
	@FindBy(linkText= "user_name")
    WebElement user_name;
	
	@FindBy(linkText= "Admin")
    WebElement Admin;
	
	@FindBy(linkText= "Options")
    WebElement Options;
	
	@FindBy(linkText= "Logout")
    WebElement Logout;
	
}
