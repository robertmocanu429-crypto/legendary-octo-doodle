package org.example;

// package hilfen;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;

/**
 Liefert Methoden zur Eingabe von Tastatur für die Basisdatentypen und für Strings.
 Erweitert um zusätzliche Methoden.
 @author:  Raymond Fleck, WI, FBW, FHH
 @version: 2002/04/04
 */
public class Tastatur {
    
    /**
     Anzahl der maximal möglichen fehlerhaften Eingaben, bevor Eingabe mit
     NumberFormatException beendet wird.
     */
    static final private int MAX_VERSUCHE = 3;
    
    /**
     Gibt an, dass ein byte-Wert eingelesen werden soll.
     */  
    static final private int BYTE_TYP    = 1;  
    
    /**
     Gibt an, dass ein short-Wert eingelesen werden soll.
     */  
    static final private int SHORT_TYP   = 2;  
    
    /**
     Gibt an, dass ein int-Wert eingelesen werden soll.
     */  
    static final private int INT_TYP     = 3;  
    
    /**
     Gibt an, dass ein long-Wert eingelesen werden soll.
     */  
    static final private int LONG_TYP    = 4;  
    
    /**
     Gibt an, dass ein float-Wert eingelesen werden soll.
     */  
    static final private int FLOAT_TYP   = 5;  
    
    /**
     Gibt an, dass ein double-Wert eingelesen werden soll.
     */  
    static final private int DOUBLE_TYP  = 6;    
    
    /**
     Hilfsmethode für die Einlesemethoden.
     @param et Der als Eingabeaufforderung anzuzeigende Text.
     @return Die eingegebenen Zeichen als ein String.
     */  
    private static String einleseHilfe(String et, InputStream is)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
        String hilfeString = " ";
        char [] eingabe = new char[21];
        
