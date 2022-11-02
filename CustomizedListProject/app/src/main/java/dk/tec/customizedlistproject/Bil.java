package dk.tec.customizedlistproject;

public class Bil
{
    int id;
    String name;
    String beskrivelse;
    int billedId;

    public Bil(int id, String name, String beskrivelse, int billedId) {
        this.id = id;
        this.name = name;
        this.beskrivelse = beskrivelse;
        this.billedId = billedId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public int getBilledId() {
        return billedId;
    }

    public void setBilledId(int billedId) {
        this.billedId = billedId;
    }




}
