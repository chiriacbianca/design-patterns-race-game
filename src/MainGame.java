public class MainGame {
    public static void main(String[] args) {
        GameContext gameContext=new GameContext(new ConcreteStrategyGenerateFixed());
        gameContext.executeStrategy();

        Character player1=Human.getInstance();
        Character player2=Monster.getInstance();


        while (!Character.finishedRace){
            GameBoard.displayBoard();
            player1.play();
            player2.play();

        }
        GameBoard.displayBoard();
    }
}
