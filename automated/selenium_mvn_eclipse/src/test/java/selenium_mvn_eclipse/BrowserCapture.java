package selenium_mvn_eclipse;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserCapture {
	
	public WebDriver fDriver;
	public WebDriver cDriver;
	public WebDriver eDriver;
	public Point p;
	public String site;
	
	@Before
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:\\dev\\tools\\seleniumdrivers\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\dev\\tools\\seleniumdrivers\\MicrosoftWebDriver.exe");
//		site = "https://www.google.com";
		site = "https://www.cpp.edu/~sci/computer-science/";
	}
	
	@Test
	public void firefoxMax() throws Exception{
		
		fDriver = new FirefoxDriver();
		fDriver.manage().window().maximize();
		fDriver.navigate().to(site);
		screenShot(fDriver, "C:\\Users\\Wie Hsing Li\\Documents\\Classes\\585\\research topic\\max\\Firefox-max.png");
		fDriver.quit();
	}
	
	
	@Test
	public void chromeMax() throws Exception{
		
		cDriver = new ChromeDriver();
		cDriver.manage().window().maximize();
		cDriver.navigate().to(site);
		screenShot(cDriver, "C:\\Users\\Wie Hsing Li\\Documents\\Classes\\585\\research topic\\max\\Chrome-max.png");
		cDriver.quit();
	}
	
	
	@Test
	public void edgeMax() throws Exception{
		
		eDriver = new EdgeDriver();
		eDriver.manage().window().maximize();
		eDriver.navigate().to(site);
		Thread.sleep(2000);
		screenShot(eDriver, "C:\\Users\\Wie Hsing Li\\Documents\\Classes\\585\\research topic\\max\\Edge-max.png");
		eDriver.quit();
	}
	
	
	public void screenShot(WebDriver driver, String path) throws Exception{
		
		TakesScreenshot tss = (TakesScreenshot)driver;
		File file = tss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(path));
		
	}
}
