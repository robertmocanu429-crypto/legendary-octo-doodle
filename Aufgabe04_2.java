   public class Aufgabe04_2 {
    public static void main (String[] args){

        int Stunden_Arbeitszeit;
        double Betrag_pro_Stunde;
        double Summe_Arbeitszeit;
        int Kilometer;
        double Betrag_pro_Km;
        double Summe_Fahrtkosten;
        double Gesamtkosten;

        Stunden_Arbeitszeit = 70;
        Betrag_pro_Stunde = 120.0;
        Summe_Arbeitszeit = Stunden_Arbeitszeit * Betrag_pro_Stunde;

        Kilometer = 490;
        Betrag_pro_Km = 0.75;
        Summe_Fahrtkosten = Kilometer * Betrag_pro_Km;

        Gesamtkosten = Summe_Arbeitszeit + Summe_Fahrtkosten;

        System.out.println("\n" + "Arbeitszeit: " + Stunden_Arbeitszeit + " Stunden zu je " + Betrag_pro_Stunde + " EUR ergibt " + Summe_Arbeitszeit + " EUR." + "\n\n" + "Fahrtkosten: " + Kilometer + " km zu je " + Betrag_pro_Km + " EUR ergibt " + Summe_Fahrtkosten + " EUR." + "\n\n" + "Gesamtkosten: " + Gesamtkosten + " EUR." + "\n");


    }
}
