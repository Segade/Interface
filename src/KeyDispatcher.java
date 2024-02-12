import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

class KeyDispatcher implements MyKeyEventDispatcher {
    String key;




    public String MyDispatchKeyEvent(KeyEvent e) {

        // System.out.println("event"+e.getKeyCode());
        //int kCode = (e.getKeyCode());
        //key = KeyEvent.getKeyText(kCode);

        // System.out.println("key = "+keyPressed);

        // String keyPressed = KeyEvent.getKeyText(keyCode);

       /* if(e.getID() == KeyEvent.KEY_TYPED) {
            //System.out.println( "typed" + e.getKeyCode() );
            //int keyCodeM = e.getKeyCode();

            // with the code, I get the text associated to the corresponding key
           // String keyPressed = KeyEvent.getKeyText(keyCodeM);
           // System.out.println( "typed" + keyPressed );
        }*/

        int keyCode = e.getKeyCode();
        String keyPressed = KeyEvent.getKeyText(keyCode);

        // allow the event to be redispatched
        return key;
    }



} // end class