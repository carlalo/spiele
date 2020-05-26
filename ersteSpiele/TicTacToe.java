import java.util.Scanner;
public class TicTacToe
{
    private Scanner scanner;
    private String[] kasten;
    private String[] player;
    private String[] computer;
    private int eingabe;
    private boolean[]spieler;
    private boolean[]rechner;
    private int counter;
    private boolean inReiheSpieler;
    private boolean inReiheComputer;
    private int runde;
    public TicTacToe()
    {
        scanner=new Scanner(System.in);
        kasten=new String[6];
        player=new String[6];
        computer=new String[6];
        spieler=new boolean[9];
        rechner=new boolean[9];
        kasten[0]="---------";
        kasten[1]="|       |";
        kasten[2]="|       |";
        kasten[3]="|       |";
        kasten[4]="|       |";
        kasten[5]="---------";

        player[0]="---------";
        player[1]="|  \\  / |";
        player[2]="|   \\/  |";
        player[3]="|   /\\  |";
        player[4]="|  /  \\ |";
        player[5]="---------";

        computer[0]="---------";
        computer[1]="|       |";
        computer[2]="|   /\\  |";
        computer[3]="|   \\/  |";
        computer[4]="|       |";
        computer[5]="---------";

        runde=0;
    }

    public void start()
    {
        System.out.println("Herzlich Willkommen zu Tic Tac Toe");
        System.out.println("Das Ziel: Dein Symbol in eine 3-Reihe bekommen");
        System.out.println("Um ein Symbol einzugeben gehe wie folgt vor: Es wird von ganz oben links gezählt");
        System.out.println("                                             Die Felder sind nummeriert von 1-9.(1 ist ganz oben links,9 ganz unten rechts)");
        System.out.println("                                             Gebe nun die Zahl für das gewünschte Feld ein");
        while(inReiheSpieler==false)
        {
            spielplanAusgeben();
            eingabe();
            inReiheSpieler();
            eingabeComp(runde);
            inReiheComputer();
            runde=runde+1;
        }
        spielplanAusgeben();
        if(inReiheComputer==false){
            System.out.println("Du hast gewonnen!");
        }
        else
        {
            System.out.println("Der Rechner gewinnt");
        }
    }

    private void spielplanAusgeben()
    {
        counter=0;
        for(int anzahl=0;anzahl<3;++anzahl)
        {
            for(int zeile=0;zeile<6;++zeile)
            { 
                counter=1+(3*anzahl);
                for(int reihe=0;reihe<3;++reihe)
                {

                    kasten[2]="|   "+counter+"   |";
                    if(spieler[counter-1]!=true)
                    {
                        if(rechner[counter-1]==true)
                        {
                            System.out.print(computer[zeile]);
                        }
                        else
                        {
                            System.out.print(kasten[zeile]);
                        }
                    }
                    else
                    {
                        System.out.print(player[zeile]);
                    }
                    counter=counter+1;
                }

                System.out.println("");
            }
        }
    }

    private void eingabe()
    {
        System.out.println("Du bist dran. Gebe jetzt deine Zahl ein");
        eingabe=scanner.nextInt();
        if(spieler[eingabe-1]!=true)
        { if(rechner[eingabe-1]==true)
            {
                System.out.println("Das ist bereits vergeben.");
            }
            else
            {
                spieler[eingabe-1]=true;
            }
        }else
        {
            System.out.println("Dieses Feld hast du schonmal ausprobiert");
        }
    }

