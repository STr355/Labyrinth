

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;

class Main {
    public static void main(String[] args) {
        String filnavn = null;

        if (args.length > 0) {
            filnavn = args[0];
        } else {
            System.out.println("ERROR: correct use og the program: "
                               +"java Main <x.in>");
            return;
        }
        File fil = new File(filnavn);
        Labyrint l = null;
        try {
            l = Labyrint.lesFraFil(fil);
        } catch (FileNotFoundException e) {
            System.out.printf("FEIL: Kunne ikke lese fra '%s'\n", filnavn);
            System.exit(1);
        }

        // les start-koordinater fra standard input
        Scanner inn = new Scanner(System.in);
        System.out.println("Type coordinates <row> <col> ('a' to exit the program)");
        String[] ord = inn.nextLine().split(" ");
        while (!ord[0].equals("a")) {

            try {
                int startRad = Integer.parseInt(ord[0]);
                int startKol = Integer.parseInt(ord[1]);
                Liste<String> utveier = l.finnUtveiFra(startRad, startKol);
                if (utveier.stoerrelse() != 0) {
                    for (int i=0; i<utveier.stoerrelse(); i++) {
                        System.out.println(utveier.hent(i));
                        startRad=0;
                        startKol=0;
                    }
                } else {
                    System.out.println("Ingen utveier.");
                }
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Ugyldig input!");
            }

            System.out.println("Skriv inn nye koordinater ('a' for aa avslutte)");
            ord = inn.nextLine().split(" ");

        }
    }
}
// int startRad = Integer.parseInt(ord[0]);
// int startKol = Integer.parseInt(ord[1]);
// if(l.board[startRad][startKol].whiteNeighnours==1){
//   Thread t1= new Thread(l.board[startRad][startKol]);
// }
// else if(l.board[startRad][startKol].whiteNeighnours==2){
//   Thread t1= new Thread(l.board[startRad][startKol]);
//   Thread t2= new Thread(l.board[startRad][startKol]);
// }
// else if(l.board[startRad][startKol].whiteNeighnours==3){
//   Thread t1= new Thread(l.board[startRad][startKol]);
//   Thread t2= new Thread(l.board[startRad][startKol]);
//   Thread t3= new Thread(l.board[startRad][startKol]);
// }
// else if(l.board[startRad][startKol].whiteNeighnours==4){
//   Thread t1= new Thread(l.board[startRad][startKol]);
//   Thread t2= new Thread(l.board[startRad][startKol]);
//   Thread t3= new Thread(l.board[startRad][startKol]);
//   Thread t4= new Thread(l.board[startRad][startKol]);
