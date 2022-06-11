// potrebno je še uvoziti slike, narediti izjeme in pa cas igranja !!!
// plosco moramo se narediti


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Igra {

	public static String [][] plosca = new String[4][4];
	public static String [][] karte = new String[4][4];
	public static Scanner scanner = new Scanner(System.in);
		
	public static void main(String[] args) {
		while(true) {
			System .out.println("Pritisni n za novo igro, q za kone igre");
			String nq = scanner.nextLine();
			if (nq.equals("q")) {
				System.out.println("Konèujem...");
				break;
			}
			else if (nq.equals("n")) {
				premesajKarte();
				for(int i = 0; i<4; i++) {
					for(int j = 0; j<4; j++) {
						plosca[i][j] = " _ ";
					}
				}
				narisiPlosco();
				preveri(karte);
				break;
			}
			else {
				System.out.println("Neveljaven znak");
				continue;
			}
		}
	}
		
	public static void narisiPlosco() {
		for (int i = 0; i<4; i++) {
			System.out.print("|");
			for(int j = 0; j<4; j++) {
				System.out.print(plosca[i][j]);
				System.out.print("|");
			}
			System.out.println();
		}
	}

	
	public static void premesajKarte() {
		Random random = new Random();
		ArrayList<String> slike = new ArrayList<String>();
		slike.add("0");
		slike.add("1");
		slike.add("2");
		slike.add("3");
		slike.add("4");
		slike.add("5");
		slike.add("6");
		slike.add("7");
		slike.add("0");
		slike.add("1");
		slike.add("2");
		slike.add("3");
		slike.add("4");
		slike.add("5");
		slike.add("6");
		slike.add("7");
		
		int indeks;
		for(int i = 0; i<4; i++ ) {
			for(int j = 0; j<4; j++) {
				indeks = random.nextInt(slike.size());
				karte[i][j] = slike.get(indeks);
				slike.remove(indeks);
			}
		}
			
	}
// tukaj si koncala,  kdaj bo konec igre, ko dobimo vse pare!!!!!
	public static void preveri(String [][] karte) {
		while(true) {
			if (!konecIgre()) {
				System.out.println("Vrstica: (1-4)");
				int vrstica_1 = scanner.nextInt();
				System.out.println("Stolpec: (1-4)");
				int stolpec_1 = scanner.nextInt();
				//... poglej
				if (!plosca[vrstica_1-1][stolpec_1].equals(" _ ")) {
					System.out.println("Že vstavljeno !!") ;
					System.out.println();
					
					narisiPlosco();
					continue;		
				}
				else {
					plosca[vrstica_1 - 1][stolpec_1 - 1] = " " + karte[vrstica_1 - 1][stolpec_1 - 1] + " ";
					narisiPlosco();
					}
				
				System.out.println("Vrstica: (1-4)");
				int vrstica_2 = scanner.nextInt();
				System.out.println("Stolpec: (1-4)");
				int stolpec_2 = scanner.nextInt();
				
				if(!plosca[vrstica_2 - 1][stolpec_2 - 1].equals(" _ ")) {
					System.out.println("Že vstavljeno");
					plosca[vrstica_1 - 1][stolpec_1 - 1] = " _ ";
					System.out.println();
					
					narisiPlosco();
					continue;
				}
				else {
					plosca[vrstica_2 - 1][stolpec_2 - 1] = " " + karte[vrstica_2 - 1][stolpec_2 - 1];
					
					if (plosca[vrstica_1 - 1][stolpec_1 - 1].equals(plosca[vrstica_2 - 1][stolpec_2 - 1])){
						narisiPlosco();
						System.out.println("Pravilno! :)");
					}
					else {
						narisiPlosco();
						System.out.println("Nepravilno! :(");
						plosca[vrstica_1 - 1][stolpec_1 - 1] = " _ ";
						plosca[vrstica_2 - 1][stolpec_2 - 1] = " _ ";
						narisiPlosco();
					}
				}
				
			}
			else {
				System.out.println("Konec igre !! ");
				break;
			}
		}
	}
	
	public static boolean konecIgre() {
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<4; j++) {
				if (plosca[i][j].equals(" _ ")) {
					return false;
				}
			}
		}
		return true;
	}
}
