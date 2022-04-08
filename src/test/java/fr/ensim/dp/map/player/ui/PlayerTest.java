package fr.ensim.dp.map.player.ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void play() {
        assertThrows(IllegalStateException.class, () -> new Player(new StatePlay()).play());
        new Player(new StatePlay()).pause();
        new Player(new StatePlay()).forward();
        new Player(new StatePlay()).backward();
        new Player(new StatePlay()).stop();
    }

    @Test
    void stop() {
        new Player(new StateStop()).play();
        assertThrows(IllegalStateException.class, () -> new Player(new StateStop()).stop());
        assertThrows(IllegalStateException.class, () -> new Player(new StateStop()).pause());
        assertThrows(IllegalStateException.class, () -> new Player(new StateStop()).forward());
        assertThrows(IllegalStateException.class, () -> new Player(new StateStop()).backward());
    }

    @Test
    void pause() {
        new Player(new StatePause()).play();
        assertThrows(IllegalStateException.class, () -> new Player(new StatePause()).pause());
        assertThrows(IllegalStateException.class, () -> new Player(new StatePause()).stop());
        assertThrows(IllegalStateException.class, () -> new Player(new StatePause()).forward());
        assertThrows(IllegalStateException.class, () -> new Player(new StatePause()).backward());
    }

    @Test
    void forward() {
        assertThrows(IllegalStateException.class, () -> new Player(new StateForward()).forward());
        assertThrows(IllegalStateException.class, () -> new Player(new StateForward()).play());
        assertThrows(IllegalStateException.class, () -> new Player(new StateForward()).pause());
        new Player(new StateForward()).stop();
        new Player(new StateForward()).backward();
    }

    @Test
    void backward() {
        new Player(new StateBackward()).stop();
        new Player(new StateBackward()).forward();
        assertThrows(IllegalStateException.class, () -> new Player(new StateBackward()).backward());
        assertThrows(IllegalStateException.class, () -> new Player(new StateBackward()).play());
        assertThrows(IllegalStateException.class, () -> new Player(new StateBackward()).pause());
    }
}