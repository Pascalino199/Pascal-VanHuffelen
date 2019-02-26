package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;


public class RegisterActivity {
    private AndroidDriver<AndroidElement> driver;
    public RegisterActivity() {
    }
    public RegisterActivity(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(className = "UIAKeyboard")
    private AndroidElement keyboard;
    @AndroidFindBy(id = "name")
    private AndroidElement nameElement;
    @AndroidFindBy(id = "password")
    private AndroidElement passwordElement;
    @AndroidFindBy(id = "login")
    private AndroidElement loginElement;
    @AndroidFindBy(id = "btn_save")
    private AndroidElement nextButton;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='EUR']")
    private AndroidElement eurCurrency;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Create default accounts']")
    private AndroidElement defaultAccounts;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Disable crash reports']")
    private AndroidElement disableReports;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='DISMISS']")
    private AndroidElement dismissButton;


    public void nextButtonClick() {
        nextButton.click();
    }
    public void selectCurrency() {
        eurCurrency.click();
        nextButtonClick();
    }
    public void selectDefaultAccount() {
        defaultAccounts.click();
        nextButtonClick();
    }
    public void selectDisableReports() {
        disableReports.click();
        nextButtonClick();
    }
    public void dismissClick() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dismissButton.click();
    }

    public boolean isDisplayed() {
        return loginElement.isDisplayed();
    }
    public void typeName(String name) {
        nameElement.sendKeys(name);
    }
    public void typePassword(String password) {
        passwordElement.sendKeys(password);
    }
    public void clickLogin() {
        loginElement.click();
    }
    public void hideKeyboardIfVisible() {
        if (keyboard != null) {
            driver.pressKeyCode(AndroidKeyCode.KEYCODE_ESCAPE);
        }
    }
    public void login (String name, String password) {
        hideKeyboardIfVisible();
        typeName(name);
        typePassword(password);
        clickLogin();
    }
}
