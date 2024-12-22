
public class FruitCosts 
{
    public static void main(String[] args) 
    {

	// Do not remove this line, it opens the file for reading.
    StdIn.setFile(args[0]);
    int numLines = StdIn.readInt();
    String[] fruits = new String[numLines];
    Double[] prices = new Double[numLines];

    for (int i = 0; i<numLines; i++)
    {
        fruits[i] = StdIn.readString();
        prices[i] = StdIn.readDouble();
    }

    Double lowestPrice = Math.min(prices[0], prices[1]);
    Double secLowestPrice = Math.max(prices[0], prices[1]);
    String lowestFruit;
    String secLowestFruit;

    if (Math.min(prices[0], prices[1]) == prices[0])
    {
        lowestFruit = fruits[0];
        secLowestFruit = fruits[1];
    }
    else
    {
        lowestFruit = fruits[1];
        secLowestFruit = fruits[0];
    }

//3.0 4.0    new = 1.5
//seclowest = lowest 3.0 3.0  1.5
//lowest = new
    for (int i = 2; i < numLines; i++)
    {
        if (prices[i] < secLowestPrice && prices[i] < lowestPrice)
        {
            
            secLowestPrice = lowestPrice;
            secLowestFruit = lowestFruit;

            lowestPrice = prices[i];
            lowestFruit = fruits[i];
        }
        else if (prices[i] < secLowestPrice && prices[i] >= lowestPrice)
        {
            secLowestPrice = prices[i];
            secLowestFruit = fruits[i];
        }
    }
    
    double total = lowestPrice + secLowestPrice;
    total = Math.round(total * 100.0) / 100.0;
    System.out.println(lowestFruit + " " + lowestPrice);
    System.out.println(secLowestFruit + " " + secLowestPrice);
    System.out.print("Total " + total);
	
    }
}
