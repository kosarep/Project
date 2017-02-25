import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Grzegorz on 08.02.2017.
 */
public class NumbersSound {

    void sound () {
        JFXPanel jfxPanel = new JFXPanel();
        String sound = "sound.mp3";
        Media media = new Media(new File(sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        //return null;
    }



    void timer () {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                sound();
            }
        };
        //timer.schedule(task, 5000);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,1);
        cal.set(Calendar.MINUTE,17);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
        Date date = cal.getTime();
        System.out.println(date.toString());

        timer.schedule(task,date);
    }

    public static void main (String[] args) {
        NumbersSound numbersSound = new NumbersSound();
        numbersSound.timer();


    }
}
