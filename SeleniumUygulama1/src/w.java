import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class w {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	/*	w ps = new w();
		ps.getPassword(driver);
		System.out.println(ps.getPassword(driver));   
		bu yöntem aşağıdaki metoda static kelimesini eklemezsem kullanılır. */
		
		
		getPassword(driver);
		System.out.println(getPassword(driver));
	
	}
	

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
