package dk.tec.personapiclient;

public class Elev
{
    public int id;
    public String navn;
    public String elevJob;

    public Elev() {}

    public Elev(int id, String navn, String elevJob)
    {
        super();
        this.id = id;
        this.navn = navn;
        this.elevJob = elevJob;
    }
}