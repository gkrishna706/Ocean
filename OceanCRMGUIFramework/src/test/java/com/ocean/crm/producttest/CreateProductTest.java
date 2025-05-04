package com.ocean.crm.producttest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ocean.crm.generic.baseutility.BaseClass;
import com.ocean.crm.objectrepositoryutility.HomePage;
import com.ocean.crm.objectrepositoryutility.ProductPage;

public class CreateProductTest extends BaseClass {
	@Test(groups="SmokeTest")
	public void createProductTest() throws IOException {
	
		String pName=eLib.getDataFromExcel("product", 1, 1)+jLib.getRandomNumber();
		HomePage hp=new HomePage(driver);
		hp.getProLink().click();
		ProductPage pp=new ProductPage(driver);
		pp.createProduct(pName);
		String actName = pp.getActproductName().getText();
		Assert.assertEquals(pName, actName);
		
	}
	@Test(groups="RegressionTest")
	public void createAndDeleteProductTest() throws IOException {
		
		String pName=eLib.getDataFromExcel("product", 1, 1)+jLib.getRandomNumber();
		
		HomePage hp=new HomePage(driver);
		hp.getProLink().click();
		ProductPage pp=new ProductPage(driver);
		pp.createAndDeleteProduct(pName);		
		
		try {
			String s=pp.getNoproductTxt().getText();
			System.out.println(s+" " +pName+ " is deleted");
		}catch(Exception e) {
			System.out.println(pName+ " is not deleted");
		}
	}

}
