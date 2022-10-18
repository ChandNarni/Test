package dataDrivenTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class datadriventest {
	public WebDriver driver;
	
	@BeforeClass
	public void Setup() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "D:\\Chrome webdriver\\chromedriver106\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			
	
		driver.get("http://testfire.net/index.jsp");
		Thread.sleep(3000);

		WebElement signin=driver.findElement(By.xpath("//font[contains(text(),'Sign In')]"));
		Thread.sleep(3000);
		signin.click();
		
		

}
	@Test(priority = 1)
	public void excelutility() throws InterruptedException, IOException
	{
	
		String path="C:\\Users\\HP\\eclipse-workspace\\Apachepoi\\defaultfiles\\login.xlsx";
		
		utility utility=new utility(path);
		int totalrows=utility.getRowCount("Sheet1");
		int totalcols=utility.getCellCount("Sheet1",1);
		
			int row_count = utility.getRowCount("Sheet1");
			
			int col_count = utility.getCellCount("Sheet1", 1);
			
			for(int i=1;i<=row_count;i++)
			{
				for(int j=0;i<=row_count;i++) 
				{
					String u_name = utility.getCellData("Sheet1", i, j);
					String p_wd = utility.getCellData("Sheet1", i, j);
					
				
					WebElement name=driver.findElement(By.xpath("//input[@id='uid']"));
					Thread.sleep(3000);
					name.sendKeys(u_name);
					
					WebElement password=driver.findElement(By.xpath("//input[@id='passw']"));
					password.sendKeys(p_wd);
					Thread.sleep(3000);
					WebElement submit=driver.findElement(By.xpath("//input[@name='btnSubmit']"));
					submit.click();
					Thread.sleep(3000);
					
					
				}
		
	}
			
			
}
	@Test(priority = 2)
	public void view() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@id='MenuHyperLink1']")).click();
		
		WebElement list=driver.findElement(By.xpath("//select[@id='listAccounts']"));
		list.click();
		Thread.sleep(3000);
		
		Select listelements= new Select(list);
		listelements.selectByValue("800001");
		Thread.sleep(3000);
		
		WebElement go=driver.findElement(By.xpath("//input[@id='btnGetAccount']"));
		go.click();
		
		WebElement availbalance=driver.findElement(By.xpath(("//body[1]/table[2]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]")));
		Thread.sleep(3000);
		String actual=availbalance.getText();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='MenuHyperLink3']")).click();
		Thread.sleep(3000);
		WebElement list1=driver.findElement(By.xpath("//select[@id='toAccount']"));
		list1.click();
		Thread.sleep(3000);
		Select listelements1= new Select(list1);
		listelements1.selectByValue("800001");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='transferAmount']")).sendKeys("9876");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='transfer']")).click();
		
	}
	@Test(priority = 3)
	public void viewRecentTransaction() throws InterruptedException
	{
		WebElement vrt=driver.findElement(By.xpath("//a[@id='MenuHyperLink2']"));
		Thread.sleep(3000);
		vrt.click();
	
		WebElement contactus=driver.findElement(By.xpath("//a[@id='HyperLink3']"));
		contactus.click();
		Thread.sleep(5000);
		
		WebElement onlineform=driver.findElement(By.xpath("//a[contains(text(),'online form')]"));
		Thread.sleep(5000);
		onlineform.click();
		
		WebElement emailaddress=driver.findElement(By.xpath("//input[@name='email_addr']"));
		emailaddress.sendKeys("chand.stu.5977@gmail.com");
		
		WebElement subject=driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]"));
		emailaddress.sendKeys("Test");
		Thread.sleep(5000);
		WebElement comment=driver.findElement(By.xpath("//tbody/tr[5]/td[2]/textarea[1]"));
		emailaddress.sendKeys("comment");
		Thread.sleep(5000);
		driver.findElement(By.xpath("input[value=' Submit ']")).click();
		
		
	}
	
	
}