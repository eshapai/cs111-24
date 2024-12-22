
public class EgyptianPyramid 
{
    
    public static void main(String[] args) 
    {
        int base = Integer.parseInt(args[0]);
        int tempbase = Integer.parseInt(args[0]);
        int total = base;
        int buildRows = 0;
        int bricksGiven = Integer.parseInt(args[1]);
        int bricksLeft = bricksGiven;
        String[][] pyramid = new String[base][base];

        //calculates total bricks needed
        //calculates num rows with bricks

        while (tempbase > 0)
        {
            if (tempbase == 1)
            {
                total +=1;
            }
            total += (tempbase-2);
            tempbase -=2;
            buildRows+=1;
        }

        for (int row = 0; row < base; row++)
        {
            for (int column = 0; column < base; column++)
            {
                pyramid[row][column] = "=";
            }
        }
        
        int start = 0;
        int end = base-1;
        for (int row = base-1; row >= base-buildRows; row--) //starting from bottom to top of pyramid
        {
            for (int column = 0; column < base; column++)
            {
                    if (column >= start && column <= end && bricksLeft > 0)
                    {
                        pyramid[row][column] = "X";
                        bricksLeft--;
                    }   
            }
            start++;
            end--;
        }


        for (int row = 0; row < base; row++)
        {
            for (int column = 0; column < base; column++)
            {
                System.out.print(pyramid[row][column]);
            }
            System.out.println();
        }

        //print bricks remaining
        if (total-bricksGiven >= 0)
        {
            System.out.println("0 Bricks Remaining");
        }
        else{
            System.out.println(bricksGiven - total + " Bricks Remaining");
        }
    }
}
