import java.io.*;

public class Calcul_Frequence_Lettres 
{
	public static double[][][] calc_freq()
	{
		double[][][] tab_freq = new double[28][27][28];
		
		File entree = new File("liste_bons_mots.txt");
		try {
		BufferedReader br = new BufferedReader(new FileReader(entree));
		String mot=br.readLine();
		while (mot != null){
			tab_freq[26][26][27]++;
			int init1=((int) mot.charAt(0))-97;
			int init2=((int) mot.charAt(1))-97;
			tab_freq[26][init1][init2]++;
			tab_freq[26][init1][27]++;
			tab_freq[26][26][init1]++;
			tab_freq[27][init1][init2]++;
			for (int i=0; i<mot.length()-2; i++)
			{
				int l1=((int) mot.charAt(i))-97;
				int l2=((int) mot.charAt(i+1))-97;
				int l3=((int) mot.charAt(i+2))-97;
				tab_freq[l1][l2][l3]++;
				tab_freq[l1][l2][27]++;
				tab_freq[27][l2][l3]++;
			}
			int avant_der=(int) (mot.charAt(mot.length()-2))-97;
			int fin=(int) (mot.charAt(mot.length()-1))-97;
			tab_freq[avant_der][fin][26]++;
			tab_freq[avant_der][fin][27]++;
			tab_freq[avant_der][26][27]++;
			tab_freq[27][fin][27]++;
			mot=br.readLine();
		}
		for (int i=0; i<27; i++)
		{
			for (int j=0; j<26; j++)
			{
				for (int k=0; k<27; k++)
				{
					if (tab_freq[i][j][27]!=0)
					{
						tab_freq[i][j][k]/=tab_freq[i][j][27];
					}
				}
			}
		}
		for (int l=0; l<26; l++)
		{
			tab_freq[26][26][l]/=tab_freq[26][26][27];
		}
		br.close();
		}
		
		catch (Exception e) {
			System.out.println("Something went wrong.");
		}
		return tab_freq;
	}
}

//	public static void main(String[] args)
//	{
//		calc_freq();
//	}
//}

	
//	public static void main(String[] args)
//	{
//		double[][][] tab_freq = Calcul_Frequence_Lettres.calc_freq();
//		for(int i=0; i<26; i++)
//		{
//			System.out.print("  "+Character.toString((char) (97+i))+"  ");
//		}
//		System.out.println();
//		
//		for (int j=0; j<27; j++)
//		{
//			System.out.print(Character.toString((char) (97)));
//			for (int k=0; k<28; k++)
//			{
//				System.out.println(Character.toString((char) (97+k))+" "+tab_freq[0][k]+" ");
//			}
//			System.out.println();
//		}
//	}
//}

