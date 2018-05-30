package memetastic;

import memetastic.po.MenuPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import memetastic.po.CreatePage;
import memetastic.po.FavoritesPage;
import memetastic.po.MainPage;
import memetastic.po.OpenPage;
import memetastic.po.SavedPage;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author andreendo
 */
public class FirstTest {

    private static String APKFILELOCATION = "./res/memetastic_44.apk";
    protected AndroidDriver d;

    @Before
    public void before() throws MalformedURLException {
        File apkFile = new File(APKFILELOCATION);
        
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());

        d = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void after() {
        if(d != null)
            d.quit(); 
    }    
    
//    @Test
//    public void testNavigation() throws Exception {
//        OpenPage openPage = new OpenPage(d);
//        MainPage mainPage = openPage.pressOK();
//        mainPage = openPage.pressOK();
//        mainPage.selectTabAnimals();        
//        mainPage.selectTabCartoon();
//        mainPage.selectTabHumans();
//        MenuPage menuPage = mainPage.openMenu();
//        mainPage = menuPage.create();
//        menuPage = mainPage.openMenu();
//        FavoritesPage favoritesPage = menuPage.favorites();
//        assertEquals("Favs", favoritesPage.getTitle());
//    }
//    
//    @Test
//    public void testSavedPage() throws Exception {
//        OpenPage openPage = new OpenPage(d);
//        MainPage mainPage = openPage.pressOK();
//        mainPage = openPage.pressOK();
//        mainPage.selectTabRage();        
//        mainPage.selectTabOther();
//        MenuPage menuPage = mainPage.openMenu();
//        SavedPage savedPage = menuPage.save();
//        assertEquals("Saved", savedPage.getTitle());
// 
//    }
//    @Test
//    public void testSaveMeme() throws Exception {
//        OpenPage openPage = new OpenPage(d);
//        MainPage mainPage = openPage.pressOK();
//        mainPage = openPage.pressOK();
//        mainPage.selectTabAnimals();
//        CreatePage createPage = mainPage.selectImage();
//        createPage.saveMeme();
//        assertEquals("Successfully saved!",createPage.memeSaved());
// 
//    }
    @Test
    public void testDeleteMeme() throws Exception {
        OpenPage openPage = new OpenPage(d);
        MainPage mainPage = openPage.pressOK();
        mainPage = openPage.pressOK();
        MenuPage menuPage = mainPage.openMenu();
        SavedPage savedPage = menuPage.save();
        savedPage.deleteAll();
        assertTrue(savedPage.imagesNotExist());
    }
    
}
