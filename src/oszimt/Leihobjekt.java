package oszimt;

public class Leihobjekt {
    private int id;
    private String name;
    private String beschreibung;
    private int aid;

    public Leihobjekt(int id, String name, String beschreibung) {
        this.id = id;
        this.name = name;
        this.beschreibung = beschreibung;
        this.aid = 0;
    }

    @Override
    public String toString() {
        return "Leihobjekt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                ", ausleiherid='" + aid + '\'' +
                '}';
    }

    public String toFormattedString() {
        return name + " mit der ID " + id;
    }

    // Getter | Setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public int getAusleiher() {
        return aid;
    }

    public void setAusleiher(int AID) {
        this.aid = aid;
    }

}
