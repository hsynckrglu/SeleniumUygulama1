import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Locators2 { 
	// şifreyi dinamik hale almak istedim. çünkü "rahulshettyacademy" olarak verdiği şifre ilerde değişebilir.
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	//	System.setProperty("webdriver.gecko.driver", "C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	//	WebDriver driver = new FirefoxDriver();
		
	//	System.setProperty("webdriver.edge.driver", "C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\edgedriver_win64\\msedgedriver.exe");
	//	WebDriver driver = new EdgeDriver();
		
		
		
		String name = "Hüseyin";
		getPassword(driver);
		String password= getPassword(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.cssSelector("input[id*='input']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("button[class*='submit']")).click();
		
		Thread.sleep(2000); // 2 saniye bekletmemin sebebi selenium cok hızlı giriş mesajı gelmiyordu.
		
		System.out.println(driver.findElement(By.xpath("//p")).getText()); // giriş başarılı yazısı
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText() , "You are successfully logged in.");
		/*bu assert ile otomotize test yaparken ekrana gelen mesaj ile yazdılan mesaj aynımı? ders40 
		 * sağ tarafa yazılan mesaj incele-inspect kısmındaki alanla aynı olmak zorunda. boşluk dahi olmamalı 
		 * .assert.Equals() seçilirken iki boolen da küçük harfle başlayan olacak.*/
		
		System.out.println(driver.findElement(By.tagName("h2")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class*='login'] h2")).getText(), "Hello "+ name+",");
		
		driver.findElement(By.xpath("//*[text()='Log Out']")).click(); // //button[text()='Log Out'] da yazabilirdik.
		driver.quit();
		
		
	}
	
	// şifreyi almak için metod oluşturdum main classı dışına
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		
		
		
		String passwordText = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		passwordText.split("'");
		String [] passwordArray = passwordText.split("'");
		//0th index --> Please use temporary password 
		//1th index --> rahulshettyacademy' to Login.
		
		passwordArray[1].split("'");
		// passwordArray'in 1. indisinde şifre olduğu için iki parçaya bölücem split ile ;
		//0th index --> rahulshettyacademy
		//1th index -->  to Login.
		
		String password = passwordArray[1].split("'")[0];
		return password;
		
		
		
		
	}
	
	
	
	
}
