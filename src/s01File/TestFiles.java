package s01File;

import java.io.File;

public class TestFiles {
	public static void main(String[] args) {

		//11
		// fichier existant
		File e = new File("test.txt");
		// fichier inéxistant
		File i = new File("inconnu.txt");
		// répertoire
		File d = new File("srt");

		// test fichier éxistant
		System.out.println("Chemin absolu : " + e.getAbsolutePath());
		System.out.println("Nom du fichier : " + e.getName());
		System.out.println("Est-ce qu'il existe ? " + e.exists());
		System.out.println("Est-ce un répertoire ? " + e.isDirectory());
		System.out.println("Est-ce un fichier ? " + e.isFile());
		System.out.println("Taille ? " + e.getTotalSpace() + " bytes");
		System.out.println();

		// test fichier inéxistant
		System.out.println("Chemin absolu : " + i.getAbsolutePath());
		System.out.println("Nom du fichier : " + i.getName());
		System.out.println("Est-ce qu'il existe ? " + i.exists());
		System.out.println("Est-ce un répertoire ? " + i.isDirectory());
		System.out.println("Est-ce un fichier ? " + i.isFile());
		System.out.println("Taille ? " + i.getTotalSpace() + " bytes");
		System.out.println();

		// test répertoire
		System.out.println("Chemin absolu : " + d.getAbsolutePath());
		System.out.println("Nom du fichier : " + d.getName());
		System.out.println("Est-ce qu'il existe ? " + d.exists());
		System.out.println("Est-ce un répertoire ? " + d.isDirectory());
		System.out.println("Est-ce un fichier ? " + d.isFile());
		System.out.println("Taille ? " + d.getTotalSpace() + " bytes");
		System.out.println();

		
		
		//12
		System.out.println("Contenu du répertoire " + d);
		String[] paths;
		try {
			// on utilise le répertoire d défini au début de la classe
			paths = d.list();

			for (String path : paths) {
				System.out.println(path);
			}
		} catch (Exception t) {
			t.printStackTrace();
		}

	}
}