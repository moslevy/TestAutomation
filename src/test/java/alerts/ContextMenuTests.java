package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextMenu(){
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickInBox();
        var text=contextMenuPage.getPopUpText();
        contextMenuPage.acceptPopUp();
        assertEquals(text, "You selected a context menu", "Popup message incorrect");
                                


    }
}
