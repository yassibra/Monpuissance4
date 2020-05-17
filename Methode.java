
public class Methode {
	//Initialiser permet de remplir toutes les cases du tableau à deux dimensions par une entier val tout deux recus en paramètre.
	 public static void initialiser (int[][] t , int val) {
		 for(int ligne = 0; ligne < t.length ; ligne++) {
			 for(int colonne = 0; colonne < t[ligne].length; colonne++) {
				 t[ligne][colonne] = val;
				 
			 }
		 }
	 }
	 // Affiche le tableau t étant à deux dimensions
	 public static void afficherTab(int[][] t) {
		 System.out.println();
		  for (int ligne = 0 ; ligne < t.length ; ligne++) {
			  for (int colonne = 0 ; colonne < t[ligne].length ; colonne++){
				  System.out.print("|"+t[ligne][colonne]+"|");
		   }
		   System.out.println();

		  }
	 }
	 
	 
	
	 
		public static void voirRegles() {
			System.out.println("Vous ne connaissez pas les règles ? Allez donc voir les règles sur "
					+ "wikipedia !");
			
				
		}
		
		public static void jouerUnContreUn(int[][]tab) {
			java.util.Scanner saisie = new java.util.Scanner(System.in);
			boolean victoire = false;
			int tour = 0;
			int numcolonne;
			int ligne;
			String[]noms = new String[2];
			
			nomDesJoueurs(noms);
			
			commenceEnPremier(noms);
			
			afficherTab(tab);
			
			
			
			
			while (victoire == false && tour != 42) {
				
				
				if (tour % 2 == 0) {
					 System.out.println("C'est votre tour " + noms[0] + " ! Quel colonne ?");
					 numcolonne = Integer.parseInt(saisie.nextLine());
					 ligne=choixJetonJoueurUn(tab, numcolonne); 
				} else {
					 System.out.println("C'est votre tour " + noms[1] + " ! Quel colonne ?");
					 numcolonne = Integer.parseInt(saisie.nextLine());
					 ligne=choixJetonJoueurDeux(tab, numcolonne); 
					
				}
				//Methode.choixJeton(tab, choix);
				 
					 Methode.afficherTab(tab);
				 
				 if(tour >= 4) {
					 victoire = verifVictoire(tab, ligne, numcolonne);
				 }
					 
				 tour = tour+1;
			}
			if (tour == 42 ) {
				System.out.println("Décidément on assiste au combat Goten contre Trunks !"); // Egalité !
			}
			else {
				System.out.println("Nous avons un gagnant !");
					if (tour % 2 == 0) {// Le jeu s'est fini après que le  joueur ait joué  du coup le joueur 1 a gagné
				System.out.println("Bravo à " + noms[1] +"!");
				}
				else { // le joueur 2 a gagné
					System.out.println("Bravo à " + noms[0] + "!");
				}
			}
			
			System.out.println();
			}
			
			
						
		// nomDesJoueurs recoit en paramètre un tableau noms et stockera les noms des joueurs apres leurs avoir demandé
		public static void nomDesJoueurs (String[] noms) {
			java.util.Scanner saisie = new java.util.Scanner(System.in);
			
			System.out.println("Quel nom pour le joueur 1");
			noms[0] = saisie.nextLine();
			System.out.println("Quel nom pour le joueur 2");
			noms[1] = saisie.nextLine();
			
			
			
		}
			//Recoit le type d'ia que l'utilisateur souhaite affronter,  définit le gagnant ou l'eventuel match nul apres différents appel de méthodes
		public static void joueContreIa(int[][]tab, int choixtypeia) {
			String[]noms = new String[2];
			int tour=0;
			boolean victoire = false;
			int numcolonne = 0;
			java.util.Scanner saisie = new java.util.Scanner(System.in);
			System.out.println("Quel nom pour le joueur 1");
			noms[0] = saisie.nextLine();
			
			noms[1] = "IA";
			
			int choixjoueur = 0;
			Methode.afficherTab(tab);
			while (victoire == false && tour != 42) {
				
				
				if (tour % 2 == 0) {
					 System.out.println("C'est votre tour " + noms[0] + " ! Quel colonne ?");
					 numcolonne = Integer.parseInt(saisie.nextLine());
					 choixjoueur=choixJetonJoueurUn(tab, numcolonne); 
					 
				} else {
					
					 if (choixtypeia == 1) {
						 choixJetonIaFaible(tab);
					 }
					 else {
						 choixJetonIaIntermediaire(tab,choixjoueur,numcolonne); 
					 }
					  
					
				}
				//Methode.choixJeton(tab, choix);
				 
					 Methode.afficherTab(tab);
				 
				 if(tour >= 5) {
					 victoire = verifVictoire(tab, choixjoueur, numcolonne);
				 }
					 
				 tour = tour+1;
			}
			if (tour == 42 ) {
				System.out.println("L'ia vous tient tête !"); // Egalité !
			}
			else {
				System.out.println("Nous avons un gagnant !");
					if (tour % 2 == 0) {// Le jeu s'est fini après que le  joueur ait joué  du coup le joueur 1 a gagné
				System.out.println("Bravo à " + noms[1] +"!");
				}
				else { // le joueur 2 a gagné
					System.out.println("L'IA  a gagné ");
					
				}
			}
			
			System.out.println();
			}
			
