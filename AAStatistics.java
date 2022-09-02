
/*Sayraj Kazi*/
package symboltable;


import  algs4.StdIn;
import algs4.StdOut;
import myalgs4.BSTEssential;
public class AAStatistics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTEssential<String, String> codonTranslation = new BSTEssential<>();
		StdIn.fromFile("data/codontranslation.txt");
		while(!StdIn.isEmpty()) {
			String line = StdIn.readLine();
			String [] Cod= line.split("\\s+");
			codonTranslation.put(Cod[0], Cod[1]);
		}
		StdIn.fromFile("data/SARSCoV2-S-gene-CA.txt");
		BSTEssential<String, Integer> codonStats = new BSTEssential<>();
		String codon;
		String abbv;
		while(!StdIn.isEmpty()) {
			codon="";
			codon+= StdIn.readChar();
			codon+= StdIn.readChar();
			codon+= StdIn.readChar();
			abbv=codonTranslation.get(codon);
			if(codonStats.contains(abbv)) {
				codonStats.put(abbv, codonStats.get(abbv)+1);
			}else {
				codonStats.put(abbv, 1);
			}
			
		}
		double totalCount=0;

		for(String key: codonStats.keys()) {
			totalCount+=codonStats.get(key);
			
			
		}
		double c;
		double percentC;
		double count;
		StdOut.println(totalCount);
		for(String key: codonStats.keys()) {
			String row= key+ " ";
			 count=codonStats.get(key);
			 c= count/totalCount;
			 percentC= c*100;
			
			System.out.println(row+" "+ count+ " "+ percentC);
			
			
		}
		
	}
}



