
import java.util.Scanner;
public class Rechenspiel
{ 
    int count=1;
    int g=0;
    String ja="ja";
    String nein="nein";
    private int zähler=0;

    String einfach="e";
    String schwer="s";
    String extrem="x";
    String[][] diagramm;
    long[]zufall1=new long[12];
    long[]zufall2=new long[12];
    long[]eingabe=new long[12];
    Scanner s=new Scanner(System.in);

    public Rechenspiel()
    {

    }

    public void start(int anzahl)
    {
        diagramm=new String[anzahl+1][12];
        System.out.format("Das Spiel geht über %d Runden\n",anzahl);
        for(int runde=0;runde<anzahl;++runde){
            System.out.println(runde+1+".Runde");
            entscheidung();
            if(runde!=anzahl)
            {
                System.out.println("Wenn du nicht erneut spielen möchtest gebe 'n' ein");
                System.out.println("Wenn du stattdessen in die nächste Runde willst, gebe irgendwas Anderes ein.");
                Scanner r=new Scanner(System.in);
                String b=r.next();
                if("n".equalsIgnoreCase(b))
                {
                    System.out.println("Du kannst das Terminal nun schließen.");
                    System.exit(0);
                }
            }
        }
        System.out.println("Das Spiel ist nun zu Ende. Ich hoffe es war zufriedenstellend");
    }

    private void entscheidung(){

        System.out.println("Entscheide dich zwischen '(m)al' und '(g)eteilt'.");
        Scanner scanner=new Scanner(System.in);
        String a="";
        String b="g";
        String c="m";
        a=scanner.next();

        if(b.equalsIgnoreCase(a))
        {
            letsGoGeteilt();
        }
        else{
            if(c.equalsIgnoreCase(a))
            {
                letsGoMal();
            }
        }
    }

    private void letsGoMal()
    {System.out.println("Du hast dich für 'mal'entschieden");
        System.out.println("");
        System.out.println("Dir werden nun 10 Aufgaben gestellt.");
        System.out.println("Diese beantwortest du, indem du einfach die Antwort eintippst");
        System.out.println("Als erstes musst du dich entscheiden.");
        System.out.println("Wähle '(e)infach','(s)chwer'oder 'e(x)trem', indem du es eintippst!");
        String entscheidung=s.next();
        if(einfach.equalsIgnoreCase(entscheidung))
        {
            einfachMal();
        }
        else
        {
            if(schwer.equalsIgnoreCase(entscheidung))
            {
                schwerMal();
            }
            else
            {
                if(extrem.equalsIgnoreCase(entscheidung))
                {
                    extremMal();
                }
            }
        }
    }

    private void einfachMal(){
        zähler=0;
        System.out.println("Du hast dich für 'einfach' entschieden.Viel Spaß :-)");
        for(int i=1;i<11;i++){
            zufall1[i]=Math.round(Math.random()*9+1);
            zufall2[i]=Math.round(Math.random()*9+1);
            System.out.println("");
            System.out.println(""+i+".Aufgabe");
            System.out.println(""+zufall1[i]+"*"+""+zufall2[i]+"=");
            long richtigesErgebnis=zufall1[i]*zufall2[i];
            eingabe[i]=s.nextInt();

            if(eingabe[i]==g){
                System.out.println("Programm geschlossen. Sie können das Terminal nun schließen");
                System.exit(0);
            }else{
                if(eingabe[i]==richtigesErgebnis){
                    zähler=zähler+1;
                }
            }
        }

        ende(zähler);
        for(int i=1;i<11;i++){
            if(eingabe[i]!=zufall1[i]*zufall2[i]){
                System.out.println("");
                System.out.println(i+". Aufgabe:");
                System.out.println(""+zufall1[i]+"*"+zufall2[i]+"="+zufall1[i]*zufall2[i]);
                System.out.println("Deine Eingabe war:"+eingabe[i]);
            }
        }

        diagrammErstellen(count,zähler, " e  ");
        count =count+1;
    }

    private void extremMal(){
        zähler=0;
        System.out.println("Du hast dich für 'extrem' entschieden.Viel Spaß :-)");
        for(int i=1;i<11;i++){
            zufall1[i]=Math.round(Math.random()*99+1);
            zufall2[i]=Math.round(Math.random()*99+1);
            System.out.println("");
            System.out.println(""+i+".Aufgabe");
            System.out.println(""+zufall1[i]+"*"+""+zufall2[i]+"=");
            long richtigesErgebnis=zufall1[i]*zufall2[i];
            eingabe[i]=s.nextInt();

            if(eingabe[i]==g){
                System.out.println("Programm geschlossen. Sie können das Terminal nun schließen");
                System.exit(0);
            }else{
                if(eingabe[i]==richtigesErgebnis){
                    zähler=zähler+1;
                }
            }
        }

        ende(zähler);
        for(int i=1;i<11;i++){
            if(eingabe[i]!=zufall1[i]*zufall2[i]){
                System.out.println("");
                System.out.println(i+". Aufgabe:");
                System.out.println(""+zufall1[i]+"*"+zufall2[i]+"="+zufall1[i]*zufall2[i]);
                System.out.println("Deine Eingabe war:"+eingabe[i]);
            }
        }

        diagrammErstellen(count,zähler, " x  ");

        count =count+1;
    }

