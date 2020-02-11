import java.util.Scanner;

public class Creation_Mots 
{
	public static void main(String[] args)
	{
		int nb=0;
		boolean estEntier;
		do 
        {
            System.out.println("Rentrez le nombre de mots que vous souhaitez créer");
            Scanner scannb = new Scanner(System.in);
            estEntier = scannb.hasNextInt();
            if (estEntier)
            {
                nb = scannb.nextInt();
            }
        }
		while (!estEntier);
		
		int l=0;
		do 
        {
            System.out.println("Rentrez la longueur des mots que vous souhaitez créer");
            Scanner scanl = new Scanner(System.in);
            estEntier = scanl.hasNextInt();
            if (estEntier)
            {
                l = scanl.nextInt();
            }
        }
		while (!estEntier);
		
		String[] tab=new String[nb];
		double[][][] tab_freq=Calcul_Frequence_Lettres.calc_freq();
		
		for (int i=0; i<nb; i++)
		{
			Character[] tab_mot=new Character[l];
			
			int init=0;
			double alea=Math.random();
			double freq_cum=tab_freq[26][26][init];
			while ((alea>freq_cum) && (init<26))
			{
				init++;
				freq_cum=freq_cum+tab_freq[26][26][init];
			}
			tab_mot[0]=(char) (init+97);
			
			int init2=0;
			int ind_init=((int) tab_mot[0])-97;
			double alea2=Math.random();
			double freq_cum2=tab_freq[26][ind_init][init2];
			while ((alea2>freq_cum2) && (init2<26))
			{
				init2++;
				freq_cum2=freq_cum2+tab_freq[26][ind_init][init2];
			}
			tab_mot[1]=(char) (init2+97);
			
			for (int j=2; j<l-1; j++)
			{
				int ini=0;
				double aleat=Math.random();
				int ind_prec=((int) tab_mot[j-1])-97;
				int ind_prec2=((int) tab_mot[j-2])-97;
				double freq_cumu=tab_freq[ind_prec2][ind_prec][ini];
				while (aleat>freq_cumu && ini<25)
				{
					ini++;
					freq_cumu=freq_cumu+tab_freq[ind_prec2][ind_prec][ini];
				}
				tab_mot[j]=(char) (ini+97);
			}
			
			int fin=0;
			int ind_avant_der=((int) tab_mot[l-2])-97;
			double alea_fin=Math.random();
			double freq_cum_fin=tab_freq[ind_avant_der][fin][26];
			while (alea_fin>freq_cum_fin && fin<26)
			{
				fin++;
				freq_cum_fin=freq_cum_fin+tab_freq[ind_avant_der][fin][26];
			}
			tab_mot[l-1]=(char) (fin+97);
			
			StringBuilder builder = new StringBuilder(l);
			for(Character ch: tab_mot)
			{
				builder.append(ch);
			}
			System.out.println(" "+builder.toString()+" ");
		}
	}
}
