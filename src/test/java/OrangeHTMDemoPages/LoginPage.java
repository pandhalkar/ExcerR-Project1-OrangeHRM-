package OrangeHTMDemoPages;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.baseconfig;

public class LoginPage extends baseconfig{
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbtn;

	public void Login()  {
// Test Case-1 : Verify that users can log in successfully using valid
		// credentials.
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
	}

// Test case- 2: Verify the left panel's appearance and functionality post-login.

	@FindBy(xpath = "//ul[@class='oxd-main-menu']")
	WebElement ExpectedItem;


		public void leftpanelMenu()
		{
			boolean ExpectedValue=Stream.of("Admin", "PIM", "Leave", "Time", "Requirement", "My Info",
					"Performance", "Dashboard", "Directory", "Maintenance", "Claim", "Buzz")
					.allMatch(s->s.equalsIgnoreCase(s));
			System.out.println(ExpectedValue);
			Assert.assertTrue(ExpectedValue);
			
		}	
	
// Test Case-3: Verify the search feature is working correctly.
				@FindBy(xpath = "//input[@placeholder='Search']")
				WebElement inputSearch;

				public void leftPanelSearch() throws InterruptedException {
					String searchquery = "Admin";
					inputSearch.sendKeys(searchquery);
					inputSearch.sendKeys(Keys.ENTER);

					WebElement searchResult = driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']//ul/li[1]"));

					if (searchResult.isDisplayed()) {
						System.out.println("Search text field working");
					}

					else
						System.out.println("Search text field not working");

					Thread.sleep(3000);
				}

// Test Case-4 : Verify the correctness and appearance of the header elements.
	
	@FindBy(xpath = "//div[@class='oxd-brand-banner']")
	WebElement logoverifrication;

	@FindBy(xpath = "//div/span/h6")
	WebElement topheaderverification1;

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	WebElement usernameverification;

	
	public void headerElement() throws InterruptedException {

		if (logoverifrication.isDisplayed()) {
			System.out.println("Logo is present in the header");
		} else {
			System.out.println("Logo is not present in the header");

		}
		Thread.sleep(3000);
		if (topheaderverification1.isDisplayed()) {
			System.out.println("Dashboard present in the header");
		} else {
			System.out.println("Dashboard is not present in the header");

		}
		if (usernameverification.isDisplayed()) {
			System.out.println("User Identified");
		} else {
			System.out.println("User Not Identified");

		}
		Thread.sleep(3000);
		
	}
// Test Case-5: Verify the correctness and appearance of footer elements.
	
	@FindBy(xpath = "//div[@class='oxd-layout-footer']/p[1]")
	WebElement hrmversion;

	@FindBy(xpath = "//div[@class='oxd-layout-footer']/p[2]")
	WebElement footerAllRightReserved;

	public void footerElement() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");
		if (hrmversion.isDisplayed()) {
			System.out.println("hrmversion Displayed");
		} else {
			System.out.println("hrmversion not Displayed");

		}
		Thread.sleep(3000);

		if (footerAllRightReserved.isDisplayed()) {
			System.out.println("All Right Reserved Displayed");
		} else {
			System.out.println("All Right Reserved Not Displayed");

		}
		Thread.sleep(3000);

	}	
// Test case -6: Verify the correctness and visibility of the 'Help' icon.

	@FindBy(xpath = "//button[@title='Help']")
	WebElement helpicon;

	public void helpicon() throws InterruptedException {

		helpicon.click();
		String currentWindowHandle = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(currentWindowHandle);

	}	
	
// Test Case7- Verify the functionality and appearance of the admin tab.
	
	@FindBy(xpath = "//div[@class='oxd-sidepanel-body']//ul/li[1]")
	WebElement admintab;
	
	@FindBy (xpath ="//div[@class='oxd-table-filter']" )
	WebElement systemUsers;
	
	@FindBy(xpath = "//div/span[@class='oxd-text oxd-text--span']")
	WebElement records;

	public void admintabfunctionality() throws InterruptedException 
	{
		Thread.sleep(3000);
		admintab.click();
		Thread.sleep(6000);

		if (systemUsers.isDisplayed())
			System.out.println("System User section is visible");
		else 
			System.out.println("System User section is not visible");
		Thread.sleep(3000);
		if (records.isDisplayed()) 
			System.out.println("Records available");
		 else 
			System.out.println("Records unavailable");

	}	
	
// Test case -8: Verify the functionality and appearance of the admin tab.
// Enter any user name in the 'Username' text field and click on search button	

	@FindBy(xpath ="//div[@class='oxd-table-filter']//input[@class='oxd-input oxd-input--active']")
	WebElement systemUsersearchKeyward;
	@FindBy (xpath = "//button[@type='submit']")
	WebElement record_search_button;
	
	@FindBy(xpath = "//div[@class='oxd-table-card']")
	WebElement foundrecord;

