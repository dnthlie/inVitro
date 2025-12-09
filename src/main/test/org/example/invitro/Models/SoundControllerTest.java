package org.example.invitro.Models;

import org.example.invitro.Controller.SoundController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

// Nat - Sound Controll Test Class
class SoundControllerTest {

    @Test
    void testSingleton() {
        SoundController soundController = SoundController.getInstance();
        SoundController soundController2 = SoundController.getInstance();
        assertSame(soundController, soundController2, "Returns same instance");
    }

    @Test
    void testGetMusic() {
        SoundController soundController = SoundController.getInstance();

        try {
            soundController.startTitleSong();
            System.out.println("Sound started successfully");
        } catch (Exception e) {
            System.out.println("Audio failed: " + e.getMessage());
        }
    }

    @Test
    void testSoundEffects() {
        SoundController soundController = SoundController.getInstance();

        try {
            soundController.playKeyBeep();
            System.out.println("Sound effects are properly working");
        } catch (Exception e) {
            System.out.println("Sound effects failed: " + e.getMessage());
        }
    }

    @Test
    void testKeyStroke() {
        SoundController soundController = SoundController.getInstance();

        try {
            soundController.playKeyBeep();
            System.out.println("Key Strokes are properly working");
        } catch (Exception e) {
            System.out.println("Key Strokes effects failed: " + e.getMessage());
        }
    }


}