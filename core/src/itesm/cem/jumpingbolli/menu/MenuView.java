package itesm.cem.jumpingbolli.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.Align;

import itesm.cem.jumpingbolli.SkinsView;
import itesm.cem.jumpingbolli.about.AboutView;
import itesm.cem.jumpingbolli.button.ButtonFactory;
import itesm.cem.jumpingbolli.button.GameButton;
import itesm.cem.jumpingbolli.configuration.ConfigurationView;
import itesm.cem.jumpingbolli.game.GameView;
import itesm.cem.jumpingbolli.GdXGame;
import itesm.cem.jumpingbolli.Pantalla;

public class MenuView extends Pantalla {


  private Stage menuStage;


  public MenuView(GdXGame mainGame) {
    super(mainGame);
//    game = mainGame;
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
    menuStage.addActor(ButtonFactory.getPlayBtn(game,  new GameView(game)));
    menuStage.addActor(ButtonFactory.getHowToBtn(game, new GameView(game)));
    menuStage.addActor(ButtonFactory.getAboutBtn(game, new AboutView(game)));
    menuStage.addActor(ButtonFactory.getSkinsBtn(game, new SkinsView(game)));
    menuStage.addActor(ButtonFactory.getConfigurationBtn(game, new ConfigurationView(game)));
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

