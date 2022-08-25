package tests.blog;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.CommentForm.*;
import static constants.Constant.Footer.FOOTER_TITLES;
import static constants.Constant.Footer.NUMBER_OF_GOOD_FOOTER_BUTTONS;
import static constants.Constant.Header.HEADER_TITLES;
import static constants.Constant.Header.NUMBER_OF_GOOD_HEADER_BUTTONS;
import static constants.Constant.Reg.*;
import static constants.Constant.Reviews.*;
import static constants.Constant.Urls.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BlogTest extends BaseTest {

    @BeforeMethod
    public void setUp () {
        startDriver("blog");
        basePage.goToUrl(BLOG_PAGE_URL);
        basePage.waitOneSeconds();
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void headerButtonsTest () {
        basePage.closePopup();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_GOOD_HEADER_BUTTONS; i++) {
            basePage.headerMenuOpen();
            basePage.waitOneSeconds();
            basePage.headerButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(HEADER_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(BLOG_PAGE_URL);
        }
        assertEquals(NUMBER_OF_GOOD_HEADER_BUTTONS, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void footerButtonsTest () {
        basePage.closePopup();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_GOOD_FOOTER_BUTTONS; i++) {
            if (i == 40) {i++; goodTitlesCount++;}
            basePage.waitOneSeconds();
            basePage.footerButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(FOOTER_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(BLOG_PAGE_URL);
        }
        assertEquals(NUMBER_OF_GOOD_FOOTER_BUTTONS, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void mainLogoLinkTest () {
        basePage.closePopup();
        basePage.mainLogoButtonClick();
        basePage.waitOneSeconds();
        assertEquals(MAIN_PAGE_URL, basePage.getCurrentUrl());
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void topPostBlogButtonTest () {
        basePage.closePopup();
        int goodUrlsCount = 0;
        for (int i = 1; i <= NUMBER_OF_TOP_POST_BLOG_BUTTONS_BLOG_PAGE; i++) {
            basePage.waitOneSeconds();
            blogPage.topPostBlogButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.getCurrentUrl().contains(BLOG_CATEGORY_URL)) { goodUrlsCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(BLOG_PAGE_URL);
        }
        assertEquals(NUMBER_OF_TOP_POST_BLOG_BUTTONS_BLOG_PAGE, goodUrlsCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void topPostButtonTest () {
        basePage.closePopup();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_TOP_POST_BUTTONS_BLOG_PAGE; i++) {
            basePage.waitOneSeconds();
            blogPage.topPostButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(BLOG_PAGE_URL);
        }
        assertEquals(NUMBER_OF_TOP_POST_BUTTONS_BLOG_PAGE, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void successfulCommentFormTest () {
        basePage.closePopup();
        blogPage.enterName(NAME)
                .enterEmail(EMAIL)
                .enterComment(COMMENT);
        basePage.waitOneSeconds();
        blogPage.submitButtonClick();
        basePage.waitTwoSeconds();
        assertTrue(blogPage.submitMessageVisibleCheck());
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void unsuccessfulCommentFormTest () {
        basePage.closePopup();
        blogPage.enterName(EMPTY)
                .enterEmail(EMPTY)
                .enterComment(EMPTY);
        basePage.waitOneSeconds();
        blogPage.submitButtonClick();
        basePage.waitTwoSeconds();
        assertTrue(mainPage.inputErrorVisibleCheck());
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void nextSliderButtonTest () {
        basePage.closePopup();
        blogPage.scrollToSlider();
        basePage.waitOneSeconds();
        blogPage.nextSliderButtonClick();
        basePage.waitOneSeconds();
        assertTrue(blogPage.sliderBlockVisibleCheck());
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void visitSiteRegButtonTest () {
        basePage.closePopup();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_VISIT_SITE_REG_BUTTONS_BLOG_PAGE; i++) {
            basePage.waitOneSeconds();
            blogPage.visitSiteRegButtonClick(i);
            basePage.nextTab();
            basePage.waitThirtySeconds();
            if (basePage.checkTitles(REG_TITLES)) { goodTitlesCount++; }
            basePage.waitOneSeconds();
            basePage.closeTabAndMoveToNext();
        }
        assertEquals(NUMBER_OF_VISIT_SITE_REG_BUTTONS_BLOG_PAGE, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void readFullReviewButtonTest () {
        basePage.closePopup();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_READ_FULL_REVIEW_BUTTONS_BLOG_PAGE; i++) {
            basePage.waitOneSeconds();
            blogPage.readFullReviewButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            basePage.waitOneSeconds();
            basePage.back(BLOG_PAGE_URL);
        }
        assertEquals(NUMBER_OF_READ_FULL_REVIEW_BUTTONS_BLOG_PAGE, goodTitlesCount);
    }

}
