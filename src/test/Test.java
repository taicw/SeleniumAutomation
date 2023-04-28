package test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		//to open target website
		  driver.get("https://todo-list-login.firebaseapp.com/#!/home");
		  String parentWindow = driver.getWindowHandle();
		
		//maximize window
		  driver.manage().window().maximize(); Thread.sleep(3000);
		
		//login with github
		  driver.findElement(By.className("btn-github")).click();
		  Thread.sleep(5000);
		  
		//switch window
		  Set<String> handles = driver.getWindowHandles();
		  for(String handle: handles) {
			  driver.switchTo().window(handle);
		  }
		  
		 //login id - you may change it to your own email address
		  driver.findElement(By.id("login_field")).sendKeys("usernamenotallow001@gmail.com");
		  Thread.sleep(2000);
		  
		//login id - you may change it to your own password
		  driver.findElement(By.id("password")).sendKeys("Testeracc123");
		  Thread.sleep(2000);
		  
		//click login
		  driver.findElement(By.name("commit")).click();
		  Thread.sleep(2000);
		  
		//switch back to main window
		  driver.switchTo().window(parentWindow);
		
		//create 10 to do list using loop
		  for(int i=1; i<11; i++) {
		  driver.findElement(By.xpath("//body/ng-view[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys("testing " + i);
		  Thread.sleep(1000); 
		  driver.findElement(By.className("task-btn")).click(); 
		  Thread.sleep(1000);
		  }
		
		//sign out
		  driver.findElement(By.xpath("//button[contains(text(),'Sign out')]")).click();
		  Thread.sleep(3000);

		//sign in again but will not prompt for email and password
		  driver.findElement(By.className("btn-github")).click();

		//using loop to delete record from 5-10
		  for(int i=0; i<6;i++) {
		  driver.findElement(By.xpath("//body/ng-view[1]/div[1]/div[3]/div[1]/ul[1]/li[5]/div[1]/div[2]/button[1]")).click();
		  Thread.sleep(1000);
		  }
		  Thread.sleep(2000);
		 
		//sign out upon completion
		  driver.findElement(By.xpath("//button[contains(text(),'Sign out')]")).click();
		  Thread.sleep(2000);
		  driver.close();
		  
		  System.out.println("Test done"); 
	}

}