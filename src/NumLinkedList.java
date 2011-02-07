
public class NumLinkedList implements NumList 
{
	int Size;
	Node Head;
	private int Current;
	private Node CurrentNode;
	private class Node
	{
		public Node Next;
		public double Value;
		public Node(double Value)
		{
			Next = null;
			this.Value = Value;
		}
	}
	
	public NumLinkedList()
	{
		Head = null;
		Size = 0;
		IteratorInit();
	}
	
	public int size() 
	{
		return Size;
	}
	public void insert(int i, double value) 
	{
		if (Size>0)
		{
			Node N1;
			Node N2 = new Node(value);
			if (i>Size-1)
			{
				N1=GetNode(Size-1);
			}
			else N1 = GetNode(i);
			N2.Next = N1.Next;
			N1.Next = N2;
			Size++;
		}
		else 
		{
			Size = 1;
			Head = new Node (value);
		}
	}
	public void remove(int i) throws Exception 
	{
		if (Size>0)
		{
			if (i<0) throw new Exception();
			if (i == 0)
			{
				if (Head == null) throw new Exception();
				Head = Head.Next;
			}
			else
			{
				Node N1 = this.GetNode(i-1);
				Node N2 = this.GetNode(i);
				N1.Next = N2.Next;
			}
			Size--;
		}
		else throw new Exception();
	}
	public double lookup(int i) throws Exception 
	{
		return GetNode(i).Value;
	}

	private Node GetNode(int i)
	{
		Node N = Head;
		while (i>0 && N!=null)
		{
			N = N.Next;
			i--;
		}
		//if (i>0) throw new Exception("Element does not exist.");
		return N;
	}

	public void IteratorInit() 
	{
		Current = 0;
		CurrentNode = Head;
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
			Node N1 = CurrentNode;
			if (Current<Size)
			{
				Current++;
				CurrentNode = CurrentNode.Next;
			}
			return N1.Value;
		}
		catch(Exception e)
		{
			System.out.println("oops");
			return 0;
		}
	}

}
