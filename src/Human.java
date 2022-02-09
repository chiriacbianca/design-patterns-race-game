public class Human extends Character {
    public final int numberOnBoard=100;

    private static Human instance=new Human();
    private Human() {
        position=new Position(10,0);
        GameBoard.gameBoard[position.xCoordinate][position.yCoordinate]=numberOnBoard;
        healthPoints=30;
        energyPoints=20;
    }
    public static Human getInstance(){
        return instance;
    }

    public void winnerIs(){
        System.out.println("Human has won the race!!");
    }

    @Override
    boolean eligibleForMove() {
        if ((energyPoints>=0)&&(healthPoints>=0)){
            System.out.println("Human has: "+ energyPoints+" energy points, "+healthPoints+" health points");
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
        int newY=position.yCoordinate+1;
        this.position=new Position(position.xCoordinate, newY);
        GameBoard.gameBoard[position.xCoordinate][position.yCoordinate]=numberOnBoard;
        System.out.println("Human is now on position:"+position.xCoordinate+" "+position.yCoordinate);
    }

    @Override
    void moveUpOrDown() {
        if (position.xCoordinate==0) {
            moveAhead();
            return;
        }
        GameBoard.gameBoard[position.xCoordinate][position.yCoordinate]=0;
        int newX=position.xCoordinate-1;
        this.position=new Position(newX, position.yCoordinate);
        GameBoard.gameBoard[position.xCoordinate][position.yCoordinate]=numberOnBoard;
        System.out.println("Human is now on position:"+position.xCoordinate+" "+position.yCoordinate);
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
                        System.out.println("Human found a health stone");
                        break;
                    case 2:
                        energyPoints+= SquareEnergyStone.energyPoints;
                        System.out.println("Human found an energy stone");
                        break;
                    case 3:
                        healthPoints-= RoundedSteppingStone.healthPoints;
                        System.out.println("Human found a stepping stone");
                        break;
                    case 4:
                        energyPoints+= SquareSpinningStone.energyPoints;
                        System.out.println("Human found a spinning stone");
                        break;
                    default:
                        System.out.println("No action required");
                }
            }
        }

        else {
            if (position.xCoordinate==0){
                moveAhead();
                return;
            }
            if (GameBoard.gameBoard[position.xCoordinate-1][position.yCoordinate]!=0){
                switch (GameBoard.gameBoard[position.xCoordinate-1][position.yCoordinate])
                {
                    case 1:
                        healthPoints+=RoundedHealthStone.healthPoints;
                        System.out.println("Human found a health stone");
                        break;
                    case 2:
                        energyPoints+=SquareEnergyStone.energyPoints;
                        System.out.println("Human found an energy stone");
                        break;
                    case 3:
                        healthPoints-=RoundedSteppingStone.healthPoints;
                        System.out.println("Human found a stepping stone");
                        break;
                    case 4:
                        energyPoints-=SquareSpinningStone.energyPoints;
                        System.out.println("Human found a spinning stone");
                        break;
                    default:
                        System.out.println("No action required");
                }
            }
        }
    }
}
