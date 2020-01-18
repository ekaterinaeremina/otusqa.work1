package otusqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserBase
{
    public static WebDriver driver;
    private static String Browser_name;

    public BrowserBase(String browser){
        Browser_name = browser;
        initialization();
    }

    public static void initialization()
    {
        switch (Browser_name)
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException("The Browser_name can be chrome, firefox, opera or ie");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
}
