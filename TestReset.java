class TestReset{
  public static void main(String[] args) {
    Lenkeliste<Integer> test = new Lenkeliste<Integer>();
    test.leggTil(1);
    test.leggTil(2);
    test.leggTil(3);
    for(int i=0; i<test.stoerrelse(); i++){
      System.out.println(test.hent(i));
    }
    test.reset();
    System.out.println(test.stoerrelse()+" forventer 0");
  }
}
