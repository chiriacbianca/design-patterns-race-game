public class SquareEnergyStone implements PlaceableArtifacts {
    Position position;
    public static final int energyPoints=3;

    @Override
    public void setStartingPosition() {
        position=new Position();
        while(GameBoard.gameBoard[position.xCoordinate][position.yCoordinate]!=0){
            position=new Position();
        }
        GameBoard.gameBoard[position.xCoordinate][position.yCoordinate]=2;
    }
}
