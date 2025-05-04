package com.ocean.crm.calendartest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ocean.crm.generic.baseutility.BaseClass;
import com.ocean.crm.objectrepositoryutility.AddeventPage;
import com.ocean.crm.objectrepositoryutility.CalendarPage;
import com.ocean.crm.objectrepositoryutility.HomePage;

public class AddEvent extends BaseClass {

	@Test(groups="SmokeTest")
	public void addEvent() throws IOException {
		
		String startDate = jLib.getRequiredDate(2);
	
		String eName = eLib.getDataFromExcel("calendar", 1, 1)+jLib.getRandomNumber();
		String eDesc = eLib.getDataFromExcel("calendar", 1, 1);
		String eLoc = eLib.getDataFromExcel("calendar", 1, 1);
		
		HomePage hp=new HomePage(driver);
		hp.getCalLink().click();
		CalendarPage cp=new CalendarPage(driver);
		cp.getAddBtn().click();
		cp.getMeetingBtn().click();
		AddeventPage ap=new AddeventPage(driver);
		ap.addEvent(eName, eDesc, eLoc, startDate);
	}

}
