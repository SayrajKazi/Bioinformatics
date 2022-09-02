/*Sayraj Kazi*/
package symboltable;
import algs4.StdIn;
import algs4.StdOut;
import myalgs4.AVLTreeST;
import myalgs4.BSTEssential;
public class MultisequenceCodonFrequencies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTreeST<String, AVLTreeST<String, Double>> FileTrees = new AVLTreeST<>();
		String	[] filenames= {"data/SARSCoV2-S-gene-CA.txt", "data/SARSCoV2-S-gene-IL.txt","data/SARSCoV2-S-gene-WH.txt"};
	
		for(String filename:filenames) {
			AVLTreeST<String, Double>	fileFreq= new AVLTreeST<>();
			
			StdIn.fromFile(filename);
			BSTEssential<String, Integer> codonStats = new BSTEssential<>();
			String codon;
	
			while(!StdIn.isEmpty()) {
	 			codon="";
				codon+= StdIn.readChar();
				codon+= StdIn.readChar();
				codon+= StdIn.readChar();
				//abbv=codonTranslation.get(codon);
				if(codonStats.contains(codon)) {
					codonStats.put(codon, codonStats.get(codon)+1);
				}else {
					codonStats.put(codon, 1);
				}
				
			}
			double totalCount=0;

			for(String key: codonStats.keys()) {
				totalCount+=codonStats.get(key);
				
				
			}
			double c;
			double percentC;
			double count;
			
			for(String key: codonStats.keys()) {
				 count=codonStats.get(key);
				 c= count/totalCount;
				 percentC= c*100;
				
			fileFreq.put(key,percentC);
		
				
			}
			FileTrees.put(filename, fileFreq);
		}
		String[] vipCodon= {"ctt", "ctc", "cta", "ctg", "tta", "ttg"};
		for (String vip:vipCodon) {
			StdOut.println("=== Percentages for " + vip);
			for(String filename: filenames) {
				double FrequencyPerc= FileTrees.get(filename).get(vip);
				StdOut.println(filename+" "+ String.valueOf(FrequencyPerc));
			}
			
		}
		
	}
}
