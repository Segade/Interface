/**Class that creates the voice that the program uses
 *It contains the method that converts the text passed as a parameter to speech
 * This is the model layer of the application
 * Authos: Ivan Segade Carou
 */

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;




public class MyVoice {
    //  variable that stores the unique instantiation of the class allowed in the program
    private static MyVoice uniqueInstance;

    // variables needed to create the voice, provided by the FreeTTS
     VoiceManager voiceManager;
     Voice voice;

    /**
     * private constructor to avoid create several instantiations of the class
     */
    private MyVoice() {
// setting up the voice
// selecting the voice used
        String voiceName = "kevin16";
         voiceManager = VoiceManager.getInstance();
         voice = voiceManager.getVoice(voiceName);
         voice.allocate();
    } // end of constructor


    /**
     * public method that returns the unique instantiation  of the class
     *
     * @return
     */
    public static MyVoice getInstance() {
        // checks that the there is not a previous instantiation to create it
        if (uniqueInstance == null)
            uniqueInstance = new MyVoice();

        return uniqueInstance;
    } // end get instance


    /**
     * public method that calls out the text passed as a paramter
     *
     * @param textToSpeech
     */
    public void speak(String textToSpeech) {
        voice.speak(textToSpeech);
    } // end speak


    /**
     * public method that diallocated the resources assigned to the voice if needed
     */
    public void deallocate() {
         voice.deallocate();
    }

} // end of class
