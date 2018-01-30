import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.Arrays;
import java.util.List;

public class StoriesMain extends JUnitStories {

    public StoriesMain()
    {
        super();
    }

    @Override
    public Configuration configuration()
    {
        return new MostUsefulConfiguration();
    }

    @Override
    public InjectableStepsFactory stepsFactory()
    {
        System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        return new InstanceStepsFactory(configuration(),
                new InputFormDemo(driver),
                new JQueryDropdown(driver),
                new SingleInputField(driver),
                new TableFilter(driver),
                new TableSearch(driver));
    }

    @Override
    protected List<String> storyPaths()
    {
        return Arrays.asList("Stories/InputFormDemo.story", "Stories/JQueryDropdown.story", "Stories/SingleInputField.story", "Stories/TableFilter.story", "Stories/TableSearch.story");
    }
}
