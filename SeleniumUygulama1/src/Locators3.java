import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Sibling - Child to parent traverse
		// -->   //header/div/button[1]/following-sibling::button[1]
		
		/* aynı başlık altında 3 tane buton var 1.practice 2. login 3. SignUp butonu.
		 *  following-sibling diyene kadar buton 1 yani practice butonunu kastettim.
		   fakat following-sibling::button dediğimde ise aynı küme içerisindeki kalan 2 butonu kastediyorum
		   ve following-sibling:.button[1] dersem logini, ::button[2] dersem signUp butonunu kastediyorum
		   kısacası aynı küme içersinde following-siblingle kardeşleri çağırabiliyorum. 
		   böylece bir kardeşten diğer bir kardeşe geçiş yapabiliyorum
		   (you can traverse from one sibling to another sibling)  */
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");		
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		//normalde .click() ile buton basmayı test ederdim fakat uygulamada logini boşa koymuşlar basılmıyor.
		
		//header/div/button[1]/parent::div/button[2]
		/* parent komutuyla button kümesindeyken , butonların da içinde olduğu bir üst kümeye çıkmak için kullandım. 
		  tekrar /button[2] ile login butonuna ulaştım geri geldim yani */
		
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		
		
	}
	

}
