import java.util.Random;

public class Position {

    public int xCoordinate;
    public int yCoordinate;
    public Random rand = new Random(System.currentTimeMillis());

    public Position(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Position() {

        this.xCoordinate=rand.nextInt(11);
        this.yCoordinate=rand.nextInt(11);
    }
}
