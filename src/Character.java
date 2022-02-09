import java.util.Random;

public abstract class Character {
    Position position;
    int healthPoints;
    int energyPoints;
    public static boolean finishedRace=false;

    Random rand=new Random();

    abstract boolean eligibleForMove();
    abstract boolean directionOfMovement();
    abstract void moveAhead();
    abstract void moveUpOrDown();
    abstract void getArtifact(boolean get);

    public final void play(){
        if (eligibleForMove()) {
            if (directionOfMovement()) {
                getArtifact(directionOfMovement());
                moveAhead();
            } else {
                getArtifact(directionOfMovement());
                moveUpOrDown();
            }
        }
    }
}
