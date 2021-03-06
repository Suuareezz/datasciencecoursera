package dmdavis;
import java.io.*;
import java.util.*;

public class dendyto {
	static int calculateSup(String[] transactions,int n,String i1,String i2)
	{
		int ans=0;
		for(int i=0;i<n;i++)
		{
			if(transactions[i].contains(i1) && transactions[i].contains(i2))
				ans++;
		}
		return ans;
	}
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Number of transactions");
		int n=s.nextInt();
		System.out.println("Min-support");
		double sup=s.nextDouble();
		sup*=n;
		System.out.println("Min-conf");
		double conf=s.nextDouble();
		String transactions[]=new String[n],temp;
		HashMap<String,Integer> count=new HashMap<String,Integer>();
		System.out.println("Enter the transactions");
		for(int i=0;i<n;i++)
		{
			
			do
			{
				temp=s.nextLine();
			}while(temp.length() == 0);
			transactions[i]=temp;
			String items[]=temp.split(" ");
			for(String item:items)
			{
				count.putIfAbsent(item, 0);
				count.put(item,count.get(item)+1);
			}
		}
		System.out.println("  Support");
		ArrayList<String> nextIter=new ArrayList<String>();
		for(Map.Entry m : count.entrySet())
		{    
			 if((int)m.getValue() >= sup)
			 {
				 System.out.println(m.getKey()+" "+m.getValue());
				 nextIter.add((String)m.getKey());
			 }
		} 
		System.out.println("\n Two Freq Itemset");
		int l=nextIter.size();
		for(int i=0;i<l;i++)
		{
			for(int j=0;j<l;j++)
			{
				if(i==j)
					continue;
				int curSup=calculateSup(transactions,n,nextIter.get(i),nextIter.get(j));
				if(curSup < sup)
					continue;
				double curConf=curSup/count.get(nextIter.get(i));
				if(curConf >= conf)
					System.out.println(nextIter.get(i)+" -> "+nextIter.get(j)+" Conf : "+curConf);
			}
		}
	}
}
