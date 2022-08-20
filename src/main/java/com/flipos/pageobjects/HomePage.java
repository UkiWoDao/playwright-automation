package com.flipos.pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

    private final Page page;
    private final Locator signupButton;

    public HomePage(Page page) {
        this.page = page;
        signupButton = page.locator("a[href = '#signup']");
    }

    public HomePage navigate() {
        page.navigate("https://test.staging-parkjockey.com/en-us/");
        return this;
    }

    public LoginModal openLoginModal() {
        signupButton.click();
        return new LoginModal(page);
    }

}
