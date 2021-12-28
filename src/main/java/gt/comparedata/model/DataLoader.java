package gt.comparedata.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
	public List<String>loadData(FileReader source) throws IOException{
		
	 	BufferedReader bufferedReader = new BufferedReader(source);
	 	
	 	List<String> result = new ArrayList<>();
	 	
	 	String line = null;
	 	while ( (line = bufferedReader.readLine()) != null ) {
	 		result.add(line);
	 	}

		return result;
	}
}
