package itesm.cem.jumpingbolli;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

public class ButtonFactory {

  private MainGame context;


  public ButtonFactory(MainGame context) {
    this.context = context;
  }

  public ImageButton getConfigurationBtn(){
    ImageButton btnConfiguration = new GameButton("buttons/btnOnClick.png");
    btnConfiguration.setPosition(1280 - btnConfiguration.getWidth()*1.5f, 720 * btnConfiguration.getHeight()*1.5f);
    return btnConfiguration;
  }


  public ImageButton getPlayBtn(final Screen toScreen){
    ImageButton btnToPlay = new GameButton("buttons/btnPlay.png", "buttons/btnPlayHover.png");
    btnToPlay.setPosition(1280/2f, 720/2f, Align.center);
    btnToPlay.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        context.setScreen(toScreen);
      }
    });
    return btnToPlay;
  }

  public ImageButton getHowToBtn(){
    ImageButton btnHowto = new GameButton("buttons/btnHow.png");
    btnHowto.setPosition(1280*.25f, 720*.3f, Align.center);
    return btnHowto;
  }

  public ImageButton getAboutBtn(final Screen toScreen){
    ImageButton btnAbout = new GameButton("buttons/btnAbout.png");
    btnAbout.setPosition(1280*.5f, 720*.3f, Align.center);
    btnAbout.addListener(new ClickListener(){
      @Override
      public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        context.setScreen(toScreen);
      }
    });
    return btnAbout;
  }

  public ImageButton getSkinsBtn(){
    ImageButton btnSkins = new GameButton("buttons/btnSkins.png");
    btnSkins.setPosition(1280*.75f, 720*.3f, Align.center);
    return btnSkins;
  }

  public ImageButton getOnGameConfigBtn(){
    ImageButton btnOnGameConfig = new GameButton("buttons/ajustes.png");
    btnOnGameConfig.setPosition(1280 - btnOnGameConfig.getWidth()*1.5f, 720 * btnOnGameConfig.getHeight()*1.5f);
    return btnOnGameConfig;
  }
}
