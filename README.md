# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Andre Gregussen, s364562, s364562@oslomet.no


# Oppgavebeskrivelse

I oppgave 1 så gikk jeg frem ved å sjekke og kopiere over programmkode 5.2.3 a) fra kommpendiet.
Deretter gikk jeg frem ved å undersøke koden slik at jeg var sikker på at jeg forstod den.
Deretter endret jeg kun verdien til foreldrenoden ved opprettelsen av en ny node til q slik at den ble satt til riktig node.

I oppgave 2 så gikk jeg frem ved å sammenligne den nåværende peker-verdien med den ønskede verdien.
Hvis verdien vi lette etter var mindre enn verdien vi så på ville vi gå til venstre, og hvis den var større gikk vi til høyre.
For å utføre denne metoden brukte jeg comp.compare som jeg fant i kompendiet.
Hvis verdien ble funnet ville antallet øke og pekeren sendes til høyre ettersom at hvis en verdi er lik foreldren sin vil den plasseres som et høyre-barn.
Når vi hadde kjørt pekeren ut hele treet ville antallet bli returnert med antallet av verdien vi lette etter.

I oppgave 3 a) så gikk jeg frem ved å først sjekke om noden vi så på hadde barn.
Om noden hadde barn fulgte jeg regelen om først venstre-så høyre som gjelder for å finne rekkefølge i postorden.
Når vi hadde nådd en node som ikke har barn, har vi funnet første post-orden i treet.
Hvis rot-noden ikke har barn vil den returneres.

I oppgave 3 b) gikk jeg først frem ved å tegne ned et tre og sjekke alle mulige alternativer for hva som kan være neste node i post-orden.
Metoden sjekker først om treet er tom og isåfall returnerer null.
Deretter sjekker om noden har et høyre-søsken eller om noden er et høyre-barn, hvor foreldren isåfall vil være neste i post-orden.
Hvis ikke setter vi pekeren på noden sitt høyre-søsken og deretter bruker samme kode som i førstpostorden().
til slutt returnerer vi p.

I oppgave 4 gikk jeg frem ved å først gjøre den rekursive oppgaven ettersom dette var en oppgave som jeg følte var ganske enkel.
Det første jeg gjorde var å sette opp en metode for å sjekke om treet var tomt ved å sjekke p.
Deretter kjørte jeg et rekursivt kall på metoden for å sjekke venstre-barn, om det var tomt sjekket vi høyre.
Når noden vi sjekket til slutt ikke hadde barn vil den verdien returneres.

I oppgave a) gjorde jeg samme som i b) ved å først sjekke om treet var tomt, men siden vi ikke får inn noder, kalte jeg på metoden tom().
Deretter satte jeg en peker på rotnoden slik at jeg hadde en stopper til når vi løp gjennom treet.
Ved å kalle på metoden førstePostorden() fant jeg den første noden i post-orden, og sender den videre.
Deretter satte jeg opp en løkke som løp gjennom nodene i treet med roten som stopper.
I løkken finner vi først første postorden fra noden vi er på, deretter sender vi den videre.
