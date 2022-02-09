public class RoundedHealthStone implements PlaceableArtifacts {
    private Position position;
    public static final int healthPoints=5;

    @Override
    public void setStartingPosition() {
        position=new Position();
        while(GameBoard.gameBoard[position.xCoordinate][position.yCoordinate]!=0){
            position=new Position();
        }
        GameBoard.gameBoard[position.xCoordinate][position.yCoordinate]=1;
    }
}
