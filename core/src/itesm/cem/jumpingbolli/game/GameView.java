package itesm.cem.jumpingbolli.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

import itesm.cem.jumpingbolli.GdXGame;
import itesm.cem.jumpingbolli.Pantalla;
import itesm.cem.jumpingbolli.button.ButtonFactory;
import itesm.cem.jumpingbolli.button.GameButton;
import itesm.cem.jumpingbolli.menu.MenuView;

public class GameView extends Pantalla {

  private Stage gameStage;


  public GameView(GdXGame game) {
    super(game);
  }


  @Override
  public void show() {
    gameStage = new Stage(super.viewport);

    gameStage.addActor(ButtonFactory.getReturnBtn(game, new MenuView(game)));

    ImageButton btnAjustes = new GameButton("buttons/ajustes.png");
    btnAjustes.setPosition(ANCHO_PANTALLA - btnAjustes.getWidth() * 1.5f, ALTO_PANTALLA - btnAjustes.getHeight() * 1.5f);
    gameStage.addActor(btnAjustes);
    Gdx.input.setInputProcessor(gameStage);

  }

  @Override
  public void render(float delta) {
    cleanScreen();
    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    batch.draw(new Texture("fondos/Nivel1.jpeg"), 0, 0);
    batch.end();
    gameStage.draw();
  }

  @Override
  public void pause() {

  }

  @Override
  public void resume() {

  }

  @Override
  public void dispose() {
  }
}
