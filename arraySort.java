
public class arraySort
{
	public static void main(String[] args)
	{ 
		// take input
		System.out.print("Enter words to be sorted: ");
		r 

		// new line for formatting
        System.out.println("------------------------------------------------------");
 
        // split input string by one or more spaces into a string array 
        String[] words = input.split("\\s+");
        
        if (words.length < 3) // validate >= 3 words were input
        {
        	System.out.println("You entered less than 3 words; please enter 3 or more!");
        	System.out.println("Exiting program.");
        	System.out.println("------------------------------------------------------");
        	return; // exit program
        }

        // Print all entered words each on a separate line
        System.out.println("You entered:");
        for (int i = 0; i < words.length; i ++)
        	System.out.println(words[i]);
        
        // new line for formatting
        System.out.println("------------------------------------------------------");

        // concat
        System.out.print("Concatenation: ");

        String concat = String.join(" ", words);
        System.out.println(concat);

        // new line for formatting
        System.out.println("------------------------------------------------------");

        //sort
        sortStringArray(words);
        System.out.println("Sorted: ");
        for (int i = 0; i < words.length; i ++)
        	System.out.println(words[i]);

        // new line for formatting
        System.out.println("------------------------------------------------------");

        // copy to StringBuilder or StringBuffer
        System.out.println("StringBuffers:");
        // then concat to single StringBuffer with a space
        StringBuffer allSBs = new StringBuffer();
        for (int i = 0; i < words.length; i ++)
        {
        	StringBuffer sb = new StringBuffer(words[i]);
        	// print them
        	System.out.println(sb);
        	allSBs.append(sb + " ");
        }
       
       	// new line for formatting
        System.out.println("------------------------------------------------------");

        // print it 
        System.out.println("Concatenated String Buffer: " + allSBs);

   		// end line for formatting
        System.out.println("------------------------------------------------------");

    }
    static void sortStringArray(String[] w)
	{	
		boolean swapped = false; // boolean variable to monitor when to end recursion
		// iterate through array (bubble sort)
		for (int i = 0; i < w.length -1; i++)
		{
			// if string is greater than the string to the right than swap positions
			if (w[i].compareTo(w[i+1]) > 0)
			{
				String temp = w[i];
				w[i] = w[i+1];				
				w[i+1] = temp;					
				swapped = true;
			}
			
		}
		// recursively call sortStringArray() until the string array is sorted
		if (swapped == true)
		{
			sortStringArray(w);
		}	
	}
}