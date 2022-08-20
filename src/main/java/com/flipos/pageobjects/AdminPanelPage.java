package com.flipos.pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AdminPanelPage {

    private final Page page;
    private final Locator sideBarMenu;

    public AdminPanelPage(Page page) {
        this.page = page;
        sideBarMenu = page.locator("aside[class = 'main-sidebar']");
    }

    public boolean isSideBarVisible() {
        return sideBarMenu.isVisible();
    }
}
