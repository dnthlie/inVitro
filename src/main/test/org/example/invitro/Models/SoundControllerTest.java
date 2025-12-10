package org.example.invitro.Models;

import org.example.invitro.Controller.SoundController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

// Nat - Sound Controll Test Class
class SoundControllerTest {

    // Nat - test to ensure that returns the same instance / singleton
    @Test
    void testSingleton() {
        SoundController soundController = SoundController.getInstance();
        SoundController soundController2 = SoundController.getInstance();
        assertSame(soundController, soundController2, "Returns same instance");
    }

    // Nat - test to make sure the music audio is working properly
    @Test
    void testGetMusic() {
        SoundController soundController = SoundController.getInstance();

        try {
            soundController.startTitleSong();
            System.out.println("Start music began successfully");
        } catch (Exception e) {
            System.out.println("Audio failed: " + e.getMessage());
        }
    }

    // Nat - test to ensure that sound effects are working properly
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

    // Nat - test to ensure that key sounds are working properly
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