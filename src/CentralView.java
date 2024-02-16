/**
 * class that manages the interface along with its GUI components
 * This is the view layer of the application
 * Author: Ivan Segade Carou
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CentralView extends JFrame implements ActionListener, FocusListener {
    // declare the controller and the GUI components
    CentralController controller;
    JFrame centralFrame;

    JPanel centerPanel;

    JButton speakButton;
    JTextField textToSpeechField;

    KeyListener keyListener;

    //NativeKeyListener nkeyListener;
private boolean stop = false;
    Thread myThread;

    int count = 0;
    /**
     * constructor of the class that receives the controller as a parameter to access its methods
     *
     * @param controller
     */

    CentralView(CentralController controller) {
        // the local controller is declared with the parameter
        this.controller = controller;

        // set the frame configuration
        setFrame();

        // add the listeners to the GUI components
       // addListeners();

// add the GUI components to the frame
        addFrame();

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        //KeyDispatcher ked = new KeyDispatcher();
        manager.addKeyEventDispatcher(new KeyDispatcher(this));

    }// end constructor

    /**
     * method that is called to display the interface
     */
    public void display() {
        // with the true value the frame and window can be displayed
        centerPanel.setVisible(true);
        centralFrame.setVisible(true);
    }

    /**
     *The following methods are declared as private to avoid external access
     */


    /**
     * set the configuration of the frame
     */

    private void setFrame() {
// create the frame along with the title
        centralFrame = new JFrame("Central application");

        // set the size of the window
        centralFrame.setSize(500, 500);

        // close the window with the X button of the window
        centralFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // type of frame
        centralFrame.setLayout(new BorderLayout(2, 2));

        // the frame can get the focus
        centralFrame.setFocusable(true);

// declare the panel and add the button and the textbox
        centerPanel = new JPanel(new GridLayout(1, 1));
        textToSpeechField = new JTextField(30);
        speakButton = new JButton("Speak");

    } // end set frame


    /**
     * method that adds the action, focus and key listeners to the GUI components
     */

    private void addListeners() {
        speakButton.addFocusListener(this);
        speakButton.addActionListener(this);
        textToSpeechField.addFocusListener(this);

    } // end add listeners



    /**
     * method that add the GUI components to the frame
     */

    private void addFrame() {

        centerPanel.add(textToSpeechField);
        centerPanel.add(speakButton);

        centralFrame.add(centerPanel, BorderLayout.CENTER);


    } // end add frame


    /**
     * method that declares the action listener
     * when the user presses the button
     *
     * @param e the event to be processed
     */

    public void actionPerformed(ActionEvent e) {
        // if the user pressed the button
        if (e.getSource() == speakButton) {

  myThread = new Thread(() -> {
    controller.speak(textToSpeechField.getText());

    while (!stop) {
    // call to the method in the controller class
        controller.speak(textToSpeechField.getText());

        try {
                         Thread.sleep(000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } // end catch
    } // end while
}); // end thread
myThread.start();
            stop = true;

} // end if
    }// end action perform





    /**
     * method to be overide
     * they must be declared for inheriting the focus class
     * in this project they are not needed
     *
     * @param e the event to be processed
     */
    public void focusGained(FocusEvent e) {}


    public void focusLost(FocusEvent e) {
    } // end focus lost

public void setKeyPressed(String key){
        count++;
        System.out.println("times " + count  );
    controller.speak(key);
} // end set key pressed


} //end of class
