package Selenium.maven.Selenium.maven.deloitte;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {

	public ChromeDriver driver;
	
	//use before to point to chrome driver, launch browser and establish connection
	@Before
	public void init() {
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("http://localhost:8080/login");
	}
	
	//Login successfully, expect to see "Task List" header on homepage after login
	@Test
	public void loginSuccess() {
		driver.findElement(By.xpath("/html/body/div/form/p[1]/input")).sendKeys("test");
        driver.findElement(By.xpath("/html/body/div/form/p[2]/input")).sendKeys("pass123");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        
        String expectedHeader = "Task List";
        String actualHeader = driver.findElement(By.xpath("/html/body/h1")).getText();
        
        Assert.assertEquals("Login Suceess", expectedHeader,actualHeader);
	}
	
	//Login Failure, expect to stay on login screen as see "Please log in" message
	@Test
	public void loginFail() {
		driver.findElement(By.xpath("/html/body/div/form/p[1]/input")).sendKeys("est");
        driver.findElement(By.xpath("/html/body/div/form/p[2]/input")).sendKeys("pass123");
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
        
        String expectedHeader = "Please sign in";
        String actualHeader = driver.findElement(By.xpath("/html/body/div/form/h2")).getText();
        
        Assert.assertEquals("Login Fail", expectedHeader,actualHeader);
	}
	
	
	//Close browser
	@After
	public void finish() {
		driver.quit();
	}
	

}
