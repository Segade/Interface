import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

class KeyDispatcher implements KeyEventDispatcher {
    private CentralView view;


public KeyDispatcher(CentralView view){

this.view = view;

} // end constructor


    public boolean dispatchKeyEvent(KeyEvent e) {
        //if(e.getID() == KeyEvent.KEY_TYPED) {
            int keyCode = e.getKeyCode();

            String keyPressed = KeyEvent.getKeyText(keyCode);



        if(e.getID() != KeyEvent.KEY_TYPED)
            System.out.println("*" + keyPressed  + "*");


        view.setKeyPressed(keyPressed);

          // allow the event to be redispatched
return false;
    } // end DispatchKeyEvent

} // end class