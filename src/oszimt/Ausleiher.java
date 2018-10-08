package oszimt;

public class Ausleiher {

    private static int ID = 0;
    private String vorname;
    private String nachname;
    private String typ;

    public Ausleiher(String vorname,String nachname,String typ){

        this.vorname = vorname;
        this.nachname = nachname;
        this.typ = typ;

        ID = ID + 1;

    }

    public void leihtAus(Leihobjekt leihobjekt){
        DBManager.einpflegen(this, leihobjekt);
    }

    public void bekommtZurueck(Leihobjekt leihobjekt){
        DBManager.loeschen(this, leihobjekt);
    }
}
