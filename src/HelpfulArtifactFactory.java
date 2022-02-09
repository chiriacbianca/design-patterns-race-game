public class HelpfulArtifactFactory extends AbstractFactory {
    @Override
    PlaceableArtifacts getype(String typeOfArtifact) {
        if (typeOfArtifact.equals("Rounded"))
            return new RoundedHealthStone();
        if (typeOfArtifact.equals("Square"))
            return new SquareEnergyStone();
        return null;
    }
}
