/**
 * class that manages the instantiation of the interface and the voice of the program
 * This is the controller layer of the application
 * Author: Ivan Segade Carou
 */

public class CentralController {
    // declaration the MyVoice class used
    MyVoice myVoice = MyVoice.getInstance();

    /**
     * Constructor of the controller
     */
    CentralController() {
        // call to the method that instantiates the view class
        display();
    } // end constructor

    public void display() {
        //It instantiates the MyVoice class
//        MyVoice myVoice = MyVoice.getInstance();

        // It calls out the presentation message of the program
        myVoice.speak("Welcome to the central application");

        // It instantiates the interface
        CentralView centralView = new CentralView(this);

        centralView.display();
    } // end display


    /**
     * public method that calls the unique MyVoice class
     * and calls the speak method to call out the text passed as paramter
     *
     * @param textToSpeech
     */
    public void speak(String textToSpeech) {

         myVoice.speak(textToSpeech);
    } // end of speak

} // end of class
