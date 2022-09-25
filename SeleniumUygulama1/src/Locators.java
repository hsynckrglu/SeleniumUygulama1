import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));/* konsol ekranında
		hata mesajını görmek için yapılır. implicit wait olarak geçer. Selenium 34. ders  */
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Hüseyin");//kullanıcı adı girmek
		//driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Aliiii");
		driver.findElement(By.name("inputPassword")).sendKeys("Asdrw3.xc(^%vdf12?"); // şifre girmek
		driver.findElement(By.className("signInBtn")).click(); // Giriş yap butonuna tıklamak
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); //ekrana hata mesajı verir ".error" şeklinde de kullanabilirdim.
		driver.findElement(By.linkText("Forgot your password?")).click(); // bu alana girer
		
		Thread.sleep(1000); // butona bastıktan sonra 1 saniye java bekle demek
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("ahsen");
	    driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("example@gmail.com");
	    driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("example28@gmail.com");
		
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("5389996655");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).clear();//yazılanı siler
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("05375459966");
		
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click(); // ".reset-pwd-btn" olarakta kullanabilirim
		System.out.println("Şifre yenileme ekranında reset login butonuna basınca çıkan hata mesajı= "+driver.findElement(By.cssSelector("p.infoMsg")).getText()); 
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("ahsen");
		driver.findElement(By.cssSelector("input[type*='passw']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("#chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); // css de button[class*='sumbit']' e eşit. class="submit signInBtn"
		
		
		

	}

}
