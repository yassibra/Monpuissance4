import java.util.Scanner;

public class Menu {
	public static void menu () {
	
	int [][] tab = new int[6][7];
	Methode.initialiser(tab, 0);
	/* 
	Methode.afficherMenu();
	Methode.saisiePremierChoix();
	*/
	int choix, choixia;
	
	String[]noms = new String[2];
	java.util.Scanner saisie = new java.util.Scanner(System.in);
	
	
	do {
		System.out.println("1. Voir les règles 2.Jouer en 1 contre 1  3.Jouer contre l'IA  4.Quitter");
		System.out.println("Quel est votre choix ?");
		choix = Integer.parseInt(saisie.nextLine());
		
	switch (choix) {
	
       
		
	
	case 1:
		
		Methode.voirRegles();
		break;
	case 2:
		//jouerUnContreUn
		Methode.initialiser(tab, 0);
		Methode.jouerUnContreUn(tab);
		
		
	//	Scanner saisie = new Scanner(System.in);
		
		break;
		
	case 3:
		Methode.initialiser(tab, 0);
		System.out.println("Tapez 1 si vous êtes novice. Tapez 2 pour jouer contre l'IA Intermédiaire");
		choixia = Integer.parseInt(saisie.nextLine());
		
		while (choixia > 2 || choixia < 1) {
			System.out.println("Vous tremblez? je le redis Tapez 1 si vous êtes novice. Tapez 2 pour faire au mieux un match nul.");
			choixia = Integer.parseInt(saisie.nextLine());
			
		}
		
		
			Methode.joueContreIa(tab, choixia);	
		
		
		break;
	case 4: 
		System.out.println("Au revoir");
	default:
		System.out.println("Mauvais choix! veuillez resaisir un nombre");
		break;
	
	}
	} while ( choix !=4 );
	
	

	}
}