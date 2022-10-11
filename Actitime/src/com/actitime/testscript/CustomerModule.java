package com.actitime.testscript;

import org.testng.Reporter;
import org.testng.annotations.Test;
import com.actitime.generics.BaseClass;

public class CustomerModule extends BaseClass {
	
	@Test
	public void testCreateCustomer()
	{
		Reporter.log("CreateCustomer",true);
	}

}
