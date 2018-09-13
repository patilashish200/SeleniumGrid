package com.qa.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTest {

	WebDriver driver;
	String hubUrl="http://192.168.0.107:4444/wd/hub";
	@Parameters({"node1"})
	@Test
	
public void setUp(String node) throws MalformedURLException

{
		if (node.equalsIgnoreCase("node1FF"))
		{
			
			DesiredCapabilities cap =DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WIN8_1);
			
			FirefoxOptions options = new FirefoxOptions();
		    options.merge(cap);
		     driver = new RemoteWebDriver(new URL (hubUrl),options);	
		}
		
		else if (node.equalsIgnoreCase("node2Chrome"))
		{
			DesiredCapabilities cap =DesiredCapabilities.firefox();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WIN8_1);
			
			ChromeOptions options = new ChromeOptions();
		    options.merge(cap);
		    driver = new RemoteWebDriver(new URL (hubUrl),options);	
		}
		
		driver.get("http://www.yahoo.com");
		
		System.out.println(driver.getTitle());
		
		
}
}
