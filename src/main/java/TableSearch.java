import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class TableSearch {
    public WebDriver driver;
    public WebElement element;
    static String filter = "SEO tags";
    static String name = "Zieko";


    public TableSearch(WebDriver driver) {
        this.driver = driver;
    }

    @Given("a page is table search filter demo")
    public void navigation()
    {
        driver.navigate().to("http://www.seleniumeasy.com/test/table-search-filter-demo.html");
    }

    @When("it's proper text in the filter field written")
    public void filterSearch(){
        element = driver.findElement(By.id("task-table-filter"));
        element.sendKeys(filter);
        element = driver.findElement(By.xpath("//td[text()='"+filter+"']"));
    }

    @Then("it's checked whether the response is correct")
    public void assertionFilterSearch(){
        Assert.assertTrue(element.isDisplayed());
    }


    @When("it's the filter button activated and a name written in a field")
    public void filterSearchWithButton(){
        element = driver.findElement(By.xpath("//input[@placeholder='First Name']"));

        //filter button active?
        while(element.isEnabled() == false)
        {
            driver.findElement(By.xpath("//button[@class='btn btn-default btn-xs btn-filter']")).click();
            if(element.isEnabled() == false)
            {
                System.out.println("Filter button is not working");
                throw new WebDriverException();

            }
        }

        element.sendKeys(name);
        element = driver.findElement(By.xpath("//td[text()='"+name+"']"));
    }

    @Then("it's checked whether the name is found")
    public void assertionButtonFilter(){
        Assert.assertTrue(element.isDisplayed());
    }


}