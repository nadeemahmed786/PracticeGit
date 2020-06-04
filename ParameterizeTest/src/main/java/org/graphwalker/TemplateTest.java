package org.graphwalker;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.graphwalker.PageObjectModels.Dashboard;
import org.graphwalker.PageObjectModels.LoginPage;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
public class TemplateTest extends ExecutionContext implements Template {

    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket;
    int waitTime;
    Dashboard dashboardPOM = new Dashboard();
    LoginPage loginPOM = new LoginPage();
    List<String> logins = new ArrayList<>();
    Iterator<String> loginIterator;

    //Logger and WebDrivers
    WebDriver driver = null;
    WebDriverWait waiter = null;

    @BeforeExecution
    public void setup() {

        // Add Data for the purpose of this example
        List<String> logins = Arrays.asList(loginPOM.getUsername().split(","));
        loginIterator = logins.iterator();

        //Config
        config.readProperties();
        browser = config.getBrowser();
        waitTime = config.getWaitTime();
        url = config.getURL();
        username = config.getUsername();
        password = config.getPassword();
        closeBrowser = config.getCloseBrowser();
        multiSite = config.getMultiSite();
        ticket = config.getTicket();

        //Driver Instance
        if (browser.equals("chrome")) {
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        } else if (browser.equals("firefox")) {
            FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        } else {
            EdgeDriverManager.getInstance(DriverManagerType.EDGE).setup();
        }
    }

    @AfterExecution
    public void cleanup() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void e_StartBrowser() {
        //Driver Instance
        System.out.println(browser);
        if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("window-size=1600,1600");
            driver = new ChromeDriver(options);
            Assert.assertNotNull(driver);
            waiter = new WebDriverWait(driver, waitTime);
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
            Assert.assertNotNull(driver);
            waiter = new WebDriverWait(driver, waitTime);
        } else {
            driver = new EdgeDriver();
            Assert.assertNotNull(driver);
            waiter = new WebDriverWait(driver, waitTime);
        }
    }


    @Override
    public void v_BrowserStarted() {
        Assert.assertNotNull(driver);
    }

    @Override
    public void e_EnterBaseURL() {
        driver.get(url);
        waiter.until(ExpectedConditions.titleContains("Illuminate Education"));
    }

    @Override
    public void v_BaseURL() {

    }

    @Override
    public void e_InvalidLogin() {
        username = loginIterator.next();
        password = username;
        Helper.login(username, password, waiter, driver);
        if (!loginIterator.hasNext()) {
            setAttribute("loginTested", true);
        }
    }

    @Override
    public void v_LoggedOut() {

    }

    @Override
    public void e_ValidLogin() {
        Helper.login(config.getUsername(), config.getPassword(), waiter, driver);
        Helper.waitUntil(dashboardPOM.getDashboardHeader(), waiter, driver);
        Helper.screenshot(driver);
    }

    @Override
    public void v_Dashboard() {
        waiter.until(ExpectedConditions.titleContains("Illuminate Education"));
    }
}
