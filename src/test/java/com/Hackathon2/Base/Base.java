package com.Hackathon2.Base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	WebDriver driver;
	public Properties prop;


	public Base(){

		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\vijayalaxmi.rajaa\\SampleTesting\\ProjectHackathon2\\src\\test\\java\\com\\Hackathon2\\Config\\config.properties");
			prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public WebDriver launch() {
		driver = new ChromeDriver();
		//driver.get("https://www.hcltech.com/");
		driver.get("https://www.hcltech.com/about-us");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}

}
