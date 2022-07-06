package pages.contactUs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ContactUsPage extends BasePage {

    public ContactUsPage (WebDriver driver) {super(driver);}

    private final By nameInput = By.xpath("//input[@id='field_qh4icy581b9279ff']");
    private final By emailInput= By.xpath("//input[@id='field_29yf4d514daf790a']");
    private final By subjectInput = By.xpath("//input[@id='field_e6lis6304bcba9ed']");
    private final By commentIInput = By.xpath("//textarea[@id='field_9jv0r14048f69194']");
    private final By submitButton = By.xpath("//button[@class='frm_button_submit frm_final_submit']");
    private final By submitMessage = By.xpath("//div[@class='frm_message']");

    public ContactUsPage enterName (String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public ContactUsPage enterEmail (String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public ContactUsPage enterSubject (String subject) {
        driver.findElement(subjectInput).sendKeys(subject);
        return this;
    }

    public ContactUsPage enterComment (String comment) {
        driver.findElement(commentIInput).sendKeys(comment);
        return this;
    }

    public ContactUsPage submitButtonClick () {
        driver.findElement(submitButton).click();
        return this;
    }

    public Boolean submitMessageVisibleCheck () {
        boolean isVisible = driver.findElements(submitMessage).size() == 1;
        if (!isVisible) {
            waitOneSeconds();
            submitButtonClick();
            waitFiveSeconds();
            isVisible = driver.findElements(submitMessage).size() == 1;
        }
        return isVisible;
    }


    public Boolean inputErrorVisibleCheck () {
        boolean errorsCheck = driver.findElements(By.xpath("//div[@class='frm_error_style']")).size() == 1;
        if (!errorsCheck) {
            waitOneSeconds();
            submitButtonClick();
            waitFiveSeconds();
            errorsCheck = driver.findElements(submitMessage).size() == 1;
        }
        return errorsCheck;
    }

}
