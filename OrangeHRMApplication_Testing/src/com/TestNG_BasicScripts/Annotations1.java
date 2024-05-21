package com.TestNG_BasicScripts;

import org.testng.annotations.Test;

public class Annotations1 {
	@Test // Test Case
	public void gmailApplicationLaunch() // Test Case Name
	// Any functionality of an application which is under Test Should be always be written using the
//	     TestNG Annotation @Test
	{
	System.out.println(" ******* Gmail Application Launch Successfully ********" );
	}

	// A Class can be Implemented with any number of Test Cases

	// If a Class contains multiple Test Cases then the Test Cases will be executed Based on the
//	    alphabetical order of the Given Test Case Names

	// If a class contains multiple Test Cases - then the Test cases will be executed based on the
//	      alphabetical Order of the Given Test case Names considering the Upper case letter of the
//	         given test case Names
	@Test
	public void LogInTest()
	{
	System.out.println("  LogIn Functionality Test Successfull ");
	}


	@Test
	public void composeMailTest()
	{
	System.out.println(" Compose Mail Functionality Test Successfull ");
	}

	@Test
	public void DraftsMailTest()
	{
	System.out.println(" Drafts Mail Functionality Test Successfull ");
	}

	@Test
	public void sentMailTest()
	{
	System.out.println(" Sent Mail Functionality Test Successfull ");
	}

	@Test
	public void gmailApplicationClose()
	{
	System.out.println(" *********** Gmail Application Closed Successfully ****************");
	}
	}



	