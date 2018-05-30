package memetastic.po;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author renil
 */
public class SavedPage {
    protected AndroidDriver d;
    
    @FindBy(id = "io.github.gsantner.memetastic:id/item__square_image__image")
    RemoteWebElement imagem;
    
    @FindBy(id = "io.github.gsantner.memetastic:id/action_delete")
    RemoteWebElement delete;
    
    @FindBy(id = "io.github.gsantner.memetastic:id/main__activity__list_empty__text")
    RemoteWebElement msgNoMemes;
    
    public SavedPage(AndroidDriver d) {
        this.d = d;
        PageFactory.initElements(new AppiumFieldDecorator(d, 15, TimeUnit.SECONDS), this);
    }
    
    public void selectImagem(){
    	imagem.click();
    }
    
    public void selectDelete(){
    	delete.click();
    }
    
    public String textMsgNoMemes(){
    	return msgNoMemes.getText();
    }
}
