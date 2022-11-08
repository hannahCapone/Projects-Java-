import java.io.*; 
import java.util.*; // TODO DO I NEED?
public class AnalyticsUser
{
	public static void main(String[] args)
    {
        String filename = "/Users/hannahcapone/Desktop/Java/Lab 7/dataset2.csv";

        String[][] dim2Array = null;

        try
        {
            FileReader fr = new FileReader(filename); // open the file for reading
            LineNumberReader lnr = new LineNumberReader(fr); // get number of lines

            lnr.skip(Long.MAX_VALUE); // skip to the end of file
            
            int nRows = lnr.getLineNumber(); // get number of lines

            fr.close(); // close the file

            dim2Array = new String [nRows][]; // create two dimensional string array

            FileReader fr2 = new FileReader(filename); // reopen the file for reading again
            BufferedReader br2 = new BufferedReader(fr2); // buffer it

            int row = 0;
            String line;

            // source input 
            System.out.println("SOURCE INPUT...");
           
            while ((line = br2.readLine()) != null) // while there are lines in the file
            {
                System.out.println(line);
                String[] dim1Array = line.split(","); // split it on ","
                dim2Array[row] = dim1Array; // append 1 dimensional array to 2 dimensional
                row++; // next row
            }
             System.out.println("");

            // CALCULATIONS
            Analytics data = new Analytics(dim2Array, nRows);

            // print data
           
            // computation
            System.out.println("COMPUTATION...");
            System.out.println(data.toStringWithData());

            // entire data set
            System.out.println("ENTIRE SET...");
            System.out.println(data.toStringForSet());

            // column 1
            System.out.println("COLUMN 1...");
            Analytics col = new Analytics(data.transpose(), data.transpose().length);
            System.out.println(col.toStringRowWithData(0));


            // transpose
            System.out.println("TRANSPOSE...");
            String[][] t = data.transpose();
            Analytics tr = new Analytics(t, t.length);
            System.out.println(tr.toString());
            System.out.println(tr.toStringWithData());

            // entire data set
            System.out.println("ENTIRE SET...");
            System.out.println(data.toStringForSet());

            // column 1 
            System.out.println("COLUMN 1...");
            Analytics col1 = new Analytics(data.transpose(), data.transpose().length);
            System.out.println(col1.toStringRowWithData(0));   
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        
    }
	
}
