package com.OrangeHRMApplication_WepPages_Test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.OrangeHRMApplication_WebPages.LoginPage;

public class LoginPage_Test extends LoginPage
{


	public LoginPage_Test() throws IOException {

	}
	@Test(priority=1)
	public void loginpage_loginPannel_Validatiion_Test() throws IOException {
		
		LoginPage loginpage=new LoginPage();
		loginpage.OHRMApplication_LoginPage_Loginpannel_Validation();
	}
	@Test(priority=2)
	public void loginPage_Title_Validation_Test() throws IOException {
		LoginPage loginpage=new LoginPage();
		loginpage.OHRM_LoginPage_Title_Validation();
	}
	@Test(priority=3)
	public void OHRM_Login_Validation_Test() throws IOException {
		
		LoginPage loginpage=new LoginPage();
		
		loginpage.OHRM_Login_Validation();
	}
}