    private void schwerMal(){
        zähler=0;
        System.out.println("Du hast dich für 'schwer' entschieden.Viel Spaß :-)");
        for(int i=1;i<11;i++){
            zufall1[i]=Math.round(Math.random()*99+1);
            zufall2[i]=Math.round(Math.random()*9+1);
            System.out.println("");
            System.out.println(""+i+".Aufgabe");
            System.out.println(""+zufall1[i]+"*"+""+zufall2[i]+"=");
            long richtigesErgebnis=zufall1[i]*zufall2[i];
            eingabe[i]=s.nextInt();

            if(eingabe[i]==g){
                System.out.println("Programm geschlossen. Sie können das Terminal nun schließen");
                System.exit(0);
            }else{
                if(eingabe[i]==richtigesErgebnis){
                    zähler=zähler+1;
                }
            }
        }

        ende(zähler);
        for(int i=1;i<11;i++){
            if(eingabe[i]!=zufall1[i]*zufall2[i]){
                System.out.println("");
                System.out.println(i+". Aufgabe:");
                System.out.println(""+zufall1[i]+"*"+zufall2[i]+"="+zufall1[i]*zufall2[i]);
                System.out.println("Deine Eingabe war:"+eingabe[i]);
            }
        }

        diagrammErstellen(count,zähler, " s  ");

        count =count+1;
    }

    private void letsGoGeteilt()
    {System.out.println("Du hast dich für 'geteilt'entschieden.");
        System.out.println("");
        System.out.println("Dir werden nun 10 Aufgaben gestellt.");
        System.out.println("Diese beantwortest du, indem du einfach die Antwort eintippst");
        System.out.println("Als erstes musst du dich entscheiden.");
        System.out.println("Wähle '(e)infach','(s)chwer'oder 'e(x)trem', indem du es eintippst!");
        String entscheidung=s.next();
        if("e".equalsIgnoreCase(entscheidung))
        {
            einfachGeteilt();
        }
        else
        {
            if("s".equalsIgnoreCase(entscheidung))
            {
                schwerGeteilt();
            }
            else{
                if("x".equalsIgnoreCase(entscheidung))
                {
                    extremGeteilt();
                }
            }

        }
    }

    private void einfachGeteilt(){
        zähler=0;
        System.out.println("Du hast dich für 'einfach' entschieden.Viel Spaß :-)");
        long[] richtigesErgebnis=new long[11];
        for(int i=1;i<11;i++){
            zufall1[i]=Math.round(Math.random()*9+1);
            zufall2[i]=Math.round(Math.random()*9+1);

            richtigesErgebnis[i]=zufall1[i]*zufall2[i];
            System.out.println("");
            System.out.println(""+i+".Aufgabe");
            System.out.println(""+richtigesErgebnis[i]+"/"+""+zufall2[i]+"=");
            eingabe[i]=s.nextInt();

            if(eingabe[i]==g){
                System.out.println("Programm geschlossen. Sie können das Terminal nun schließen");
                System.exit(0);
            }else{
                if(eingabe[i]==zufall1[i]){
                    zähler=zähler+1;
                }
            }
        }
        ende(zähler);
        for(int i=1;i<11;i++){
            if(eingabe[i]!=richtigesErgebnis[i]/zufall2[i]){
                System.out.println("");
                System.out.println(i+". Aufgabe:");
                System.out.println(""+richtigesErgebnis[i]+"/"+zufall2[i]+"="+richtigesErgebnis[i]/zufall2[i]);
                System.out.println("Deine Eingabe war:"+eingabe[i]);
            }
        }

        diagrammErstellen(count,zähler, " e  ");

        count =count+1;
    }

    private void schwerGeteilt(){
        System.out.println("Du hast dich für 'extrem' entschieden.Viel Spaß :-)");
        zähler=0;
        long[] richtigesErgebnis=new long[11];
        for(int i=1;i<11;i++){
            zufall1[i]=Math.round(Math.random()*99+1);
            zufall2[i]=Math.round(Math.random()*9+1);

            richtigesErgebnis[i]=zufall1[i]*zufall2[i];
            System.out.println("");
            System.out.println(""+i+".Aufgabe");
            System.out.println(""+richtigesErgebnis[i]+"/"+""+zufall2[i]+"=");
            eingabe[i]=s.nextInt();

            if(eingabe[i]==g){
                System.out.println("Programm geschlossen. Sie können das Terminal nun schließen");
                System.exit(0);
            }else{
                if(eingabe[i]==zufall1[i]){
                    zähler=zähler+1;
                }
            }
        }
        ende(zähler);
        for(int i=1;i<11;i++){
            if(eingabe[i]!=richtigesErgebnis[i]/zufall2[i]){
                System.out.println("");
                System.out.println(i+". Aufgabe:");
                System.out.println(""+richtigesErgebnis[i]+"/"+zufall2[i]+"="+richtigesErgebnis[i]/zufall2[i]);
                System.out.println("Deine Eingabe war:"+eingabe[i]);
            }
        }

        diagrammErstellen(count, zähler, " s  ");

        count =count+1;
    }

