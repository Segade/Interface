
import java.awt.*;
import java.awt.event.KeyEvent;

public interface MyKeyEventDispatcher extends KeyEventDispatcher {
    boolean DispatchKeyEvent(KeyEvent e);

    @Override
    default boolean dispatchKeyEvent(KeyEvent e) {
        return false;
    }
}