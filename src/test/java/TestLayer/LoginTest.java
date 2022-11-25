package TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.Baseclass;
import TestData.ExcelSheet;
import pompackage.PomLogin;

public class LoginTest extends Baseclass{

	PomLogin Log;
	public LoginTest () {
		
		super(); 
	}
		
	@BeforeMethod
	public void initsetup() {
		initiate();
		screenshots("Login");
		
		Log=new PomLogin();
	}
	
	@Test (priority=1)
	public void Title() {
		
	String actual=Log.verify();
	System.out.println(actual);
	Assert.assertEquals(actual, "OrangeHRM");
		
	}
	public Object [][] Details(){
		Object result[][]=ExcelSheet.readdata("Sheet1");
		return result;
	}
	@Test (priority=2, dataProvider="Details")
	public void Login(String name,String password) {
	Log.typeusername(name);
		Log.typepassword(password);
		//Log.clickbtn();
	}
	
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
