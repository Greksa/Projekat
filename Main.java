/*
 Aplikacija "Banka"
Jedna banka ima svoje korisnike i njihove podatke (racune, kartice, kredite, stednju)...
Program prikazuje manipulaciju sa svim tim podacima tako da je moguce izvesti nekoliko operacija koje ilustruju pravi rad jedne banke....
Operacija kao sto su: Podigni novac sa racuna, prebaci novac sa racuna na karticu, proveri mesecnu ratu kredita i mnoge druge operacije...
 
 */
package cs101.Projekat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mihal
 */
public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // liste Kartica i Korisnika
        List<Kartica> listaKartica = new ArrayList<>();
        List<Korisnik> listaKorisnika = new ArrayList<>();

//***************************************************************************************************************** 
// pravim objekte kartica i dodajem ih u listu
        Kartica k1 = new Kartica("2345", "21/45", "123", 0);
        Kartica k2 = new Kartica("3332", "25/34", "231", 0);
        Kartica k3 = new Kartica("5731", "44/88", "610", 0);
        Kartica k4 = new Kartica("2037", "11/38", "645", 0);
        listaKartica.add(k1);
        listaKartica.add(k2);
        listaKartica.add(k3);
        listaKartica.add(k4);

// pravim objekat za racun orocene stednje i tekuci racun...
        StednjaKreditRacun stednja1 = new StednjaKreditRacun("123-456-789-213", 100000, 0);
        TekuciRacun tekuci1 = new TekuciRacun("333-444-555-666", 90000, listaKartica.subList(0, 2));

        // Pravim objekat za Korisnik - fizicko lice, dodajem mu listu njegovih kartica i racun za stednju 
        Korisnik f1 = new FizickoLice("Pera", "Peric", "000999", "Borska 34", "Dusan", "Milena", "1991", true, "066-666-555", "pera.peric@gmail.com", false, stednja1, tekuci1);

        //*****************************************************************************************************************
        // ponavljam isti proces za pravno lice...
        StednjaKreditRacun stednja2 = new StednjaKreditRacun("345-666-341-789", 700000, 0);
        TekuciRacun tekuci2 = new TekuciRacun("321-324-555-777", 900000, listaKartica.subList(2, 4));

        Korisnik p1 = new PravnoLice("Mika", "Mikic", "980777", "Ustanicka 2", "011-222-333", "it.solutions@gmail.com",
                "IT-solutions", "55-44-33", "IT-industrija", false, stednja2, tekuci2);

//*******************************************************************************************************************
// pravim objekat za Banku i dodajem joj listu njenih korisnika
        Banka komercijalna = new Banka("Komercijalna banka", "Pozeska 14", listaKorisnika);
        listaKorisnika.add(f1);
        listaKorisnika.add(p1);
// Prikazuje korisniku izbor radnji koje trenutno moze da izvede...
// Pre pokretanja programa setuju se uslovi po zelji u zavisnosti koje informacije korisnik zeli da obradi...

        Integer odabir = null;
        boolean greska = false;

        do {

            try {
                komercijalna.ispisiUpustvoKorisniku();
                odabir = Integer.parseInt(sc.next());
            } catch (Exception e) {
                System.out.println("Pogresan unos, pokusajte ponovo...");
                sc.reset();
                greska = false;
                odabir = 900;

            }

            switch (odabir) {
                case 1:
                    Collections.sort(listaKorisnika);
                    System.out.println(komercijalna);
                    break;
                case 2:
                    komercijalna.proveriMogucnostUzimanjaKredita(f1);
                    break;
                case 3:
                    komercijalna.platiOnline(k1);
                    break;
                case 4:
                    System.out.println("Visina dobiti za unesen period je: " + komercijalna.racunaVisinuDobiti(f1) + " din");
                    break;
                case 5:
                    komercijalna.IzracunajRatuKredita();
                    break;
                case 6:
                    komercijalna.odrzavanjeRacuna();
                    break;
                case 7:
                    komercijalna.prebaciNovacSaTekucegNaKarticu(f1, k1);
                    break;
                case 8:
                    komercijalna.podigniNovacSaTekucegRacuna(f1);
                    break;
                case 9:
                    komercijalna.uzmiKredit(f1);
                    break;
                case 10:
                    System.out.println("Kursna lista na danasnji dan: ");
                    for (KursnaLista valuta : KursnaLista.values()) {
                        System.out.println(valuta.getNaziv() + " - " + valuta.getValuta());
                    }
                    break;
                case 11:
                    try (BufferedReader bfr = new BufferedReader(new FileReader("C:\\Users\\Korisnik\\Documents\\NetBeansProjects\\CS101-JAVA-Ucenje\\Izvod.txt"))) {
                    String trenutnaLinija;

                    while ((trenutnaLinija = bfr.readLine()) != null) {
                        System.out.println(trenutnaLinija);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            greska = true;

        } while (odabir != 0 && greska);
    }

}
