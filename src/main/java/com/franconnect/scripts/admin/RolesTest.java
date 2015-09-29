package com.franconnect.scripts.admin;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;

public class RolesTest  {
	
	@FindBy(linkText= "Roles")
    WebElement Roles;
	
	@FindBy(css= "input.cm_new_button_link")
    WebElement cm_new_button_link;
	
	@FindBy(name= "roleName")
    WebElement roleName;
	
	@FindBy(name= "Submit")
    WebElement Submit;
}
