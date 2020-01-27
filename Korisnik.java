/*
    Apstraktna klasa Korisnik...
 */
package cs101.Projekat;

/**
 *
 * @author Mihal
 */
public abstract class Korisnik implements Comparable<Korisnik>  {

    private String ime;
    private String prezime;
    private String jmbg;
    private String adresa;
    private String telefon;
    private String mail;
    private boolean kredit;
    
    private StednjaKreditRacun stednjaKreditRacun;
    private TekuciRacun tekuciRacun;

    // prazan konstruktor
    public Korisnik() {

    }

// konstruktor kopije
    public Korisnik(Korisnik x) {
        this.ime = x.ime;
        this.prezime = x.prezime;
        this.jmbg = x.jmbg;
        this.adresa = x.adresa;
        this.kredit = x.kredit;
      
        this.stednjaKreditRacun = x.stednjaKreditRacun;
        this.tekuciRacun = x.tekuciRacun;
        
    }

// konstruktor polja
    public Korisnik(String ime, String prezime, String jmbg, String adresa, String telefon, String mail, boolean kredit,  
            StednjaKreditRacun stednjaKreditRacun, TekuciRacun tekuciRacun) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.adresa = adresa;
        this.telefon = telefon;
        this.mail = mail;
       
        this.stednjaKreditRacun = stednjaKreditRacun;
        this.tekuciRacun = tekuciRacun;
        
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public boolean getKredit() {
        return kredit;
    }
    
    public void setKredit(boolean kredit) {
        this.kredit = kredit;
    }

    

    public StednjaKreditRacun getStednjaKreditRacun() {
        return stednjaKreditRacun;
    }

    public TekuciRacun getTekuciRacun() {
        return tekuciRacun;
    }


    @Override
    public String toString() {
        return "Ime: " + ime + "\nPrezime: " + prezime + "\nJMBG: " + jmbg + "\nAdresa: " + adresa + "\nKontakt telefon: " + telefon + 
                "\nEmail: " + mail + "\nStednja Racun: " + stednjaKreditRacun + "\nTekuci Racun: " + tekuciRacun + "\nDa li je pod kreditom: " + kredit;
    }
}
