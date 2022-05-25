import java.awt.*;

public class Platform {

    public final int WIDTH = 35;
    public final int HEIGHT = 5;

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private final int SPEED = 10;

    Platform(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void tick() {
        if (x + WIDTH > Game.WIDTH) {
            x = 0;
        } else if (x < 0) {
            x = Game.WIDTH - WIDTH;
        }

        x += SPEED;
    }

    public void render(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

}
