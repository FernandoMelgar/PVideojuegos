package itesm.cem.jumpingbolli;

import com.badlogic.gdx.Game;

import itesm.cem.jumpingbolli.menu.MenuView;

public class GdXGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuView(this));
    }

    @Override
    public void render() {
        super.render();
    }
}

