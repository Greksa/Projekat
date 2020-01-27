/*
 Apstraktna klasa Racun...
 */
package cs101.Projekat;

/**
 *
 * @author Mihal
 */
public abstract class Racun {

    private String brojBankovnogRacuna;
    
    // prazan konstruktor
    public Racun() {

    }

    // konstruktor kopije
    public Racun(Racun x) {
        
        this.brojBankovnogRacuna = x.brojBankovnogRacuna;
        
    }

    // konstruktor polja
    public Racun(String brojBankovnogRacuna) {
        this.brojBankovnogRacuna = brojBankovnogRacuna;
        
       
    }

    public String getBrojBankovnogRacuna() {
        return brojBankovnogRacuna;
    }

    public void setBrojBankovnogRacuna(String brojBankovnogRacuna) {
        this.brojBankovnogRacuna = brojBankovnogRacuna;
    }


    @Override
    public String toString() {
        return "Broj bankovnog racuna: " + brojBankovnogRacuna;
    }

}
