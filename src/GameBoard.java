public class GameBoard {
    public static int matrixSize=11;
    public static int[][] gameBoard=new int[matrixSize][matrixSize];

    public static void displayBoard(){
        for (int i=0;i<=10;i++){
            for (int j=0;j<=10;j++){
                System.out.print(gameBoard[i][j]+"\t\t\t\t");
            }
            System.out.println();
        }
    }
}
