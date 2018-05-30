/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memetastic.po;

import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Andressa
 */
public class SavedPage extends BasePage {
    @FindBy(className = "android.widget.TextView")
    RemoteWebElement title;
    
    @FindBy(id = "io.github.gsantner.memetastic:id/item__square_image__image")
    RemoteWebElement image;
    
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView")
    RemoteWebElement simage;
    
    @FindBy(id = "io.github.gsantner.memetastic:id/action_delete")
    RemoteWebElement delete;
    
    @FindBy(id = "io.github.gsantner.memetastic:id/main__activity__recycler_view")
    public List<RemoteWebElement> itens;
    
    public SavedPage(AndroidDriver d) {
        super(d);
    }
    public String getTitle() {
        return title.getText();
    }
    
    public void deleteAll(){
        while(itens.size() > 0){
         simage.click();
         delete.click();
        }      
    }
    public boolean imagesNotExist(){
        if(itens.size() == 0){
            return true;
        } else return false;
    }      
}
