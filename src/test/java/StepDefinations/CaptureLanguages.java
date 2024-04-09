package StepDefinations;

import java.io.IOException;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
 
import BasePackage.BaseClass;
import PageObjects.CoursePageObject;
import PageObjects.HomePageObject;
import PageObjects.LanguageObj;
import PageObjects.ReadytotransformObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class CaptureLanguages extends BaseClass{
	HomePageObject hpo;
	CoursePageObject cpo;
	LanguageObj lpo;
	ReadytotransformObject rto;
	@Given("the user is navigated to coursera home page")
	public void the_user_is_navigated_to_coursera_home_page() {
//		rto = new ReadytotransformObject(driver, mywait);
//		rto.scrollToTop();
		driver.findElement(By.xpath("//a[@aria-label='Coursera']")).click();
	    WebElement logo = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-click-key='front_page.front_page_story.click.navigation_meta_nav_Individuals']")));
	    log.info("The User is navigated to the coursera Home Page");
	    Assert.assertTrue(logo.isDisplayed(),"The user hasn't navigated to the home page");
	}
	@When("clicks on Explore button")
	public void clicks_on_explore_button() {
	    // Write code here that turns the phrase above into concrete actions
		hpo = new HomePageObject(driver,mywait);
		log.info("Clicking on Explore Button");
		hpo.exploreButton();
	}
 
	@When("clicks on Language Learning")
	public void clicks_on_language_learning() {
	    // Write code here that turns the phrase above into concrete actions
		hpo= new HomePageObject(driver,mywait);
		log.info("Clicking on Language Learning");
		try {
			hpo.languageLearning();
		}
		catch(Exception e) {
			hpo.languageLearning();
		}
	}
 
	@When("select the language as All Language Courses")
	public void select_the_language_as_All_Language_Courses() {
	    // Write code here that turns the phrase above into concrete actions
		hpo= new HomePageObject(driver,mywait);
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
 
	@Then("the user should print Languages under various levels")
	public void the_user_should_print_languages_under_various_levels() throws IOException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    // Write code here that turns the phrase above into concrete actions
		lpo=new LanguageObj(driver,mywait);
		log.info("Selecting Course Levels");
		List<WebElement> alllevels=lpo.allLevels();
//		System.out.println(alllevels.size());
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
