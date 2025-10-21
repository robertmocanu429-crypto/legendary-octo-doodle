   public class Aufgabe04_2 {
    public static void main (String[] args){

        //Deklaration und Initialisierung der symbolischen Konstanten
        final double STUNDENSATZ = 120.0, KM_PAUSCHALE = 0.75;

        //Dasselbe mit : final double STUNDENSATZ = 120.0;
                       //final double KM_PAUSHCHALE = 0.75;
        //Deklaration der Variablen
        int geleisteteStunden, gefahreneKM;
        double arbeitskosten, fahrtkosten, gesamtkosten;

        //Einlesen der Eingabewerte
        geleisteteStunden = Tastatur.liesINT("Anzahl der Arbeitsstunden: ");
        gefahreneKM = Tastatur.liesINT("Anzahl der gefahrenden Kilometer: ");
        
        //Verarbeitung
        arbeitskosten = geleisteteStunden * STUNDENSATZ;
        fahrtkosten = gefahreneKM * KM_PAUSCHALE;
        gesamtkosten = arbeitskosten + fahrtkosten;
        
        //Ausgabe der Ergebnisse
        System.out.println("Arbeitszeit : " + geleisteteStunden + " Stunden zu je " + STUNDENSATZ + "EUR = " + arbeitskosten +  " EUR");
        System.out.println();
        
        System.out.println("Fahrtkosten : " + gefahreneKM + " km zu je " + KM_PAUSCHALE + " EUR = " + fahrtkosten +  " EUR");
        System.out.println();
        
        System.out.println("Gesamtkosten : " + gesamtkosten + " EUR");
        System.out.println();
        



    }
}
