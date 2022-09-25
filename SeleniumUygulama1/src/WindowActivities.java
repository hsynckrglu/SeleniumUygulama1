import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); // pencereleri yöneteceğim demek ve .maximize max ekran büyüklüğünde çalıştır demek
		
		driver.get("http://www.google.com"); /*iki yöntem de kullanılabilir fakat get metoduyla URL e ulaşmak 
		sayfanın %100 yüklenmesini bekler. diğer nagivate().to() bu şekilde değil. */				
		
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		driver.navigate().back(); // google geri döner
		driver.navigate().forward(); // "https://rahulshettyacademy.com/AutomationPractice/" sayfasına gider.
		
		/*aynı andan birden fazla get ile URL yazmayı planladım fakat hata verdi demekki sayfalar arasında gezinmek için 
		 * bir tek get metodu diğerini navigate kullanmak gerekiyor.  */
		
		
		
	}

}
