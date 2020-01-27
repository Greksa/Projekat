/*
enum preko kojeg prikazujem fiksnu kursnu listu valuta...
 */
package cs101.Projekat;

/**
 *
 * @author Mihal
 */
public enum KursnaLista {
    
     EVRO("Evro ",117.82),DOLAR("Dolar ",107.23),FUNTA("Funta ",133.43),JUAN("Juan ",108.55), RUBLJA("Rublja", 83.22);
         
        private final double valuta;
        private final String naziv;
         
        KursnaLista(String s, double v){
            valuta = v;
            naziv = s;
            
        }
         
        public double getValuta(){
            return valuta;
        }
        
        public String getNaziv() {
            return naziv;
        }
    
}
