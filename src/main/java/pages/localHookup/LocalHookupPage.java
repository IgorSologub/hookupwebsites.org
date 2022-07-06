package pages.localHookup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class LocalHookupPage extends BasePage {

    public LocalHookupPage (WebDriver driver) {super(driver);}

    private final By learnMoreButton = By.xpath("//a[@class='Vkm1ZLuS FQVrho']");
    private final By loadMoreButton = By.xpath("//button[@class='yw0tcenHMi6 d8UJ38ZI0jH js-showner-more js-showner-sortgroups']");
    private final By cityBlock = By.xpath("//div[normalize-space()='Chicago']");
    private final By loadMoreReviewButton = By.xpath("//button[@class='yw0tcenHMi6 d8UJ38ZI0jH MigYLSQGeQ js-showner-more']");
    private final By reviewBlock = By.xpath("(//tr[@class='w-sIAfbvvWZc'])[2]");
    private final By faqCollapseButton = By.xpath("(//div[@class='qzxNuOZkpY'])[1]");
    private final By faqCollapseText = By.xpath("(//div[@class='IWOdyC'])[1]");
    private final By authorButton = By.xpath("//a[@class='wEJQ3x4D']");
    private final By nextSliderButton = By.xpath("//button[@class='js-sites-next-sm slick-arrow slick-next']");
    private final By blogSlide = By.xpath("(//div[@class='rNjITkxM'])[6]");
    private final By scrollToBlogSlider = By.xpath("(//h2[@class='i6SXKVbQaBZ2'])[9]");

    public LocalHookupPage learnMoreButtonClick () {
        driver.findElement(learnMoreButton).click();
        return this;
    }

    public LocalHookupPage loadMoreButtonClick () {
        driver.findElement(loadMoreButton).click();
        return this;
    }

    public Boolean cityBlockCheck () {
        return elementVisibleCheck(cityBlock);
    }

    public LocalHookupPage visitSiteButtonClick (int numButton) {
        By visitSiteButton = By.xpath("(//a[@class[contains(.,'Vkm1ZLuS r0l4lp20bLG')]])[" + numButton + "]");
        driver.findElement(visitSiteButton).click();
        return this;
    }

    public LocalHookupPage readReviewButtonClick (int numButton) {
        By readReviewButton = By.xpath("(//a[@class[contains(.,'KE9vhRh')]])[" + numButton + "]");
        driver.findElement(readReviewButton).click();
        return this;
    }

    public LocalHookupPage latestNewsButtonClick (int numButton) {
        By latestNewsButton = By.xpath("(//a[@class='PD_2dIu5iIO4'])[" + numButton + "]");
        driver.findElement(latestNewsButton).click();
        return this;
    }

    public LocalHookupPage loadMoreReviewButtonClick () {
        driver.findElement(loadMoreReviewButton).click();
        return this;
    }

    public Boolean reviewBlockCheck () {
        return elementVisibleCheck(reviewBlock);
    }

    public LocalHookupPage visitSiteInTextButtonClick (int numButton) {
        By visitSiteInTextButton = By.xpath("(//a[@class[contains(.,'Vkm1ZLuS Xvye rjpm0')]])[" + numButton + "]");
        driver.findElement(visitSiteInTextButton).click();
        return this;
    }

    public LocalHookupPage readFullReviewButtonClick (int numButton) {
        By readFullReviewButton = By.xpath("(//a[@class='fXnq6'])[" + numButton + "]");
        driver.findElement(readFullReviewButton).click();
        return this;
    }

    public LocalHookupPage faqCollapseButtonClick () {
        driver.findElement(faqCollapseButton).click();
        return this;
    }

    public Boolean faqCollapseTextCheck () {
        return elementVisibleCheck(faqCollapseText);
    }

    public LocalHookupPage articlesButtonClick (int numButton) {
        By articlesButton = By.xpath("(//a[@class='NS_1IIV8zv5L'])[" + numButton + "]");
        driver.findElement(articlesButton).click();
        return this;
    }

    public LocalHookupPage authorButtonClick () {
        driver.findElement(authorButton).click();
        return this;
    }

    public Boolean authorCheck () {
        return driver.getTitle().contains("Sarah");
    }

    public LocalHookupPage scrollToBlogSlider () {
        scrollToElement(scrollToBlogSlider);
        return this;
    }

    public LocalHookupPage nextBlogSliderButtonClick () {
        driver.findElement(nextSliderButton).click();
        return this;
    }

    public Boolean blogSliderVisibleCheck () {
        return elementVisibleCheck(blogSlide);
    }

}
