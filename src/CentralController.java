import javax.swing.JOptionPane;

public class CentralController {

CentralController(){
MyVoice myVoice = MyVoice.getInstance();
    myVoice.speak("Welcome to the central application");
CentralView centralView = new CentralView(this);
} // end constructor

    public void  speak(String textToSpeech) {
        MyVoice myVoice = MyVoice.getInstance();
        if (textToSpeech.equals("Ctrl")){
try {
myVoice.interrupt();
}catch(Exception e){System.out.println("Exception handled "+e);}

    }else
    myVoice.speak(textToSpeech);

    } // end of text to speech
} // end of class
