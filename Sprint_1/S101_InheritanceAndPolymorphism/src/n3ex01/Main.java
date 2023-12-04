package n3ex01;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Redactor> redactors = new ArrayList<Redactor>();

	
	public static void main(String[] args) {
	
		int opcio = 0;
		String msg = "";
		int subOpcio = 0;
		int redacIndex, notIndex;
		
		String nomR, dniR, titularN;
		int puntN, preuN;
		/* data per testejar
		{
			redactors.add(new Redactor("Maria","123a"));
			redactors.add(new Redactor("Jordi","32165487X"));
			redactors.get(0).setNoticies(new NotFutbol("Partit ajustat","LLiga","Barça","Ferran Torres"));
			redactors.get(1).setNoticies(new NotFutbol("Campiones","LLiga campions","Barça","Mapi"));
			redactors.get(0).setNoticies(new NotFutbol("Partit perdut","LLiga","Madrid","Benzema"));
			redactors.get(0).setNoticies(new NotBasquet("Grans perdedors", "ABC", "Madrid"));
			redactors.get(1).setNoticies(new NotBasquet("Campions", "Eurolliga", "Barça"));
			redactors.get(0).setNoticies(new NotTenis("Favorits a l'Open", "Open Austàlia", "Djokovic"));
			redactors.get(1).setNoticies(new NotTenis("Propera competició", "Roland-Garros", "Federer"));
			redactors.get(0).setNoticies(new NotF1("Gran Prix de Monaco", "Red Bull"));
			redactors.get(1).setNoticies(new NotF1("Australian Gran Prix", "Mercedes"));
			redactors.get(0).setNoticies(new NotMotoc("València MotoGP", "Aprilia"));
			redactors.get(1).setNoticies(new NotMotoc("Grand Prix de France", "Yamaha"));
		}
		*/
		
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
				nomR = introduirDadesStr("Per introduir un redactor,\nIntrodueixi el nom del redactor:");
				dniR = introduirDadesStr("Introdueixi el DNI del redactor:");
				// buscar que el dni no estigui a la bd pq només n'hi pot haver un
				boolean existeix = trobarDni(dniR);
				if(existeix == false) {
					introdRedactor(nomR, dniR, redactors);
				} else {
					System.out.println("Error! Aquest redactor ja existeix\n");
				}
				break;
			case 2:
				dniR = introduirDadesStr("Per eliminar un redactor,\nIntrodueixi el seu dni:");
				// buscar redactor index i eliminar
				redacIndex = trobarRedactor(dniR);
				if(redacIndex != -1) {
					eliminarRedactor(redacIndex);
				} else {
					System.out.println("Error! No existeix cap redactor amb aquest DNI que es pugui eliminar\n");
				}
				break;
			case 3:
				dniR = introduirDadesStr("Per introduir una notícia a un redactor,\nIntrodueixi el seu dni:");
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
					titularN = introduirDadesStr("Introdueixi el titular de la notícia:");
					introdNotaRedactor(subOpcio, redacIndex, titularN);
				} else {
					System.out.println("Error, redactor inexistent o dni erroni! No podem introduir cap notícia");
				}
				break;
			case 4:
				dniR = introduirDadesStr("Per eliminar una notícia,\nIntrodueixi el dni del seu redactor:");
				redacIndex = trobarRedactor(dniR);
				
				if(redacIndex != -1) {
					titularN = introduirDadesStr("Introdueixi el titular de la notícia a eliminar");
					notIndex = trobarNoticia(redacIndex, titularN);
					if(notIndex != -1) {
						eliminarNoticia(redacIndex, notIndex);
					} else {
						System.out.println("Error! Aquest redactor no té cap notícia amb aquest titular");
					}
				} else {
					System.out.println("Error! No existeix cap redactor amb aquest DNI, per tant no hi ha cap notícia que es pugui eliminar");
				}
				break;
			case 5:
				dniR = introduirDadesStr("Per mostrar totes les notícies per redactor,\nIntrodueixi'n el dni:");
				redacIndex = trobarRedactor(dniR);
				if(redacIndex != -1) {
					if(redactors.get(redacIndex).getNoticies().size() > 0) {
						System.out.println("A continuació mostrem les notícies del redactor amb DNI " + dniR +":");
						mostrarTotesNotXRed(redacIndex);
					} else {
						System.out.println("El redactor encara no ha escrit cap notícia que poguem mostrar");
					}
				} else {
					System.out.println("Error! No existeix cap redactor amb aquest DNI, per tant no hi ha cap notícia que es pugui mostrar");
				}
				break;
			case 6:
				dniR = introduirDadesStr("Per calcular la puntuació de la notícia,\nIntrodueixi el dni del redactor:");
				redacIndex = trobarRedactor(dniR);
				if(redacIndex != -1) {
					titularN = introduirDadesStr("I el titular de la notícia");
					notIndex = trobarNoticia(redacIndex, titularN);
					if(notIndex != -1) {
						System.out.println("A continuació calculem la puntuació de la notícia:");
						puntN = redactors.get(redacIndex).getNoticies().get(notIndex).calcularPuntuacioNoticia();
						System.out.println("Puntuació: " + puntN + " punts.");
					} else {
						System.out.println("El redactor encara no ha escrit cap notícia amb aquest titular");
					}
				} else {
					System.out.println("Error! No existeix cap redactor amb aquest DNI");
				}
				break;
			case 7:
				dniR = introduirDadesStr("Per calcular el preu de la notícia,\nIntrodueixi el dni del redactor:");
				redacIndex = trobarRedactor(dniR);
				if(redacIndex != -1) {
					titularN = introduirDadesStr("I el titular de la notícia");
					notIndex = trobarNoticia(redacIndex, titularN);
					if(notIndex != -1) {
						System.out.println("A continuació calculem el preu de la notícia:");
						preuN = redactors.get(redacIndex).getNoticies().get(notIndex).calcularPreuNoticia();
						System.out.println("Preu: " + preuN + "€.");
					} else {
						System.out.println("El redactor encara no ha escrit cap notícia amb aquest titular");
					}
				} else {
					System.out.println("Error! No existeix cap redactor amb aquest DNI");
				}
				break;
			default:
				msg = "Error! Esculli una opció vàlida entre 0 i 7.\n";
				break;
			}
			
			System.out.println(msg);
			
		} while(opcio != 0);

	}
	
	
	// MÈTODES
	
	// Mètode per introduir dades tipus String
	public static String introduirDadesStr(String msgXusuari) {
		System.out.println(msgXusuari);
		String str = sc.nextLine();
		return str;
	}
	
	// Mètodes del menú
	/** 1.- Introduir redactor */
	public static void introdRedactor(String nomR, String dniR, ArrayList<Redactor> redactors) {
		Redactor redacActual = new Redactor(nomR, dniR);
		redactors.add(redacActual);
		System.out.println(redacActual.toString());
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
			comp = introduirDadesStr("Al ser una notícia de Futbol, introdueixi les següents dades:\nCompetició:");
			club = introduirDadesStr("Club:");
			jug = introduirDadesStr("Jugador:");
			redactors.get(redacIndex).setNoticies(new NotFutbol(titularN, comp, club, jug));
			break;
		case 2:
			comp = introduirDadesStr("Al ser una notícia de Bàsquet, introdueixi les següents dades:\nCompetició:");
			club = introduirDadesStr("Club:");
			redactors.get(redacIndex).setNoticies(new NotBasquet(titularN, comp, club));
			break;
		case 3:
			String tenista;
			comp = introduirDadesStr("Al ser una notícia de Tenis, introdueixi les següents dades:\nCompetició:");
			tenista = introduirDadesStr("Tenista:");
			redactors.get(redacIndex).setNoticies(new NotTenis(titularN, comp, tenista));
			break;
		case 4:
			String escud;
			escud = introduirDadesStr("Al ser una notícia de F1, introdueixi les següents dades:\nEscuderia:");
			redactors.get(redacIndex).setNoticies(new NotF1(titularN, escud));
			break;
		case 5: 
			String equip;
			equip = introduirDadesStr("Al ser una notícia de Motociclisme, introdueixi les següents dades:\nEquip:");
			redactors.get(redacIndex).setNoticies(new NotMotoc(titularN, equip));
		default:
			System.out.println("Error! Esculli una opció entre 1 i 5");
		}
		System.out.println("Notícia introduïda correctament");
	}
	
	/** 4.- Eliminar notícia */
	public static void eliminarNoticia(int redacIndex, int notIndex) {
		redactors.get(redacIndex).getNoticies().remove(notIndex);
		System.out.println("La notícia s'ha eliminat correctament");
	}
	 
	/** 5.- Mostrar totes les notícies per redactor */
	public static void mostrarTotesNotXRed(int redacIndex) {
	 for (int i = 0; i < redactors.get(redacIndex).getNoticies().size(); i++) {
		 System.out.println((i+1) + "- " + redactors.get(redacIndex).getNoticies().get(i).toString());
	 }
	}
	
	// Mètodes per trobar
	/** Trobar si un DNI ja existeix.
	 * Pq només n'hi ha un per persona, no es pot repetir  */
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
			
			if(titularN.equalsIgnoreCase(redactors.get(redacIndex).getNoticies().get(i).getTitular())) {
				trobat = true;
				notIndex = i;
			}
			i++;
		}
		return notIndex;
	}
	

}
