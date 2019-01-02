package oszimt;

public class Leihobjekt {
    private int id;
    private String name;
    private String beschreibung;
    private int aid;

    public Leihobjekt(int id, String name, String beschreibung, int aid) {
        this.id = id;
        this.name = name;
        this.beschreibung = beschreibung;
        this.aid = aid;
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

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

}
