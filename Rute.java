import java.util.concurrent.locks.ReentrantLock;

abstract class Rute{
  final int rowPos;
  final int colPos;
  String road;
  Labyrint thisLabyrinth;
  boolean start=false;
  volatile boolean visited=false;
  int whiteNeighbours=0;
  ReentrantLock laas = new ReentrantLock();
  Rute neighbourNorth, neighbourSouth, neighbourEast, neighbourWest;

  protected Rute(int xPos, int yPos, Labyrint lab){
    rowPos=xPos;
    colPos=yPos;
    thisLabyrinth=lab;
  }


  static Rute generate(char type, int xPos, int yPos, Labyrint lab){
    if(type=='#'){
      return new SortRute(xPos, yPos, lab);
    }
    else if(type=='.'&&xPos==0||yPos==0||xPos==lab.numOfRows-1||yPos==lab.numOfColumns-1){
      return new Aapning(xPos, yPos, lab);
    }
    else{
      return new HvitRute(xPos, yPos, lab);
    }
  }

  void setNumOfwhiteNeighbours(){
    if(neighbourNorth instanceof HvitRute){
      whiteNeighbours++;
    }
    if(neighbourEast instanceof HvitRute){
      whiteNeighbours++;
    }
    if(neighbourSouth instanceof HvitRute){
      whiteNeighbours++;
    }
    if(neighbourWest instanceof HvitRute){
      whiteNeighbours++;
    }
  }

  abstract void gaa(String road, Rute previous);

  void findEscapeRoute(){
    gaa("", null);
  }

  public abstract char tilTegn();

  @Override
  public String toString(){
    return(rowPos+","+colPos);
  }
}
