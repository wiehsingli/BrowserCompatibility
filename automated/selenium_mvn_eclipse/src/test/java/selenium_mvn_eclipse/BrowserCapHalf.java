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

public class BrowserCapHalf {
	
	public WebDriver fDriver;
	public WebDriver cDriver;
	public WebDriver eDriver;
	public Dimension halfWindow;
	public Dimension ehalfWindow;
	public Point p;
	public String site = "https://www.google.com";
	
	@Before
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:\\dev\\tools\\seleniumdrivers\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\dev\\tools\\seleniumdrivers\\MicrosoftWebDriver.exe");
		//Screen resolution 3840x2160
		halfWindow = new Dimension(1920, 2160);
//		halfWindow = new Dimension(800, 2160);
		p = new Point(0,0);
	}
	
	
	@Test
	public void firefoxHalf() throws Exception{
		
		fDriver = new FirefoxDriver();
		fDriver.manage().window().setPosition(p);
		fDriver.manage().window().setSize(halfWindow);
		fDriver.navigate().to(site);
		screenShot(fDriver, "C:\\Users\\Wie Hsing Li\\Documents\\Classes\\585\\research topic\\half\\Firefox-half.png");
		fDriver.quit();
	}
	
	
	@Test
	public void chromeHalf() throws Exception{
		cDriver = new ChromeDriver();
		cDriver.manage().window().setPosition(p);
		cDriver.manage().window().setSize(halfWindow);
		cDriver.navigate().to(site);	
		screenShot(cDriver, "C:\\Users\\Wie Hsing Li\\Documents\\Classes\\585\\research topic\\half\\Chrome-half.png");
		cDriver.quit();
	}
	
	
	@Test
	public void edgeHalf() throws Exception{
		
		eDriver = new EdgeDriver();
		eDriver.manage().window().setPosition(p);
		eDriver.manage().window().setSize(halfWindow);
		eDriver.navigate().to(site);
		Thread.sleep(2000);
		screenShot(eDriver, "C:\\Users\\Wie Hsing Li\\Documents\\Classes\\585\\research topic\\half\\Edge-half.png");
		eDriver.quit();
	}

	
	public void screenShot(WebDriver driver, String path) throws Exception{
		
		TakesScreenshot tss = (TakesScreenshot)driver;
		File file = tss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(path));
		
	}
}
