import java.util.Scanner;
import java.util.ArrayList;
public class Magarin_Cameron_Lab11ListMaker {
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        final String menu = "A - Add D - Delete P - Print Q - Quit";
        boolean done = false;
        String cmd = "";
        String aChoice = "";
        int dChoice;
        do{
            displayList();

            cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase(); //Forces user input to be uppercase regardless 

            switch(cmd)//stores the commands for all the different menu options
            {
                case "A":
                    System.out.println("Please enter your input for the list");
                    aChoice = SafeInput.getNonZeroLenString(in, "Input is: ");
                    list.add(aChoice);
                    break;
                case "D":
                    System.out.println("Please enter the value that you want to delete");
                    dChoice = SafeInput.getRangedInt(in, "Which value do you want to delete?", 0, 100);
                    list.remove(dChoice -1);// -1 is there because arrays are zero based
                    break;
                case"P":
                displayList();
                    break;
                case"Q":
                    System.exit(0);
                    break;
            }
            System.out.println("Cmd is " + cmd);
        }while(!done);

    
    }
    private static void displayList()
    {
        System.out.println("");//creates space between menu options and the list
        if(list.size() != 0)
        {
         for(int i = 0; i < list.size(); i++)
            {
            System.out.printf("%5d%5s", i+1, list.get(i)); //fixes the formatting of the array so the user can interpret it better
            }
        }
        else
        {
            System.out.println("***    list is empty!    ***");
        }
        System.out.println("");//creates space between menu options and the list
    }
}
