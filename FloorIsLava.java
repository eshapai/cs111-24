

/*************************************************************************
 *  Compilation:  javac FloorIsLava.java
 *  Execution:    java FloorIsLava n
 *
 *  @author Shane Haughton, Maaz Mansuri
 *5
 1 2 3 4 5 // number
 0 1 2 3 4 // index

 fw = index 1, 3
 bw = index 0, 2, 4

 **************************************************************************/

public class FloorIsLava
 {

    public static void main (String[] args ) 
    {
        int max = Integer.parseInt(args[0]);
        int[] fward = new int[max/2];
        int[] bward = new int[max/2];

        for (int num = 1; num <= max; num++)
        {
            if (num % 2 == 0)
            {
                fward[num-1] = num;
            }
            else
            {
                bward[num-1] = num;
            }
        }
    }
}
