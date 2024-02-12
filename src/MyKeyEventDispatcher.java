
import java.awt.*;
import java.awt.event.KeyEvent;

public interface MyKeyEventDispatcher extends KeyEventDispatcher {
    String MyDispatchKeyEvent(KeyEvent e);

    @Override
    default boolean dispatchKeyEvent(KeyEvent e) {
        return false;
    }
}