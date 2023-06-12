package com.Hackathon2.Pages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUsPage {

	WebDriver driver;
	JavascriptExecutor js;

	@FindBy(xpath="//div[@class='block']/div[@class='content']")
	List<WebElement> fullContent;
	@FindBy(xpath="")
	List<WebElement> yearList;
	@FindBy(xpath="//div[@class='block']/div[@class='content']")
	WebElement yearContent;
	@FindBy(xpath="//div[@class='dot']")
	WebElement slider;
	@FindBy (xpath="//button[text()='1978']")
	WebElement next78;
	@FindBy(xpath="//div[@class='block']/div[@class='content']")
	WebElement Content78;
	@FindBy(xpath="(//div[@class='content'])[5]")
	WebElement con78;
	@FindBy (xpath="//button[text()='1993']")
	WebElement next93;
	@FindBy(xpath="(//div[@class='content'])[6]")
	WebElement con93;
	@FindBy (xpath="//button[text()='1999']")
	WebElement next99;
	@FindBy(xpath="(//div[@class='content'])[7]")
	WebElement con99;
	@FindBy (xpath="//button[text()='2016']")
	WebElement next16;
	@FindBy(xpath="(//div[@class='content'])[8]")
	WebElement con16;
	@FindBy (xpath="//button[text()='2018']")
	WebElement next18;
	@FindBy(xpath="(//div[@class='content'])[9]")
	WebElement con18;
	@FindBy (xpath="//button[text()='2020']")
	WebElement next20;
	@FindBy(xpath="(//div[@class='content'])[10]")
	WebElement con20;
	
	@FindBy(xpath="//button[text()='Next']")
	WebElement next;
	
	


	public AboutUsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	public void writedata() throws IOException, InterruptedException {

		js= (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", yearContent);
		js.executeScript("window.scrollBy(0,1500)");
		//store the data in text file
		String TestFile = "C:\\Users\\vijayalaxmi.rajaa\\OneDrive - HCL Technologies Ltd\\Documents\\HClYearContent.txt";
		File FC = new File(TestFile);//Created object of java File class.
		FC.createNewFile();

		FileWriter FW = new FileWriter(TestFile);
		BufferedWriter BW = new BufferedWriter(FW);

/*		BW.write(yearContent.getText());
		System.out.println(yearContent.getText());

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		// executor.executeScript("arguments[0].setAttribute('style', 'left: 11%;')",slider);
		executor.executeScript("arguments[0].click()", next78);		 
		Thread.sleep(2000);
		BW.newLine();
		BW.write(con78.getText());
		System.out.println(con78.getText());
		executor.executeScript("arguments[0].click()", next93);		 
		Thread.sleep(2000);
		BW.newLine();
		BW.write(con93.getText());
		System.out.println(con93.getText());
		executor.executeScript("arguments[0].click()", next99);		 
		Thread.sleep(2000);
		BW.newLine();
		BW.write(con99.getText());
		System.out.println(con99.getText());
		executor.executeScript("arguments[0].click()", next16);		 
		Thread.sleep(2000);
		BW.newLine();
		BW.write(con16.getText());
		System.out.println(con16.getText());
	*/			
		
	
	//	while(true) {
				  for(WebElement each:fullContent) {
						 BW.write(each.getText());
						 System.out.println(each.getText());
					 // js.executeScript("arguments[0].getAttribute('innertext');", each);
						 BW.newLine();
						 next.click();
						 Thread.sleep(2000);
						 if(each.getText().contains("2022")) {
							 break;
							  }
						  }
				  BW.close();	  
		//		   }		  
				  
		 
	
		}

}
