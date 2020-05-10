class SortRute extends Rute{
  SortRute(int xPos, int yPos, Labyrint lab){
    super(xPos, yPos, lab);
  }

  @Override
  public char tilTegn(){
    return'#';
  }

  @Override
   void gaa(String road, Rute previous){
     return;
    }
}
