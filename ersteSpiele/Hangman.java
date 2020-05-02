
import java.util.Scanner;
public class Hangman
{
    private  String[][] männchen;
    private boolean istGefunden;
    private String[] wörter;
    private int leben;
    private String[] ausprobierte;
    int rundenanzahl;
    int zufall; 
    String gescannt;
    Scanner scanner=new Scanner(System.in);
    public Hangman()
    {
        männchen=new String[6][7];
        männchen[0][0]="  ---   ";
        männchen[0][1]=" |   |  ";
        männchen[0][2]=" |   O  ";
        männchen[0][3]=" |  -|- ";
        männchen[0][4]=" |  / \\ ";
        männchen[0][5]=" |      ";
        männchen[0][6]="---     ";

        männchen[1][0]="  ---   ";
        männchen[1][1]=" |   |  ";
        männchen[1][2]=" |   O  ";
        männchen[1][3]=" |  -|- ";
        männchen[1][4]=" |      ";
        männchen[1][5]=" |      ";
        männchen[1][6]="---     ";

        männchen[2][0]="  ---   ";
        männchen[2][1]=" |   |  ";
        männchen[2][2]=" |   O  ";
        männchen[2][3]=" |   |  ";
        männchen[2][4]=" |      ";
        männchen[2][5]=" |      ";
        männchen[2][6]="---     ";

        männchen[3][0]="  ---   ";
        männchen[3][1]=" |   |  ";
        männchen[3][2]=" |   O  ";
        männchen[3][3]=" |      ";
        männchen[3][4]=" |      ";
        männchen[3][5]=" |      ";
        männchen[3][6]="---     ";

        männchen[4][0]="  ---   ";
        männchen[4][1]=" |   |  ";
        männchen[4][2]=" |      ";
        männchen[4][3]=" |      ";
        männchen[4][4]=" |      ";
        männchen[4][5]=" |      ";
        männchen[4][6]="---     ";

        männchen[5][0]="  ---   ";
        männchen[5][1]=" |      ";
        männchen[5][2]=" |      ";
        männchen[5][3]=" |      ";
        männchen[5][4]=" |      ";
        männchen[5][5]=" |      ";
        männchen[5][6]="---     ";
        wörter=new String[20];
        wörter[0]="Hase";
        wörter[1]="Bahnlinie";
        wörter[2]="Quarantäne";
        wörter[3]="Äpfel";
        wörter[4]="Uhr";
        wörter[5]="Eskorte";
        wörter[6]="Armbanduhr";
        wörter[7]="Wind";
        wörter[8]="Federmäppchen";
        wörter[9]="Türschloss";
        wörter[10]="Brioche";
        wörter[11]="Handy";
        wörter[12]="Buch";
        wörter[13]="Baumstütze";
        wörter[14]="Garagendach";
        wörter[15]="Lautsprecher";
        wörter[16]="Auto";
        wörter[17]="Programm";
        wörter[18]="Minister";
        wörter[19]="Präsident";
    }

    public void start()
    {
        zufall=Integer.parseInt(String.valueOf(Math.round(Math.random()*wörter.length)));
        ausprobierte=new String[26];
        leben=5;
        rundenanzahl=1;

        istGefunden=false;
        System.out.println("Willkommen zu Hangman.");
        System.out.println("Die Regeln: 1.Tippe den Buchstaben ein der deiner Meinung nach in dem gesuchten Wort vorkommt");
        System.out.println("            2.Hab Spaß");
        System.out.println("");
        for(int zeile=0;zeile<7;++zeile)
        {
            if(zeile!=0)
            {
                System.out.println(männchen[5][zeile]);
            }else
            {
                System.out.print(männchen[5][zeile]);
                System.out.println("                 Leben:"+leben);
            }
        }
        System.out.println("-".repeat(31));
        System.out.println("Das gesuchte Wort ist :"+"_".repeat(wörter[zufall].length()-1));
        System.out.println("-".repeat(31));
        System.out.println("Ihr Versuch:");

        while(leben>0)
        {
            schleife();
            if(leben==0)
            {
                System.out.println("Du hast verloren. Das richtige Wort wäre '"+wörter[zufall]+"' gewesen");
            }
        }
    }

    private void schleife()
    {
        if(rundenanzahl!=1)
        {
            System.out.print("Bereits eingegeben;");

            for(int anzahl=0;anzahl<ausprobierte.length;++anzahl)
            {
                if(ausprobierte[anzahl]!=null)
                {
                    System.out.print(ausprobierte[anzahl]+";");
                }
                if(anzahl==ausprobierte.length-1)
                {
                    System.out.println("");
                }
            }
            System.out.print("Momentanes Wort:");
            int count =0;
            int countBeiFalsch=0;
            for(int index=0;index<wörter[zufall].length();++index)
            {       

                count =0;
                countBeiFalsch=0;
                for(int buchstabe=0;buchstabe<ausprobierte.length;++buchstabe)
                {   
                    if(ausprobierte[buchstabe]!=null)
                    {
                        if(String.valueOf(wörter[zufall].charAt(index)).equalsIgnoreCase(ausprobierte[buchstabe]))
                        {
                            System.out.print(ausprobierte[buchstabe]);
                        }else
                        {
                            countBeiFalsch=countBeiFalsch+1;
                        }
                        count=count+1;
                    }

                }
                if(count==countBeiFalsch)
                {
                    System.out.print("_");
                }
            }
            System.out.println("");
        }
        gescannt=scanner.next();

        int countbeidoppelt=0;
        for(int buchstabe=0;buchstabe<ausprobierte.length;++buchstabe)
        {
            if(ausprobierte[buchstabe]!=null)
            {
                if(gescannt.equalsIgnoreCase(ausprobierte[buchstabe]))
                {
                    countbeidoppelt=countbeidoppelt+1;
                }

            }
        }
        if(0==countbeidoppelt)
        {
            ausprobierte[rundenanzahl-1]=gescannt;
        }else
        {
            System.out.println("Das hast du bereits eingegeben!");
        }
        if(gescannt.equalsIgnoreCase("0"))
        {
            System.exit(0);
        }
        istGefunden=false;
        for(int index=0;index<wörter[zufall].length();++index )
        {
            if(gescannt.equalsIgnoreCase(String.valueOf(wörter[zufall].charAt(index))))
            {
                istGefunden=true;

            }
        }
        if(istGefunden==true)
        {
            System.out.println("richtig");
            for(int index=0;index<7;++index)
            {
                System.out.println(männchen[leben][index]);
            }
        }else
        {
            System.out.println("Falsch");
            leben=leben-1;
            System.out.println("Jetzt hast du nur noch "+leben+" Leben. Setze sie weise ein.");
            for(int index=0;index<7;++index)
            {
                System.out.println(männchen[leben][index]);
            }
        }
        int zähler =0;
        for(int index=0;index<wörter[zufall].length();++index)
        {       

            for(int buchstabe=0;buchstabe<ausprobierte.length;++buchstabe)
            {   
                if(ausprobierte[buchstabe]!=null)
                {
                    if(String.valueOf(wörter[zufall].charAt(index)).equalsIgnoreCase(ausprobierte[buchstabe]))
                    {
                        zähler=zähler+1;
                    }
                }
            }

        }
        if(zähler==wörter[zufall].length())
        {
            System.out.println("Du hast gewonnen!");
            System.out.println("Glückwunsch du konntest das richtige Wort:"+wörter[zufall]+", finden und das mit "+leben+" Leben übrig!");
            leben=-1;

        }

        rundenanzahl=rundenanzahl+1;
    }
}
