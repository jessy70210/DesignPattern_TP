package fr.ensim.dp.map.player.ui;

import fr.ensim.dp.map.player.IPlayer;
import fr.ensim.dp.map.player.IStatePlayer;

public class StateForward implements IStatePlayer {
    @Override
    public void play(IPlayer player) {
        throw new IllegalStateException("Impossible");
    }

    @Override
    public void stop(IPlayer player) {
        player.firechangeState(new StateStop());
    }

    @Override
    public void pause(IPlayer player) {
        throw new IllegalStateException("Impossible");
    }

    @Override
    public void forward(IPlayer player) {
        throw new IllegalStateException("Est déjà sur Forward");
    }

    @Override
    public void backward(IPlayer player) {
        player.firechangeState(new StateBackward());
    }
}