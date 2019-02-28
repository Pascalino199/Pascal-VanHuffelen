package activities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
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

    @AndroidFindBy(id = "btn_save")
    private AndroidElement nextButton;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='EUR']")
    private AndroidElement eurCurrency;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Other…']")
    private AndroidElement otherCurrency;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='ALL - Lek']")
    private AndroidElement befCurrency;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Create default accounts']")
    private AndroidElement defaultAccounts;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Let me handle it']")
    private AndroidElement noAccounts;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Disable crash reports']")
    private AndroidElement disableReports;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Automatically send crash reports']")
    private AndroidElement sendReports;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='DISMISS']")
    private AndroidElement dismissButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No accounts to display']")
    private AndroidElement emptyAccount;

    public void nextButtonClick() {
        nextButton.click();
    }
    public void selectCurrencyEUR() {
        eurCurrency.click();
        nextButtonClick();
    }
    public void selectCurrencyOther(){
        otherCurrency.click();
        nextButtonClick();
    }

    public void selectDefaultAccount() {
        defaultAccounts.click();
        nextButtonClick();
    }
    public void selectNoAccount() {
        noAccounts.click();
        nextButtonClick();
    }
    public void selectDisableReports() {
        disableReports.click();
        nextButtonClick();
    }
    public void selectSendReports() {
        sendReports.click();
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

    public void selectCurrencyBEF() {
        befCurrency.click();
        nextButtonClick();
    }

    public boolean checkEmptyAccount() {
        try{
            if(emptyAccount.isDisplayed()){
                return true;
            }
        }catch (NoSuchElementException e) {
            System.out.println("Account view not empty");
            return false;
        }
        return false;
    }
}
