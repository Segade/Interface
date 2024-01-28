
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


public class MyVoice implements Runnable  {
    private static MyVoice uniqueInstance;
    VoiceManager voiceManager;
    Voice voice;
    public boolean exit = false;
    private static Thread thread;
    private String textToSpeech;

    private MyVoice()    {

        String voiceName = "kevin16";
        voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(voiceName);
        voice.allocate();
    } // end of constructor

    public static MyVoice getInstance(){
        if (uniqueInstance == null)
            uniqueInstance = new MyVoice();
thread = new Thread(uniqueInstance);

        return  uniqueInstance;
    } // end get instance

    public void  speak(String textToSpeech) {
         this.textToSpeech = textToSpeech;
         if(textToSpeech.equals("Ctrl")){
             exit = true;
         }

        uniqueInstance = new MyVoice();
        thread = new Thread(uniqueInstance);

        run();


    } // end speak

    public void  deallocate(){
        voice.deallocate();
    } // end deallocate

    public void run(){
        while(!exit) {
            voice.speak(textToSpeech);
            exit = true;
        }
    } // end run

} // end of class
