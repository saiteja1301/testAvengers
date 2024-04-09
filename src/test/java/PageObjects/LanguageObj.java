package PageObjects;
 
import java.util.List;
 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class LanguageObj extends BasePage{
	public LanguageObj(WebDriver driver, WebDriverWait mywait) {
		super(driver, mywait);
		// TODO Auto-generated constructor stub
	}
	JavascriptExecutor js = (JavascriptExecutor)(driver);
	Actions act=new Actions(driver);
	@FindBy(xpath="//div[@data-testid='search-filter-group-Level']/div/div/div")//
	List<WebElement> alllevels;
	@FindBy(xpath="//button[@aria-label='Show more Language options']")
	WebElement showmore;
	@FindBy(xpath="//div[@data-testid='scroll-container']//h2")
	WebElement languageHead;
	@FindBy(xpath="//div[@id='checkbox-group']/div/label/div/span/span")
	List<WebElement> alllang;
	@FindBy(xpath="//div[@class='cds-Dialog-dialog']/div/button")
	WebElement close;
	public List<WebElement> allLevels(){	
		return alllevels;
	}
	public void showMore() {
		js.executeScript("arguments[0].click();", showmore);
	}
	public void languageText()  {
		mywait.until(ExpectedConditions.visibilityOfAllElements(languageHead));
	}
	public List<WebElement> allLang(){	
		mywait.until(ExpectedConditions.visibilityOfAllElements(alllang));
		return alllang;
	}
	public void closeButton()  {
		js.executeScript("arguments[0].click();",close);
	}
	public String getDynaLevel(String str) {
		int ind = str.indexOf(" (");
		String dynaLevel = str.substring(0,ind);
		return dynaLevel;
	}
}
