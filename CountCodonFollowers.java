/*Sayraj Kazi*/
package symboltable;
import algs4.StdIn;
import algs4.StdOut;
import myalgs4.AVLTreeST;
import myalgs4.BSTEssential;
import java.util.Queue;
import java.util.LinkedList;
public class CountCodonFollowers {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		StdIn.fromFile("data/codonlist.txt");
		String[] CodonArray= new String [64];
		int i= 0;
		while(!StdIn.isEmpty()) {
			String line = StdIn.readLine();
			CodonArray[i]=line;
			i++;


		}
		StdIn.fromFile("data/SARSCoV2-S-gene-WH.txt");
		String COVgenes= StdIn.readAll();
		char[] COVChar= COVgenes.toCharArray();
		AVLTreeST<String, Queue<Integer>> codonPos = new AVLTreeST<>();
		for(String codon:CodonArray) {
			Queue<Integer> CodonQ= new LinkedList<Integer>();

			for(int COV=0; COV<=COVChar.length-1;COV+=3 ) {

				String currcodon =""+ COVChar[COV] + COVChar[COV+1] + COVChar[COV+2];
				
				if(currcodon.equals(codon)) {
					CodonQ.add(COV);
				}


			}
			if(!CodonQ.isEmpty()) {
				codonPos.put(codon, CodonQ); /*Putting Codon and Queue in symbol table*/
				
			}
		}
		for(String codon:CodonArray) {
			if(codonPos.contains(codon)){
				AVLTreeST<String, Boolean> CodonQUEST= new AVLTreeST<>();
				Queue<Integer> Quest= codonPos.get(codon) ;
				for(int Q:Quest) {
					if (Q<COVChar.length-3) {
					
					String FinalCodon=""+ COVChar[Q+3] + COVChar[Q+4] + COVChar[Q+5];
					CodonQUEST.put(FinalCodon, true);
					}
				}
				StdOut.println(CodonQUEST.size());
				
			}else {
				StdOut.println(codon +" not Present");
			}
			
		}
	}

}