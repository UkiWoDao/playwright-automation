package com.flipos.pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginModal {

    private final Page page;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator logInButton;

    public LoginModal(Page page) {
        this.page = page;
        emailInput = page.locator("input[name = 'data[User][email]']");
        passwordInput = page.locator("input[name = 'data[User][password]']");
        logInButton = page.locator("input[value = 'Log in']");
    }

    public AdminPanelPage logInAs(String email, String password) {
        emailInput.type(email);
        passwordInput.type(password);
        logInButton.click();
        return new AdminPanelPage(page);
    }

    public boolean isVisible() {
        return emailInput.isVisible() && passwordInput.isVisible() && logInButton.isVisible();
    }

}
