package itesm.cem.jumpingbolli;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

public class GameView extends Pantalla {

  MainGame game;
  private Stage gameStage;
  ButtonFactory buttonFactory;


  public GameView(MainGame game) {
    super(game);
  }


  @Override
  public void show() {
    gameStage = new Stage(super.viewport);

    ImageButton btnReturn = new GameButton("buttons/btnReturn.png");
    btnReturn.setPosition(ANCHO_PANTALLA / 2, ALTO_PANTALLA / 2, Align.center);
    btnReturn.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        game.setScreen(new MenuView(game));
      }
    });
    gameStage.addActor(buttonFactory.getOnGameConfigBtn());

    gameStage.addActor(btnReturn);

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
