package oszimt;

public class Leihobjekt {
    private int id;
    private String name;
    private String typ;
    private String beschreibung;

    public Leihobjekt(int id, String name, String typ, String beschreibung) {
        this.id = id;
        this.name = name;
        this.typ = typ;
        this.beschreibung = beschreibung;
    }

    @Override
    public String toString() {
        return "Leihobjekt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typ='" + typ + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                '}';
    }

    // Getter Setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
