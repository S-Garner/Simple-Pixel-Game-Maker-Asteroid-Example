
import java.awt.*;

/**
 A shape that can be moved around.
 */
public interface MoveableObject
{
    void paint(Graphics g);
    void translate(int dx, int dy);
}

