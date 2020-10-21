package dmlab;
import weka.associations.*;
import weka.core.Instances;
import weka.core.SelectedTag;

import java.io.*;
import java.util.*;

public class dmex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
						try
						{
							Instances data = new Instances(new BufferedReader(new FileReader("C:\\Users\\shara\\Desktop\\file.arff")));
							Apriori model = new Apriori();
							model.setLowerBoundMinSupport(0.2);
							model.setMinMetric(0.8);
							model.buildAssociations(data);
							System.out.println(model);
						}
						catch(Exception e)
						{
							System.out.println("Error");
						}
		

	}

}
