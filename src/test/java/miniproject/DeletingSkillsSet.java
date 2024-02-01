package miniproject;
 
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
 
public class DeletingSkillsSet 
{

	public static void main(String[] args) throws InterruptedException, IOException {

		 {
			  Scanner input = new Scanner(System.in);
			  System.out.println("Enter the Browser name :"); 
			  String BrowserName = input.nextLine();

		 WebDriver driver= Driversetup.getDriver(BrowserName);//passing the browser

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	
	// connecting the Excel to the list
		String file = System.getProperty("user.dir")+"//testdata//Data.xlsx";
		int cells1 = ExcelUtils.getCellCount(file, "Sheet1", 0);
		System.out.println(cells1);
		List<String> list = new ArrayList<String>();
		for(int i =0;i<cells1;i++) {
			list.add(ExcelUtils.getCellData(file, "Sheet1", 0, i));
		}
	//Login using Username and Password
		driver.findElement(By.name("username")).sendKeys(list.get(0));
		driver.findElement(By.name("password")).sendKeys(list.get(1));
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
	
		
	//Navigating form Dashboard
		driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();

	
	//1-Click to Job tab, select Job Categories, Add the category as “Test Engineer” and delete the created categories.
		driver.findElement(By.xpath("//*[@class='oxd-topbar-body-nav-tab --parent']")).click();
	
		driver.findElement(By.xpath("(//*[@role='menuitem'])[4]")).click();
		
	//Add
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		
	//Input
		driver.findElement(By.xpath("(//*[@class='oxd-input oxd-input--active'])[2]")).sendKeys(list.get(2));
		
	//Save
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
		
	//Delete
		driver.findElement(By.xpath("//div[text()='Test Engineer']/parent::div/following-sibling::div//i[@class='oxd-icon bi-trash']")).click();
		 
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")).click();
		
	// step 2
	//Click on organisation tab, select locations.
		driver.findElement(By.xpath("(//*[@class='oxd-topbar-body-nav-tab-item'])[3]")).click();
		
		driver.findElement(By.xpath("(//*[@role='menuitem'])[2]")).click();

		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		
	//Add the Locations, fill all the mandatory fields.
		driver.findElement(By.xpath("(//*[@class='oxd-input oxd-input--active'])[2]")).sendKeys(list.get(3));
		
		driver.findElement(By.xpath("(//*[@placeholder='Type here ...'])[2]")).sendKeys(list.get(4));
		
		driver.findElement(By.xpath("(//*[@placeholder='Type here ...'])[5]")).sendKeys(list.get(5));
	
	//For Seleting Country
		driver.findElement(By.xpath("//div[@class = 'oxd-select-text--after']/i")).click();
		
		List<WebElement> options=driver.findElements(By.xpath("//div[@class = 'oxd-select-wrapper']/div[2]/div"));
		for(WebElement option:options) {
		String text=option.getText();
		if(text.equals(list.get(6))) {
						option.click();
						break;
					}
				} 
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click(); 
	
	//Delete the create locations
		driver.findElement(By.xpath("//div[text()='cts']/parent::div/following-sibling::div//i[@class='oxd-icon bi-trash']")).click(); 
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")).click();
		

	//STEP 3
	//Navigate to skill page from Admin->Qualification->Skills Page
	//Add the skill named as “Testing Demo”.
	//Delete the skill “Testing Demo”
		driver.findElement(By.xpath("(//*[@class='oxd-topbar-body-nav-tab-item'])[4]")).click();
	
		driver.findElement(By.xpath("(//*[@role='menuitem'])[1]")).click();	
	
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
	
		driver.findElement(By.xpath("(//*[@class='oxd-input oxd-input--active'])[2]")).sendKeys(list.get(7));
	
		driver.findElement(By.xpath("(//*[@placeholder='Type description here'])")).sendKeys(list.get(8));
	
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
		
		driver.findElement(By.xpath("//div[text()='Testing Demo']/parent::div/following-sibling::div//i[@class='oxd-icon bi-trash']")).click();
		 
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")).click();
	
	//Verify whether the skill is deleted successfully	
		List<WebElement> list1 = driver.findElements(By.xpath("//*[@class='oxd-table-card']"));
		for(WebElement el:list1) {
			if(el.getText().equalsIgnoreCase("Testing Demo")){
				System.out.print("The skill is not deleted");
				}
				}
				System.out.print("The skill is deleted successfully");		

	//logout page
		driver.findElement(By.xpath("(//*[@class='oxd-userdropdown-tab'])")).click();
		
		driver.findElement(By.xpath("(//*[@role='menuitem'])[4]")).click();
				
	//Close	
		driver.quit();
}
}
}
