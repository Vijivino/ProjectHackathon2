package com.Hackathon2.Pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	Actions builder;

	@FindBy (xpath="//ul[@id='block-mainnavigationbt']/li")
	List<WebElement> menulist;
	@FindBy(xpath="//a[text()='Services']")
	WebElement services;
	@FindBy (xpath="//ul[@class='dropdown-menu level-1']/li")
	List<WebElement> submenulist;
	@FindBy(xpath="//a[text()='Industries']")
	WebElement industries;
	@FindBy (xpath="//ul[@class='dropdown-menu level-1']/li")
	List<WebElement> industrieslist;
	@FindBy(xpath="//a[text()='About Us']")
	WebElement aboutus;
	@FindBy (xpath="//ul[@class='dropdown-menu level-1']/li")
	List<WebElement> aboutuslist;
	@FindBy(xpath="//a[text()='Trends and Insights']")
	WebElement trends;
	@FindBy (xpath="//ul[@class='dropdown-menu level-1']/li")
	List<WebElement> trendslist;
	@FindBy(xpath="//a[text()='Careers']")
	WebElement careers;
	@FindBy (xpath="//ul[@class='dropdown-menu level-1']/li")
	List<WebElement> careerslist;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		builder=new Actions(driver);
	}

	public void printmenulist() {

		for(WebElement each:menulist) {
			System.out.println(each.getText());
		}

	}

	public void subServiceslist() {


		builder.moveToElement(services).perform();
		System.out.println("*****SubMenu List items : services");

		for(WebElement each:submenulist) {
			System.out.println(each.getText());
		}
	}	
	public void industrieslist() throws IOException {


		builder.moveToElement(industries).perform();
		System.out.println("*****SubMenu List items : industries");

		for(WebElement each:industrieslist) {
			System.out.println(each.getText());
		}
		
		File source1=((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
		File destination1=new File("C:\\Users\\vijayalaxmi.rajaa\\SampleTesting\\ProjectHackathon2\\Screenshots\\Industriessnap.png");
		FileUtils.copyFile(source1, destination1);
	}

	public void aboutuslist() {


		builder.moveToElement(aboutus).perform();
		System.out.println("*****SubMenu List items : about us");

		for(WebElement each:aboutuslist) {
			System.out.println(each.getText());
		}
	}
	public void trendslist() {


		builder.moveToElement(trends).perform();
		System.out.println("*****SubMenu List items : Trends and insights");

		for(WebElement each:trendslist) {
			System.out.println(each.getText());
		}
	}
	public void careerslist() throws IOException {


		builder.moveToElement(careers).perform();
		System.out.println("*****SubMenu List items : careers");

		for(WebElement each:careerslist) {
			System.out.println(each.getText());
		}
		
		File source=((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\vijayalaxmi.rajaa\\SampleTesting\\ProjectHackathon2\\Screenshots\\Careersnap.png");
		FileUtils.copyFile(source, destination);
	}



}
