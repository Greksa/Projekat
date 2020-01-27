/*
 Klasa TekuciRacun, dete apstraktne klase Racun
 */
package cs101.Projekat;


import java.util.List;

/**
 *
 * @author Mihal
 */
public class TekuciRacun extends Racun {

    private List<Kartica> listaKartica;
    private int stanjeNaRacunu;

    // prazan konstruktor
    public TekuciRacun() {

    }

    // konstruktor kopije
    public TekuciRacun(TekuciRacun x) {
        this.listaKartica = x.listaKartica;
    }
    // konstruktor polja

    public TekuciRacun(String brojBankovnogRacuna, int stanjeNaRacunu, List listaKartica) {
        super(brojBankovnogRacuna);
        this.listaKartica = listaKartica;
        this.stanjeNaRacunu = stanjeNaRacunu;
    }

    // seteri i geteri
    public int getStanjeNaRacunu() {
        return stanjeNaRacunu;
    }

    public void setStanjeNaRacunu(int stanjeNaRacunu) {
        this.stanjeNaRacunu = stanjeNaRacunu;
    }

    public List<Kartica> getListaKartica() {
        return listaKartica;
    }

    public void setListaKartica(List<Kartica> listaKartica) {
        this.listaKartica = listaKartica;
    }

    // toString
    public String toString() {
        return "\n" + stanjeNaRacunu + " din" + "\nKartice korisnika: " + listaKartica;
    }
}
