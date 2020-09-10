package itesm.cem.jumpingbolli;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class PantallaMenu extends Pantalla {

  MainGame game;
  private Stage menuStage;

  public PantallaMenu(MainGame mainGame) {
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
    ImageButton btnToPlay = new ButtonMenu("buttons/buttonExample.png", "buttons/btnOnClick.png");
    btnToPlay.setPosition(ANCHO_PANTALLA / 2, ALTO_PANTALLA / 2, Align.center);
    menuStage.addActor(btnToPlay);
  }

  @Override
  public void render(float delta) {
    paintScreen(1 / 255f, 1 / 255f, 43 / 255f);
    batch.setProjectionMatrix(camera.combined);

    batch.begin();
    // batch.draw(fondo, 0, 0);
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