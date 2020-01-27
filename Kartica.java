/*
 Klasa Kartica je samostalna klasa i sluzi za pravljenje objekata kartica koje se posle dodeljuju korisnicima...
 */
package cs101.Projekat;

/**
 *
 * @author Mihal
 */
public class Kartica{
    // promenjive
    private String pin;
    private String datumIsteka;
    private String sigurnosniBroj;
    private int stanjeNaRacunuKartice;

    // prazan konstruktor
    public Kartica() {

    }

    // konstruktor kopije
    public Kartica(Kartica x) {
        this.datumIsteka = x.datumIsteka;
        this.pin = x.pin;
        this.sigurnosniBroj = x.sigurnosniBroj;
        this.stanjeNaRacunuKartice = x.stanjeNaRacunuKartice;
    }

    // konstruktor polja
    public Kartica(String pin, String datumIsteka, String sigurnosniBroj, int stanjeNaRacunuKartice) {
        this.datumIsteka = datumIsteka;
        this.pin = pin;
        this.sigurnosniBroj = sigurnosniBroj;
        this.stanjeNaRacunuKartice = stanjeNaRacunuKartice;
    }
   // seteri i geteri
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getDatumIsteka() {
        return datumIsteka;
    }

    public void setDatumIsteka(String datumIsteka) {
        this.datumIsteka = datumIsteka;
    }

    public String getSigurnosniBroj() {
        return sigurnosniBroj;
    }

    public void setSigurnosniBroj(String sigurnosniBroj) {
        this.sigurnosniBroj = sigurnosniBroj;
    }

    public int getStanjeNaRacunuKartice() {
        return stanjeNaRacunuKartice;
    }

    public void setStanjeNaRacunuKartice(int stanjeNaRacunuKartice) {
        this.stanjeNaRacunuKartice = stanjeNaRacunuKartice;
    }
    
    // toString
    @Override
    public String toString() {
        return "PIN-CODE: " + pin + ", Vazenje: " + datumIsteka + ", Sigurnosni broj: " + sigurnosniBroj
                + ", Stanje na racunu: " + stanjeNaRacunuKartice + " din || ";
    }
}
