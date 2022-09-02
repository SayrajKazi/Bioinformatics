/*Sayraj Kazi*/

package symboltable;




import algs4.StdIn;
import algs4.StdOut;
import myalgs4.BSTEssential;

public class TranslateCodonToAA {

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
		String protein;
		while(!StdIn.isEmpty()) {
			protein="";
			protein+= StdIn.readChar();
			protein+= StdIn.readChar();
			protein+= StdIn.readChar();
			StdOut.println("Protein: "+protein+" "+codonTranslation.get(protein));
			
		}
	}

}
