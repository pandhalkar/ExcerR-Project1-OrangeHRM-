package Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import OrangeHTMDemoPages.LoginPage;
import base.baseconfig;


public class LoginPageTest extends baseconfig{
	

	
	@Test (priority = 1)
	public void loginPage() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
		loginpage.Logoutbtn();
		
	}
	
	@Test (priority = 2)
	public void VerifyLeftpanel()
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
		loginpage.leftpanelMenu();
		loginpage.Logoutbtn();

	}
	
	@Test(priority = 3)
	public void leftPanelSearch() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
		loginpage.leftPanelSearch();
		loginpage.Logoutbtn();
	}
	
	
	@Test (priority = 4)
	public void HeaderElement() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
		loginpage.headerElement();
		loginpage.Logoutbtn();
	}
	

	
	@Test(priority = 5)
	public void FooterVerification() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
		loginpage.footerElement();
		loginpage.Logoutbtn();
	}
	
	
	@Test(priority = 6)
	public void helpicon() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
		loginpage.helpicon();
		loginpage.Logoutbtn();
	}
	
	@Test(priority = 7)
	public void admintabfunctionality() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
		loginpage.admintabfunctionality(); 
		loginpage.Logoutbtn();
	}
	
//	@Test(priority = 8)
//	public void adminUsernameSearch() throws InterruptedException
//	{
//		LoginPage loginpage=new LoginPage(driver);
//		loginpage.Login();
//		loginpage.adminUsernameSearch();
//		loginpage.Logoutbtn();
//	}
	
//	@Test(priority = 9)
//	public void selectAllRecord() throws InterruptedException
//	{
//		LoginPage loginpage=new LoginPage(driver);
//		loginpage.Login();
//		loginpage.selectAllRecord();
//		loginpage.deselectAll();
//		loginpage.Logoutbtn();
//	}
//	
//	@Test(priority = 10)
//	public void deselectAll() throws InterruptedException
//	{
//		LoginPage loginpage=new LoginPage(driver);
//		loginpage.Login();
//		loginpage.deselectAll();
//		loginpage.Logoutbtn();
//	}
	
	@Test(priority = 10)
	public void UserManagementMenu() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
	loginpage.admintabfunctionality(); 
	loginpage.UserManagementMenu();
		loginpage.Logoutbtn();
	}
	
	@Test(priority = 11)
	public void jobmenu() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
	loginpage.admintabfunctionality(); 
	loginpage.jobmenu();
		loginpage.Logoutbtn();
	}
	
	@Test(priority = 12)
	public void organizationMenu() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
	loginpage.admintabfunctionality(); 
	loginpage.organizationMenu();
		loginpage.Logoutbtn();
	}
	
	@Test(priority = 13)
	public void qualificationMenu() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
	loginpage.admintabfunctionality(); 
	loginpage.qualificationMenu();
		loginpage.Logoutbtn();
	}
	
	@Test(priority = 14)
	public void configurationMenu() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
	loginpage.admintabfunctionality(); 
	loginpage.configurationMenu();
		loginpage.Logoutbtn();
	}
	
	@Test(priority = 15)
	public void nationalitiesmMenu() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
	loginpage.admintabfunctionality(); 
	loginpage.nationalitiesmMenu();
		loginpage.Logoutbtn();
	}
	
	@Test(priority = 16)
	public void corporateBrandingMenu() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
	loginpage.admintabfunctionality(); 
	loginpage.corporateBrandingMenu();
		loginpage.Logoutbtn();
	}
	
	@Test(priority = 16)
	public void expandCollapseFunctionality() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
	loginpage.admintabfunctionality(); 
	loginpage.expandCollapseFunctionality();
		loginpage.Logoutbtn();
	}
	
	@Test(priority = 17)
	public void nationalitiesDeleteIcon() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
	loginpage.admintabfunctionality(); 
	loginpage.nationalitiesmMenu();
	loginpage.nationalitiesDeleteIcon();

		loginpage.Logoutbtn();
	}	
	
	@Test(priority = 18)
	public void nationalitieseditIcon() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
	loginpage.admintabfunctionality(); 
	loginpage.nationalitiesmMenu();
	loginpage.nationalitieseditIcon();

		loginpage.Logoutbtn();
	}	
	
	@Test(priority = 19)
	public void nationalitiesEditPageCancel() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
	loginpage.admintabfunctionality(); 
	loginpage.nationalitiesmMenu();
	loginpage.nationalitieseditIcon();
	loginpage.nationalitiesEditPageCancel();

		loginpage.Logoutbtn();
	}
	
	@Test(priority = 20)
	public void addFromNationalities() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
	loginpage.admintabfunctionality(); 
	loginpage.nationalitiesmMenu();
	loginpage.addFromNationalities();
		loginpage.Logoutbtn();
	}
	
	@Test(priority = 21)
	public void collapseBar() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
		loginpage.collapseBar();
		loginpage.Logoutbtn();
	}
	
	@Test(priority = 22)
	public void expandBar() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
		loginpage.collapseBar();
		loginpage.expandBar();
	}
	
	@Test(priority = 13)
	public void corporateBrandingTitle() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login();
	loginpage.admintabfunctionality(); 
	loginpage.corporateBrandingMenu();
	loginpage.corporateBrandingTitle();
		loginpage.Logoutbtn();
	}
	

}
