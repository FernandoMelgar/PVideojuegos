package itesm.cem.jumpingbolli;

import com.badlogic.gdx.Game;

public class MainGame extends Game {
    @Override
    public void create() {
        setScreen(new PantallaMenu(this));
    }

    @Override
    public void render() {
        super.render();
    }
}

