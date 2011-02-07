
public interface NumList 
{
	int size();
	void insert(int i, double value);
	void remove(int i) throws Exception;
	double lookup(int i) throws Exception;
	void IteratorInit();
	boolean HasNext();
	double GetNext();
}
