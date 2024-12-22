
public class BusStop 
{
    public static void main(String[] args) 
    {
        char[] stops = new char[args.length]; // A B C D = 4
        char myBus = args[args.length-1].charAt(0);
        int busLoc = 1;
        boolean busFound = false;
        for (int i = 0; i < args.length-1; i++)
        {
            stops[i] = args[i].charAt(0);
        }

        
        for(char bus : stops)
        {
            if (myBus == bus) 
            {
                busFound = true;
                System.out.println(busLoc);
                break;
            }
            else
            {
                busLoc++;
            }
        }
        if (!busFound)
        {
            System.out.print(-1);
        }
     }
        
}
