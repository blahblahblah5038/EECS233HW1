
public class NumArrayList implements NumList
{
	double [] List;
	int GrowthFactor;
	int Size;
	//size is the initial size of the arraylist, and growthfactor is the factor that it grows by every time it resizes
	private int Current;

	public NumArrayList(int size, int growthfactor) 
	{
		IteratorInit();
		if (size<1||growthfactor<2)
		{
			size = 10;
			growthfactor = 10;
		}
		Size = 0;
		List = new double [size];
		GrowthFactor = growthfactor;
	}
	public int size() 
	{
		return Size;
	}
	public void insert(int i, double value) 
	{
		Size++;
		double [] Temp;
	    if (Size==List.length)
	    {
	    	Temp = new double [List.length*GrowthFactor];
	    }
	    else Temp = new double [List.length];
	    
	    for (int j =0; j<i; j++)
	    {
	    	Temp[j] = List[j];
	    }
	    Temp[i] = value;
	    for (int j=i+1;j<Size-1; j++)
	    {
	    	Temp[j] = List[j-1];
	    }
	    List = Temp;
	}
	public void remove(int i) throws Exception 
	{
		if (i<Size)
		{
			if (Size>0)
			{
			double [] Temp = new double [Size-1];
			for (int j = 0; j<i; j++)
			{
				Temp[j] = List[j];
			}
			for (int j = i+1; j<Size-1; j++)
			{
				Temp[j-1] = List[j];
			}
			List = Temp;
			Size-=1;
			}
			else throw new Exception("List is empty, cannot remove");
		}
	}
	public double lookup(int i) throws Exception 
	{
		if(i<0 || i>Size-1)
		{
			throw new Exception("Invalid Read, Element does not exist!!!");
		}
		return List[i];
	}

	public void IteratorInit() 
	{
		Current = 0;
	}

	public boolean HasNext() 
	{
		if (Current<Size) return true;
		else return false;
	}

	public double GetNext() 
	{
		try
		{
		return lookup(Current++);
		}
		catch(Exception e)
		{
		System.out.println("oops");
		return 0;
		}
	}
}
