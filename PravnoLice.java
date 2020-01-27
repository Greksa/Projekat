/*
 Klasa PravnoLice, dete apstraknte klase Korisnik....
 */
package cs101.Projekat;

/**
 *
 * @author Mihal
 */
public class PravnoLice extends Korisnik {

    private String regBrojPreduzeca;
    private String nazivPreduzeca;
    private String delatnost;
    

    // prazan konstruktor
    public PravnoLice() {

    }

    // konstruktor kopije
    public PravnoLice(PravnoLice x) {

        this.nazivPreduzeca = x.nazivPreduzeca;
        this.regBrojPreduzeca = x.regBrojPreduzeca;
        this.delatnost = x.delatnost;
       

    }
// konstruktor polja

    public PravnoLice(String ime, String prezime, String jmbg, String adresa, String telefon, String mail,
            String nazivPreduzeca, String regBrojPreduzeca, String delatnost, boolean kredit, StednjaKreditRacun stednjaKreditRacun, TekuciRacun tekuciRacun) {
        super(ime, prezime, jmbg, adresa, telefon, mail, kredit, stednjaKreditRacun, tekuciRacun);
        this.nazivPreduzeca = nazivPreduzeca;
        this.regBrojPreduzeca = regBrojPreduzeca;
        this.delatnost = delatnost;
        

    }
// seteri i geteri
    public String getNazivPreduzeca() {
        return nazivPreduzeca;
    }

    public void setNazivPreduzeca(String nazivPreduzeca) {
        this.nazivPreduzeca = nazivPreduzeca;
    }

    public String getRegBrojPreduzeca() {
        return regBrojPreduzeca;
    }

    public void setRegBrojPreduzeca(String regBrojPreduzeca) {
        this.regBrojPreduzeca = regBrojPreduzeca;
    }

    public String getDelatnost() {
        return delatnost;
    }

    public void setDelatnost(String delatnost) {
        this.delatnost = delatnost;
    }

    
// toString metod
    @Override
    public String toString() {
        return "\n===============================================================================\n"
                + "Ime: " + getIme() + "\nPrezime: " + getPrezime() + "\nJMBG: " + getJmbg()
                + "\nAdresa: " + getAdresa() + "\nKontakt telefon: " + getTelefon()
                + "\nEmail: " + getMail()
                + "\nStednja racun: " + getStednjaKreditRacun() + "\nTekuci Racun: " + getTekuciRacun() + "\nNaziv preduzeca: " + nazivPreduzeca
                + "\nRegistarski broj preduzeca: " + regBrojPreduzeca + "\nDelatnost: " + delatnost
                + "\nPod (investicionim) kreditom: " + getKredit()
                + "\n===============================================================================\n";
    }

    // comapreTo metod
    @Override
    public int compareTo(Korisnik drugiKorisnik) {
        return this.getIme().compareTo(drugiKorisnik.getIme());
    }
}
