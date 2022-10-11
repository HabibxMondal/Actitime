package com.actitime.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.LoginPage;

public class BaseClass {
	static {System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");}
	public static WebDriver driver;
	
	@BeforeTest
	public void openBrowser() throws IOException {
		driver=new ChromeDriver();
		FileLib f=new FileLib();
		driver.get(f.getPropertyData("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("openBrowser",true);
	}
	/*@AfterTest
	public void closeBrowser() throws IOException {
		driver.close();
		Reporter.log("closeBrowser",true);
	}*/
	@BeforeMethod
	public void login() throws IOException {
		FileLib f=new FileLib();
		driver.get(f.getPropertyData("url"));
		LoginPage l=new LoginPage(driver);
		String un=f.getPropertyData("username");
		String pw=f.getPropertyData("password");
		l.setLogin(un, pw);
		Reporter.log("login",true);
	}
	@AfterMethod
	public void logout() throws IOException {
		
		Reporter.log("logout",true);
	}
	
}
