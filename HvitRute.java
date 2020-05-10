import java.lang.Math;

class HvitRute extends Rute implements Runnable{

  HvitRute(int xPos, int yPos, Labyrint lab){
    super(xPos, yPos, lab);
  }
  @Override
  public char tilTegn(){
    return'.';
  }


  @Override
   void gaa(String road, Rute previous){
    road+= this.toString()+"  ->";

    if(neighbourNorth!=previous&&neighbourNorth.visited==false){
      neighbourNorth.visited=true;
      neighbourNorth.gaa(road, this);
    }
    if(neighbourEast!=previous&&neighbourEast.visited==false){
      neighbourEast.visited=true;
      neighbourEast.gaa(road, this);
    }
    if(neighbourSouth!=previous&&neighbourSouth.visited==false){
      neighbourSouth.visited=true;
      neighbourSouth.gaa(road, this);
    }
    if(neighbourWest!=previous&&neighbourWest.visited==false){
      neighbourWest.visited=true;
      neighbourWest.gaa(road, this);
    }
  }

  public void run(){
    gaa(road, this);
    System.out.println("Ny traad");

  }

  void goNorth(){
    if(this.rowPos>0){
      neighbourNorth.gaa(road, this);
      }
      else{
        return;
      }
    }

  void goSouth(){
    if(this.rowPos<thisLabyrinth.numOfRows){
      neighbourSouth.gaa(road, this);
    }
    else{
      return;
    }
  }

  void goWest(){
      if(this.rowPos>0){
        neighbourWest.gaa(road, this);
        }
        else{
          return;
        }
      }

  void goEast(){
        if(this.colPos<thisLabyrinth.numOfColumns){
          neighbourEast.gaa(road, this);
        }
        else{
          return;
        }
      }

      // if(this.start==true){
      //   if(this.whiteNeighbours==2){
      //     Thread t1 = new Thread(this);
      //     t1.start();
      //   }
      //   else if(this.whiteNeighbours==2){
      //     Thread t1 = new Thread(this);
      //     Thread t2 = new Thread(this);
      //     t1.start();
      //     t2.start();
      //   }
      //   else if(this.whiteNeighbours==3){
      //     Thread t1 = new Thread(this);
      //     Thread t2 = new Thread(this);
      //     Thread t3 = new Thread(this);
      //     t1.start();
      //     t2.start();
      //     t3.start();
      //
      //   }
      // }

}
