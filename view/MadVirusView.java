package view;

import model.MadVirusModel;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class MadVirusView {
    private MadVirusModel spel;
    private Scanner scanner = new Scanner(System.in);
    public String invoergebruiker;

    public MadVirusView(MadVirusModel spel){
        this.spel = spel;
    }

    public void startSpel() {
        System.out.println("Wat is je naam: ");
        String naam = scanner.nextLine();
        spel.setNaam(naam);
        System.out.println("Dag, " + spel.getNaam() + ". Welkom bij Mad Virus!");
        int keuze;
            do {
                keuze = menuKeuze();
                switch (keuze) {
                    case 1:
                        nieuwSpel();
                        break;
                    case 2:
                        System.out.println(spel.getUitleg());
                    case 3:
                        System.out.println("***HIGHSCORES***");
                        try{
                            FileInputStream fstream = new FileInputStream(spel.getNaam()+".scr");
                            DataInputStream in = new DataInputStream(fstream);
                            BufferedReader br = new BufferedReader(new InputStreamReader(in));
                            String strLine;
                            while ((strLine = br.readLine()) != null)   {
                                System.out.println (strLine);
                            }
                            in.close();
                        }
                        catch (Exception e){
                            System.err.println("Geen highscore gevonden!");
                        }
                        System.out.println("***----------***");
                        break;

                    case 4:
                        System.out.println("Tot de volgende keer, " + spel.getNaam() + "!");
                }
            } while (keuze != 4);
        }

    private void nieuwSpel() {
        int level = 0;
        boolean gebruikerWilStoppen = false;
        System.out.println("********************************************************************");
        String supvirus = "";
        boolean supervirus = false;
        do{
            scanner.nextLine();
            System.out.println("Kies je spelmodus: normaal of supervirus!");
            supvirus = scanner.nextLine();
            if (supvirus.equals("normaal")){
                supervirus = false;
            }
            else if (supvirus.equals("supervirus")){
                supervirus = true;
            }
            else {
                System.out.println("verkeerde invoer!");
            }
        } while (!supvirus.equals("normaal") && !supvirus.equals("supervirus"));
        while (level < 3){
            spel.reset(supervirus, level);
            level++;
            long start = System.currentTimeMillis();
            while (!spel.isSpelGedaan() && !gebruikerWilStoppen){
                int cijfer = spel.doeZet();
                switch (cijfer){
                    case 1: invoergebruiker = "rood";break;
                    case 2: invoergebruiker = "geel";break;
                    case 3: invoergebruiker = "paars";break;
                    case 4: invoergebruiker = "blauw";break;
                    case 5: invoergebruiker = "groen";break;
                    case 6: invoergebruiker = "oranje";break;
                    case 7: invoergebruiker = "roos";break;
                    case 8: invoergebruiker = "bruin";break;
                    case 9: invoergebruiker = "stop";break;
                    default: invoergebruiker = " ";break;
                }
                gebruikerWilStoppen = invoergebruiker.trim().equalsIgnoreCase("stop");
            }
            if(spel.isSpelGedaan()) {
                long einde = System.currentTimeMillis();
                System.out.println("Proficiat! Je voltooide level " + level + " in " + spel.getBeurt() + " zetten.");
                try{
                    FileWriter fstream = new FileWriter(spel.getNaam() + ".scr", true);
                    BufferedWriter out = new BufferedWriter(fstream);
                    out.write(spel.getNaam()+ ": level "+ level +" in "+ spel.getBeurt() + " beurten, " + ((einde-start)/1000) + " sec. Mode: "+ spel.getModus() +"\n");
                    out.close();
                }
                catch (Exception e){
                    System.err.println("Error: " + e.getMessage());
                }
            }
            else if(spel.beurtenOp()) {
                System.out.println("Je hebt alle beurten opgebruikt. Jammer!");
                break;
            }
            else {
                System.out.println("Je hebt het spel beindigd.");
                break;
            }
        }
        System.out.println("*********************************************************************");
    }

    private int menuKeuze() {
        boolean gekozen = false;
        int keuze = 0;
        do {
            System.out.println("Maak uw keuze:");
            System.out.println("1. Nieuw spel");
            System.out.println("2. Uitleg");
            System.out.println("3. Highscores");
            System.out.println("4. Einde");
            try {
                keuze = scanner.nextInt();
                if (keuze > 0 && keuze <= 4) {
                    gekozen = true;
                } else {
                    System.out.println("Maak een keuze van 1..4");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Ongeldige keuze!");
                scanner.nextLine();
            }
        } while (!gekozen);
        return keuze;
    }

}
