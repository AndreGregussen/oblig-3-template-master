package no.oslomet.cs.algdat.Oblig3;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringJoiner;

public class SBinTre<T> {

    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    //Oppgave 1:
    /*
    En Node i SBinTre har referanser til venstre barn, høyre barn, samt nodens forelder. Forelder
    må  få  riktig  verdi  ved  hver  innlegging,  men  forelder  skal  være  null  i  rotnoden.  Lag
    metoden public boolean leggInn(T verdi). Der kan du kopiere Programkode 5.2 3 a), men
    i tillegg må du gjøre de endringene som trengs for at referansen forelder får korrekt verdi i
    hver node. Teknikken med en forelder-referanse brukes f.eks. i klassen TreeSet i java.util.
    Sjekk at følgende kode er feilfri (ikke kaster noen unntak):
    Integer[] a = {4,7,2,9,5,10,8,1,3,6};
    SBinTre<Integer> tre = new SBinTre<>(Comparator.naturalOrder());
    for (int verdi : a) {tre.leggInn(verdi); }
    System.out.println(tre.antall());  // Utskrift: 10
     */

    public boolean leggInn(T verdi){
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node <T> p = rot, q = null;             // p starter i roten
        int cmp = 0;                            // hjelpevariabel

        while (p != null){                      // fortsetter til p er ute av treet
            q = p;                              // q er forelder til p
            cmp = comp.compare(verdi, p.verdi); // bruker komperatoren
            p = cmp < 0 ? p.venstre : p.høyre;  // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<>(verdi, null, null, q);                 // oppretter en ny node

        if (q == null) rot = p;                 // p blir rotnode
        else if (cmp < 0) q.venstre = p;        // venstre barn til q
        else q.høyre = p;                       // høyre barn til q

        antall ++;                              // antall øker
        return true;                            // vellykket innlegging
    }

    //Oppgave 6:
    /*
    Lag metoden public boolean fjern(T verdi). Der kan du kopiere Programkode 5.2 8 d),
    men i tillegg må du gjøre de endringene som trengs for at pekeren forelder får korrekt verdi
    i  alle  noder  etter  en  fjerning.  Lag  så  metoden public int fjernAlle(T  verdi).  Den  skal
    fjerne  alle  forekomstene  av verdi i  treet.  Husk  at  duplikater  er  tillatt.  Dermed  kan  en  og
    samme verdi ligge flere steder i treet. Metoden skal returnere antallet som ble fjernet. Hvis
    treet  er  tomt,  skal  0  returneres.  Lag  så  metoden public  void  nullstill().  Den  skal
    traversere (rekursivt eller iterativt) treet i en eller annen rekkefølge og sørge for at samtlige

    pekere  og  nodeverdier  i  treet  blir  nullet.  Det  er  med  andre  ord  ikke  tilstrekkelig  å
    sette rot til null og antall til 0.
    Et eksempel på hvordan det skal virke:
      int[] a = {4,7,2,9,4,10,8,7,4,6,1};
      SBinTre<Integer> tre = new SBinTre<>(Comparator.naturalOrder());
      for (int verdi : a) tre.leggInn(verdi);

      System.out.println(tre.fjernAlle(4));  // 3
      tre.fjernAlle(7); tre.fjern(8);

      System.out.println(tre.antall());  // 5

      System.out.println(tre + " " + tre.omvendtString());
      // [1, 2, 6, 9, 10] [10, 9, 6, 2, 1]


    */

    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    //Oppgave 2:
    /*
        public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public boolean tom() {
        return antall == 0;
    }

    public int antall() {
        return antall;
    }
    Metodene inneholder(), antall() og tom() er ferdig kodet. Den første avgjør om en verdi
    ligger i treet eller ikke. De to andre fungerer på vanlig måte. Lag kode for metoden public
    int antall(T verdi). Den skal returnere antall forekomster av verdi i treet. Det er tillatt
    med  duplikater  og  det  betyr  at  en  verdi  kan  forekomme  flere  ganger.  Hvis verdi ikke  er  i
    treet (null er ikke i treet), skal metoden returnere 0. Test koden din ved å lage trær der du
    legger inn flere like verdier. Sjekk at metoden din da gir rett svar. Her er ett eksempel:
    Integer[] a = {4,7,2,9,4,10,8,7,4,6};
    SBinTre<Integer> tre = new SBinTre<>(Comparator.naturalOrder());
    for (int verdi : a) { tre.leggInn(verdi); }

    System.out.println(tre.antall());      // Utskrift: 10
    System.out.println(tre.antall(5));     // Utskrift: 0
    System.out.println(tre.antall(4));     // Utskrift: 3
    System.out.println(tre.antall(7));     // Utskrift: 2
    System.out.println(tre.antall(10));    // Utskrift: 1
     */

    public int antall(T verdi) {

        Node<T> p = rot;

        int teller = 0;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (p.verdi == verdi){
                teller ++;
                p = p.høyre;
            }
            else if (cmp < 0) p = p.venstre;
            else p = p.høyre;
        }

        return teller;
    }