        try {
            if ( et.length() != 0 )
                System.out.print(et);
            br.read(eingabe);
            hilfeString= String.copyValueOf(eingabe).trim();
        }
        catch (java.io.IOException e) {
            System.out.println("IOException in Tastatur.einleseHilfe()");
            hilfeString = "Eingabefehler";
        }
        finally {
            System.out.println("<Eingabe : " + hilfeString + ">");
            return(hilfeString);
        }
    }
    
    /**
     Hilfsmethode für das Einlesen von ganzen Zahlen.
     @param et Der als Eingabeaufforderung anzuzeigende Text.
     @param datentyp Datentyp des einzugebenden Wertes.
     @return Der eingegebene Wert.
     */  
    private static long liesGanzeZahl(String et, int datentyp, InputStream is)
    {
        long wert = 0;
        int errNr = 0;
        boolean korrekt = false;
        String typ;
        
        switch ( datentyp ) {
            case BYTE_TYP : typ = "byte";
            break;
            case SHORT_TYP: typ = "short";
            break;
            case INT_TYP  : typ = "int";
            break;
            case LONG_TYP : typ = "long";
            break;
            default       : typ = "";
            break;
        }
        
        while ( !korrekt ) {
            try {
                switch ( datentyp ) {
                    case BYTE_TYP : wert = Byte.parseByte(einleseHilfe(et, is));
                    break;
                    case SHORT_TYP: wert = Short.parseShort(einleseHilfe(et, is));
                    break;
                    case INT_TYP  : wert = Integer.parseInt(einleseHilfe(et, is));
                    break;
                    case LONG_TYP : wert = Long.parseLong(einleseHilfe(et, is));
                    break;
                }
                korrekt = true;
            }
            catch (NumberFormatException nfe) {
                errNr++;
                System.out.println("Fehlerhafter " + typ + "-Wert (evtl. leer, Punkt, Komma, zu gro�/klein)!!");   
            }
            if (errNr == MAX_VERSUCHE) {
                throw new NumberFormatException("Nach " + MAX_VERSUCHE + " Fehlversuchen beendet!");    
            }
        }
        
        return wert;
    }
    
    /**
     Hilfsmethode für das Einlesen von reellen Zahlen.
     @param et Der als Eingabeaufforderung anzuzeigende Text.
     @param datentyp Datentyp des einzugebenden Wertes.
     @return Der eingegebene Wert.
     */    
    private static double liesReelleZahl(String et, int datentyp, InputStream is)
    {
        double wert = 0;
        int errNr = 0;
        boolean korrekt = false;
        String typ;
        
        switch ( datentyp ) {
            case FLOAT_TYP : typ = "float";
            break;
            case DOUBLE_TYP: typ = "double";
            break;
            default       : typ = "";
            break;
        }
        
        while ( !korrekt ) {
            try {
                switch ( datentyp ) {
                    case FLOAT_TYP : wert = new Float(einleseHilfe(et, is)).floatValue();
                    break;
                    case DOUBLE_TYP: wert = new Double(einleseHilfe(et, is)).doubleValue();
                    break;
                }
                korrekt = true;
            }
            catch (NumberFormatException nfe) {
                errNr++;
                System.out.println("Fehlerhafter " + typ + "-Wert (evtl. leer, Komma statt Punkt)!!");   
            }
            if (errNr == MAX_VERSUCHE) {
                throw new NumberFormatException("Nach " + MAX_VERSUCHE + " Fehlversuchen beendet!");    
            }
        }
        
        return wert;
    }
    
    /**
     Liest einen byte-Wert ein.
     @return Eingelesener Wert.
     */
    public static byte liesByte()
    {
        return liesByte(System.in, "");
    }
    
    /**
     Liest einen short-Wert ein.
     @return Eingelesener Wert.
     */
    public static short liesShort()
    {
        return liesShort(System.in, "");
    }
    
    /**
     Liest einen int-Wert ein.
     @return Eingelesener Wert.
     */
    public static int liesInt()
    {
        return liesInt(System.in, "");
    }
    
    /**
     Liest einen long-Wert ein.
     @return Eingelesener Wert.
     */
    public static long liesLong()
    {
        return liesLong(System.in, "");
    }
    
    /**
     Liest einen float-Wert ein.
     @return Eingelesener Wert.
     */
    public static float liesFloat()
    {
        return liesFloat(System.in, "");
    }
    
    /**
     Liest einen double-Wert ein.
     @return Eingelesener Wert.
     */
    public static double liesDouble()
    {
        return liesDouble(System.in, "");
    }
    
    /**
     Liest einen boolean-Wert ein.
     @return Eingelesener Wert.
     */
    public static boolean liesBoolean()
    {
        return liesBoolean("");
    }
    
    /**
     Liest einen char-Wert ein.
     @return Eingelesener Wert.
     */
    public static char liesChar()
    {
        return liesChar(System.in, "");
    }
    
    /**
     Liest einen String ein.  
     @return Eingelesener Wert.
     */
    public static String liesString()
    {
        return liesString("");
    }
    
    
    /**
     Liest einen byte-Wert ein.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */
    public static byte liesByte(String et)
    {
        return liesByte(System.in, et);
    }
    
    /**
     Liest einen short-Wert ein.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesenerr Wert.
     */
    public static short liesShort(String et)
    {
        return liesShort(System.in, et);
    }
    
    /**
     Liest einen int-Wert ein.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */
    public static int liesInt(String et)
    {
        return liesInt(System.in, et);
    }
    
    /**
     Liest einen long-Wert ein.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */
    public static long liesLong(String et)
    {
        return liesLong(System.in, et);
    }
    
    /**
     Liest einen float-Wert ein.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */
    public static float liesFloat(String et)
    {
        return liesFloat(System.in, et);
    }
    
    /**
     Liest einen double-Wert ein.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */
    public static double liesDouble(String et)
    {
        return liesDouble(System.in, et);
    }
    
    /**
     Liest einen boolean-Wert ein.
     true, t oder T wird als Eingabe für true akzeptiert.
     Alle anderen Werte werden als false behandelt.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */
    public static boolean liesBoolean(String et)
    {
        return liesBoolean(System.in, et);
    }
    
    /**
     Liest einen char-Wert ein.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */
    public static char liesChar(String et)
    {
        return liesChar(System.in, et);
    }
    
    /**
     Liest einen String ein.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */
    public static String liesString(String et)
    {
        return liesString(System.in, et);
    }
    
    /**
     Liest einen byte-Wert ein.
     @param in Der verwendete InputStream.
     @return Eingelesener Wert.
     */
    public static byte liesByte(InputStream in)
    {
        return liesByte(in, "");
    }  
    
    /**
     Liest einen short-Wert ein.
     @param in Der verwendete InputStream.
     @return Eingelesener Wert.
     */
    public static short liesShort(InputStream in)
    {
        return liesShort(in, "");
    }  
    
    /**
     Liest einen int-Wert ein.
     @param in Der verwendete InputStream.
     @return Eingelesener Wert.
     */
    public static int liesInt(InputStream in)
    {
        return liesInt(in, "");
    }  
    
    /**
     Liest einen long-Wert ein.
     @param in Der verwendete InputStream.
     @return Eingelesener Wert.
     */  
    public static long liesLong(InputStream in)
    {
        return liesInt(in, "");
    }  
    
    /**
     Liest einen float-Wert ein.
     @param in Der verwendete InputStream.
     @return Eingelesener Wert.
     */  
    public static float liesFloat(InputStream in)
    {
        return liesFloat(in, "");
    }  
    
    /**
     Liest einen double-Wert ein.
     @param in Der verwendete InputStream.
     @return Eingelesener Wert.
     */  
    public static double liesDouble(InputStream in)
    {
        return liesDouble(in, "");
    }  
    
    /**
     Liest einen char-Wert ein.
     @param in Der verwendete InputStream.
     @return Eingelesener Wert.
     */  
    public static char liesChar(InputStream in)
    {
        return liesChar(in, "");
    }  
    
    /**
     Liest einen boolean-Wert ein.
     @param in Der verwendete InputStream.
     @return Eingelesener Wert.
     */  
    public static boolean liesBoolean(InputStream in)
    {
        return liesBoolean(in, "");
    }  
    
    /**
     Liest einen String ein.
     @param in Der verwendete InputStream.
     @return Eingelesener Wert.
     */  
    public static String liesString(InputStream in)
    {
        return liesString(in, "");
    }  
    
