package com.flipos;

import com.flipos.pageobjects.AdminPanelPage;
import com.flipos.pageobjects.HomePage;
import com.flipos.pageobjects.LoginModal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FirstTest extends PlaywrightSetup {

    @Test
    void accessing_signup_section_should_display_signup_form() {
        HomePage homePage = new HomePage(page).navigate();
        LoginModal loginModal = homePage.openLoginModal();
        assertTrue(loginModal.isVisible());
    }

    @Test
    void logging_in_should_take_to_admin_panel() {
        HomePage homePage = new HomePage(page).navigate();
        LoginModal loginModal = homePage.openLoginModal();
        AdminPanelPage adminPanelPage = loginModal.logInAs("test", "test");
        assertTrue(adminPanelPage.isSideBarVisible());
    }
}
