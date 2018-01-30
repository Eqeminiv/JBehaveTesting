import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableFilter {
    public WebDriver driver;
    public WebElement element, element2, element3;

    public TableFilter(WebDriver driver) {
        this.driver = driver;
    }

    @Given("a page is table records filter demo")
    public void navigation(){
        driver.navigate().to("http://www.seleniumeasy.com/test/table-records-filter-demo.html");
    }

    @When("there are green elements chosen")
    public void filter(){
        driver.findElement(By.xpath("//button[@data-target='pagado']")).click();
        element = driver.findElement(By.xpath("//tr[@data-status='pendiente']"));
        element2 = driver.findElement(By.xpath("//tr[@data-status='pagado']"));
        element3 = driver.findElement(By.xpath("//tr[@data-status='cancelado']"));
    }

    @Then("it's checked whether presented items are only green")
    public void assertionFilter(){
        Assert.assertTrue(!element.isDisplayed() && element2.isDisplayed() && !element3.isDisplayed());
    }
}