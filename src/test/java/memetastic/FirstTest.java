package memetastic;

import memetastic.po.MenuPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import memetastic.po.CreatePage;
import memetastic.po.EditPage;
import memetastic.po.FavoritesPage;
import memetastic.po.MainPage;
import memetastic.po.OpenPage;
import memetastic.po.SavedPage;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author andreendo
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FirstTest {

    private static String APKFILELOCATION = "./res/memetastic_44.apk";
    protected AndroidDriver d;

    @Before
    public void before() throws MalformedURLException {
        File apkFile = new File(APKFILELOCATION);
        
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X API 22");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
        capabilities.setCapability("autoGrantPermissions", "true");

        d = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @After
    public void after() {
        if(d != null)
            d.quit(); 
    }    
    
    @Test
    public void testNavigation() throws Exception {
        OpenPage openPage = new OpenPage(d);
        MainPage mainPage = openPage.pressOK();
        mainPage.selectTabAnimals();        
        mainPage.selectTabCartoon();
        mainPage.selectTabHumans();
        MenuPage menuPage = mainPage.openMenu();
        mainPage = menuPage.create();
        menuPage = mainPage.openMenu();
        FavoritesPage favoritesPage = menuPage.favorites();
        assertEquals("Favs", favoritesPage.getTitle());
    }
    
    @Test
    public void createMeme(){
    	OpenPage openPage = new OpenPage(d);
        MainPage mainPage = openPage.pressOK();
        mainPage.selectSearchButton();
        mainPage.writeTextSearch("Trump");
        CreatePage createPage = mainPage.selectImagem();
        createPage.selectImageView();
        createPage.writeTextMeme("Sorvete de Frango");
        createPage.selectDone();
        createPage.selectSave();
        assertEquals("Successfully saved!", createPage.textAlert());
        createPage.selectYes();
    }
    
    @Test
    public void deleteMeme(){
    	OpenPage openPage = new OpenPage(d);
    	MainPage mainPage = openPage.pressOK();
    	MenuPage menuPage = mainPage.openMenu();
    	SavedPage savedPage = menuPage.saved();
    	savedPage.selectImagem();
    	savedPage.selectDelete();
    	assertEquals("No memes saved yet.\nUse the top save button after editing a meme.",
    			savedPage.textMsgNoMemes());
    }
    
    @Test
    public void favoriteMeme(){
    	OpenPage openPage = new OpenPage(d);
        MainPage mainPage = openPage.pressOK();
        mainPage.selectSearchButton();
        mainPage.writeTextSearch("Trump");
        mainPage.selectStarButton();
        MenuPage menuPage = mainPage.openMenu();
        FavoritesPage favPage = menuPage.favorites();
        assertTrue(favPage.imageExists());
    }

}
