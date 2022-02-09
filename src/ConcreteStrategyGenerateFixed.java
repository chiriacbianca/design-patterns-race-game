public class ConcreteStrategyGenerateFixed implements Strategy {
    final int numberOfEachArtifact=10;
    final int totalNumberOfArtifacts=4*numberOfEachArtifact;
    PlaceableArtifacts[] artifacts= new PlaceableArtifacts[totalNumberOfArtifacts];

    @Override
    public void generateArtifacts() {
        int startingPoint=0;
        AbstractFactory artifactFactory= FactoryProducer.getFactory(true);
        for (int i=startingPoint;i<(numberOfEachArtifact+startingPoint);i++){
            artifacts[i]=artifactFactory.getype("Rounded");
            artifacts[i].setStartingPosition();
        }
        startingPoint+=numberOfEachArtifact;
        for(int i=startingPoint;i<(numberOfEachArtifact+startingPoint);i++){
            artifacts[i]=artifactFactory.getype("Square");
            artifacts[i].setStartingPosition();
        }
        startingPoint+=numberOfEachArtifact;
        AbstractFactory anotherArtifactFactory= FactoryProducer.getFactory(false);
        for (int i=startingPoint;i<(numberOfEachArtifact+startingPoint);i++){
            artifacts[i]=anotherArtifactFactory.getype("Rounded");
            artifacts[i].setStartingPosition();
        }
        startingPoint+=numberOfEachArtifact;
        for (int i=startingPoint;i<(numberOfEachArtifact+startingPoint);i++){
            artifacts[i]=anotherArtifactFactory.getype("Square");
            artifacts[i].setStartingPosition();
        }
    }
}
