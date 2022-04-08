package fr.ensim.dp.map.player.ui;

import fr.ensim.dp.map.player.IPlayer;
import fr.ensim.dp.map.player.IStatePlayer;

public class StatePlay implements IStatePlayer {
    @Override
    public void play(IPlayer player) {
        throw new IllegalStateException("Est déjà sur Play");
    }

    @Override
    public void stop(IPlayer player) {
        player.firechangeState(new StateStop());
    }

    @Override
    public void pause(IPlayer player) {
        player.firechangeState(new StatePause());
    }

    @Override
    public void forward(IPlayer player) {
        player.firechangeState(new StateForward());
    }

    @Override
    public void backward(IPlayer player) {
        player.firechangeState(new StateBackward());
    }
}