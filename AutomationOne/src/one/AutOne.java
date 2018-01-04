package one;

import org.openqa.selenium.By;			
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;			


public class AutOne {

		
	    WebDriver driver;			

		    // Method 1: Open Brower			
		    @BeforeTest		
		    public void openBrowser() {				
				//set path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Venturedive\\Downloads\\chromedriver.exe");
				//create chrome instance
				driver = new ChromeDriver();
				driver.get("http://www.practiceselenium.com/practice-form.html");
		    }
		    
			
		    @Test		
		    public void Form() {				
		        driver.findElement(By.name("firstname")).sendKeys("Tabinda");
		        driver.findElement(By.name("lastname")).sendKeys("Kazmi");
		        WebElement radio1 = driver.findElement(By.id("sex-1"));
		        radio1.click();	
		        WebElement radio2 = driver.findElement(By.id("exp-1"));
		        radio2.click();
		        driver.findElement(By.id("datepicker")).sendKeys("Never");
		        WebElement checkbox1 = driver.findElement(By.id("tea2"));
		        checkbox1.click();
		        WebElement checkbox2 = driver.findElement(By.id("tool-1"));
		        checkbox2.click();
				Select drpContinents = new Select(driver.findElement(By.id("continents")));
				drpContinents.selectByVisibleText("Asia");
				Select work = new Select(driver.findElement(By.id("selenium_commands")));
				work.selectByVisibleText("Browser Commands");
				driver.findElement(By.id("submit")).submit();
		    }
		    
		    @Test
		    public void URL(){

		    	String currentURL = driver.getCurrentUrl();
		    	Assert.assertEquals(currentURL, "http://www.practiceselenium.com/welcome.html?firstname=Tabinda&lastname=Kazmi&sex=Female&exp=2&RedTea=Red+Tea&tool=Harmless+Addiction&continents=Asia&selenium_commands=Browser+Commands" );
		    	System.out.println(currentURL);
		        
		    }

		    
		    @AfterTest
		    public void Close() {	    	
		    	driver.close();
		    }
		    
}
