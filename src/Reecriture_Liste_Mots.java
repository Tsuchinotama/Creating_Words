import java.io.*;

public class Reecriture_Liste_Mots 
{
	public static void Exo()
	{
		
		File entree = new File("liste_bons_mots.txt");
		File sortie = new File("temp.txt");
		try {
		BufferedReader br = new BufferedReader(new FileReader(entree));
		BufferedWriter bw = new BufferedWriter(new FileWriter(sortie));
		String mot=br.readLine();
		String mot_suivant=br.readLine();
		while (mot_suivant != null){
			while (mot_suivant.equals(mot) || 
					Character.isUpperCase(mot_suivant.charAt(0)) ||
					mot_suivant.contains(" ") ||
					mot_suivant.contains("-") ||
					mot_suivant.contains("'") ||
					mot_suivant.contains("(") ||
					mot_suivant.contains(")") ||
					mot_suivant.length()<3)
			{
				mot_suivant=br.readLine();
			}
			bw.write(mot + "\n");
		    mot=mot_suivant;
		    bw.flush();
		}
		
		bw.close();
		br.close();
		
		 
		entree.renameTo(new File("poubelle.txt"));
		sortie.renameTo(new File("liste_mots_francais.txt"));
		}
		
		catch (Exception e) {
			System.out.println("Something went wrong.");
		}
	}
	
}
		

   