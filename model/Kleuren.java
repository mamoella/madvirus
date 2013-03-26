package model;

public enum Kleuren {
    ROOD,PAARS,GEEL,BLAUW,LEEG,GROEN,ROOS,BRUIN;
    public static boolean geldigeKleur(String test) {
        for (Kleuren k : Kleuren.values()) {
            if (k.name().equals(test.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}


