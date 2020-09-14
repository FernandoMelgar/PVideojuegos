package itesm.cem.jumpingbolli;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

class GameButton extends ImageButton {

  public GameButton(String pathUp, String pathDown) {
    super(new TextureRegionDrawable(new Texture(pathUp)), new TextureRegionDrawable(new Texture(pathDown)));
  }

  public GameButton(String pathUp) {
    super(new TextureRegionDrawable(new Texture(pathUp)));
  }
}