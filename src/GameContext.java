public class GameContext {
    private Strategy strategy;

    public GameContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(){
        strategy.generateArtifacts();
    }
}
