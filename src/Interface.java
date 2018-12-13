package src;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Interface {
	
	List<Question> listaPytan = new ArrayList<Question>();
	
	
	public List<Question> OpenFile (String filename) throws IOException {
		File file = new File(filename);
		
		
		Scanner sc = new Scanner(file);
		sc.useDelimiter(";");
		
		
		
		while(sc.hasNext()) {
			listaPytan.add(new Question(sc.next()));
			try {
				listaPytan.get(listaPytan.size() - 1).setAns(sc.next());
			}
			catch (NoSuchElementException e) {
				System.out.println("Can't set Variable. Element not found ");
			}
			
		}
		
		sc.close();
		System.out.println("To jest twoje pytanie: \n" +listaPytan.get(0).getQuestion());
		System.out.println("ODPOWIEDZ: " +listaPytan.get(0).getAns());
		return listaPytan;
	}
	
}

