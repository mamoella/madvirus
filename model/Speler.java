package model;

public class Speler {
    private String gebruikersnaam;
    private int score;
    private int highscore;


    public Speler(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public int getScore() {
        return score;
    }

    public int getHighscore() {
        return highscore;
    }
}