public void adminUsernameSearch() throws InterruptedException {
	Thread.sleep(6000);

	systemUsersearchKeyward.sendKeys("admin");
	Thread.sleep(6000);
	record_search_button.click();
	Thread.sleep(6000);

	List<WebElement> foundrecord = driver.findElements(By.xpath("//div[@class='orangehrm-container']"));

	if (foundrecord.size() > 0) {
		System.out.println("User found!");
	} else {
		System.out.println("User Not Found");
	}

	Thread.sleep(3000);
}

// Test Case-9: Select all

@FindBy (xpath="//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-paper-container']/div[@class='orangehrm-container']/div[@role='table']/div[@role='rowgroup']/div[@role='row']/div[1]")
WebElement selectall;
public void selectAllRecord() throws InterruptedException {
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,600)");
	Thread.sleep(6000);
	selectall.click();
}

// Test Case-10: Deselect all
@FindBy (xpath = "//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-paper-container']/div[@class='orangehrm-container']/div[@role='table']/div[@role='rowgroup']/div[@role='row']/div[1]")
WebElement Deselectall;
public void deselectAll() throws InterruptedException {
	Thread.sleep(6000);
	Deselectall.click();
	Thread.sleep(3000);
}
	
// Test Case 11- Verify the functionality of User management Menu

@FindBy (xpath = "//ul/li/span[contains(text(),'User Management ')]")
WebElement usermanagementMenu;
	
@FindBy (xpath = "//ul/li/a[contains(text(),'Users')]")
WebElement option1;
	public void UserManagementMenu()throws InterruptedException
	{
		Thread.sleep(3000);
		usermanagementMenu.click();
		Thread.sleep(6000);

		if(option1.equals(option1))
		{
			System.out.println("User Management Option displayed");
		}else
		{
			System.out.println("User Management Option not displayed");
		}

		Thread.sleep(3000);
	}
	
	//Test Case 12- Verify the functionality of Job Menu

	@FindBy (xpath ="//ul/li/span[contains(text(),'Job')]" )
	WebElement jobmenu;
	
	@FindBy (xpath ="//ul[@role='menu']" )
	WebElement joboptions;
	
	public void jobmenu()throws InterruptedException
	{


		jobmenu.click();Thread.sleep(6000);

		if(joboptions.equals(joboptions))
		{
			System.out.println("Job Options displayed");
		}else
		{
			System.out.println("Job Options not displayed");
		}

		Thread.sleep(3000);
	}
	
	
	@FindBy (xpath = "//ul/li/span[contains(text(),'Organization')]")
	WebElement organizationmenu;
	
	@FindBy (xpath = "//ul[@role='menu']")
	WebElement organizationoptions;
	
	//Test Case 13- Verify the functionality of Organization Menu

	public void organizationMenu()throws InterruptedException
	{
		organizationmenu.click();Thread.sleep(6000);
		if(organizationoptions.equals(organizationoptions))
		{
			System.out.println("Organization Options displayed");
		}else
		{
			System.out.println("Organization Options not displayed");
		}

		Thread.sleep(3000);
	}
	
	@FindBy(xpath = "//ul/li/span[contains(text(),'Qualifications')]")
	WebElement Qualificationsmenu;
	
	@FindBy(xpath = "//ul[@role='menu']")
	WebElement Qualificationsmenuoptions;
	
	//Test Case 14- Verify the functionality of Qualifications  Menu
	
	public void qualificationMenu() throws InterruptedException
	{


		Qualificationsmenu.click();Thread.sleep(6000);

		if(Qualificationsmenuoptions.equals(Qualificationsmenuoptions))
		{
			System.out.println("Qualifications Options displayed");
		}else
		{
			System.out.println("Qualifications Options not displayed");
		}

		Thread.sleep(3000);
	}
	
	@FindBy (xpath = "//ul/li/span[contains(text(),'Configuration')]")
	WebElement Configurationmenu;
	
	@FindBy(xpath = "//ul[@role='menu']")
	WebElement Configurationmenuoptions;
	
	//Test Case 15- Verify the functionality of Configuration   Menu

	public void configurationMenu()throws InterruptedException
	{


		Configurationmenu.click();Thread.sleep(6000);

		if(Configurationmenuoptions.equals(Configurationmenuoptions))
		{
			System.out.println("Configurations Options displayed");
		}else
		{
			System.out.println("Configurations Options not displayed");
		}

		Thread.sleep(3000);
	}	
	
	
	//Test Case 16- Verify the functionality of Nationalities   Menu
	
	@FindBy (xpath = "//ul/li/a[contains(text(),'Nationalities')]")
	WebElement nationalities;
	
	@FindBy (xpath = "//div/h6")
	WebElement nationalitiestitle;
	
	public void nationalitiesmMenu()throws InterruptedException
	{
		

		nationalities.click();Thread.sleep(6000);

		if(nationalitiestitle.equals("Nationalities"))
		{
			System.out.println("Nationlities title matched");
		}else
		{
			System.out.println("Nationlities title matched");
		}

		Thread.sleep(7000);
	}
	
	
	@FindBy (xpath = "//ul/li/a[contains(text(),'Corporate Branding')]")
	WebElement CorporateBranding;

	public void corporateBrandingMenu() throws InterruptedException
	{
	//Test Case 17- Verify the functionality of Corporate Branding Menu

		CorporateBranding.click();Thread.sleep(6000);
	}
	
	@FindBy (xpath = "//i[@class='oxd-icon bi-caret-up-fill']")
	WebElement systemuserEC;
	
	@FindBy (xpath = "//i[@class='oxd-icon bi-caret-down-fill']")
	WebElement systemuserECex;
	// Test Case 18: System user section expand and collapse
	
	public void expandCollapseFunctionality() throws InterruptedException {


		systemuserEC.click();
		Thread.sleep(3000);
		System.out.println("System User collapse");
		Thread.sleep(6000);

		systemuserECex.click();
		System.out.println("System User Expand");

	}
	
	@FindBy (xpath = "//div[@role='table']//div[1]//div[1]//div[3]//div[1]//button[1]//i[1]")
	WebElement nationalitiesRecordDeleteButton;
	
	@FindBy (xpath = "//div[@role='document']")
	WebElement alertpopup;
	