		// appel la méthode Mecanisme pion en mettant un numéro de colonne supérieur à 7 de sorte à ce que le jeton de l'ia faible soit déposer dans une colonne aléatoire
		public static void choixJetonIaFaible(int[][]tab) {
			mecanismePionIa(tab, 8);
		}
		//Demande à l'utilisateur quel joueur commencer en premier ou tire au sort...
		public static void commenceEnPremier(String[] noms) {
			int choixcommencer;
			
			java.util.Scanner saisie = new java.util.Scanner(System.in);
			System.out.println("Quel joueur commence en premier ? Ecrire 1 pour " + noms[0] + " Ecrire 2 pour "+ noms[1] + " Tapez 3 pour tirer au sort" );
			choixcommencer = Integer.parseInt(saisie.nextLine());
			while(choixcommencer < 1 || choixcommencer > 3) {
				System.out.println("Valeur saisie incorrecte veuillez choisir entre 1 et 3 ! Ecrire 1 pour " + noms[0] + " Ecrire 2 pour "+ noms[1] + " Tapez 3 pour tirer au sort");
				choixcommencer = Integer.parseInt(saisie.nextLine());
			}
			switch (choixcommencer) {
			case 1:
				System.out.println("Très bien ! c'est parti");
				break;
			case 2:
				
				String pivot; 
				
				pivot = noms[0];
				noms[0] = noms[1];
				noms[1] = pivot;
				System.out.println("Très bien ! c'est parti");
				break;
			case 3:
				if( Math.random() < 0.5) {
					pivot = noms[0];
					noms[0] = noms[1];
					noms[1] = pivot;
					System.out.println("Le sort en est jeté... le joueur 1 est " +  noms[0] +" !");
				} else {
					System.out.println("Le sort en est jeté... le joueur 1 est " + noms[0] + " !");
				}
				break;

			default:
				Menu.menu();
				break;
			}
		}
		//fonction recoit en parametre le plateau, la ligne et la colonne du pion qui retourne le boolean victoire apres avoir appeler les 4 méthodes de verification
		public static boolean verifVictoire( int[][]tab, int ligne, int colonne) {
			
			return( verifHorizontal(tab, ligne, colonne) || verifVerticale(tab, ligne, colonne) || verifDiagonaleGauche(tab) || verifDiagonaleDroite(tab, ligne, colonne) ) ;
		}
		// renvoi un boolean en fonction de si  4 pions sont alignés horizontalement après avoir recu la ligne et la colonne du pion joué
		public static boolean verifHorizontal(int[][] tab, int ligne, int col) {
			col = col-1;
			if (col <=3) { 
				for (int i=0; i <= col ; i++) {
					if (tab[ligne][i] == tab[ligne][i+1] && tab[ligne][i] == tab[ligne][i+2] && tab[ligne][i] == tab[ligne][i+3] && tab[ligne][i]!= 0 ) {
					return true;
					}
				}
			}
			else {
				for (int i = 6; i >= col ; i--) {
					if (tab[ligne][i] == tab[ligne][i-1] && tab[ligne][i] == tab[ligne][i-2] && tab[ligne][i] == tab[ligne][i-3] && tab[ligne][i]!= 0 ) {
						return true;
					}
				}
			}
			return false ;
		
			}
		//renvoi un boolean en fonction de si  4 pions sont alignés verticalement après avoir recu la ligne et la colonne du pion joué
		public static boolean verifVerticale(int[][] tab, int ligne, int col) {
			col = col-1;
			
				for(int i=ligne; i <= 2; i++) {
					if( tab[i][col] == tab[i+1][col] && tab[i][col] == tab[i+2][col] && tab[i][col] == tab[i+3][col] && tab[i][col] !=0) {
						return true;
					}
				}
				return false;
			
		}
	
// renvoi un boolean en fonction de si  4 pions sont aligné selon une diagonale droite après avoir recu la ligne et la colonne du pion joué
		public static boolean verifDiagonaleDroite(int[][]tab, int ligne, int col) { 
			
			col = col-1;
			
			int x;
			int y;
			x = ligne;
			y =  col; 
			// si la position du jeton correspond à la diagonale où la somme de la ligne et de la colonne fait 5 ou 6
			if (x + y == 5 || x + y == 6 ) {
				
				if( col > 3) {
					if( x + y == 5) {
						x = 0;
						y = 5;
					}
					else {
						x = 0;
						y = 6;
					}
					
					if (tab[x][y] == tab[x+1][y-1] && tab[x][y] == tab[x+2][y-2] && tab[x][y] == tab[x+3][y-3]  && tab[x][y]!=0) {
						return true;
					}
					while(x != ligne && y != col) {
						
						if (tab[x][y] == tab[x+1][y-1] && tab[x][y] == tab[x+2][y-2] && tab[x][y] == tab[x+3][y-3]  && tab[x][y]!=0) {
							return true;
						}
						x++;
						y--;
					}
				}
			
			    else {
			    	if(x + y == 5) {
			    		x=5;
						y=0;
			    	}
			    	else {
			    		x = 5;
			    		y = 1;
			    	}
				
					while(x != ligne && y != col) {
						
						if (tab[x][y] == tab[x-1][y+1] && tab[x][y] == tab[x-2][y+2] && tab[x][y] == tab[x-3][y+3]  && tab[x][y]!=0) {
							return true;
						}
						x--;
						y++;
					}
				
				}
			}
			
			else if( x + y == 3 || x+y == 8 ) {
				if (x + y == 3) {
					x=3;
					y=0;
				}else {
					x=5;
					y=3;
				}
			
			
				if (tab[x][y] == tab[x-1][y+1] && tab[x][y] == tab[x-2][y+2] && tab[x][y] == tab[x-3][y+3]  && tab[x][y]!=0) {
					return true;
				}
				
			}else if ( x + y == 4 || x + y == 7) {
				if (x + y == 4) {
					x=4;
					y=0;
				}else {
					x=5;
					y=2;
				}
			 for (int i = 0; i <2 ; i++ ) {
				 if (tab[x][y] == tab[x-1][y+1] && tab[x][y] == tab[x-2][y+2] && tab[x][y] == tab[x-3][y+3]  && tab[x][y]!=0) {
						return true;
					}
				 x--;
				 y++;
			 }
			}
			else {
				return false;
			}
			return false;
		}
		
					
			
			
		// renvoi un boolean en fonction de si  4 pions sont aligné horizontalement après avoir parcouru le tableau recu en paramètre					
		public static boolean verifDiagonaleGauche(int[][] tab) {
			for(int ligne=0; ligne < 3; ligne++) {
				for(int colonne = 0; colonne <= 3; colonne++) {
					if ( tab[ligne][colonne] == tab[ligne+1][colonne+1] && tab[ligne][colonne] == tab[ligne+2][colonne+2] && tab[ligne][colonne] == tab[ligne+3][colonne+3] && tab[ligne][colonne] !=0)
						return true;
				}
			}
			return false;
		}
		
