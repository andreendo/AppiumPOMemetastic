package memetastic;

import memetastic.po.MenuPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import memetastic.po.EditImagePage;
import memetastic.po.FavoritesPage;
import memetastic.po.MainPage;
import memetastic.po.OpenPage;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.openqa.selenium.By;
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
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus4-22");
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());

        d = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void after() {
        if (d != null) {
            d.quit();
        }
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
    public void editFirstHumanMemeTest() throws Exception {
        OpenPage openPage = new OpenPage(d);
        MainPage mainPage = openPage.pressOK();
        EditImagePage editImagePage = mainPage.selectFirstImage();
        editImagePage.selectToAddText();
        editImagePage.insertText();
        editImagePage.saveMeme();

        assertEquals("Successfully saved!", editImagePage.getAlerta());
    }

   
    @Test
    public void editAnimalMemeTest() throws Exception {
        OpenPage openPage = new OpenPage(d);
        MainPage mainPage = openPage.pressOK();
        mainPage.selectTabAnimals();
        EditImagePage editImagePage = mainPage.selectFirstImage();
        editImagePage.selectToAddText();
        editImagePage.insertText();
        editImagePage.saveMeme();

        assertEquals("Successfully saved!", editImagePage.getAlerta());
    }


    @Test
    public void favEmptyTest() {
        OpenPage openPage = new OpenPage(d);
        MainPage mainPage = openPage.pressOK();
        MenuPage menuPage = mainPage.openMenu();

        FavoritesPage fav = menuPage.favorites();

        
        assertEquals("No favourites yet.\n"
                + "Use the star button of a meme template to add it to the favourites.", fav.msgVazio());

    }
    
  
    @Test
    public void createCartoonMemeTest() {
        OpenPage openPage = new OpenPage(d);
        MainPage mainPage = openPage.pressOK();

        MenuPage menuPage = mainPage.openMenu();
        mainPage = menuPage.create();
        mainPage.selectTabCartoon();

        EditImagePage editImagePage = mainPage.selectFirstImage();
        editImagePage.selectToAddText();
        editImagePage.insertText();
        editImagePage.saveMeme();

        assertEquals("Successfully saved!", editImagePage.getAlerta());
    }
    
 

}
