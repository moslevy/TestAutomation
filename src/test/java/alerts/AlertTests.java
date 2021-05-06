package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert(){
        var alertPage = homePage.clickJavaScriptAlert();
        alertPage.triggerAlert();
        alertPage.alert_clickToAccept();
        assertEquals(alertPage.getResult(), "You successfully clicked an alert", "Result is incorrect");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertsPage = homePage.clickJavaScriptAlert();
        alertsPage.triggerConfirm();
        var text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
    }

    @Test
    public void testSetInputAlert(){
        var alertsPage = homePage.clickJavaScriptAlert();
        alertsPage.triggerPrompt();
        String inputText = "Hello Moses!";
        alertsPage.alert_setInput(inputText);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You entered: " + inputText, "Result is incorrect");
    }
}
