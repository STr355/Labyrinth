import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Labyrint{
  protected final Rute[][] board;
  final int numOfRows;
  final int numOfColumns;
  public Lenkeliste<String> escapeRoutes = new Lenkeliste<String>();

  private Labyrint(Rute [][] board, int rows, int cols){
    this.board = board;
    numOfRows = rows;
    numOfColumns = cols;
  }

  static Labyrint lesFraFil(File fil) throws FileNotFoundException{
    //Lager et nytt labytint objekt ved å kalle på konstruktøren
    //inne i en metode
    Scanner scanner = new Scanner(fil);
    String [] size = scanner.nextLine().split(" ");
    int numOfRows=Integer.parseInt(size[0]);
    int numOfColumns = Integer.parseInt(size[1]);
    Rute [][] board= new Rute [numOfRows][numOfColumns];
    Labyrint labytinth = new Labyrint(board, numOfRows, numOfColumns);

    // Legger inn ruteobjekter i arrayet
    for(int i=0; i<numOfRows; i++){
      char[] type = scanner.nextLine().toCharArray();
      for(int p=0; p<numOfColumns; p++){
        board[i][p] = Rute.generate(type[p], i, p, labytinth);
      }
    }

    //Setter naboer til hver rute
    for(int thisRow=1; thisRow<numOfRows-1; thisRow++){
      for(int thisCol=1; thisCol<numOfColumns-1; thisCol++){
        //Håndterer først de rutene jeg vet har naboer i alle retninger
        board[thisRow][thisCol].neighbourNorth=board[thisRow-1][thisCol];
        board[thisRow][thisCol].neighbourSouth=board[thisRow+1][thisCol];
        board[thisRow][thisCol].neighbourEast=board[thisRow][thisCol+1];
        board[thisRow][thisCol].neighbourWest=board[thisRow][thisCol-1];
      }
      //Så håndterer jeg ekstremitetene
      for(int row=0; row<numOfRows; row++){
        for(int col=0;col<numOfColumns; col++){
          if(row==0){
            board[row][col].neighbourSouth=board[1][col];
            if(col!=0){
              board[row][col].neighbourWest=board[row][col-1];
            }
            if(col!=numOfColumns-1){
              board[row][col].neighbourEast=board[row][col+1];
            }
          }
          if(col==0){
            board[row][col].neighbourEast=board[row][1];
            if(row!=0){
              board[row][col].neighbourNorth=board[row-1][col];
            }
            if(row!=numOfRows-1){
              board[row][col].neighbourSouth=board[row+1][col];
            }
          }
          if(row==numOfRows-1){
            board[row][col].neighbourNorth=board[numOfRows-2][col];
            if(col!=0){
              board[row][col].neighbourWest=board[row][col-1];
            if(col!=numOfColumns-1){
              board[row][col].neighbourEast=board[row][col+1];
            }
            }
          }
          if(col==numOfColumns-1){
            board[row][col].neighbourWest=board[1][col];
          }
        }
      }
    }
    //Setter antall hvite naboer for hver rute
    for(int i=0; i<numOfRows; i++){
      for(int p=0;p<numOfColumns; p++){
        board[i][p].setNumOfwhiteNeighbours();
      }
    }
    System.out.println(labytinth);
    return labytinth;
  }

  Liste<String> finnUtveiFra(int row, int col){
    board[row][col].findEscapeRoute();
    return escapeRoutes;
  }

  void resetEscapeRoute(){
    escapeRoutes.reset();
  }

  @Override public String toString(){
    for(int i=0; i<numOfRows; i++){
      for(int p=0; p<numOfColumns; p++){
        System.out.print(board[i][p].tilTegn());
      }
      System.out.println("");
    }
    return("");
  }
}
