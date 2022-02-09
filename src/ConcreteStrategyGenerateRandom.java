import java.util.Random;

public class ConcreteStrategyGenerateRandom implements Strategy{
    PlaceableArtifacts[] artifacts;


    @Override
    public void generateArtifacts() {
        Random rand=new Random(System.currentTimeMillis());
        int startingPoint=0;
        int endPoint=rand.nextInt(10);
        AbstractFactory artifactFactory= FactoryProducer.getFactory(true);
        for (int i=startingPoint;i<(endPoint+startingPoint);i++){
            artifacts[i]=artifactFactory.getype("Rounded");
            artifacts[i].setStartingPosition();
        }
        startingPoint+=endPoint;
        endPoint=rand.nextInt(10);
        for(int i=startingPoint;i<(endPoint+startingPoint);i++){
            artifacts[i]=artifactFactory.getype("Square");
            artifacts[i].setStartingPosition();
        }
        startingPoint+=endPoint;
        endPoint=rand.nextInt(10);
        AbstractFactory anotherArtifactFactory= FactoryProducer.getFactory(false);
        for (int i=startingPoint;i<(endPoint+startingPoint);i++){
            artifacts[i]=anotherArtifactFactory.getype("Rounded");
            artifacts[i].setStartingPosition();
        }
        startingPoint+=endPoint;
        endPoint=rand.nextInt(10);
        for (int i=startingPoint;i<(endPoint+startingPoint);i++){
            artifacts[i]=anotherArtifactFactory.getype("Square");
            artifacts[i].setStartingPosition();
        }
    }
}