// Test case-19: Verify the title of the Nationalities page delete icon

	public void nationalitiesDeleteIcon()throws InterruptedException
	{

		nationalitiesRecordDeleteButton.click();Thread.sleep(7000);

		Thread.sleep(7000);

		WebElement delete = driver
				.findElement(By.xpath("//button[normalize-space()='Yes, Delete']"));
		delete.click();Thread.sleep(7000);
	}
	
	
	// //Test case-20: Verify the title of the Nationalities page Edit icon
@FindBy (xpath = "//div[@role='table']//div[1]//div[1]//div[3]//div[1]//button[2]//i[1]")
WebElement nationalitiesRecordEditButton;

@FindBy (xpath = "//div/h6")
WebElement editNationalities;

	public void nationalitieseditIcon() throws InterruptedException
	{
		Thread.sleep(3000);

		nationalitiesRecordEditButton.click();
		Thread.sleep(7000);

		if(editNationalities.equals("Edit Nationality"))
		{
			System.out.println("Edit Nationality title matched");
		}else
		{
			System.out.println("Edit Nationality title matched");
		}

	}
	
	@FindBy (xpath = "//button[@type='submit']")
	WebElement cancelButtonOnNationalitiesEdit;
	// //Test case-21: Verify the Cancel button on Nationalities page Edit icon

	public void nationalitiesEditPageCancel() throws InterruptedException
	{
		cancelButtonOnNationalitiesEdit.click();Thread.sleep(7000);
	}
	
	
	// Test Case-22: Verify the functionality of "Add" from Nationalities

	@FindBy (xpath = "//button[normalize-space()='Add']")
	WebElement addButtonOnNationalities;
	
	@FindBy (xpath = "//button[normalize-space()='Cancel']")
	WebElement cancelButtonOnNationalitiesadd;
	
	public void addFromNationalities() throws InterruptedException
	{
		addButtonOnNationalities.click();Thread.sleep(7000);

		cancelButtonOnNationalitiesadd.click();Thread.sleep(7000);

	}
	
	// Test Case-23: Collapse Bar
@FindBy(xpath = "//button[@role='none']")
WebElement collapseBar;
	
	public void collapseBar() throws InterruptedException
	{


		collapseBar.click();Thread.sleep(3000);
	}

	// Test Case-24: Expand Bar
	@FindBy(xpath = "//button[@role='none']")
	WebElement expandBar;

	public void expandBar() throws InterruptedException
	{
		expandBar.click();Thread.sleep(3000);


	}	
	
	@FindBy(xpath = "//div/h6")
	WebElement CBtitle;
	
	// Test Case-25: Verify the title of Corporate Branding

	
	public void corporateBrandingTitle() throws InterruptedException
	{


		CBtitle.click();Thread.sleep(6000);

		if(CBtitle.equals("Corporate Branding"))
		{
			System.out.println("Corporate Branding title matched");
		}else
		{
			System.out.println("Corporate Branding title matched");
		}

		Thread.sleep(7000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		@FindBy (xpath = "//p[@class='oxd-userdropdown-name']")
		WebElement userDropDown;
		
		@FindBy (xpath = "//a[text()='Logout']")
		WebElement logoutbtn;
		
		public void Logoutbtn()
		{
			userDropDown.click();
			logoutbtn.click();
		}
		
		
		

				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}

