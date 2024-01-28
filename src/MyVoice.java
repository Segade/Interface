
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;



public class MyVoice extends Thread  {
private static MyVoice uniqueInstance;
    private  VoiceManager voiceManager;
private     Voice voice;

   public boolean exit = false;
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


        return  uniqueInstance;
    } // end get instance

    public void  speak(String textToSpeech) {
           this.textToSpeech = textToSpeech;

     run();
    } // end speak

public void  deallocate(){
        voice.deallocate();
} // end ealocate

public void run() {
try {
    Thread.sleep(1000);
        voice.speak(textToSpeech);
}catch(InterruptedException e){
    throw new RuntimeException("Thread interrupted..."+e);

}
} // end run

} // end of class
