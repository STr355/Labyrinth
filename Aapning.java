class Aapning extends HvitRute{
  Aapning(int xPos, int yPos, Labyrint lab){
    super(xPos, yPos, lab);
  }
  @Override
  public char tilTegn(){
    return('O');
  }

  @Override
   void gaa(String road, Rute previous){
    laas.lock();
    try{
      road+= toString()+" framme!\n";
      thisLabyrinth.escapeRoutes.leggTil(road);
    }

    finally{
      laas.unlock();
    }
  }
  
}
