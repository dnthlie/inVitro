package org.example.invitro.Controller;
import javafx.util.Duration;
import javax.sound.sampled.*;
import javafx.animation.PauseTransition;
import java.net.URL;
import java.util.Random;



public class SoundController {

    private static final SoundController instance = new SoundController();
    public static SoundController getInstance() { return instance; }

    private Clip titleClip;

    private SoundController() {}
    //Starts the Title Song
    public void startTitleSong() throws Exception {
        URL url = getClass().getResource("/org/example/invitro/Assets/Sounds/TitleSong.wav");  // your file path
        AudioInputStream stream = AudioSystem.getAudioInputStream(url);

        titleClip = AudioSystem.getClip();
        titleClip.open(stream);
        titleClip.start();

    }
    //Stops the Title Song
    public void stopTitleSong() {
        if (titleClip != null) {
            titleClip.stop();
            titleClip.close();
        }
    }
    //Sets the volume of the titlws song
    public void setTitleVolume(float gainDb) {
        if (titleClip != null && titleClip.isOpen()) {
            FloatControl volume = (FloatControl) titleClip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(gainDb);  // e.g., -10f for quieter
        }
    }
    //Fades out the Title song once the game has been started
    public void fadeTitleVolume() {
        if (titleClip == null || !titleClip.isOpen()) return;
        FloatControl volume = (FloatControl) titleClip.getControl(FloatControl.Type.MASTER_GAIN);
        PauseTransition pause = new PauseTransition(Duration.millis(100));
        pause.setOnFinished(event -> {
            float current = volume.getValue();

            if (current <= -60f) {
                titleClip.stop();
            } else {
                volume.setValue(current - 1f);
                pause.playFromStart();
            }
        });
        pause.play();

    }
    public void playKeyBeep() throws Exception {
        URL url = getClass().getResource("/org/example/invitro/Assets/Sounds/Keybeep.wav");  // your file path
        AudioInputStream stream = AudioSystem.getAudioInputStream(url);

        Clip keyClip = AudioSystem.getClip();
        keyClip.open(stream);
        keyClip.start();
        keyClip.addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP) {
                keyClip.close();
            }
        });


    }

    public void playKeyStroke() throws Exception {
        Random rng = new Random();

        String [] keyStrokeFiles = {
                "/org/example/invitro/Assets/Sounds/Keystroke1.wav",
                "/org/example/invitro/Assets/Sounds/Keystroke2.wav",
                "/org/example/invitro/Assets/Sounds/Keystroke3.wav",
                "/org/example/invitro/Assets/Sounds/Keystroke4.wav",
                "/org/example/invitro/Assets/Sounds/Keystroke5.wav",
        };
        int x = rng.nextInt(5);
        URL url = getClass().getResource(keyStrokeFiles[x]);
        AudioInputStream stream = AudioSystem.getAudioInputStream(url);

        Clip keystrokeClip = AudioSystem.getClip();
        keystrokeClip.open(stream);
        keystrokeClip.start();
        keystrokeClip.addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP) {
                keystrokeClip.close();
            }
        });




    }


}
