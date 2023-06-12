package com.Hackathon2.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Hackathon2.Base.Base;
import com.Hackathon2.Pages.AboutUsPage;
import com.Hackathon2.Pages.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;



public class TestHCLTech extends Base{
	
	WebDriver driver;
    HomePage home;
    AboutUsPage about;
	
	
	public TestHCLTech() {
		super();
	}
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	public void beforetest() throws IOException {

		report=com.Hackathon2.Utils.ExtentReporter.generateReport();
		report.attachReporter(htmlReporter);
		test = report.createTest("HCLTech Testing Report");

	}
	
	@Test
	public void PrintMenuSubMenuitems() throws IOException {
		
		driver=launch();
		home=new HomePage(driver);
		home.printmenulist();
		home.subServiceslist();
		home.industrieslist();
		test.log(Status.PASS, "Industries submenu navigation and printing done successfully");
		test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\vijayalaxmi.rajaa\\SampleTesting\\ProjectHackathon2\\Screenshots\\Industriessnap.png").build());
		home.aboutuslist();
		home.trendslist();
		home.careerslist();
		test.log(Status.PASS, "Career submenu navigation and printing done successfully");
		test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\vijayalaxmi.rajaa\\SampleTesting\\ProjectHackathon2\\Screenshots\\Careersnap.png").build());
		test.log(Status.PASS, "All the menu and submenu lists are printed.");	
	}
	
	@Test(priority=1)
	public void embedDataToText() throws IOException, InterruptedException {
		
		driver=launch();
		//driver.navigate().to("https://www.hcltech.com/about-us");
		about=new AboutUsPage(driver);
		about.writedata();
		test.log(Status.PASS, "Year content embedded in text file successfully");
			
	}
	
	
	
	@Test(priority=2)
	public void compareImage() throws IOException {
		
		driver=launch();
		driver.navigate().to("https://www.hcltech.com/about-us");
		WebElement element = driver.findElement(By.xpath("//img[@class='img-fluid']"));
	
		String src = element.getAttribute("src");
		System.out.println(src);
		driver.get(src);
		BufferedImage bufferedImage = ImageIO.read(new URL(src).openStream());
		System.out.println(bufferedImage);
		File outputfile = new File("C:\\Users\\vijayalaxmi.rajaa\\SampleTesting\\ProjectHackathon2\\src\\test\\resources\\Imagesaved.png");
		ImageIO.write(bufferedImage, "png", outputfile);
	  
//	       Screenshot screenshot = new AShot().takeScreenshot(driver,element);
//	       ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") +"\\Images\\ElementScreenshot.png"));
	
	
/*		//read the expectedsnap from the path
		BufferedImage expectedImage=ImageIO.read(new File("C:\\Users\\vijayalaxmi.rajaa\\OneDrive - HCL Technologies Ltd\\Pictures\\HCLExpectedimage.png"));
		test.log(Status.INFO,"Expected Image is here");
		test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\vijayalaxmi.rajaa\\OneDrive - HCL Technologies Ltd\\Pictures\\HCLExpectedimage.png").build());
		File source=((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\vijayalaxmi.rajaa\\OneDrive - HCL Technologies Ltd\\Pictures\\HCLActualsnap.png");
		FileUtils.copyFile(source, destination);
		BufferedImage actualImage=ImageIO.read(new File("C:\\Users\\vijayalaxmi.rajaa\\OneDrive - HCL Technologies Ltd\\Pictures\\HCLActualsnap.png"));
		test.log(Status.INFO,"Actual Image is here");
		test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\vijayalaxmi.rajaa\\OneDrive - HCL Technologies Ltd\\Pictures\\HCLActualsnap.png").build());
		ImageDiffer imagediff=new ImageDiffer();
		ImageDiff diff=imagediff.makeDiff(expectedImage, actualImage);

		boolean boo = diff.hasDiff();
		System.out.println(boo);
		Assert.assertEquals(boo, false);
		
		if(diff.hasDiff()==true) {
			System.out.println("Screenshots are Not same");
		}else {
			System.out.println("Screenshots are same");
		}
		test.log(Status.PASS, "Images are compared successfully");
*/
	}
	
	@AfterMethod
	public void close() {
		
		report.flush();
		//driver.quit();
	}

}