// Hier sind die tats�chlichen Aufrufe der Hilfsmethoden bzw. Eingabe enthalten   
    /**
     Liest einen byte-Wert ein.
     @param in Der verwendete InputStream.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */
    public static byte liesByte(InputStream in, String et)
    {
        return (byte)liesGanzeZahl(et, BYTE_TYP, in);
    }   
    
    /**
     Liest einen Short-Wert ein.
     @param in Der verwendete InputStream.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */  
    public static short liesShort(InputStream in, String et)
    {
        return (short)liesGanzeZahl(et, SHORT_TYP, in);
    }   
    
    /**
     Liest einen int-Wert ein.
     @param in Der verwendete InputStream.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */
    public static int liesInt(InputStream in, String et)
    {
        return (int)liesGanzeZahl(et, INT_TYP, in);
    }
    
    /**
     Liest einen long-Wert ein.
     @param in Der verwendete InputStream.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */  
    public static long liesLong(InputStream in, String et)
    {
        return liesGanzeZahl(et, LONG_TYP, in);
    }     
    
    /**
     Liest einen float-Wert ein.
     @param in Der verwendete InputStream.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */  
    public static float liesFloat(InputStream in, String et)
    {
        return (float)liesReelleZahl(et, FLOAT_TYP, in);
    }   
    
    /**
     Liest einen double-Wert ein.
     @param in Der verwendete InputStream.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */  
    public static double liesDouble(InputStream in, String et)
    {
        return liesReelleZahl(et, DOUBLE_TYP, in);
    }   
    
    /**
     Liest einen char-Wert ein.
     @param in Der verwendete InputStream.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */  
    public static char liesChar(InputStream in, String et)
    {
        String s = einleseHilfe(et, in);
        while (s.length() == 0 ) {
            s = einleseHilfe(et, in);
        }
        return s.charAt(0);
    }   
    
    /**
     Liest einen boolean-Wert ein.
     @param in Der verwendete InputStream.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */  
    public static boolean liesBoolean(InputStream in, String et)
    {
        String s = einleseHilfe(et, in);
        Boolean b;
        
        if ( s.equals("t") || s.equals("T") )     
            b = new Boolean("true");
        else
            b = new Boolean(s);
        
        return(b.booleanValue());  
    }
    
    /**
     Liest einen String ein.
     @param in Der verwendete InputStream.
     @param et Wird dem Anwender als Eingabeaufforderung angezeigt.
     @return Eingelesener Wert.
     */
    public static String liesString(InputStream in, String et)
    {
        BufferedReader d = new BufferedReader(new InputStreamReader(in));
        String s;
        
        try {
            System.out.print(et);
            s = d.readLine();
        }
        catch (IOException ioe) {
            s = "?";
        }
        
        System.out.println("<Eingabe : " + s + ">");
        return s;
    } 
    
    /**
     Warte auf eine beliebige Eingabe, um dann weiterzulaufen.
     */    
    public static void pause()
    {
        liesChar();
    }
    
}

