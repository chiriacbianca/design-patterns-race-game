public class FactoryProducer {
    public static AbstractFactory getFactory(boolean good){
        if (good)
            return new HelpfulArtifactFactory();
        else
            return new HarmfulArtifactFactory();
    }
}
