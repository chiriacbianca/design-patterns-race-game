public class Monster extends Character{
    public final int numberOnBoard=99;

    private static Monster instance=new Monster();

    private Monster() {
        this.position=new Position(0,0);
        GameBoard.gameBoard[position.xCoordinate][position.yCoordinate]=numberOnBoard;
        healthPoints=30;
        energyPoints=20;
    }

    public static Monster getInstance(){
        return instance;
    }

    public void winnerIs(){
        System.out.println("Monster has won the race!!");
    }

    @Override
    boolean eligibleForMove() {
        if ((energyPoints>=0)&&(healthPoints>=0)){
            System.out.println("Monster has: "+ energyPoints+" energy points, "+healthPoints+" health points");
            return true;
        }
        finishedRace=true;
        return false;
    }

    @Override
    boolean directionOfMovement() {

        return rand.nextBoolean();
    }


    @Override
    void moveAhead() {
        if (position.yCoordinate==10) {
            finishedRace=true;
            winnerIs();
            return;
        }
        GameBoard.gameBoard[position.xCoordinate][position.yCoordinate]=0;
        position.yCoordinate++;
        position=new Position(position.xCoordinate, position.yCoordinate);
        GameBoard.gameBoard[position.xCoordinate][position.yCoordinate]=numberOnBoard;
        System.out.println("Monster is now on position:"+position.xCoordinate+" "+position.yCoordinate);
    }

    @Override
    void moveUpOrDown() {
        if (position.xCoordinate==10) {
            moveAhead();
            return;
        }
        GameBoard.gameBoard[position.xCoordinate][position.yCoordinate]=0;
        position.xCoordinate++;
        position=new Position(position.xCoordinate, position.yCoordinate);
        GameBoard.gameBoard[position.xCoordinate][position.yCoordinate]=numberOnBoard;
        System.out.println("Monster is now on position:"+position.xCoordinate+" "+position.yCoordinate);
    }

    @Override
    void getArtifact(boolean get) {
        if (get){
            if (position.yCoordinate==10) {
                finishedRace=true;
                winnerIs();
                return;
            }
            if (GameBoard.gameBoard[position.xCoordinate][position.yCoordinate+1]!=0){
                switch (GameBoard.gameBoard[position.xCoordinate][position.yCoordinate+1])
                {
                    case 1:
                        healthPoints+= RoundedHealthStone.healthPoints;
                        System.out.println("Monster found a health stone");
                        break;
                    case 2:
                        energyPoints+= SquareEnergyStone.energyPoints;
                        System.out.println("Monster found an energy stone");
                        break;
                    case 3:
                        healthPoints-= RoundedSteppingStone.healthPoints;
                        System.out.println("Monster found a stepping stone");
                        break;
                    case 4:
                        energyPoints+= SquareSpinningStone.energyPoints;
                        System.out.println("Monster found a spinning stone");
                        break;
                    default:
                        System.out.println("No action required");
                }
            }
        }

        else {
            if (position.xCoordinate==10){
                moveAhead();
                return;
            }
            if (GameBoard.gameBoard[position.xCoordinate+1][position.yCoordinate]!=0){
                switch (GameBoard.gameBoard[position.xCoordinate+1][position.yCoordinate])
                {
                    case 1:
                        healthPoints+=RoundedHealthStone.healthPoints;
                        break;
                    case 2:
                        energyPoints+=SquareEnergyStone.energyPoints;
                        break;
                    case 3:
                        healthPoints-=RoundedSteppingStone.healthPoints;
                        break;
                    case 4:
                        energyPoints-=SquareSpinningStone.energyPoints;
                        break;
                    default:
                        System.out.println("No action required");
                }
            }
        }
    }
}
