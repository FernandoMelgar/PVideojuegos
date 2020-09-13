package itesm.cem.jumpingbolli;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class MenuView extends Pantalla {

  MainGame game;
  private Stage menuStage;

  public MenuView(MainGame mainGame) {
    game = mainGame;
  }


  @Override
  public void show() {
    menuStage = new Stage(super.viewport);
    createTitle();
    createMenu();
    Gdx.input.setInputProcessor(menuStage);
  }

  private void createTitle() {
    ImageButton mainText = new ButtonMenu("titles/title.png", "titles/titleHover.png");
    mainText.setPosition(ANCHO_PANTALLA / 2, ALTO_PANTALLA / 2 + ALTO_PANTALLA * .4f, Align.center);
    menuStage.addActor(mainText);

  }

  private void createMenu() {
    ImageButton btnToPlay = new ButtonMenu("buttons/btnPlay.png");
    btnToPlay.setPosition(ANCHO_PANTALLA / 2, ALTO_PANTALLA / 2, Align.center);
    btnToPlay.addListener(new ClickListener(){
      @Override
      public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        game.setScreen(new GameView(game));
      }
    });


    menuStage.addActor(btnToPlay);



    ImageButton btnAjustes = new ButtonMenu("buttons/ajustes.png");
    btnAjustes.setPosition(ANCHO_PANTALLA - btnAjustes.getWidth(), ALTO_PANTALLA - btnAjustes.getHeight());
    menuStage.addActor(btnAjustes);

    ImageButton btnHowTo = new ButtonMenu("buttons/btnHow.png");
    btnHowTo.setPosition(ANCHO_PANTALLA * .2f, ALTO_PANTALLA*.2f);
    menuStage.addActor(btnHowTo);

    ImageButton btnAbout = new ButtonMenu("buttons/btnAbout.png");
    btnAbout.setPosition(ANCHO_PANTALLA * .4f, ALTO_PANTALLA*.2f);
    menuStage.addActor(btnAbout);

    ImageButton btnSkins = new ButtonMenu("buttons/btnSkins.png");
    btnSkins.setPosition(ANCHO_PANTALLA * .6f, ALTO_PANTALLA*.2f);
    menuStage.addActor(btnSkins);
  }

  @Override
  public void render(float delta) {
    paintScreen(1 / 255f, 1 / 255f, 43 / 255f);
    batch.setProjectionMatrix(camera.combined);

    batch.begin();
    batch.draw(new Texture("fondos/FondoPrincipal.png"), 0, 0);
    batch.end();

    menuStage.draw();
  }

  @Override
  public void pause() {

  }

  @Override
  public void resume() {

  }

  @Override
  public void dispose() {
    batch.dispose();
  }
}

class ButtonMenu extends ImageButton {

  public ButtonMenu(String pathUp, String pathDown) {
    super(new TextureRegionDrawable(new Texture(pathUp)), new TextureRegionDrawable(new Texture(pathDown)));
  }

  public ButtonMenu(String pathUp) {
    super(new TextureRegionDrawable(new Texture(pathUp)));
  }
}