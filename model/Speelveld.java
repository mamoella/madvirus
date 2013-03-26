package model;

import java.util.Scanner;
import java.util.Random;

public class Speelveld {
    private int BREEDTE;
    private int HOOGTE;
    private static final int MAX = 5;
    int [][] speelveld;
    private boolean virus;
    private boolean supervirus;
    private int Score;
    private int aantalzetten;
    private int moeilijkheidsgraad;

    public Speelveld() {
        this.BREEDTE = 6;
        this.HOOGTE = 6;
        this.moeilijkheidsgraad = 0;
        this.speelveld = new int[this.BREEDTE][this.HOOGTE];
    }

    public Speelveld(int moeilijkheidsgraad) {
        this.moeilijkheidsgraad = moeilijkheidsgraad;
        this.BREEDTE = 6 + moeilijkheidsgraad;
        this.HOOGTE = 6 + moeilijkheidsgraad;
        this.speelveld = new int[this.BREEDTE][this.HOOGTE];
    }

    public Speelveld(int breedte, int hoogte, int moeilijkheidsgraad) {
        this.BREEDTE = breedte + moeilijkheidsgraad;
        this.HOOGTE = hoogte + moeilijkheidsgraad;
        this.moeilijkheidsgraad = moeilijkheidsgraad;
        this.speelveld = new int[this.BREEDTE][this.HOOGTE];
    }

    private static final Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public int getBreedte() {
        return BREEDTE;
    }

    public int getHoogte() {
        return HOOGTE;
    }

    public static int getMax() {
        return MAX;
    }

    public int getScore() {
        return Score;
    }

    public int getAantalzetten() {
        return aantalzetten;
    }

    public int getMoeilijkheidsgraad() {
        return moeilijkheidsgraad;
    }

    public void setMoeilijkheidsgraad(int moeilijkheidsgraad) {
        this.moeilijkheidsgraad = moeilijkheidsgraad;
    }

    public void setMode(boolean supervirus){
        this.supervirus = supervirus;
    }

    public boolean getMode(){
        return this.supervirus;
    }

    public void vulSpelbord(){
        for (int y = 0 ; y < HOOGTE ;y++ ) {
            for ( int i = 0 ; i < BREEDTE ; i++){
                int willekeurigewaarde = random.nextInt(MAX) + 1;
                speelveld[i][y] = willekeurigewaarde;
            }
        }
        while (!virus){
        int willekeurigebreedte = random.nextInt(BREEDTE);
        int willekeurigehoogte = random.nextInt(HOOGTE);
        speelveld[willekeurigebreedte][willekeurigehoogte] = 0;
        virus = true;
        }
    }

    public void geefbord  (){
        String tekst;
        for (int y = 0 ; y < HOOGTE ;y++ ) {
            for ( int i = 0 ; i < BREEDTE ; i++){
                switch (speelveld[i][y]){
                    case 1: tekst = "Rd";break;
                    case 2: tekst = "Ge";break;
                    case 3: tekst = "Pa";break;
                    case 4: tekst = "Bl";break;
                    case 5: tekst = "Gr";break;
                    case 6: tekst = "Or";break;
                    case 7: tekst = "Rs";break;
                    case 8: tekst = "Br";break;
                    case 0: tekst = " X";break;
                    default: tekst = " ";break;
                }
                System.out.print(tekst + " |");
            }
            System.out.print("\n");

            for ( int i = 0 ; i < (3*BREEDTE) ; i++ ){
                System.out.print("-");
            }
        System.out.print("\n");
        }
    }

