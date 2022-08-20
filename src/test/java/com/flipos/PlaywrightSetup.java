package com.flipos;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

class PlaywrightSetup {

    static Playwright playwright;
    static Browser browser;

    BrowserContext context;
    Page page;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false);
        browser = playwright.chromium().launch(launchOptions);
    }

    @AfterAll
    static void afterAll() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }
}