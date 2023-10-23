package n3ex01;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Redactor> redactors = new ArrayList<Redactor>();
	static String msg = "";
//	static ArrayList<Noticia> noticies = new ArrayList<Noticia>();
	
	public static void main(String[] args) {
		
//		Redactor red1 = new Redactor("Maria","12345678A");
//		
//		
		
		int opcio = 0;
		int subOpcio = 0;
		
		String nomR, dniR, titularN;
		int puntN, preuN;
		int redacIndex = -1;
		int notIndex = -1;
		
		do {
			System.out.println("Menú Redacció\n"
					+ "0.- Sortir de l'aplicació\n"
					+ "1.- Introduir redactor\n"
					+ "2.- Eliminar redactor\n"
					+ "3.- Introduir notícia a un redactor\n"
					+ "4.- Eliminar notícia\n"
					+ "5.- Mostrar totes les notícies per redactor\n"
					+ "6.- Calcular puntuació de la notícia\n"
					+ "7.- Calcular preu notícia\n");
			opcio = sc.nextInt();
			sc.nextLine();
			
			switch(opcio) {
			case 0:
				msg = "Ha decidit sortir de l'aplicació\n";
				break;
			case 1:
				System.out.println("Per introduir un redactor,\nIntrodueixi el nom del redactor:");
				nomR = sc.nextLine();
				System.out.println("Introdueixi el DNI del redactor:");
				dniR = sc.nextLine();
				// buscar que el dni no estigui a la bd pq només n'hi pot haver un
				boolean existeix = trobarDni(dniR);
				if(existeix == false) {
					introdRedactor(nomR, dniR, redactors);
				} else {
					msg = "Error! Aquest redactor ja existeix\n";
				}
				break;
			case 2:
				System.out.println("Per eliminar un redactor,\nIntrodueixi el seu dni");
				dniR = sc.nextLine();
				// buscar redactor index i eliminar
				redacIndex = trobarRedactor(dniR);
				if(redacIndex != -1) {
					eliminarRedactor(redacIndex);
				} else {
					msg = "Error! No existeix cap redactor amb aquest DNI que es pugui eliminar\n";
				}
				break;
			case 3:
				System.out.println("Per introduir una notícia a un redactor,\nIntrodueixi el seu dni");
				dniR = sc.nextLine();
				redacIndex = trobarRedactor(dniR);
				if(redacIndex != -1) {
					System.out.println("Quin tipus de notícia vol donar d'alta?\n"
							+ "1. Futbol\n"
							+ "2. Bàsquet\n"
							+ "3. Tenis\n"
							+ "4. F1\n"
							+ "5. Motociclisme");
					subOpcio = sc.nextInt();
					sc.nextLine();
					System.out.println("Introdueixi el titular de la notícia:");
					titularN = sc.nextLine();
					introdNotaRedactor(subOpcio, redacIndex, titularN);
				} else {
					msg = "Error, redactor inexistent! No podem introduir una notícia, introdueixi primer un redactor\n";
				}
				break;
			case 4:
				System.out.println("Per eliminar una notícia,\nIntrodueixi el dni del seu redactor");
				dniR = sc.nextLine();
				redacIndex = trobarRedactor(dniR);
				if(redacIndex != -1) {
					System.out.println("Introdueixi el titular de la notícia a eliminar");
					titularN = sc.nextLine();
					msg = eliminarNoticia(redacIndex, titularN);
				} else {
					msg = "Error! No existeix cap redactor amb aquest DNI, per tant no hi ha cap notícia que es pugui eliminar\n";
				}
				// demanar redactor i titular de la notícia
//				confirmacio = 
				break;
			case 5:
				System.out.println("Per mostrar totes les notícies per redactor,\\nIntrodueixi'n el dni");
				dniR = sc.nextLine();
				redacIndex = trobarRedactor(dniR);
				if(redacIndex != -1) {
					if(redactors.get(redacIndex).getNoticies().size() > 0) {
						redacIndex = trobarRedactor(dniR);
						System.out.println("A continuació mostrem les notícies del redactor:");
//						System.out.println(redactors.get(redacIndex).getNoticies().toString());
						mostrarTotesNotXRed(redacIndex);
					} else {
						msg = "El redactor encara no ha escrit cap notícia que poguem mostrar.\n";
					}
				} else {
					msg = "Error! No existeix cap redactor amb aquest DNI, per tant no hi ha cap notícia que es pugui mostrar\n";
				}
				break;
			case 6:
				System.out.println("Per calcular la puntuació de la notícia,\\nIntrodueixi el dni del redactor:");
				dniR = sc.nextLine();
				System.out.println("I el titular de la notícia");
				titularN = sc.nextLine();
				redacIndex = trobarRedactor(dniR);
				if(redacIndex != -1) {
					if(redactors.get(redacIndex).getNoticies().size() > 0) {
						notIndex = trobarNoticia(redacIndex, titularN);
						System.out.println("A continuació calculem la puntuació de la notícia:");
						puntN = redactors.get(redacIndex).getNoticies().get(notIndex).calcularPuntuacioNoticia();
						msg = "Preu: " + puntN + "€.";
					} else {
						msg = "El redactor encara no ha escrit cap notícia que poguem calcular la puntuació.\n";
					}
				} else {
					msg = "Error! No existeix cap redactor amb aquest DNI\n";
				}
				break;
			case 7:
				System.out.println("Per calcular el preu de la notícia,\\nIntrodueixi el dni del redactor:");
				dniR = sc.nextLine();
				System.out.println("I el titular de la notícia");
				titularN = sc.nextLine();
				redacIndex = trobarRedactor(dniR);
				if(redacIndex != -1) {
					if(redactors.get(redacIndex).getNoticies().size() > 0) {
						notIndex = trobarNoticia(redacIndex, titularN);
						System.out.println("A continuació calculem el preu de la notícia:");
						preuN = redactors.get(redacIndex).getNoticies().get(notIndex).calcularPreuNoticia();
						msg = "Preu: " + preuN + "€.";
					} else {
						msg = "El redactor encara no ha escrit cap notícia que poguem calcular la puntuació.\n";
					}
				} else {
					msg = "Error! No existeix cap redactor amb aquest DNI\n";
				}
				break;
			default:
				msg = "Error! Esculli una opció vàlida entre 0 i 7.\n";
				break;
			}
			
			System.out.println(msg);
			
		} while(opcio != 0);

	}
	
	// Mètodes del menú
	/** 1.- Introduir redactor */
	public static void introdRedactor(String nomR, String dniR, ArrayList<Redactor> redactors) {
			redactors.add(new Redactor(nomR, dniR));
			redactors.add(new Redactor("Maria","12345678Z"));
			redactors.add(new Redactor("Jordi","32165487X"));
			System.out.println(redactors.toString());
	}
	
	/** 2.- Eliminar redactor */
	public static void eliminarRedactor(int redacIndex) {
		redactors.remove(redacIndex);
		System.out.println("El redactor s'han eliminat correctament");
	}
	
	/** 3.- Introduir notícia a un redactor */
	public static void introdNotaRedactor(int subOpcio, int redacIndex, String titularN) {
		String comp, club;
		
		switch(subOpcio) {
		case 1:
			String jug;
			System.out.println("Al ser una notícia de Futbol, introdueixi les següents dades:\nCompetició:");
			comp = sc.nextLine();
			System.out.println("Club:");
			club = sc.nextLine();
			System.out.println("Jugador:");
			jug = sc.nextLine();
			redactors.get(redacIndex).setNoticies(new NotFutbol(titularN, comp, club, jug));
			redactors.get(redacIndex).setNoticies(new NotFutbol("Campiones","LLiga campions","Barça","Mapi"));
			redactors.get(redacIndex).setNoticies(new NotFutbol("Partit ajustat","LLiga","Barça","Ferran Torres"));
			redactors.get(redacIndex).setNoticies(new NotFutbol("Partit perdut","LLiga","Madrid","Benzema"));
			System.out.println(redactors.get(redacIndex).getNoticies().toString());
			break;
		case 2:
			System.out.println("Al ser una notícia de Bàsquet, introdueixi les següents dades:\nCompetició:");
			comp = sc.nextLine();
			System.out.println("Club:");
			club = sc.nextLine();
			redactors.get(redacIndex).setNoticies(new NotBasquet(titularN, comp, club));
			redactors.get(redacIndex).setNoticies(new NotBasquet("Grans perdedors", "ABC", "Madrid"));
			redactors.get(redacIndex).setNoticies(new NotBasquet("Campions", "Eurolliga", "Barça"));
			System.out.println(redactors.get(redacIndex).getNoticies().toString());
			break;
		case 3:
			String tenista;
			System.out.println("Al ser una notícia de Tenis, introdueixi les següents dades:\nCompetició:");
			comp = sc.nextLine();
			System.out.println("Tenista:");
			tenista = sc.nextLine();
			redactors.get(redacIndex).setNoticies(new NotTenis(titularN, comp, tenista));
			redactors.get(redacIndex).setNoticies(new NotTenis("Favorits a l'Open", "Open Austàlia", "Djokovic"));
			redactors.get(redacIndex).setNoticies(new NotTenis("Propera competició", "Roland-Garros", "Federer"));
			System.out.println(redactors.get(redacIndex).getNoticies().toString());
			break;
		case 4:
			String escud;
			System.out.println("Al ser una notícia de F1, introdueixi les següents dades:\nEscuderia:");
			escud = sc.nextLine();
			redactors.get(redacIndex).setNoticies(new NotF1(titularN, escud));
			redactors.get(redacIndex).setNoticies(new NotF1("Gran Prix de Monaco", "Red Bull"));
			redactors.get(redacIndex).setNoticies(new NotF1("Australian Gran Prix", "Mercedes"));
			System.out.println(redactors.get(redacIndex).getNoticies().toString());
			break;
		case 5: 
			String equip;
			System.out.println("Al ser una notícia de Motociclisme, introdueixi les següents dades:\nEquip:");
			equip = sc.nextLine();
			redactors.get(redacIndex).setNoticies(new NotMotoc(titularN, equip));
			redactors.get(redacIndex).setNoticies(new NotMotoc("València MotoGP", "Aprilia"));
			redactors.get(redacIndex).setNoticies(new NotMotoc("Grand Prix de France", "Yamaha"));
			System.out.println(redactors.get(redacIndex).getNoticies().toString());
		default:
			System.out.println("Error! Esculli una opció entre 1 i 5");
		}
//		System.out.println(noticies.toString());
	}
	
	/** 4.- Eliminar notícia */
	public static String eliminarNoticia(int redacIndex, String titularN) {
		if(redactors.get(redacIndex).getNoticies().size() > 0) {
			int notIndex = trobarNoticia(redacIndex, titularN);
			redactors.get(redacIndex).getNoticies().remove(notIndex);
			msg = "La notícia s'ha eliminat correctament\n";
		} else {
			msg = "Encara no hi ha cap notícia per poder eliminar";
		}
		return msg;
	}
	
	/** 5.- Mostrar totes les notícies per redactor */
	public static void mostrarTotesNotXRed(int redacIndex) {
		String tipusNot;
		
		for(int i = 0; i < redactors.get(redacIndex).getNoticies().size(); i++) {
			System.out.println("- " + redactors.get(redacIndex).getNoticies().get(i).toString());
			tipusNot = redactors.get(redacIndex).getNoticies().get(i).getTipusNot();
			
			switch(tipusNot) {
			case "Futbol":
				System.out.println("Notícies de Futbol:");
				NotFutbol nFut = (NotFutbol) redactors.get(redacIndex).getNoticies().get(i);
				break;
			case "Basquet":
				System.out.println("Notícies de Bàsquet:");
				NotBasquet nBasq = (NotBasquet) redactors.get(redacIndex).getNoticies().get(i);
				break;
			case "Tenis":
				System.out.println("Notícies de Tenis:");
				NotTenis nTen = (NotTenis) redactors.get(redacIndex).getNoticies().get(i);
				break;
			case "F1":
				System.out.println("Notícies de F1:");
				NotF1 nF1 = (NotF1) redactors.get(redacIndex).getNoticies().get(i);
				break;
			case "Motociclisme":
				System.out.println("Notícies de Motociclisme:");
				NotMotoc nMotoc = (NotMotoc) redactors.get(redacIndex).getNoticies().get(i);
				break;
			}
		}
	}
	
	// Mètodes per trobar
	/** Trobar si un DNI ja existeix.
	 * Pq només n'hi ha un per persona, no es pot repetir */
	public static boolean trobarDni(String dniR) {
		boolean trobat = false;
		int i = 0;
		
		while(i < redactors.size() && !trobat) {
			if(dniR.equalsIgnoreCase(redactors.get(i).getDNI())) {
				trobat = true;
			}
			i++;
		}
		return trobat;
	}
	
	/** Trobar index del redactor dins l'array */
	public static int trobarRedactor(String dniR) {
		boolean trobat = false;
		int i = 0;
		int redacIndex = -1;
		
		while(i < redactors.size() && !trobat) {
			
			if(dniR.equalsIgnoreCase(redactors.get(i).getDNI())) {
				redacIndex = i;
				trobat = true;
			}
			i++;
		}
		return redacIndex;
	}
	
	/** Trobar index de la notícia a través del redactor i el titular */
	public static int trobarNoticia(int redacIndex, String titularN) {
		boolean trobat = false;
		int i = 0;
		int notIndex = -1;
		
		while(i < redactors.get(redacIndex).getNoticies().size() && !trobat) {
			
			Noticia notActual = redactors.get(redacIndex).getNoticies().get(i);
			
			if(notActual.getTitular().equalsIgnoreCase(titularN)) {
				trobat = true;
				redacIndex = i;
			}
			i++;
		}
		return notIndex;
	}
	

}
