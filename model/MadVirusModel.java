package model;

public class MadVirusModel {
    private Speler speler ;
    private Speelveld speelveld;
    private int teller;
    private boolean einde;

    public MadVirusModel() {

    }

    public String getNaam() {
        return speler.getGebruikersnaam();
    }

    public void setNaam(String naam){
        speler = new Speler(naam);
    }

    public String getModus() {
        String modus;
        if (speelveld.getMode()){
            modus= "supervirus";
        }
        else {
            modus = "normaal";
        }
        return modus;
    }

    public void setModus(int virus){
        if (virus==1){
            speelveld.setMode(true);
        }
        else {
            speelveld.setMode(false);
        }
    }

    public void reset(boolean virus, int level) {
        teller = 15;
        speelveld = new Speelveld(6,6,level);
        speelveld.vulSpelbord();
        speelveld.setMode(virus);
        einde = false;
    }

    public void zoekVirus(int kleur){
        speelveld.zoekenVirus(kleur);
    }

    public int doeZet() {
        int cijfer = 0;
        if (!speelveld.isVeldVol()) {
            teller--;
            cijfer = speelveld.keuzeKleur();
            speelveld.zoekenVirus(cijfer);
            speelveld.geefbord();
            return cijfer;
        }
        else{
            einde = true;
            return cijfer;
        }
    }

    public String getUitleg() {
        String str = "Mad Virus is een spel waarbij je een tactische keuze moet maken om het spel te beïndigen in zo weinig mogelijk stappen.";
        str += "\nJe Kiest telkens een kleur en het virus zal zich vervolgens verspreiden over de gekozen kleur";
        str += "\ntot heel het speelveld besmet is door het virus.";

        return str;
    }

    public boolean isSpelGedaan() {
        return einde;
    }

    public boolean veldVol() {
        return speelveld.isVeldVol();
    }

    public int getBeurt() {
        return speelveld.getAantalzetten();
    }

    public boolean beurtenOp() {
        return (teller <= speelveld.getAantalzetten());
    }

    public int getScore() {
        return speelveld.getScore();
    }

    public String toString(){
        return ("Welkom bij Mad Virus "+speler.getGebruikersnaam()+ ".");
    }

    public int getBreedte() {
        return speelveld.getBreedte();
    }

    public int getHoogte() {
        return speelveld.getHoogte();
    }

    public int getKleur(int a, int b){
        return speelveld.getKleur(a,b);
    }
}
