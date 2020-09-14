package itesm.cem.jumpingbolli;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.Align;

public class MenuView extends Pantalla {


  private Stage menuStage;


  public MenuView(MainGame mainGame) {
    super(mainGame);
    game = mainGame;
    btnFactory = new ButtonFactory(game);
  }

  @Override
  public void show() {
    menuStage = new Stage(super.viewport);
    createTitle();
    createMenu();
    Gdx.input.setInputProcessor(menuStage);
  }

  private void createTitle() {
    ImageButton mainText = new GameButton("titles/title.png", "titles/titleHover.png");
    mainText.setPosition(ANCHO_PANTALLA / 2, ALTO_PANTALLA / 2 + ALTO_PANTALLA * .4f, Align.center);
    menuStage.addActor(mainText);

  }

  private void createMenu() {
    menuStage.addActor(btnFactory.getPlayBtn(new GameView(game)));
    menuStage.addActor(btnFactory.getHowToBtn());
    menuStage.addActor(btnFactory.getAboutBtn(new AboutView(game)));
    menuStage.addActor(btnFactory.getSkinsBtn());
    menuStage.addActor(btnFactory.getConfigurationBtn());
  }

  @Override
  public void render(float delta) {
    cleanScreen();
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

