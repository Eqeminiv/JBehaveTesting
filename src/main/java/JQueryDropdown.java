import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JQueryDropdown {

    public WebDriver driver;
    public WebElement element, element2;
    static String countryFragment = "aus";
    static String countryFull = "Australia";
    static String state = "Colorado";
    static String territory = "Guam";
    public Actions action;

    public JQueryDropdown(WebDriver driver) {
        this.driver = driver;
        action = new Actions(this.driver);
    }

    @Given("a page is JQuery dropdown search demo")
    public void navigation(){
        driver.navigate().to("http://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
    }

    @When("the single search is given a country fragment")
    public void dropdownSearch(){
        element = driver.findElement(By.xpath("//span[@class='select2 select2-container select2-container--default']"));
        element.click();
        element = driver.findElement(By.xpath("//span/input[@class='select2-search__field']"));
        element.sendKeys(countryFragment);
        element.sendKeys(Keys.ENTER);
        element = driver.findElement(By.id("select2-country-container"));
    }

    @Then("it's tested whether the response is proper")
    public void assertionSearch(){
        Assert.assertTrue(element.getAttribute("title").equals(countryFull));
    }

    @When("in the multiple select state is clicked")
    public void selectMultiple(){
        element = driver.findElement(By.xpath("//span[@class='select2 select2-container select2-container--default' and @style='width: 50%;']"));
        element.click();
        element = driver.findElement(By.xpath("//li[text()='"+state+"']"));
        element.click();

        driver.findElement(By.xpath("//span[@class='select2-selection__choice__remove']")).click();
        element = driver.findElement(By.xpath("//input[@class='select2-search__field']"));

    }
    @Then("it's tested whether the response is valid")
    public void assertionMultiple(){
        Assert.assertEquals(element.getAttribute("placeholder"),"Select state(s)");
    }

    @When("the dropdown with disabled values is checked")
    public void dropdownDisabled(){
        element2 = driver.findElement(By.xpath("//span[@class='select2-selection__rendered' and @title='American Samoa']"));
        element2.click();
        element = driver.findElement(By.xpath("//span/input[@class='select2-search__field']"));
        element.sendKeys(territory);
        element.sendKeys(Keys.ENTER);
        //element = driver.findElement(By.xpath("//span[@class='select2-selection__rendered']"));
    }

    @Then("it's tested whether the chosen option is returned")
    public void assertionDisabled(){
        Assert.assertNotEquals(element2.getText(),territory);
    }

    public void dropdownCategories(){
        element = driver.findElement(By.id("files"));
        element.click();
        driver.findElement(By.xpath("//option[@value='somefile']")).click();
        element.click();
    }
    public void assertionCategories(){
        Assert.assertEquals(element.getText(),"Unknown Script");
    }

}