		//Recoit la colonne choisi   par le joueur 1, place le pion  et lui demande à nouveau si il n'est pas possible de placer son pion à la colonne indiqué jusqu'à que le pion soit  placé
		public static int choixJetonJoueurUn(int [][] tab, int numcolonne) {
			java.util.Scanner saisie = new java.util.Scanner(System.in);
			 while( numcolonne < 1 || numcolonne > 7 || tab[0][numcolonne-1] == 1 || tab[0][numcolonne-1] == 2  ) {
				 
				System.out.println("Saisie incorrecte veuillez entrez une nouvelle colonne");
				numcolonne = Integer.parseInt(saisie.nextLine()); 
					
			 }
			boolean pionposé = false;
			int ligne = 5;
			while (!pionposé && ligne >= 0) {
				if (tab[ligne][numcolonne-1] == 1 || tab[ligne][numcolonne-1] == 2 ) {
										ligne--;
				}
				else {
					tab[ligne][numcolonne-1] = 1;
					pionposé = true;
				}
				
			}
			return ligne;
		}
		//Recoit la colonne choisi   par le joueur 2, place le pion  ou lui demande à nouveau si il n'est pas possible de placer son pion à la colonne indiqué jusqu'à que le pion soit placé
		public static int choixJetonJoueurDeux(int [][] tab, int numcolonne) {
			java.util.Scanner saisie = new java.util.Scanner(System.in);
			while(  numcolonne < 1 || numcolonne > 7 || tab[0][numcolonne-1] == 1 || tab[0][numcolonne-1] == 2  ) {
				 
				System.out.println("Saisie incorrecte veuillez entrez une nouvelle colonne");
				numcolonne = Integer.parseInt(saisie.nextLine()); 
					
			 }
			boolean pionposé = false;
			int ligne = 5;
			while (!pionposé && ligne >=0) {
				if (tab[ligne][numcolonne-1] == 1 || tab[ligne][numcolonne-1] == 2 ) {
					ligne--;
				}
				else {
					tab[ligne][numcolonne-1] = 2;
					pionposé = true;
				}
				}
				return ligne;
		}
		
