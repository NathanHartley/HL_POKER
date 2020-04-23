package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Evaluation {

	// Vérifie si les cartes se suivent
	private static Boolean royalStraighFlush = false;

	// Nombre de cartes par rapport aux sortes
	private static int clubsNumber = 0, spadesNumber = 0, heartsNumber = 0, diamondsNumber = 0;

	// Nombre et le nom de la sorte le plus grand
	private static int number = 0;
	private static String kind = "";

	// Entrepose les valeurs des cartes en ordre (un qui répète et l'autre non)
	private static ArrayList<Integer> straightRepeat, straightNoRepeat;
	
	// Entrepose la sorte de main la plus haute
	private static String win;

	// Listes des numéros des sortes de cartes
	private static ArrayList<Integer> clubs, spades, hearts, diamonds;
	
	// Liste principale, les total cartes joueurs
	private static ArrayList<Integer> cartes;
	
	// Pour créer la liste straightNoRepeat && trouver la somme
	private static int current, count = 0, sum = 0;
	private static LinkedHashSet<Integer> set;
	
	// Entrepose le nombre de carte entre 2-14
	private static Map<String, Integer> map;
	private static String[] names;
	
	// Ce qui est retourné lorsque la fonction est appelé
	private static String[] turn;
	
	public static String[] evaluate(ArrayList<Integer> player, ArrayList<Integer> dealer) {

		// Crée un 'ArrayList' des cartes pour le joueur
		cartes = new ArrayList<Integer>();
		cartes.addAll(player);
		cartes.addAll(dealer);

		// Trie le ArrayList en ordre croissant
		Collections.sort(cartes);

		// Définie les cartes et leurs sortes
		clubs = new ArrayList<Integer>();
		spades = new ArrayList<Integer>();
		hearts = new ArrayList<Integer>();
		diamonds = new ArrayList<Integer>();
		for (int i = 1; i <= 13; i++) {
			clubs.add(i);
			spades.add(13 + i);
			hearts.add(26 + i);
			diamonds.add(39 + i);
		}

		// Vérifie le nombre de cartes de chaque sorte
		for (int i = 0; i <= 12; i++) {
			if (cartes.contains(clubs.get(i))) {
				clubsNumber = clubsNumber + 1;
			}
			if (cartes.contains(spades.get(i))) {
				spadesNumber = spadesNumber + 1;
			}
			if (cartes.contains(hearts.get(i))) {
				heartsNumber = heartsNumber + 1;
			}
			if (cartes.contains(diamonds.get(i))) {
				diamondsNumber = diamondsNumber + 1;
			}
		}

		// Détermine quel sorte de cartes retrouvé le plus
		if (number < clubsNumber) {
			number = clubsNumber;
			kind = "clubs";
		}
		if (number < spadesNumber) {
			number = spadesNumber;
			kind = "spades";
		}
		if (number < heartsNumber) {
			number = heartsNumber;
			kind = "hearts";
		}
		if (number < diamondsNumber) {
			number = diamondsNumber;
			kind = "diamonds";
		}

		// Vérifie si les cartes se suivent
		if (number >= 5) {
			for (int i = 0; i < cartes.size() - 2; i++) {
				try {
				if (cartes.get(i + 1) == cartes.get(i) + 1 && cartes.get(i + 2) == cartes.get(i) + 2
						&& cartes.get(i + 3) == cartes.get(i) + 3 && cartes.get(i + 4) == cartes.get(i) + 4) {
					for (int j = 0; j < 5; j++) {
						hand = hand + cartes.get(i + j);
					}
					royalStraighFlush = true;
					break;
				}
				} catch (IndexOutOfBoundsException e) {
					break;
				}
			}
		}
		
		// Mets des nombres de 2-14 && calcule le total
		straightRepeat = new ArrayList<Integer>();
		for (int e : cartes) {
			current = cartes.get(count);
			current++;
			if (e <= 13) {
			} else if (e <= 26) {
				current = current - 13;
			} else if (e <= 39) {
				current = current - 26;
			} else if (e <= 52) {
				current = current - 39;
			}
			straightRepeat.add(current);
			count++;
			sum = sum + current;
		}

		// Enlève Removes duplicates in the set && puts them back in a ArrayList
		set = new LinkedHashSet<Integer>();
		set.addAll(straightRepeat);
		straightNoRepeat = new ArrayList<Integer>();
		straightNoRepeat.addAll(set);

		// Trie l'ArrayList straightNoRepeat && straightRepeat en ordre croissant
		Collections.sort(straightNoRepeat);
		Collections.sort(straightRepeat);

		// Compte le nombre de nombre se trouvant dans la liste straightRepeat
		map = new HashMap<String, Integer>();
		names = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14" };
		for (int i = 0; i < names.length; i++) {
			map.put(names[i], 0);
		}
		for (int e : straightRepeat) {
			map.replace(String.valueOf(e), map.get(String.valueOf(e)) + 1);
		}

		main: while (true) {
			// Détermine si c'est un royal flush on une straight flush
			if (royalStraighFlush) {
				if (String.valueOf(kind).equals("clubs")) {
					if (cartes.contains(13)) {
						win = "royalFlush";
					} else {
						win = "straightFlush";
					}
				} else if (String.valueOf(kind).equals("spades")) {
					if (cartes.contains(26)) {
						win = "royalFlush";
					} else {
						win = "straightFlush";
					}
				} else if (String.valueOf(kind).equals("hearts")) {
					if (cartes.contains(39)) {
						win = "royalFlush";
					} else {
						win = "straightFlush";
					}
				} else if (String.valueOf(kind).equals("diamonds")) {
					if (cartes.contains(52)) {
						win = "royalFlush";
					} else {
						win = "straightFlush";
					}
				}
				break main;
			}

			// Détermine si c'est un four of a kind
			for (String e : names) {
				if (map.get(e) == 4) {
					hand = Integer.valueOf(e) * 4;
					win = "fourOfAKind";
					break main;
				}
			}

			// Détermine si c'est un full house
			for (String e : names) {
				if (map.get(e) == 3) {
					for (String f : names) {
						if (map.get(f) == 2) {
							hand = (Integer.valueOf(e) * 3) + (Integer.valueOf(f) * 2);
							win = "fullHouse";
							break main;
						}
					}
				}
			}

			// Détermine si c'est un flush
			if (number >= 5) {
				int i = 0;
				if (String.valueOf(kind).equals("clubs")){
				} else if (String.valueOf(kind).equals("spades")){
					i = 13;
				} else if (String.valueOf(kind).equals("hearts")){
					i = 26;
				} else if (String.valueOf(kind).equals("diamonds")){
					i = 39;
				}
				for (int e : cartes){
					if (e > i && e <= i + 13){
						hand = hand + (e - i);
					}
				}
				win = "flush";
				break main;
			}

			// Détermine si c'est une suite
			if (straightNoRepeat.size() >= 5) {
				for (int i = 0; i < straightNoRepeat.size() - 2; i++) {
					try {
						if (straightNoRepeat.get(i + 1) == straightNoRepeat.get(i) + 1
								&& straightNoRepeat.get(i + 2) == straightNoRepeat.get(i) + 2
								&& straightNoRepeat.get(i + 3) == straightNoRepeat.get(i) + 3
								&& straightNoRepeat.get(i + 4) == straightNoRepeat.get(i) + 4) {

							for (int j = 0; j < 5; j++) {
								hand = hand + straightNoRepeat.get(i + j);
							}
							win = "straight";
							break main;
						}
					} catch (IndexOutOfBoundsException e) {
						break;
					}

				}
			}

			// Détermine si c'est un deux paires
			for (String e : names) {
				if (map.get(e) >= 2) {
					for (String f : names) {
						if (map.get(f) >= 2 && f != e) {
							hand = (Integer.valueOf(e) * 2) + (Integer.valueOf(f) * 2);
							win = "twoPair";
							break main;
						}
					}
				}
			}

			// Détermine si c'est un three of a kind
			for (String e : names) {
				if (map.get(e) == 3) {
					hand = Integer.valueOf(e) * 3;
					win = "threeOfAKind";
					break main;
				}
			}

			// Détermine si c'est une pair
			for (String e : names) {
				if (map.get(e) == 2) {
					hand = Integer.valueOf(e) * 2;
					win = "onePair";
					break main;
				}
			}

			// Détermine s'il y a rien
			hand = sum;
			win = "highCards";
			break main;

		}

		// Ce qui est retourné lorsque la fonction est appelé
		turn = new String[] { win, String.valueOf(sum), String.valueOf(hand) };
		clear();
		return turn;
	}

	private static int hand = 0;;

	// Rétablie tous les variables pour que cette fonction soit réutilisable
	public static void clear() {
		set.clear();
		straightNoRepeat.clear();
		straightRepeat.clear();
		win = "";
		number = 0;
		kind = "";
		clubsNumber = 0;
		spadesNumber = 0;
		heartsNumber = 0;
		diamondsNumber = 0;
		royalStraighFlush = false;
		hand = 0;
		sum = 0;
		count = 0;
	}
}
