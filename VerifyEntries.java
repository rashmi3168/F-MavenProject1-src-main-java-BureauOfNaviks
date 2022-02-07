package BureauOfNaviks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyEntries {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.buvik.gov.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("ContentPlaceHolder1_login_username")).sendKeys("icgssagar");
		driver.findElement(By.id("ContentPlaceHolder1_login_password")).sendKeys("Sagar45@123#");
		String a=driver.findElement(By.id("ContentPlaceHolder1_lblCaptcha")).getText();
		driver.findElement(By.id("ContentPlaceHolder1_TxtCaptcha")).sendKeys(a);
		driver.findElement(By.id("ContentPlaceHolder1_BtnEnter")).click();
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("Property Return")).click();
		
		WebElement unit = driver.findElement(By.id("ContentPlaceHolder1_DDLUnit"));
		Select dd = new Select(unit);
		dd.selectByValue("000296");
		driver.findElement(By.id("ContentPlaceHolder1_BtnEnter")).click();
		String b = driver.findElement(By.xpath("//input[@value='VERIFY']")).getAttribute("value");
		
		//String i=driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_GvReturnPending\"]/tbody/tr[2]/td[1]")).getText();
		boolean flag=false;
		for(int j=0;j<282;j++)
		{
		if(b.equals("VERIFY"))
		{
			driver.findElement(By.xpath("//input[@value='VERIFY']")).click();
			driver.findElement(By.id("txt_Off_pno")).sendKeys("1763-E");
			driver.findElement(By.id("txt_off_Name")).sendKeys("Abhishek Rawat");
			
			WebElement rank = driver.findElement(By.id("ddl_Off_Rank"));
			Select dd1 = new Select(rank);
			dd1.selectByValue("907");
			
			driver.findElement(By.id("btn_verify_decline")).click();
			//i--;
			flag=true;
		}
		}
		if (flag==false) {
			System.out.println("No Records Left");
			driver.close();
		}
		}
		
	}