		//recoit la colonne préalablement déterminé, ou choisit une colonne au hasard jusqu'à que le pion de l'ordinateur soit placé 
		public static void mecanismePionIa(int [][]tab, int col) {
			
			
			while(  col < 0 || col > 6 || tab[0][col] == 1 || tab[0][col] == 2  ) {
				 
				
				col = (int)(Math.random() * 6) + 1 ;
					
			 }
			boolean pionposé = false;
			int ligne = 5;
			while (!pionposé && ligne >=0) {
				if (tab[ligne][col] == 1 || tab[ligne][col] == 2 ) {
					ligne--;
				}
				else {
					tab[ligne][col] = 2;
					pionposé = true;
				}
				}
			}
		//recoit la ligne et la colonne du pion joué par le joueur 1, et en fonction de ca la méthode détermine la colonne que doit choisir l'ia et effectue l'appel de méthode mecanismePionIa
public static void choixJetonIaIntermediaire(int[][]tab, int choixligne,int numcol) {
	int colia=-2;
	numcol = numcol -1;
		for (int i=0; i <=4 && colia == -2  ; i++) {
			if (tab[choixligne][i] == tab[choixligne][i+1] && tab[choixligne][i] == tab[choixligne][i+2] && tab[choixligne][i]!=0) {
				if (i != 4) { 
					if (tab[choixligne][i+3]== 0) {
						colia = i+3;
					}
					
				}
				else {
					if (i != 0 && tab[choixligne][i-1] == 0)
					colia = i-1;
				}
			}
		}
		if( choixligne < 5 && choixligne > 0) {
			if (tab[choixligne][numcol] == tab[choixligne+1][numcol] ) {
				colia = numcol;
			}
			else {
				colia = (int)(Math.random() * 6) + 1 ;
			}
		}
		else {
				if( numcol < 5 && numcol > 1) {
					
					if ( tab[choixligne][numcol] == 1 && tab[choixligne][numcol-1] == 1) {
		
						if (tab[choixligne][numcol+1] == 0) {
							colia = numcol+1;
						}
						else if (tab[choixligne][numcol-2] == 0) {
							colia = numcol-2;
						}
						else {
							colia = (int)(Math.random() * 6) + 1 ;
						}	
					}
					else if ( tab[choixligne][numcol] == 1 && tab[choixligne][numcol+1] == 1)  {
						if (tab[choixligne][numcol+2] == 0) {
							colia = numcol+2;
						}
						else if (tab[choixligne][numcol-1] == 0) {
							colia = numcol-1;
						}
						else {
							colia = (int)(Math.random() * 6) + 1 ;
						}
					}
		
					else   {
						colia = (int)(Math.random() * 6) + 1 ;
					}
				}
			}
	
		
	mecanismePionIa(tab, colia);
}
}