    //Oppgave 3:
    /*
    Lag hjelpemetodene private static <T> Node<T> førstePostorden(Node<T> p) og private
    private static <T> Node<T> nestePostorden(Node<T> p). Siden dette er private metode,
    tas det som gitt at parameteren p ikke er null. Det er når metoden brukes at en må sikre
    seg  at  det  ikke  går  inn  en  nullreferanse.  Førstepostorden  skal  returnere  første  node  post
    orden med p som rot, og nestePostorden skal returnere den noden som kommer
    etter p i postorden. Hvis p er den siste i postorden, skal metoden returnere null (Se seksjon

    “5.1.7 Preorden, inorden og postorden” for detaljer om postorden og hvordan man kan finne
    neste post orden).
     */

    private static <T> Node<T> førstePostorden(Node<T> p) {
        while(p.venstre != null){
            p = p.venstre;
        }
        while (p.venstre == null && p.høyre != null) {
            p = p.høyre;
        }
        return p;

    }

    private static <T> Node<T> nestePostorden(Node<T> p) {

        if (p == p.forelder.venstre){
            if (p.
            }
        }
            /*
        if (p.forelder == null){
            return null;
        }
        else if (p.forelder.høyre == null || p == p.forelder.høyre){
            return p.forelder;
        }
        else if (p.høyre != null){
            p = p.høyre;
        }
        else {
            p = p.forelder.høyre;
        }
            while(p.venstre != null){
                p = p.venstre;
            }

            while (p.venstre == null && p.høyre != null){
                p = p.høyre;
            }
        return p;
            */
    }

    //Oppgave 4:
    /*
    Lag hjelpemetodene public void postorden(Oppgave <? super T> oppgave) og private void
    postordenRecursive(Node<T>  p,  Oppgave<?  super  T>  oppgave)  som  brukes  til  å  utføre  en
    oppgave. Oppgave kan for eksempel være skriv til skjerm, og da vil denne metoden skrive ut
    treet i post orden. Du skal implementere den første funksjonen uten bruk av rekursjon og
    uten bruk av hjelpevariabler som stack / queue. Du skal bruke funksjonen nestePostorden fra
    forrige oppgave. Start med å finne den første noden p i postorden. Deretter vil (f.eks. i en
    while-løkke) setningen: p = nestePostorden(p); gi den neste. Osv. til p blir null. For den
    rekursive metoden skal du lage et rekursivt kall som traverserer treet i postorden rekkefølge.
     */

    public void postorden(Oppgave<? super T> oppgave) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    //Oppgave 5:
    /*
    For å lagre et binært søketre i en fil må vi legge treet inn i en datastruktur som egner seg for
    fil-skriving. I denne oppgaven skal du lage serialize som gjør om binærtreet til et array, og
    tilsvarende deserialize som tar et array og gjør om til et binært søketre. Lag hjelpemetoden
    public ArrayList<T> serialize() og static <K> SBinTre<K> deserialize(ArrayList<K> data,
    Comparator<?  super  K>  c).  Metoden  serialize  skal  være  iterativ  og  må  bruke  en  kø  til  å
    traversere treet i nivå orden. Arrayet som returneres av serialize skal inneholde verdiene i
    alle nodene i nivå orden. Deserialize skal da ta dette arrayet, og legge inn alle verdiene (igjen
    i nivå orden), og dermed gjenskape treet.
    Et eksempel på hvordan det skal virke:
    //Lag et nytt binærtre
    SBinTre<Integer> tre =
           new SBinTre<>(Comparator.naturalOrder());
    int[] a = {10, 14, 6, 8, 1, 12, 7, 3, 11, 9, 13, 5, 2, 4};
    for (int verdi : a) { tre.leggInn(verdi); }

    //Gjør om treet til et array
    ArrayList<Integer> data = tre.serialize();

    //Lag nytt tre fra arrayet over
    SBinTre<Integer> tre2 = SBinTre.deserialize(data, Comparator.naturalOrder());

    //Utskriften av tre og tre2 skal være identiske
    System.out.println(tre.toStringPostOrder());
    System.out.println(tre2.toStringPostOrder());
     */

    public ArrayList<T> serialize() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


} // ObligSBinTre
