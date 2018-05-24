package memetastic.po;

import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.*;


public class SavedPage extends BasePage {
    
    @FindAll({@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout")})
    public List<RemoteWebElement> itens;

    public SavedPage(AndroidDriver d) {
         super(d);
    }
    
    
    private void clickItem(RemoteWebElement item){
        item.click();
        ViewImageSavedPage v = new ViewImageSavedPage(d);
        this.d = v.delete();
    }
    
    public void deleteItens(){
        while(itens.size() > 0){
            this.clickItem(itens.get(0));
        }
        
    }
    
    public int getTotalItens(){
        return itens.size();
    }
}
