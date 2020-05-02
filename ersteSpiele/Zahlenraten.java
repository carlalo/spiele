
import java.util.Scanner;
public class Zahlenraten
{
    private Scanner scanner;
    private int random;
    private int leben;
    public Zahlenraten()
    {
        scanner=new Scanner(System.in);
        random=Integer.parseInt(String.valueOf(Math.round(Math.random()*10)));
        leben=3;
    }

    public void start()
    {
        System.out.println("Ich denke mir eine Zahl zwischen 1 und 10 aus");
        System.out.println("Was ratest du ist meine Zahl? Gebe es ein");
        System.out.println("Du hast 3 Versuche");
        while(leben>=0)
        {

            if(leben==0)
            {
                System.out.println("Schade du konntest sie nicht erraten. Meine Zahl wäre "+random+" gewesen.");
                leben=-1;
            }
            if(leben>0){
                int eingabe =scanner.nextInt();
                if(eingabe==random)
                {
                    System.out.println("Super du hast meine Zahl erraten und das mit "+leben+" Leben übrig.");
                    leben=-1;
                }
                if(eingabe<random)
                {
                    System.out.println("Leider nicht richtig. Meine Zahl ist größer.");
                    leben=leben-1;
                    System.out.println("Leben: "+leben);
                }
                if(eingabe>random)
                {
                    System.out.println("Leider nicht richtig. Meine Zahl ist kleiner.");
                    leben=leben-1;
                    System.out.println("Leben: "+leben);
                }
            }
        }

    }
}
