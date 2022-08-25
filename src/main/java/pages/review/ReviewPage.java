package pages.review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ReviewPage extends BasePage {

    public ReviewPage (WebDriver driver) {super(driver);}

    private final By visitSiteRegButton = By.xpath("//a[contains(@class,'Vkm1ZLuS lIZaFFEDwon g_6UBEXj')]");
    private final By nameInput = By.xpath("//input[@id='author']");
    private final By emailInput= By.xpath("//input[@id='email']");
    private final By commentIInput = By.xpath("//textarea[@id='comment']");
    private final By submitButton = By.xpath("//button[@class='Vkm1ZLuS']");
    private final By submitMessage = By.xpath("//div[@id='form-message']");
    private final By nextSliderButton = By.xpath("//button[@class='js-sites-next-sm slick-arrow slick-next']");
    private final By sliderBlock = By.xpath("(//div[@class='rNjITkxM'])[4]");
    private final By scrollToSlider = By.xpath("(//h2[@class='i6SXKVbQaBZ2'])[11]");
    private final By scrollToSubmitButton = By.xpath("//div[@id='customer-reviews-nav-6454']");

    public ReviewPage visitSiteRegButtonClick () {
        driver.findElement(visitSiteRegButton).click();
        return this;
    }

    public ReviewPage pictureRegButtonClick (int numButton) {
        By pictureRegButton = By.xpath("(//a[contains(@class,'sUsIZumkQJ7')])[" + numButton + "]");
        driver.findElement(pictureRegButton).click();
        return this;
    }

    public ReviewPage enterName (String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public ReviewPage enterEmail (String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public ReviewPage enterComment (String comment) {
        driver.findElement(commentIInput).sendKeys(comment);
        return this;
    }

    public ReviewPage scrollToSubmitButton () {
        scrollToElement(scrollToSubmitButton);
        return this;
    }

    public ReviewPage submitButtonClick () {
        driver.findElement(submitButton).click();
        return this;
    }

    public Boolean submitMessageVisibleCheck () {
        boolean isVisible = driver.findElements(submitMessage).size() > 0;
        if (!isVisible) {
            waitOneSeconds();
            submitButtonClick();
            waitTwoSeconds();
            isVisible = driver.findElements(submitMessage).size() > 0;
        }
        return isVisible;
    }

    public Boolean inputErrorVisibleCheck () {
        boolean errorsCheck = driver.findElements(By.xpath("//*[@class='puXrVenH3 error']")).size() == 3;
        if (!errorsCheck) {
            waitOneSeconds();
            submitButtonClick();
            waitTwoSeconds();
            errorsCheck = driver.findElements(submitMessage).size() == 3;
        }
        return errorsCheck;
    }

    public ReviewPage nextSliderButtonClick () {
        driver.findElement(nextSliderButton).click();
        return this;
    }

    public Boolean sliderBlockVisibleCheck () {
        return elementVisibleCheck(sliderBlock);
    }

    public ReviewPage scrollToSlider () {
        scrollToElement(scrollToSlider);
        return this;
    }

    public ReviewPage latestReviewsButtonClick (int numButton) {
        By latestReviewsButton = By.xpath("(//a[@class='PD_2dIu5iIO4'])[" + numButton + "]");
        driver.findElement(latestReviewsButton).click();
        return this;
    }

}
