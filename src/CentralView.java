import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;
import java.awt.event.*;


public class CentralView extends JFrame implements ActionListener, FocusListener, KeyListener  {

    CentralController controller;
    JFrame centralFrame;

    JPanel centerPanel;

    JButton speakButton;
    JTextField textToSpeechField;

KeyListener keyListener;

    CentralView(CentralController controller) {
this.controller = controller;
setFrame();
addListeners();
addFrame();

centerPanel.setVisible(true);
centralFrame.setVisible(true);
     }// end constructor


    private void setFrame(){

        centralFrame  =new JFrame("Central application");
        centralFrame.setSize(500, 500);
        centralFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centralFrame.setLayout(new BorderLayout(2, 2));
        centralFrame.setFocusable(true);


        centerPanel = new JPanel(new GridLayout(1,1));
        textToSpeechField = new JTextField(30);
        speakButton = new JButton("Speak");

    } // end set frame


    private  void    addListeners(){
        speakButton.addFocusListener(this);
        speakButton.addActionListener(this);
        textToSpeechField.addFocusListener(this);
        textToSpeechField.addKeyListener(this);
        addFrameListener();

         speakButton.addKeyListener(keyListener);
    } // end add listeners


    private  void addFrameListener(){
    keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

                int keyCode = e.getKeyCode();
                String keyPressed =  KeyEvent.getKeyText(keyCode);

             controller.speak(keyPressed);

        } // end key press

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }  ;
centralFrame.addKeyListener(keyListener);
    } // end add frame listener

private  void    addFrame(){

    centerPanel.add(textToSpeechField);
    centerPanel.add(speakButton);

    centralFrame.add(centerPanel, BorderLayout.CENTER);


} // end add frame

public void actionPerformed(ActionEvent e){
 if (e.getSource() == speakButton) {

     controller.speak(textToSpeechField.getText());
 }
}// end action perform


public  void focusGained(FocusEvent e){
         String textFocus = "";

        if (e.getSource() == speakButton )
         textFocus    = "Speak, Button";
        else if (e.getSource() == textToSpeechField)
            textFocus = "Enter the text to speech, Text edit";

        controller.speak(textFocus);

} // end focus gained


    public  void focusLost(FocusEvent e) {
    } // end focus lost


    public  void keyTyped(KeyEvent e) {}

    public      void     keyReleased(KeyEvent e){ }
public  void    keyPressed(KeyEvent e){

    int keyCode = e.getKeyCode();
   String keyPressed =  KeyEvent.getKeyText(keyCode);

controller.speak(keyPressed);

} // end key pressed



} //end of class
