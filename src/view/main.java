package view;

import javax.swing.*;
import controller.RedesController;

public class main {
	static String sisOp;

	public static void main( String[] args) {
		RedesController rc = new RedesController();

		int opc = 0; String comando;

		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Define So \n2 - verifica o IPv4 \n3 - testa PING \n9 - Encerrar programa"));
			switch (opc) {
			case 1:
				sisOp = qualSo(sisOp);
				System.out.println(sisOp);
				break;
			case 2:
				if (sisOp != null) {
					if (sisOp.contains("Windows")) { comando = "ipconfig"; } else { comando = "ifconfig"; }
					rc.chamaProcesso(comando, sisOp, opc);
				} else { JOptionPane.showMessageDialog(null, "Defina um sistema antes"); }
				break;
			case 3: 
				if (sisOp != null) {
					if (sisOp.contains("Windows")) { comando = "PING -4 -n 10 www.google.com.br"; } else { comando = "ping -4 -c 10 www.google.com.br"; }
					rc.chamaProcesso(comando, sisOp, opc);
				} else { JOptionPane.showMessageDialog(null, "Defina um sistema antes"); }
				break;
			case 9:
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
				break;
			}
		}
	}

	private static String qualSo(String so) {
		so = System.getProperty("os.name");
		return so;
	}

}
