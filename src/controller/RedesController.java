package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public void chamaProcesso(String processo, String sop, int cod) {
		try { 
			Process r = Runtime.getRuntime().exec(processo); 
			InputStream in = r.getInputStream();
			InputStreamReader inR = new InputStreamReader(in);
			BufferedReader buffer = new BufferedReader(inR);
			String linha = buffer.readLine();
			
			while (linha != null) {
				if (cod == 2) {
					if (sop.equals("Windows 10")) {
						if (linha.contains("IPv4")) { 
							String vet[] = linha.split(":");
							System.out.println(vet[1].trim()); 
						}
					} else {
						if (linha.contains("inet")) {
							String vet[] = linha.trim().split(" "); 
							if (vet[0].equals("inet")) { System.out.println(linha); }
	 					}
					}
				} else {
					if (sop.equals("Windows 10")) {
						if (linha.contains("dia")) {
							String vet[] = linha.split(",");
							System.out.println(vet[2].trim());
						} 
					} else {
						if (linha.contains("mdev")) {
							String vet1[] = linha.trim().split("=");
							String vet2[] = vet1[1].trim().split("/");
							System.out.println(vet2[1] + " ms");
						}
					}
				}
				
				linha = buffer.readLine();
			}
			
			buffer.close(); inR.close(); in.close();
		} 
		catch (Exception e) { System.out.print(e); }
	}
	
}
