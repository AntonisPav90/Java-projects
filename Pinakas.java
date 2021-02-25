import java.util.Scanner;

public class pinakas {

	public static int megethos;
	public static int[] stoixeia = new int[megethos];

	public static int sunolo(int[] stoixeia) {

		int elaxista,megista;
        elaxista = megista = 0;
		double min,max;
		min = stoixeia[0];
		max = stoixeia[0];

		for(int i=0; i < megethos; i++) {
			if(stoixeia[i] > max) {
				max = stoixeia[i];
			} else if(stoixeia[i] < min) {
				min = stoixeia[i];
			}
		}

		for(int i=0; i < megethos; i++) {
			if(stoixeia[i] == max) {
				megista += 1;
			} else if(stoixeia[i] == min) {
				elaxista += 1;
			}
		}

		return (elaxista + megista);

	}


	public static void main(String args[]) {

		int sunolika;

		Scanner scnr = new Scanner(System.in);

		System.out.println("Δώστε το μέγεθος του πίνακα:");
		megethos = scnr.nextInt();
		int[] stoixeia = new int[megethos];

		for(int i=0; i < megethos; i++) {
			System.out.printf("Δώσε στοιχείο %d του πίνακα:",i);
			stoixeia[i] = scnr.nextInt();
		}

		sunolika = sunolo(stoixeia);

		System.out.println("Το σύνολο των ακροτάτων είναι "+sunolika);
                
                scnr.close();

	}



}