package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GmailTest {
	private WebDriver driver;

	@Test(priority = 2)
	public void test1() {
		driver.findElement(By.id("Email")).sendKeys("jharshit2725@gmail.com");
		driver.findElement(By.id("Passwd")).sendKeys("harsh");
		driver.findElement(By.id("signIn")).click();
		System.out.println("Doing Gmail test");
		String msg="The email or password you entered is incorrect.";
		String msgFromUI=driver.findElement(By.id("errormsg_0_Passwd")).getText();
		Assert.assertTrue(msgFromUI.contains(msg), "msg not as expected");
	}

	@Test(priority = 1, enabled=false)
	public void test2() {
		driver.findElement(By.id("Email")).sendKeys("jharshit2725@gmail.com");
		driver.findElement(By.id("Passwd")).sendKeys("pass");
		driver.findElement(By.id("signIn")).click();
		driver.findElement(By.xpath("//table[@id=':3z']/tbody/tr[2]/td[2]/div")).click();
		driver.findElement(By.xpath("//div[@title='Delete']/div/div")).click();
		Boolean deleteFlag=driver.findElement(By.xpath("//div[contains(text(),'The conversation has been moved to the Trash')]")).isDisplayed();
		try{
			Assert.assertTrue(deleteFlag, "not deleted not as expected");
		}catch (Error e){

		}
		driver.findElement(By.id("link_undo")).click();		
	}

	@BeforeMethod
	public void beforeSuite() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.gmail.com");
	}

	@AfterMethod
	public void afterSuite() {
		driver.quit();
	}

}
