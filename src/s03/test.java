package s03;

import s03.IPastisModel;

import java.util.Random;

public class test {
	
	
	
	public static void main(String[] args) {
		
		
		Random r = new Random();
		String mdp = new String();
		char[] chars;
		

		// Longueur par défault
		int l = 12;
		
		

			chars = "abcdef".toCharArray();
		

			
			String strtemp = "ABCDF";
			
			for (int i = 0; i < chars.length; i++) {
				strtemp += chars[i];
			}
			
			System.out.println(strtemp);

			

			

			
		
		

		// création du mdp
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < l; i++) {
			char c = chars[r.nextInt(chars.length)];
			sb.append(c);
		}
		mdp = sb.toString();

		//System.out.println(mdp);
		
	}

}
