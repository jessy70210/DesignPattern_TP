package fr.ensim.dp.map.player.ui;

import fr.ensim.dp.map.player.IPlayer;
import fr.ensim.dp.map.player.IStatePlayer;

public class StatePause implements IStatePlayer {
    @Override
    public void play(IPlayer player) {
        player.firechangeState(new StatePlay());
    }

    @Override
    public void stop(IPlayer player) {
        throw new IllegalStateException("Impossible");
    }

    @Override
    public void pause(IPlayer player) {
        throw new IllegalStateException("Est déjà sur Pause");
    }

    @Override
    public void forward(IPlayer player) {
        throw new IllegalStateException("Impossible");
    }

    @Override
    public void backward(IPlayer player) {
        throw new IllegalStateException("Impossible");
    }
}