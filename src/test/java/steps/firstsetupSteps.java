package steps;

import activities.RegisterActivity;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class firstsetupSteps {
    private AndroidDriver wd = null;
    private RegisterActivity activity = null;
    @Given("^I launch the GnuCash App for the first time$")
    public void iLaunchTheGnuCashAppForTheFirstTime() {
        String apkpath="src\\test\\resources\\GnucashAndroid_v2.4.0.apk";
        File app=new File(apkpath);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("deviceName", "Nexus 5X 25");
        capabilities.setCapability("app",app.getAbsolutePath() );
        capabilities.setCapability("appWaitActivity", "org.gnucash.android.ui.wizard.FirstRunWizardActivity");
        capabilities.setCapability("automationName","uiautomator2");

        try {
            wd = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            //wd.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @And("^I am in the configurator$")
    public void iAmInTheConfigurator() {
    }

    @When("^I dismiss the welcome screen$")
    public void iDismissTheWelcomeScreen() {
        activity=new RegisterActivity(wd);
        activity.nextButtonClick();
    }

    @And("^I select eur as currency$")
    public void iSelectEurAsCurrency() {
        activity.selectCurrencyEUR();
    }

    @And("^I select default accounts$")
    public void iSelectDefaultAccounts() {
        activity.selectDefaultAccount();
    }

    @And("^I disable the crash reports$")
    public void iDisableTheCrashReports() {
        activity.selectDisableReports();
    }

    @And("^I agree with the review$")
    public void iAgreeWithTheReview() {
        activity.nextButtonClick();
    }

    @Then("^I see the news popup$")
    public void iSeeTheNewsPopup() {
    }

    @And("^I end up in the accounts page$")
    public void iEndUpInTheAccountsPage() {
        activity.dismissClick();
    }

    @And("^I select other as currency$")
    public void iSelectOtherAsCurrency() {
        activity.selectCurrencyOther();
    }

    @And("^I select BEF$")
    public void iSelectCurrency() {
        activity.selectCurrencyBEF();
    }

    @And("^I enable the crash reports sending$")
    public void iEnableTheCrashReportsSending() {
        activity.selectSendReports();
    }

    @And("^I select no accounts$")
    public void iSelectNoAccounts() {
        activity.selectNoAccount();
    }

    @And("^I end up in the empty account page$")
    public void iEndUpInTheEmptyAccountPage() {
        activity.dismissClick();
        assertEquals(activity.checkEmptyAccount(),true);
    }
}

