package oszimt;

public class Leihobjekt {
    private static int ID = 0;
    private String beschreibung;
    private String typ;

    public Leihobjekt(String beschreibung,String typ){
        this.beschreibung = beschreibung;
        this.typ = typ;

        ID = ID + 1;
    }
}
