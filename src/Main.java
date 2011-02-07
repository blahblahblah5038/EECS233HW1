
public class Main 
{
	public static void main(String[] args) 
	{
		NumLinkedList A = new NumLinkedList();
		NumArrayList B = new NumArrayList(10,10);
		double CorrectSum = 0;
		double NumOfNums = 0;
		for (int i = 0; i<11; i++)
		{
			NumOfNums++;
			CorrectSum+=i;
			A.insert(0, i);
			B.insert(0, i);
			
		}
		System.out.println("The mean of the numbers from 0 to 100 inclusive is "+CorrectSum/NumOfNums+".");
		System.out.println("The mean of the NumLinkedList elements is "+meanSequence(A)+".");
		System.out.println("The mean of the NumArrayList elements is "+meanSequence(B)+".");
	}
	public static double meanSequence(NumList A)
	{
		double sum = 0;
		double numofnums = 0;
		A.IteratorInit();
		while(A.HasNext())
		{
			//System.out.println(numofnums);
			sum += A.GetNext();
			numofnums++;
		}
		return sum/numofnums;
	}
}
