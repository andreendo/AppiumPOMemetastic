package memetastic.po;

import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


public class HiddenImagesPage extends BasePage {
    
    @FindAll({@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout")})
    private List<RemoteWebElement> itens;
    
    public HiddenImagesPage(AndroidDriver d) {
        super(d);
    }
    
    public int getTotalImagesHidden(){
        return itens.size();
    }
}
