package mediatheque;

import java.util.ArrayList;

import model.Cd;
import model.Dvd;
import model.Livre;
import model.Media;
import utilitaires.Utilitaires;

public class Menu {

	static boolean appliOn = true;

	public static void menuPrincipal(ArrayList<Media> alMedia) {

		System.out.println("Bonjour");
		do {

			System.out.println("1 Create");
			System.out.println("2 Read");
			System.out.println("3 Update");
			System.out.println("4 Delete");
			System.out.println("5 Exit");

			int i = Utilitaires.readInt();

			switch (i) {
			case 1: System.out.println("Creer 1 Livre, 2 DVD, 3 CD")	;
				int toCreate = Utilitaires.readInt();
				System.out.println("Le nom : ");
				String nameToBeCreated = Utilitaires.saisieString();
				Media mediaToBeCreated;
				switch(toCreate) {
				case 1:
					mediaToBeCreated=new Livre(Utilitaires.returnMaxIndexFromAL(alMedia)+1
							, nameToBeCreated, "", "", "", 1);
					alMedia.add(mediaToBeCreated);
					break;
				case 2:
					mediaToBeCreated=new Dvd(Utilitaires.returnMaxIndexFromAL(alMedia)+1
							, nameToBeCreated, "", "", "");
					alMedia.add(mediaToBeCreated);
					break;

				case 3:
					mediaToBeCreated=new Cd(Utilitaires.returnMaxIndexFromAL(alMedia)+1
							, nameToBeCreated, "", "", "");
					alMedia.add(mediaToBeCreated);
					break;

				}
				break;
				
			case 2:
				Utilitaires.readArrayList(alMedia);
				break;
			case 3:
				Utilitaires.readArrayList(alMedia);
				int toBeModified = Utilitaires.readInt();
				if(alMedia.size() >= toBeModified && toBeModified > 0) {
					alMedia.get(toBeModified-1).invertDisponible();
				}
				break;
			case 4:
				Utilitaires.readArrayList(alMedia);
				int toBeDeleted = Utilitaires.readInt();
				alMedia.remove(toBeDeleted-1);
				break;
			case 5:
				appliOn = false;
				break;
			default:
				;
			}

		} while (appliOn);

	}

}
