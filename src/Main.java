import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.io.IOException;

/**
 * Created by jonesdc on 3/7/17.
 */
public class Main {

    private static final String VOICENAME_kevin = "kevin16";
    private String text; // user
    private String textTwo;  //comment

    public static void main(String[] args) throws IOException {
        Crawler crawl = new Crawler();

        for(int j = 0; j < crawl.grabText()[0].length; j++)
        {
            String user = crawl.grabText()[0][j];
            String comment = crawl.grabText()[1][j];
            Main freeTTS = new Main(user, comment);
            freeTTS.speak();
        }
    }

    public Main(String text, String textTwo) {
        this.text = text + " says";
        this.textTwo = textTwo;
        System.out.print(this.text);
    }

    public void speak() {
        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICENAME_kevin);
        voice.allocate();
        voice.speak(text);
        voice.speak(textTwo);
    }
}