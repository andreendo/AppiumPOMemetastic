package memetastic.po;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author andreendo
 */
public class MainPage extends BasePage {

    @FindBy(id = "Open navigation drawer")
    RemoteWebElement menu;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Human\")")
    RemoteWebElement humanTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Animals\")")
    RemoteWebElement animalsTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Cartoon\")")
    RemoteWebElement cartoonTab;

    @FindBy(id = "io.github.gsantner.memetastic:id/item__square_image__image")
    RemoteWebElement firstImage;

    @FindAll({@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout")})
    private List<RemoteWebElement> itens;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]")
    private RemoteWebElement hideMenuButton;
    
    @FindBy(id = "io.github.gsantner.memetastic:id/main_activity__view_pager")
    private RemoteWebElement listItensWithScroll;

    public MainPage(AndroidDriver d) {
        super(d);
    }

    public void selectTabHumans() {

        humanTab.click();
    }

    public void selectTabAnimals() {
        animalsTab.click();
    }

    public void selectTabCartoon() {
        cartoonTab.click();
    }

    public MenuPage openMenu() {
        menu.click();
        return new MenuPage(d);
    }

    public EditImagePage selectFirstImage() {
        firstImage.click();
        return new EditImagePage(d);
    }

    private void hideItem(RemoteWebElement item) {
        TouchAction action = new TouchAction(d);
        action.longPress(item).release().perform();
        hideMenuButton.click();
    }

    public void hideAll() {
       while(itens.size() > 0){
            this.hideItem(itens.get(0));
       }
    }
    
    public int getTotalItens(){
        TouchActions action = new TouchActions(d);
        action.scroll(listItensWithScroll, 0, 1000);
        action.perform();
        return itens.size();
    }
}
