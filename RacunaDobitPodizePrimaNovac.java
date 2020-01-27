package cs101.Projekat;
// Interfejs 

public interface RacunaDobitPodizePrimaNovac {

    public void odrzavanjeRacuna();
    public void proveriMogucnostUzimanjaKredita(Korisnik korisnik);
    public void prebaciNovacSaTekucegNaKarticu(Korisnik korisnik, Kartica kartica);
    public void podigniNovacSaTekucegRacuna(Korisnik korisnik);
    

}
