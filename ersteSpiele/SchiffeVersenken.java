
import java.util.Scanner;
public class SchiffeVersenken
{
    private boolean[][] Spielerschiffe;
    private boolean[][] Computerschiffe;
    private boolean[][] Spielereingegeben;
    private boolean[][] Computereingegeben;
    private String[] kasten;
    private String[] kreuz;
    private String[] markiert;
    private int counter;
    private Scanner scanner;
    public SchiffeVersenken()
    {
        counter=0;
        scanner=new Scanner(System.in);
        Spielerschiffe=new boolean[5][5];
        Computerschiffe=new boolean[5][5];
        Spielereingegeben=new boolean[5][5];
        Computereingegeben=new boolean[5][5];
        kasten=new String[6];
        kreuz=new String[6];
        markiert=new String[6];
        kasten[0]="------";
        kasten[1]="|    |";
        kasten[2]="|    |";
        kasten[3]="|    |";
        kasten[4]="|    |";
        kasten[5]="------";

        kreuz[0]="------";
        kreuz[1]="|\\  /|";
        kreuz[2]="| \\/ |";
        kreuz[3]="| /\\ |";
        kreuz[4]="|/  \\|";
        kreuz[5]="------";

        markiert[0]="------";
        markiert[1]="|    |";
        markiert[2]="| /\\ |";
        markiert[3]="| \\/ |";
        markiert[4]="|    |";
        markiert[5]="------";

        while(counter<5)
        {
            int random1=Integer.parseInt(String.valueOf(Math.round(Math.random()*4)));
            int random2=Integer.parseInt(String.valueOf(Math.round(Math.random()*4)));
            if(Computerschiffe[random2][random1]!=true)
            {
                Computerschiffe[random2][random1]=true;
                counter=counter+1;
            }
        }
    }

    public void start()
    {
        System.out.println("Das Feld ist 5*5 groß.");
        System.out.println("Rate die Schiffe des Gegners, indem du die Koordinaten eingibst (Beispiel: 5 enter, 7 enter).");
        System.out.println("Achte darauf das die erste Zahl die du eingibst die Reihen und die Zweite die Zeilen sind.");
        System.out.println("Aber als erstes musst du deine Schiffe platzieren.");
        System.out.println("Du hast 5 Schiffe. Platziere sie, indem du , wie beim Raten, die Koordinaten eingibst");
        spielplanAusgeben();
        schiffeEingeben();
        System.out.println("So jetzt kann es losgehen. Alle Schiffe sind platziert, die des Gegners unsichtbar!");
        schiffeRaten();
    }

    private void schiffeEingeben()
    {
        counter=0;
        while(counter<5)
        {
            System.out.println("Die x-Koordinate bitte eingeben.");
            int x=scanner.nextInt();
            if(x==0)
            {
                System.exit(0);
            }
            System.out.println("Die y-Koordinate bitte eingeben.");
            int y=scanner.nextInt();
            if(y==0)
            {
                System.exit(0);
            }
            if(Spielerschiffe[y-1][x-1]!=true)
            {
                Spielerschiffe[y-1][x-1]=true;
                counter=counter+1;
                spielplanAusgeben();
            }else
            {
                System.out.println("Dieses Schiff ist schon platziert");
            }
        }
    }

    private void spielplanAusgeben()
    {
        System.out.println(" ".repeat(8)+"Dein Spielplan"+" ".repeat(22)+"Computer");
        for(int anzahl=0;anzahl<5;++anzahl){
            for(int zeile=0;zeile<6;++zeile)
            {
                for(int reihe=0;reihe<5;++reihe)
                {
                    if(Spielerschiffe[reihe][anzahl]==true)
                    {if(Spielerschiffe[reihe][anzahl]==Computereingegeben[reihe][anzahl])
                        {
                            System.out.print(kreuz[zeile]);
                        }else
                        {
                            System.out.print(markiert[zeile]);
                        }
                    }
                    else
                    {
                        if(Computereingegeben[reihe][anzahl]==true)
                        {
                            System.out.print(kreuz[zeile]);}
                        else
                        {
                            System.out.print(kasten[zeile]);
                        }
                    }
                }
                for(int reihe=0;reihe<5;++reihe)
                {
                    if(Computerschiffe[reihe][anzahl]==true){
                        if(Computerschiffe[reihe][anzahl]==Spielereingegeben[reihe][anzahl])
                        {
                            System.out.print("  ");
                            System.out.print(markiert[zeile]);
                        }else
                        {
                            System.out.print("  ");
                            System.out.print(kasten[zeile]);
                        }
                    }
                    else
                    {if(Spielereingegeben[reihe][anzahl]==true)
                        {
                            System.out.print("  ");
                            System.out.print(kreuz[zeile]);
                        }
                        else{
                            System.out.print("  ");
                            System.out.print(kasten[zeile]);
                        }
                    }
                }
                System.out.println(" ");
            }
        }
    }

    private void schiffeRaten()
    {
        int Spielerleben=5;
        int Computerleben=5;
        while(Spielerleben>0){
            System.out.println("Du bist dran. Gebe deine geschätzten Koordinaten ein wo sich das gegnerische Schiff aufhält.");
            System.out.println("Als erstes x dann y");
            int x=scanner.nextInt();
            x=x-1;
            int y=scanner.nextInt();
            y=y-1;
            if(Spielereingegeben[y][x]!=true)
            {
                Spielereingegeben[y][x]=true;
                if(Spielereingegeben[y][x]==Computerschiffe[y][x])
                {
                    Computerleben=Computerleben-1;
                    System.out.println("SCHIFF VERSENKT");
                    spielplanAusgeben();
                }
                else
                {
                    System.out.println("Nicht getroffen");
                    spielplanAusgeben();
                }
            }
            else
            {
                Spielereingegeben[y][x]=true;
                System.out.println("Das hast du bereits probiert. Pech gehabt, ein Versuch verschwendet");
                spielplanAusgeben();
            }
            System.out.println("Jetzt ist der Computer dran");
            x=Integer.parseInt(String.valueOf(Math.round(Math.random()*4)));
            y=Integer.parseInt(String.valueOf(Math.round(Math.random()*4)));
            if(Computereingegeben[y][x]!=true)
            {
                Computereingegeben[y][x]=true;
                if(Computereingegeben[y][x]==Spielerschiffe[y][x])
                {
                    Spielerleben=Spielerleben-1;
                    System.out.println("SCHIFF VERSENKT");
                    spielplanAusgeben();
                }
                else
                {
                    System.out.println("Nicht getroffen");
                    spielplanAusgeben();
                }
            }
            else
            {
                Computereingegeben[y][x]=true;
                System.out.println("Das hat er bereits probiert. Glück gehabt, er schenkt dir eine Runde");
                spielplanAusgeben();
            }
            if(Computerleben==0)
            {
                System.out.println("Du hast gewonnen. Herzlichen Glückwunsch ;-)");
                Spielerleben=0;
            }
        }
    }
}