    private void eingabeComp(int runde)
    {
        if(rechner[0]==true)
        {
            if(rechner[1]==true)
            {
                if(spieler[2]!=true) 
                {
                    rechner[2]=true;
                }
            }else
            {
                if(rechner[3]==true)
                {
                    if(spieler[6]!=true)
                    {
                        rechner[6]=true;
                    }
                }else
                {
                    if(rechner[4]==true)
                    {
                        if(spieler[8]!=true)
                        {
                            rechner[8]=true;
                        }
                    }
                    else
                    {
                        if(rechner[2]==true)
                        {
                            if(spieler[1]!=true)
                            {
                                rechner[1]=true;
                            }
                            else
                            {
                                if(rechner[3]==true)
                                {
                                    if(spieler[6]!=true)
                                    {
                                        rechner[6]=true;
                                    }
                                }
                            }
                        }

                    }
                }
                if(rechner[3]==true)
                {
                    if(rechner[4]==true)
                    {
                        if(spieler[5]!=true) 
                        {
                            rechner[5]=true;
                        }
                    }
                    if(rechner[5]==true)
                    {
                        if(spieler[4]!=true)
                        {
                            rechner[4]=true;
                        }
                    }
                }
                if(rechner[6]==true)
                {
                    if(rechner[7]==true)
                    {
                        if(spieler[8]!=true) 
                        {
                            rechner[8]=true;
                        }
                    }
                }

                if(rechner[1]==true)
                {
                    if(rechner[4]==true)
                    {
                        if(spieler[7]!=true) 
                        {
                            rechner[7]=true;
                        }
                    }
                }
                if(rechner[2]==true)
                {
                    if(rechner[5]==true)
                    {
                        if(spieler[8]!=true) 
                        {
                            rechner[8]=true;
                        }
                    }
                    else
                    {
                        if(rechner[4]==true)
                        {
                            if(spieler[6]!=true)
                            {
                                rechner[6]=true;
                            }
                        }else
                        {
                            if(rechner[6]==true)
                            {
                                if(spieler[4]!=true)
                                {
                                    rechner[4]=true;
                                }
                            }
                        }
                    }
                }
            }
            int random=Integer.parseInt(String.valueOf(Math.round(Math.random()*8)));
            if(spieler[random]!=true)
            {
                if(rechner[random]!=true)
                {
                    rechner[random]=true;
                }

            }
        }
    }

    private void inReiheSpieler()
    {
        inReiheSpieler=false;
        if(spieler[0]==true)
        {
            if(spieler[1]==true)
            {
                if(spieler[2]==true)
                {
                    inReiheSpieler=true;
                }
            }
        }
        if(spieler[3]==true)
        {
            if(spieler[4]==true)
            {
                if(spieler[5]==true)
                {
                    inReiheSpieler=true;
                }
            }
        }
        if(spieler[6]==true)
        {
            if(spieler[7]==true)
            {
                if(spieler[8]==true)
                {
                    inReiheSpieler=true;
                }
            }
        }
        if(spieler[0]==true)
        {
            if(spieler[3]==true)
            {
                if(spieler[6]==true)
                {
                    inReiheSpieler=true;
                }
            }
        }
        if(spieler[1]==true)
        {
            if(spieler[4]==true)
            {
                if(spieler[7]==true)
                {
                    inReiheSpieler=true;
                }
            }
        }
        if(spieler[2]==true)
        {
            if(spieler[5]==true)
            {
                if(spieler[8]==true)
                {
                    inReiheSpieler=true;
                }
            }
        }
        if(spieler[0]==true)
        {
            if(spieler[4]==true)
            {
                if(spieler[8]==true)
                {
                    inReiheSpieler=true;
                }
            }
        }
        if(spieler[2]==true)
        {
            if(spieler[4]==true)
            {
                if(spieler[6]==true)
                {
                    inReiheSpieler=true;
                }
            }
        }

    }

    private void inReiheComputer()
    {
        if(rechner[0]==true)
        {
            if(rechner[1]==true)
            {
                if(rechner[2]==true)
                {
                    inReiheComputer=true;
                    inReiheSpieler=true;
                }
            }
        }
        if(rechner[3]==true)
        {
            if(rechner[4]==true)
            {
                if(rechner[5]==true)
                {
                    inReiheComputer=true;
                    inReiheSpieler=true;
                }
            }
        }
        if(rechner[6]==true)
        {
            if(rechner[7]==true)
            {
                if(rechner[8]==true)
                {
                    inReiheComputer=true;
                    inReiheSpieler=true;
                }
            }
        }
        if(rechner[0]==true)
        {
            if(rechner[3]==true)
            {
                if(rechner[6]==true)
                {
                    inReiheComputer=true;
                    inReiheSpieler=true;
                }
            }
        }
        if(rechner[1]==true)
        {
            if(rechner[4]==true)
            {
                if(rechner[7]==true)
                {
                    inReiheComputer=true;
                    inReiheSpieler=true;
                }
            }
        }
        if(rechner[2]==true)
        {
            if(rechner[5]==true)
            {
                if(rechner[8]==true)
                {
                    inReiheComputer=true;
                    inReiheSpieler=true;
                }
            }
        }
        if(rechner[0]==true)
        {
            if(rechner[4]==true)
            {
                if(rechner[8]==true)
                {
                    inReiheComputer=true;
                    inReiheSpieler=true;
                }
            }
        }
        if(rechner[2]==true)
        {
            if(rechner[4]==true)
            {
                if(rechner[6]==true)
                {
                    inReiheComputer=true;
                    inReiheSpieler=true;
                }
            }
        }

    }
}