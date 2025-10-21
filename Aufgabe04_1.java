public class Aufgabe04_1 {
    public static void main (String[] args){

        //Variablen Deklarieren

        String bezeichnung;
        double einzelpreis;
        int anzahl;
        double gesamtpreis;

        //Eingabewerte einlesen
        bezeichnung = Tastatur.liesString("Bitte Bezeichnung eingeben: ");
        einzelpreis = Tastatur.liesDouble("Bitte Einzelpreis eingeben: ");
        anzahl = Tastatur.liesInt("Bitte Anzahl eingeben: ");
        //Ausgabe berechnen
        gesamtpreis = anzahl * einzelpreis;
        //Ergebnis ausgeben


        System.out.println(einzelpreis + " "  + bezeichnung + " zu je " + einzelpreis + "EUR kosten insgesamt " + gesamtpreis + " EUR.");
        }
    }