    public void zoekenVirus (int kleur){
        aantalzetten++;
        for (int x = 0; x < Math.max(HOOGTE,BREEDTE); x++){
            for (int j = 0; j < HOOGTE ; j++){
                for (int i = 0; i < BREEDTE; i++){
                    if ( speelveld[i][j] == 0){
                        if (supervirus){
                            if (i == 0){
                                if (j==0){
                                    for (int h = i; h < i+2; h++){
                                        for (int b = j; b < j+2; b++){
                                            if ( speelveld[h][b] == kleur){
                                                speelveld[h][b] = 0;
                                            }
                                        }
                                    }
                                }
                                else if (j== HOOGTE-1){
                                    for (int h = i; h < i+2; h++){
                                        for (int b = j-1; b < j+1; b++){
                                            if ( speelveld[h][b] == kleur){
                                                speelveld[h][b] = 0;
                                            }
                                        }
                                    }
                                }
                                else{
                                    for (int h = i; h < i+2; h++){
                                        for (int b = j-1; b < j+2; b++){
                                            if ( speelveld[h][b] == kleur){
                                                speelveld[h][b] = 0;
                                            }
                                        }
                                    }
                                }
                            }
                            else if (i == BREEDTE - 1){
                                if (j==0){
                                    for (int h = i-1; h < i+1; h++){
                                        for (int b = j; b < j+2; b++){
                                            if ( speelveld[h][b] == kleur){
                                                speelveld[h][b] = 0;
                                            }
                                        }
                                    }
                                }
                                else if (j== HOOGTE-1){
                                    for (int h = i-1; h < i+1; h++){
                                        for (int b = j-1; b < j+1; b++){
                                            if ( speelveld[h][b] == kleur){
                                                speelveld[h][b] = 0;
                                            }
                                        }
                                    }
                                }
                                else{
                                    for (int h = i-1; h < i+1; h++){
                                        for (int b = j-1; b < j+2; b++){
                                            if ( speelveld[h][b] == kleur){
                                                speelveld[h][b] = 0;
                                            }
                                        }
                                    }
                                }
                            }
                            else {
                                if (j==0){
                                    for (int h = i-1; h < i+2; h++){
                                        for (int b = j; b < j+2; b++){
                                            if ( speelveld[h][b] == kleur){
                                                speelveld[h][b] = 0;
                                            }
                                        }
                                    }
                                }
                                else if (j== HOOGTE-1){
                                    for (int h = i-1; h < i+2; h++){
                                        for (int b = j-1; b < j+1; b++){
                                            if ( speelveld[h][b] == kleur){
                                                speelveld[h][b] = 0;
                                            }
                                        }
                                    }
                                }
                                else{
                                    for (int h = i-1; h < i+2; h++){
                                        for (int b = j-1; b < j+2; b++){
                                            if ( speelveld[h][b] == kleur){
                                                speelveld[h][b] = 0;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else{
                            if ( i > 0){
                                if ( speelveld[i-1][j] == kleur){
                                    speelveld[i-1][j] = 0;
                                }
                            }
                            if ( i < BREEDTE -1){
                                if ( speelveld[i+1][j] == kleur){
                                    speelveld[i+1][j] = 0;
                                }
                            }
                            if ( j > 0){
                                if ( speelveld[i][j-1] == kleur){
                                    speelveld[i][j-1] = 0;
                                }
                            }
                            if ( j < HOOGTE -1){
                                if (speelveld[i][j+1] == kleur){
                                    speelveld[i][j+1] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (kleur != 9){

        }
        else{

        }
    }



    public int keuzeKleur(){
        int kleurwaarde = 0;
        String userkleur;
        do{
            System.out.println("zet " + aantalzetten + ". Geef een kleur in , lowercase only aub.");
            System.out.println("\n");
            userkleur = scanner.nextLine();
            System.out.println("\n");
            if ( userkleur.equals("rood") ){
                kleurwaarde = 1;
            }
            else if ( userkleur.equals("geel")){
                kleurwaarde =2;
            }
            else if ( userkleur.equals("paars")){
                kleurwaarde =3;
            }
            else if ( userkleur.equals("blauw")){
                kleurwaarde =4;
            }
            else if ( userkleur.equals("groen")){
                kleurwaarde =5;
            }
            else if ( userkleur.equals("oranje")){
                kleurwaarde =6;
            }
            else if ( userkleur.equals("roos")){
                kleurwaarde =7;
            }
            else if ( userkleur.equals("bruin")){
                kleurwaarde =8;
            }
            else if (userkleur.equals("stop")){
                kleurwaarde =9;
            }
            else {
            }
            if(!Kleuren.geldigeKleur(userkleur) && !userkleur.equals("stop")) {
                System.out.println("Verkeerde invoer!");
            }
        } while (!Kleuren.geldigeKleur(userkleur) && !userkleur.equals("stop"));
        return kleurwaarde;
    }

    public boolean isVeldVol (){
        for (int j =0 ; j < HOOGTE;j++ ) {
            for (int i=0; i < BREEDTE;i++){
                if(speelveld[i][j] != 0){
                    return false;
                }else{
                }
            }
        }
        return true;
    }


    public void setScore(int score) {
        Score = score;
    }

    public int getKleur(int a, int b){
        return speelveld[a][b];
    }
}
