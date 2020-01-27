/*
 Klasa Banka ima listu njenih korisnika i svoje osnovne informacije, 
poseduje sve metode za rad sa podacima iz ostalih klasa...
 */
package cs101.Projekat;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mihal
 */
public class Banka implements RacunaDobitPodizePrimaNovac, KonverzijeDigitroni {

    // Scanner za unos podataka
    Scanner sc = new Scanner(System.in);

    // promenjive
    private String ime;
    private String adresa;
    private List<Korisnik> listaKorisnika;

    // prazan konstruktor
    public Banka() {

    }

    // konstruktor kopije
    public Banka(Banka x) {
        this.ime = x.ime;
        this.adresa = x.adresa;
        this.listaKorisnika = x.listaKorisnika;
    }

    // konstruktor polja
    public Banka(String ime, String adresa, List listaKorisnika) {
        this.ime = ime;
        this.adresa = adresa;
        this.listaKorisnika = listaKorisnika;
    }

    // seteri i geteri
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List getListuKorisnika() {
        return listaKorisnika;
    }

    public void setListaKorisnika(List listaKorisnika) {
        this.listaKorisnika = listaKorisnika;
    }

    // skida novac sa kartice prilikom placanja, upisuje ransakciju u datoteku i cuva je...
    public void platiOnline(Kartica kartica) {
        String primalac, adresaPrimaoca, brojRacuna, sigurnosniBroj;
        int iznos;

        sc.nextLine();
        System.out.println("Unesi ime primaoca i prezime primaoca: ");
        primalac = sc.nextLine();
        System.out.println("Unesi adresu: ");
        adresaPrimaoca = sc.nextLine();
        System.out.println("Unesi broj racuna primaoca: ");
        brojRacuna = sc.nextLine();
        System.out.println("Unesi iznos novca za placanje: ");
        iznos = sc.nextInt();
        System.out.println("Unesi sigurnosni broj: ");
        sigurnosniBroj = sc.next();

        if (sigurnosniBroj.equals(kartica.getSigurnosniBroj()) && kartica.getStanjeNaRacunuKartice() >= iznos) {
            kartica.setStanjeNaRacunuKartice(kartica.getStanjeNaRacunuKartice() - iznos);
            System.out.println("Uspesno izvrsena transakcija.");

            String izvod = "\nPrimalac: " + primalac + ", adresa: " + adresaPrimaoca + ", broj racuna: " + brojRacuna + ", isplata: " + iznos + ", novo stanje na kartici: " + kartica.getStanjeNaRacunuKartice();
            System.out.println(izvod);
            try {
                FileWriter fw = new FileWriter("C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\CS101-JAVA-Ucenje\\Izvod.txt", true); //Set true for append mode
                PrintWriter izlaz = new PrintWriter(fw);
                izlaz.println(izvod);
                izlaz.close();

            } catch (IOException ex) {
                System.out.printf("GRESKA: %s\n", ex);
            }

        } else {
            System.out.println("Nemate dovoljno sredstava na racunu kartice ili ste uneli pogresan sigurnosni broj...");
        }
    }

    // provera da korisnik moze da uzme kredit, uslov da vec nema kredit
    public void proveriMogucnostUzimanjaKredita(Korisnik korisnik) {

        if (korisnik.getKredit() == true) {
            System.out.println("Ne mozete da uzmete kredit, vec ga imate...");
        } else {
            System.out.println("Mozete da podignete kredit....");
        }
    }

    // Racuna visinu dobiti na orocenu stednju korisnika
    @Override
    public double racunaVisinuDobiti(Korisnik korisnik) {
        Integer meseci = null;
        boolean greska = false;
        do {
            try {
                System.out.println("Unesite broj meseci za koji zelite da obracunate kamatu na stednju: ");
                meseci = Integer.parseInt(sc.next());
                greska = true;
            } catch (Exception e) {
                System.out.println("Pogresan unos, pokusajte ponovo...");
                greska = false;
                sc.reset();

            }
        } while (greska != true);

        double procenatRasta = 0.05; // kamata 5%
        double dobit = korisnik.getStednjaKreditRacun().getOrocenaSredstva() * procenatRasta;

        return korisnik.getStednjaKreditRacun().getOrocenaSredstva() + (dobit * meseci);

    }

    // Ispisuje na konzoli upustvo za korisnika
    public void ispisiUpustvoKorisniku() {
        System.out.println("\nIzaberi redni broj u listi za izvrsenje radnje ili unesi broj 0 za prekid programa: \n"
                + "1. Prikazi listu svih korisnika banke i njihove informacije...\n"
                + "2. Proveri mogucnost uzimanja kredita...\n"
                + "3. Plati online...\n"
                + "4. Izracunaj visinu dobiti na orocenu stednju...\n"
                + "5. Izracunaj mesecnu ratu kredita korisnika...\n"
                + "6. Izracunaj koliko banka zaradi na odrzavanju svih racuna korisnika mesecno...\n"
                + "7. Prebaci novac sa tekucegRacuna na karticu...\n"
                + "8. Podigni novac sa racuna...\n"
                + "9. Uzmi kredit...\n"
                + "10. Prikazi Kursnu listu na danasnji dan...\n"
                + "11. Prikazi izvode sa racuna korisnika...\n"
        );

    }

