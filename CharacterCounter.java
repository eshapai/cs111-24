public class CharacterCounter 
{
    public static void main(String[] args) 
	{
	StdIn.setFile(args[0]);
	int[] occurrences = new int[128];
	char currChar;

	for (int i = 0; i < 128; i++) // inititalizes array with 0 value
	{
		occurrences[i] = 0;
	}

	while (StdIn.hasNextChar()) // parses entirety of file
	{
		currChar = StdIn.readChar();
		occurrences[(int) currChar] +=1; //increments index (decimal) of char
	}
	
	float count = 0;

	for (int i = 0; i <= 127; i++) // totals total chars w 32 <= decimal <= 126
	{
		count += occurrences[i];
	}
	
	StdOut.setFile(args[1]);
	for (int i = 32; i <= 126; i++)
	{
		StdOut.print((char) i);
		StdOut.print(",");
		StdOut.print(i);
		StdOut.print(",");
		StdOut.print(occurrences[i]);
		StdOut.print(",");
		StdOut.println(occurrences[i]/count * 100);
	}
	
    }
}
