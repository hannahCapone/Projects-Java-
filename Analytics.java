public class Analytics
{
	String [][] array;
	Double [][] dArray;
	int rows;
	double count = 0;
	int c = 0;
	
	// constructor
	Analytics(String[][] a, int r)
	{
		array = a;
		rows = r;
		for (String[ ] row : array) 
		{
            for (String col : row) 
            {
            	if (col != null)
            		count++; 
            	c++;
            }
        }
	}

	// toDouble(): creates a 2D Double array using the 2D String array
	// to be used within calculation methods
	void toDouble()
	{
		Double tempArray[][] = new Double[array.length][array[0].length];

		for (int r = 0; r < array.length; r++)
		{
			for (int c = 0; c < array[r].length; c++)
			{
				Double temp = null;
				if (array[r][c] == null)
					tempArray[r][c] = temp ;	
				else
					tempArray[r][c] = Double.parseDouble(array[r][c]);
			}
		}
		dArray = tempArray;
	}

	// sortDoubleArray(): recursive sort helper method to be used in getMedian()
	Double [] sortDoubleArray(Double[] w)
	{	
		boolean swapped = false; // boolean variable to monitor when to end recursion
		// iterate through array (bubble sort)
		for (int i = 0; i < w.length -1; i++)
		{
			// if Double is greater than the Double to the right than swap positions
			if (w[i].compareTo(w[i+1]) > 0)
			{
				Double temp = w[i];
				w[i] = w[i+1];				
				w[i+1] = temp;					
				swapped = true;
			}
			
		}
		// recursively call sortStringArray() until the array is sorted
		if (swapped == true)
		{
			sortDoubleArray(w);
		}	
		return w;
	}

	// getCount(int): calculates & returns count for specific substring of dArray
	double getCount(int index) // for one row
	{
		double count = 0;
		this.toDouble();
		for (int i = 0; i < dArray[index].length; i++)
		{
			if (dArray[index][i] != null)
				count++;
		}

		return count;
	}

	// getSum(int): calculates & returns the sum of every value within a specific substring of dArray
	double getSum(int index)
	{
		double sum = 0;
		this.toDouble();

		for (Double row : dArray[index]) 
		{
           	sum += row; 
        }
        sum = Math.round(sum*100.0)/100.0;
        return sum;

	}

	// getAverage(int): calculates & returns the mean of a specific substring of dArray
	double getAverage(int index)
	{
		double average = this.getSum(index) / this.getCount(index);
		average = Math.round(average*100.0)/100.0;
		return average;

	}

	// getMedian(int): calculates & returns the median value of a specific substring of dArray
	double getMedian(int index)
	{
		double median;
		this.toDouble();
		
		// sort array
		Double [] sortedArray = this.sortDoubleArray(dArray[index]);

		int middleIndex = dArray[index].length/2;
		if (dArray[index].length % 2 == 0)
		{
			median = dArray[index][middleIndex] + dArray[index][middleIndex-1];
			median = median / 2;
		}
		else
		{
			median = dArray[index][middleIndex];
		}
		median = Math.round(median*100.0)/100.0;
		return median;
	}	
	public int countFrequency(int index, Double l)
	{
		// sort array
		Double [] sortedArray = this.sortDoubleArray(dArray[index]);

		int count = 0;
		for (int i = 0; i < sortedArray.length; i++)
		{
			if (sortedArray[i].equals(l))
				count++;
		
		}
		return count;
	}
	// TODO
	// getMode(int): calculates & returns the mode of a specific substring of dArray
	String getMode(int index)
	{	
		this.toDouble();

		Double [] sortedArray = this.sortDoubleArray(dArray[index]);

		Double mode = 0.0;

		int maxCount = 0;

		int counter = 0;

		for (Double num : sortedArray)
		{
			while(countFrequency(index, num) > maxCount)
			{
				maxCount = countFrequency(index, num);
				mode = num;

				if (counter == sortedArray.length)
					break;
				counter++;
			}
		}
		String output = "";

		if (countFrequency(index, mode) <= 1)
		{
		 	output = "[--]";
		 	return output;
		}
		else
		{
			output = "[";
			for (int i = 0; i < sortedArray.length; i++)
			{
				if (countFrequency(index, sortedArray[i]) == countFrequency(index, mode) && !sortedArray[i].equals(mode))
				{	
					if(!sortedArray[i].equals(sortedArray[i-1]))
						output += sortedArray[i] + ", ";
				}
			}
			output += mode + "]";
		}
		
		return output;

	}
	
	// getMin(int): calculates & returns the minimum value in a specific substring of dArray
	double getMin(int index)
	{
		this.toDouble();
		double min = dArray[index][0];
		for (Double row : dArray[index]) 
		{
            if (row < min)
           	{
           		min = row;
           	}
        }
		return min;
	}

	// getMax(int): calculates & returns the maximum value in a specific substring of dArray
	double getMax(int index)
	{
		this.toDouble();
		double max = dArray[index][0];
		for (Double row : dArray[index])
		{
            if (row > max)
           	{
           		max = row;
           	}
        }
		return max; 
	}

	// getRange(int): calculates & returns the range of a specific substring of dArray
	double getRange(int index)
	{
		double range = this.getMax(index) - this.getMin(index);
        range = Math.round(range*100.0)/100.0;
		return range;
	}

	// getStandardD(int): calculates & returns the range of a specific substring of dArray
	double getStandardD(int index)
	{
        double sd = 0;

        double sum = this.getSum(index);
		double count = this.getCount(index);
		double average = this.getAverage(index);

		for (Double num : dArray[index])
			sd += Math.pow(num - average, 2);
		
		sd = Math.sqrt(sd/count);
		sd = Math.round(sd*100.0)/100.0;
		return sd;
		
	}

	// TODO TITLE
	String[][] transpose()
	{
		int r = rows;
		int c = array[0].length;

		String[][] newArray = new String[c][r];

		int col2 = 0;
        for (int row=0; row < array.length; row++)
        {
            int row2 = 0;
            for (int col=0; col < array[row].length; col++)
            {
                newArray[row2][col2] = array[row][col];
                row2++;
            }
            col2++;
        }
        return newArray;
	}

	public String toString()
	{
		String data = "";
		for (int i = 0; i < rows; i++)
		{
			data += "\t";
			data += this.toStringRow(i);
			data += "\n";
		}
		return data;
		
	}
	public String toStringWithData()
	{
		String data = "";
		for (int i = 0; i < rows; i++)
		{
			data += "\t";
			data += this.toStringRow(i);
			data += " | ";
			data += "Count=" + this.getCount(i) + "\t";
			data += "Sum=" + this.getSum(i) + "\t";
			data += "Avg=" + this.getAverage(i) + "\t";
			data += "Median=" + this.getMedian(i) + "\t"; // TODO
			data += "Mode=" + this.getMode(i) + "\t"; // TODO
			data += "Min=" + this.getMin(i) + "\t";
			data += "Max=" + this.getMax(i) + "\t";
			data += "Range=" + this.getRange(i) + "\t";
			data += "stdDev=" + this.getStandardD(i);; // TODO
			data += "\n";
		}
		String [][] columnSwitch = this.transpose();
		Analytics colSwi = new Analytics(columnSwitch, columnSwitch.length);

		data += "-------------------------------------\n";
		
		data += String.format("%-9s", "Count=");
		for (int i = 0; i < columnSwitch.length; i++)
		{
			data += String.format("%-9s", colSwi.getCount(i));
		}
		data += "\n";

		data += String.format("%-9s", "Sum=");
		for (int i = 0; i < columnSwitch.length; i++)
		{
			data += String.format("%-9s", colSwi.getSum(i));
		}
		data += "\n";

		data += String.format("%-9s", "Average=");
		for (int i = 0; i < columnSwitch.length; i++)
		{
			data += String.format("%-9s", colSwi.getAverage(i));
		}
		data += "\n";

		data += String.format("%-9s", "Median=");
		for (int i = 0; i < columnSwitch.length; i++)
		{
			data += String.format("%-9s", colSwi.getMedian(i));
		}
		data += "\n";

		data += String.format("%-9s", "Mode=");
		for (int i = 0; i < columnSwitch.length; i++)
		{
			data += String.format("%-9s", colSwi.getMode(i));
		}
		data += "\n";

		data += String.format("%-9s", "Min=");
		for (int i = 0; i < columnSwitch.length; i++)
		{
			data += String.format("%-9s", colSwi.getMin(i));
		}
		data += "\n";

		data += String.format("%-9s", "Max=");
		for (int i = 0; i < columnSwitch.length; i++)
		{
			data += String.format("%-9s", colSwi.getMax(i));
		}
		data += "\n";

		data += String.format("%-9s", "Range=");
		for (int i = 0; i < columnSwitch.length; i++)
		{
			data += String.format("%-9s", colSwi.getRange(i));
		}
		data += "\n";

		data += String.format("%-9s", "stdDev=");
		for (int i = 0; i < columnSwitch.length; i++)
		{
			data += String.format("%-9s", colSwi.getStandardD(i));
		}
		data += "\n";

		/// TODO: add column data

        return data;
	}

	// TODO TITLE 
	public String toStringRow(int index)
	{
		this.toDouble();

		String data = "";
		int count = 0;

		for (Double col : dArray[index])
		{
			String column = "";
			//column += String.format("%.2f", col);
			
			if (count != dArray[index].length -1)
				column += ", ";

			data += String.format("%-9s", col, "\n");
			count ++;
		}
		
		return data;// 8 spaces
		
	}

	// TODO TITLE 
	public String toStringRowWithData(int i)
	{
		this.toDouble();

		String data = "";
		data += String.format("%-9s", "Count=");
		data += String.format("%-9s", this.getCount(i));
		data += "\n";

		data += String.format("%-9s", "Sum=");
		data += String.format("%-9s", this.getSum(i));
		data += "\n";

		data += String.format("%-9s", "Average=");
		data += String.format("%-9s", this.getAverage(i));
		data += "\n";

		data += String.format("%-9s", "Median=");
		data += String.format("%-9s", this.getMedian(i));
		data += "\n";

		data += String.format("%-9s", "Mode=");
		data += String.format("%-9s", this.getMode(i));
		data += "\n";

		data += String.format("%-9s", "Min=");
		data += String.format("%-9s", this.getMin(i));
		data += "\n";

		data += String.format("%-9s", "Max=");
		data += String.format("%-9s", this.getMax(i));
		data += "\n";

		data += String.format("%-9s", "Range=");
		data += String.format("%-9s", this.getRange(i));
		data += "\n";

		data += String.format("%-9s", "stdDev=");
		data += String.format("%-9s", this.getStandardD(i));
		data += "\n";
		
		return data;// 8 spaces
		
	}

	// TODO TITLE 
	public String toStringForSet()
	{
		int h = 0;
		String[][] s = new String[2][c];
		for (String[] row : array)
        {
            for (String col : row)
            {
            	s[0][h] = col;
            	h++;
            }
        }
        Analytics set = new Analytics(s, s.length);

		set.toDouble();

		String data = "";
		data += String.format("%-9s", "Values=");
		data += set.toStringRow(0);

		data += String.format("%-9s", "Count=");
		data += String.format("%-9s", set.getCount(0));
		data += "\n";

		data += String.format("%-9s", "Sum=");
		data += String.format("%-9s", set.getSum(0));
		data += "\n";

		data += String.format("%-9s", "Average=");
		data += String.format("%-9s", set.getAverage(0));
		data += "\n";

		data += String.format("%-9s", "Median=");
		data += String.format("%-9s", set.getMedian(0));
		data += "\n";

		data += String.format("%-9s", "Mode=");
		data += String.format("%-9s", set.getMode(0));
		data += "\n";

		data += String.format("%-9s", "Min=");
		data += String.format("%-9s", set.getMin(0));
		data += "\n";

		data += String.format("%-9s", "Max=");
		data += String.format("%-9s", set.getMax(0));
		data += "\n";

		data += String.format("%-9s", "Range=");
		data += String.format("%-9s", set.getRange(0));
		data += "\n";

		data += String.format("%-9s", "stdDev=");
		data += String.format("%-9s", set.getStandardD(0));
		data += "\n";
		
		return data;// 8 spaces
		
	}


}