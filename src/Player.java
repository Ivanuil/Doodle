import java.awt.*;

public class Player {

    private final int WIDTH = 5;
    private final int HEIGHT = WIDTH;

    private int x;
    private int y;

    private final int horizontalSpeed = 5;
    private int verticalSpeed = 10;
    private final int gravity = 1;
    private final int jumpSpeed = 10;

    public int getY() {
        return y;
    }

    Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void rightPressed() {
        this.x += horizontalSpeed;
        tick();
    }

    public void leftPressed() {
        this.x -= horizontalSpeed;
        tick();
    }

    public void tick() {
        if (x + WIDTH > Game.WIDTH) {
            x = 0;
        } else if (x < 0) {
            x = Game.WIDTH - WIDTH;
        }
    }

    public void moveVertically() {
        y -= verticalSpeed;
        verticalSpeed -= gravity;
    }

    public void render(Graphics g) {
        g.setColor(new Color(49, 239, 7));
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public boolean checkForCollision(Platform platform) {
        if ((x > platform.getX() - platform.WIDTH / 2
                && x < platform.getX() + platform.WIDTH / 2)
                && (y > platform.getY() && y < platform.getY() + 5)
                && verticalSpeed <= 0) {
            return true;
        }
        return false;
    }

    public void jump() {
        verticalSpeed = jumpSpeed;
        System.out.println("+1");
    }

}
