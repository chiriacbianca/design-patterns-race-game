public class HarmfulArtifactFactory extends AbstractFactory{
    @Override
    PlaceableArtifacts getype(String typeOfArtifact) {
        if (typeOfArtifact.equals("Rounded"))
            return new RoundedSteppingStone();
        if (typeOfArtifact.equals("Square"))
            return new SquareSpinningStone();
        return null;
    }
}
