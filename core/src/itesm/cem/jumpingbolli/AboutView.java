package itesm.cem.jumpingbolli;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class AboutView extends Pantalla {

  private Stage stage;
  BitmapFont font = new BitmapFont();


  public AboutView(MainGame game) {
    super(game);
  }

  @Override
  public void show() {
    stage = new Stage(super.viewport);

  }

  @Override
  public void render(float delta) {
    cleanScreen();
    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    font.draw(batch, "Fernando Melgar \n Alex Leyva \n Arturo Marquez \n Claudio Mayoral", ANCHO_PANTALLA / 2f, ALTO_PANTALLA /2f);
    batch.end();
    stage.draw();
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
