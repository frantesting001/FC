package com.franconnect.baseutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

public class Build {
	
	//creating static obj of driver, to be called for all test cases
	public static WebDriver driver;
	
	//Browser selection
	@Test
	public static void openBrowser(){		
		
		String browser_name="firefox";
		if(browser_name!=null&&browser_name.equalsIgnoreCase("firefox")){
			Build.driver = new FirefoxDriver();
		}
		
		else if(browser_name!=null&&browser_name.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","browsers\\chromedriver.exe");
			Build.driver=new ChromeDriver();		}
		
		else if(browser_name!=null&&browser_name.equalsIgnoreCase("safari")){
			System.out.println("Work in Progress............Browser is not available!");
		}
		
		else if(browser_name!=null&&browser_name.equalsIgnoreCase("opera")){
			System.setProperty("webdriver.opera.driver","browsers\\operadriver.exe");
			Build.driver = new OperaDriver();		
		}
		
		else if(browser_name!=null&&browser_name.equalsIgnoreCase("internetexplorer")){
			System.setProperty("webdriver.ie.driver","browsers\\IEDriverServer.exe");
			Build.driver = new InternetExplorerDriver();
		}
		
		else{
			System.out.println("@@@@@@ Could Not load Browser :(");
		}
		
		
		// implicit wait of 20 seconds applied on browser for all instance 
		Build.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
		//Browser maximized
		Build.driver.manage().window().maximize();
	}
	
	@Test
	public static void closeBrowser(){
		//Only selected browser will be closed
		Build.closeBrowser();
	}
	
	@Test
	public static void quitBrowser(){
		//All instance of browser will be closed
		Build.quitBrowser();
	}
}
