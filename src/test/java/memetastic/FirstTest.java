package memetastic;

import memetastic.po.MenuPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import memetastic.po.FavoritesPage;
import memetastic.po.MainPage;
import memetastic.po.OpenPage;
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

    private static String APKFILELOCATION = "/home/andre/git/AppiumPOMemetastic/res/memetastic_44.apk";
    protected AndroidDriver d;

    @Before
    public void before() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
				.setPlatformName("Android")
				.setAutoGrantPermissions(true)
				.setApp(APKFILELOCATION);

		d = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
}
