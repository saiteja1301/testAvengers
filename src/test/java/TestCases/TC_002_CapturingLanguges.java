package TestCases;

import java.io.IOException;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
 
import BasePackage.BaseClassNG;
import PageObjects.CoursePageObject;
import PageObjects.HomePageObject;
import PageObjects.LanguageObj;
 
public class TC_002_CapturingLanguges extends BaseClassNG{
	HomePageObject hpo;
	CoursePageObject cpo;
	LanguageObj lpo;
	@Test(priority=0,groups= {"smoke"})
	public void exploreButtonHome() {
		hpo= new HomePageObject(driver,mywait);
		log.info("Clicking on Explore Button");
		try {
			hpo.exploreButton();
		}
		catch(Exception exp) {
			hpo.exploreButton();
		}
		log.info("Clicking on Language Learning");
		try {
			hpo.languageLearning();
		}
		catch(Exception e) {
			hpo.languageLearning();
		}
		log.info("Clicking on All Language Courses");
		hpo.allLangCourses();
		try {
			hpo.allLangHeading() ;
			log.info("Navigated to All Language Courses");
			Assert.assertTrue(true);
		}
		catch(Exception e) {
			log.info("Did Not Navigate to All Language Courses");
			Assert.fail(); 
		}

 
	}
	@Test(priority=1,groups= {"regression","smoke"})
	public void courseLevels() throws IOException{
		JavascriptExecutor js = (JavascriptExecutor)(driver);
		lpo=new LanguageObj(driver,mywait);
		log.info("");
		List<WebElement> alllevels=lpo.allLevels();
		if(alllevels.size()>0) {
			eu.setCellData(rowNum, 0, "Course Levels", 0);
			eu.setCellData(rowNum, 1, "Languages and Course count", 0);
			//eu.setCellData(rowNum, 2, "", 0);
			rowNum+=1;
				List<WebElement> allLevels = lpo.allLevels();
				for(int i=0;i<alllevels.size();i++) {
					allLevels.get(i).click();
					String str = alllevels.get(i).getText();
					String dynaLevel = lpo.getDynaLevel(str);
					System.out.println(dynaLevel);
					eu.setCellData(rowNum, 0, dynaLevel , 3);
					mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-testid,'"+dynaLevel+"-true')]")));
					lpo.showMore();
					lpo.languageText();
					log.info("Capturing all available languages");
					List<WebElement> alllang = lpo.allLang();
						for(WebElement ele1:alllang) {
							String lang=ele1.getText();
							System.out.println(lang);
							eu.setCellData(rowNum, 1, lang, 1);
							rowNum+=1;
						}
						rowNum+=1;
					System.out.println();
					log.info("Clicking on close button");
					try {
						lpo.closeButton();
					}
					catch(Exception e) {
						lpo.closeButton();
					}
					WebElement le = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-testid,'"+dynaLevel+"')]")));
					js.executeScript("arguments[0].scrollIntoView(false);", le);
					le.click();
					mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-testid,'"+dynaLevel+"-false')]")));
 
				}	
 
				Assert.assertTrue(true);
		}	
		else {
			Assert.assertFalse(false);
		}
	}
 
}