    private void extremGeteilt(){
        System.out.println("Du hast dich für 'extrem' entschieden.Viel Spaß :-)");
        zähler=0;
        long[] richtigesErgebnis=new long[11];
        for(int i=1;i<11;i++){
            zufall1[i]=Math.round(Math.random()*99+1);
            zufall2[i]=Math.round(Math.random()*99+1);

            richtigesErgebnis[i]=zufall1[i]*zufall2[i];
            System.out.println("");
            System.out.println(""+i+".Aufgabe");
            System.out.println(""+richtigesErgebnis[i]+"/"+""+zufall2[i]+"=");
            eingabe[i]=s.nextInt();

            if(eingabe[i]==g){
                System.out.println("Programm geschlossen. Sie können das Terminal nun schließen");
                System.exit(0);
            }else{
                if(eingabe[i]==zufall1[i]){
                    zähler=zähler+1;
                }
            }
        }
        ende(zähler);
        for(int i=1;i<11;i++){
            if(eingabe[i]!=richtigesErgebnis[i]/zufall2[i]){
                System.out.println("");
                System.out.println(i+". Aufgabe:");
                System.out.println(""+richtigesErgebnis[i]+"/"+zufall2[i]+"="+richtigesErgebnis[i]/zufall2[i]);
                System.out.println("Deine Eingabe war:"+eingabe[i]);
            }
        }

        diagrammErstellen(count,zähler, " x  ");

        count =count+1;
    }

    private void ende(int zähler){
        System.out.println("");
        System.out.println("Dein Ergebnis:");
        System.out.println("Du hast "+zähler+" von 10 Aufgaben richtig gelöst.");
        System.out.println("Herzlichen Glückwunsch");
        System.out.println("");
        System.out.println("Nun die richtigen Ergebnisse für deine falschen Antworten");
        if(zähler==10){
            System.out.println("Oh alles richtig :-)");
        }
    }

    private void diagrammErstellen(int runde,int punktzahl, String schwierigkeitsgrad)
    {
        diagramm[0][0]="10|";
        diagramm[0][1]=" 9|";
        diagramm[0][2]=" 8|";
        diagramm[0][3]=" 7|";
        diagramm[0][4]=" 6|";
        diagramm[0][5]=" 5|";
        diagramm[0][6]=" 4|";
        diagramm[0][7]=" 3|";
        diagramm[0][8]=" 2|";
        diagramm[0][9]=" 1|";
        diagramm[0][10]="---";
        diagramm[0][11]="   ";

        diagramm[runde][0]="   |";
        diagramm[runde][1]="   |";
        diagramm[runde][2]="   |";
        diagramm[runde][3]="   |";
        diagramm[runde][4]="   |";
        diagramm[runde][5]="   |";
        diagramm[runde][6]="   |";
        diagramm[runde][7]="   |";
        diagramm[runde][8]="   |";
        diagramm[runde][9]="   |";
        diagramm[runde][10]="----";
        diagramm[runde][11]=" "+runde+"  ";
        if(punktzahl==10)
        {
            diagramm[runde][0]=" * |";
        }
        if(punktzahl>=9)
        {
            diagramm[runde][1]=" * |";
        }
        if(punktzahl>=8)
        {
            diagramm[runde][2]=" * |";
        }
        if(punktzahl>=7)
        {
            diagramm[runde][3]=" * |";
        }
        if(punktzahl>=6)
        {
            diagramm[runde][4]=" * |";
        }
        if(punktzahl>=5)
        {
            diagramm[runde][5]=" * |";
        }
        if(punktzahl>=4)
        {
            diagramm[runde][6]=" * |";
        }
        if(punktzahl>=3)
        {
            diagramm[runde][7]=" * |";
        }
        if(punktzahl>=2)
        {
            diagramm[runde][8]=" * |";
        }
        if(punktzahl>=1)
        {
            diagramm[runde][9]=" * |";
        }
        for(int zeile=0;zeile<=11;++zeile)
        {
            System.out.print(diagramm[0][zeile]);
            for(int index=1;index<=count;++index)
            {
                System.out.print(diagramm[index][zeile]);

            }
            System.out.println("");
        }
    }
} 

