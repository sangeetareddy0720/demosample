package com.atibidar.maven.basic;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MavenSample {
	
	public static WebDriver driver;
	public Logger log;
	@BeforeClass	
	public void openBrowser()
	{
	log=Logger.getLogger(MavenSample.class);
	PropertyConfigurator.configure("log4j.properties");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abhishek Patil\\Downloads\\class\\workspace_class_work\\MavenTest\\drivers\\chromedriver.exe");
	log.debug("Chrome driver binary successfully set");
	driver=new ChromeDriver();
	driver.get("http://practice.automationtesting.in/");
	log.info("Browser opened");
	driver.manage().window().maximize();
	log.info("browser maximized");
	}
			
	@Test
	public void verifyHomePageTitle() {
    String expectedTitle="Automation Practice Site";
	String actualTitle=driver.getTitle();
	Assert.assertEquals(actualTitle, expectedTitle);
	log.debug("Title macthed");
	}
			
	@Test
	public void verifyNewArrivalsDisplayed() {
	boolean arrivalsActual=false;
	try{
	arrivalsActual=driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-1-1-0\"]/h2")).isDisplayed();	
	if(arrivalsActual==true)
	{
	log.debug("arrival element identifed successfully ");
	}
	}
	catch(Exception e){
	log.debug("arrival element not identifed successfully ");
	log.error(e.toString());
	}
	Assert.assertTrue(arrivalsActual);
	log.info("arrivals displyed");
	}
			
	@Test
	public void verifyFirstBookTitle() {
	String expectedTitleBook="Selenium Ruby";
	String actualTitleBook=driver.findElement(By.xpath("//h3[text()='Selenium Ruby']")).getText();	
	Assert.assertEquals(actualTitleBook,expectedTitleBook);
	}
			
	@AfterClass
	public void closeBrowser()
	{
	driver.quit();
	log.info("browser closed successfully");
	}
	  
}
