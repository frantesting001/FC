package com.franconnect.uimaps.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(name= "user_id")
    WebElement user_id;	
        
	@FindBy(name= "password")
    WebElement password;	
	
	@FindBy(linkText= "Login")
    WebElement Login;	
	
	@FindBy(linkText= "Forgot Password")
    WebElement forgot_password;
	
	@FindBy(linkText= "Support")
    WebElement Support;
	
	@FindBy(linkText= "Bookmark this site")
    WebElement bookmark_this_site;
	
	
	
	
	public LoginPage(){
		System.out.println("Hi");
	}
}