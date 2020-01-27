/*
 Klasa FizickoLice, dete apstraknte klase Korisnik....
 */
package cs101.Projekat;

/**
 *
 * @author Mihal
 */
public class FizickoLice extends Korisnik {

    private boolean bracniStatus;
    private String godinaRodjenja;
    private String imeOca;
    private String imeMajke;

    // prazan konstruktor
    public FizickoLice() {

    }
   // konstruktor kopije
    public FizickoLice(FizickoLice x) {
        this.bracniStatus = x.bracniStatus;
        this.godinaRodjenja = x.godinaRodjenja;
        this.imeMajke = x.imeMajke;
        this.imeOca = x.imeOca;
    }

    // konstruktor polja
    public FizickoLice(String ime, String prezime, String jmbg, String adresa, String imeOca, String imeMajke, String godinaRodjenja, boolean bracniStatus,
            String telefon, String mail, boolean kredit,
            StednjaKreditRacun stednjaKreditRacun, TekuciRacun tekuciRacun) {
        super(ime, prezime, jmbg, adresa, telefon, mail, kredit, stednjaKreditRacun, tekuciRacun);
        
        this.bracniStatus = bracniStatus;
        this.godinaRodjenja = godinaRodjenja;
        this.imeMajke = imeMajke;
        this.imeOca = imeOca;

    }
    // seteri i geteri
    public void setBracniStatus(boolean bracniStatus) {
        this.bracniStatus = bracniStatus;
    }

    public void setGodinaRodjenja(String godinaRodjenja) {
        this.godinaRodjenja = godinaRodjenja;
    }

    public void setImeOca(String imeOca) {
        this.imeOca = imeOca;
    }

    public void setImeMajke(String imeMajke) {
        this.imeMajke = imeMajke;
    }

    public boolean isBracniStatus() {
        return bracniStatus;
    }

    public String getGodinaRodjenja() {
        return godinaRodjenja;
    }

    public String getImeOca() {
        return imeOca;
    }

    public String getImeMajke() {
        return imeMajke;
    }

    // toString metod
    @Override
    public String toString() {
        return "\n===============================================================================\n"
                + "Ime: " + getIme() + "\nPrezime: " + getPrezime() + "\nJMBG: " + getJmbg() + "\nAdresa: "
                + getAdresa() + "\nKontakt Telofon: " + getTelefon() + "\nEmail: " + getMail() + "\nBracni status: " + bracniStatus + "\nGodina rodjenja: " 
                + godinaRodjenja + "\nIme oca: " + imeOca + "\nIme majke: " + imeMajke 
                + "\nStednja racun: " + getStednjaKreditRacun() + "\nTekuci racun: " + getTekuciRacun() + "\nPod kreditom: " + getKredit()
                + "\n===============================================================================\n";
    }

    // compareTo metod
    @Override
    public int compareTo(Korisnik drugiKorisnik) {
        return this.getIme().compareTo(drugiKorisnik.getIme());
    }

}
