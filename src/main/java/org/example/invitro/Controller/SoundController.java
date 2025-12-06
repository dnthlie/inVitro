package org.example.invitro.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javax.sound.sampled.*;
import javafx.animation.PauseTransition;
import java.io.IOException;
import java.net.URL;



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
                // fade finished
                titleClip.stop();
            } else {
                volume.setValue(current - 1f); // reduce volume
                pause.playFromStart();         // 🔥 restart the fade step
            }
        });
        pause.play();

    }


}
