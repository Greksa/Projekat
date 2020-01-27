/*
 StednjaKredit racun, dete klase Racun...
 */
package cs101.Projekat;

/**
 *
 * @author Mihal
 */
public class StednjaKreditRacun extends Racun {

    private int orocenaSredstva;
    private int kredit;

    // prazan konstruktor
    public StednjaKreditRacun() {

    }

    // konstruktor kopije
    public StednjaKreditRacun(StednjaKreditRacun x) {
        this.orocenaSredstva = x.orocenaSredstva;
        this.kredit = x.kredit;
    }

    // konstruktor polja
    public StednjaKreditRacun(String brojBankovnogRacuna, int orocenaSredstva, int kredit) {
        super(brojBankovnogRacuna);
        this.orocenaSredstva = orocenaSredstva;
        this.kredit = kredit;

    }

    // seteri i geteri
    public int getOrocenaSredstva() {
        return orocenaSredstva;
    }

    public void setOrocenaSredstva(int orocenaSredstva) {
        this.orocenaSredstva = orocenaSredstva;
    }

    public int getKredit() {
        return kredit;
    }

    public void setKredit(int kredit) {
        this.kredit = kredit;
    }

    // toString
    @Override
    public String toString() {
        return "Orocena sredstva: " + orocenaSredstva + "\nIma kredit u visini od: " + kredit + " din" + "\nBroj bankovnog racuna: " + getBrojBankovnogRacuna();
    }
}