    // prebacuje zeljeni iznos novca sa racuna korisnika na njegovu kraticu
    public void prebaciNovacSaTekucegNaKarticu(Korisnik korisnik, Kartica kartica) {
        Integer skiniSaTekuceg = null;
        boolean greska = false;
        do {
            try {
                System.out.println("Unesite iznos koji zelite da prebacite na karticu....");
                skiniSaTekuceg = Integer.parseInt(sc.next());
                greska = true;
            } catch (Exception e) {
                System.out.println("Pogresan unos, pokusajte ponovo...");
                sc.reset();
                greska = false;

            }
        } while (greska != true);

        int tekuciRacun = korisnik.getTekuciRacun().getStanjeNaRacunu();
        korisnik.getTekuciRacun().setStanjeNaRacunu(tekuciRacun - skiniSaTekuceg);
        kartica.setStanjeNaRacunuKartice(kartica.getStanjeNaRacunuKartice() + skiniSaTekuceg);

        System.out.println("Novo stanje na tekucem racunu je: " + korisnik.getTekuciRacun().getStanjeNaRacunu());
        System.out.println("Novo stanje na kartici je: " + kartica.getStanjeNaRacunuKartice());
    }

    // podize novac sa tekuceg racuna
    public void podigniNovacSaTekucegRacuna(Korisnik korisnik) {
        Integer skiniSaTekuceg = null;
        boolean greska = false;
        System.out.println("Unesite broj bankovnog racuna...");
        String brojRacuna = sc.next();

        if (brojRacuna.equals(korisnik.getTekuciRacun().getBrojBankovnogRacuna())) {
            do {
                try {
                    System.out.println("Unesite iznos koji zelite da podignete...");
                    skiniSaTekuceg = Integer.parseInt(sc.next());
                    greska = true;
                } catch (Exception e) {
                    System.out.println("Pogresan unos, pokusajte ponovo...");
                    greska = false;
                    sc.reset();

                }
            } while (greska != true);
            int tekuciRacun = korisnik.getTekuciRacun().getStanjeNaRacunu() - skiniSaTekuceg;

            korisnik.getTekuciRacun().setStanjeNaRacunu(tekuciRacun);
            System.out.println("Podigli ste " + skiniSaTekuceg + " din, sa vaseg racuna...");
            System.out.println("Novo raspolozivo stanje: " + korisnik.getTekuciRacun().getStanjeNaRacunu());

        } else {
            System.out.println("Unos nije validan, probajte ponovo...");
        }
    }

    // stavlja novac na kreditni racun, ako su zadovoljeni uslovi
    public void uzmiKredit(Korisnik korisnik) {
        Integer iznosKredita = null;
        boolean greska = false;
        int limitKredita = korisnik.getTekuciRacun().getStanjeNaRacunu() * 5;
        System.out.println("Unesite broj Stednja-Kredit racuna...");
        String brojRacuna = sc.next();

        if (brojRacuna.equals(korisnik.getStednjaKreditRacun().getBrojBankovnogRacuna())) {
            do {
                try {
                    System.out.println("Unesite iznos kredita koji zelite...");
                    iznosKredita = Integer.parseInt(sc.next());
                    greska = true;
                } catch (Exception e) {
                    System.out.println("Pogresan unos, pokusajte ponovo...");
                    greska = false;
                    sc.reset();
                }
            } while (greska != true);
            if (iznosKredita > limitKredita) {
                System.out.println("Prekoracili ste dozvoljen limit za uzimanje krdita...");
            } else {
                korisnik.getStednjaKreditRacun().setKredit(iznosKredita);
                korisnik.setKredit(true);

                System.out.println("Uspesno ste uzeli kredit u visini od: " + iznosKredita + "\n"
                        + "Stanje na vasem kreditnom racunu je: " + korisnik.getStednjaKreditRacun().getKredit());

            }

        } else {
            System.out.println("Unos nije validan pokusajte ponovo...");

        }
    }

    // izracunava mesecnu ratu korisnika na zeljeni kredit
    @Override
    public void IzracunajRatuKredita() {
        Integer meseci = null;
        Integer kredit = null;
        Integer godine = null;
        boolean greska = false;

        double kamata = 0.09; // 9% kamata
        System.out.println("Ova opcija racuna mesecnu kamatu kredita: ");

        do {
            try {
                System.out.println("Unesite cifru zeljenog kredita...");
                kredit = Integer.parseInt(sc.next());
                System.out.println("Korisnik je uzeo kredit u visini: " + kredit + " din");
                System.out.print("Unesite broj godina otplate: ");
                godine = Integer.parseInt(sc.next());
                System.out.println();
                greska = true;
            } catch (Exception e) {
                System.out.println("Pogresan unos, pokusajte ponovo...");
                greska = false;
                sc.reset();

            }
        } while (greska != true);

        // formula za izracunavanje rate kredita 
        meseci = 12 * godine;
        double c = kamata / 12.0 / 100.0;
        double vratitiBanci = kredit * c * Math.pow(1 + c, meseci)
                / (Math.pow(1 + c, meseci) - 1);

        System.out.println("Mesecna rata korisnika iznosi: " + (int) vratitiBanci + " din");

    }

    // racuna koliko banka zaradi mesecno od odrzavanja racuna korisnika
    @Override
    public void odrzavanjeRacuna() {
        int odrzavanjeRacuna = 350;
        int sum = 0;

        for (Korisnik e : listaKorisnika) {
            sum += odrzavanjeRacuna;
        }

        System.out.println("Odrzavanje racuna iznosi 350 din.\n"
                + "Banka mesecno zaradi na odrzavanju svih racuna iznos od: " + sum + " din");
    }

    // toString 
    @Override
    public String toString() {
        return "Naziv banke: " + ime + "\nAdresa: " + adresa + "\nLista Korisnika: \n" + listaKorisnika;
    }
}
