import javax.swing.JOptionPane;

public class Escola {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nome, reprovar, matricula1, notaa, notab, notac, qtde_aulas_ministradas, qtde_aulas_assistidas, tipo_aluno;

		int matricula;
		int nota1;
		int nota2;
		int nota3;
		float media;
		int qtde_aulas_ministradas1;
		int qtde_aulas_assistidas1;

		nome = JOptionPane.showInputDialog("Nome Aluno");
		tipo_aluno = JOptionPane
				.showInputDialog("Tipo de Aluno(Normal, Repetente ou Alistado)");
		matricula1 = JOptionPane.showInputDialog("Informe a Matricula");
		notaa = JOptionPane.showInputDialog("Informe a primeira Nota");
		notab = JOptionPane.showInputDialog("Informe a segunda Nota");
		notac = JOptionPane.showInputDialog("Informe a terceira Nota");
		qtde_aulas_ministradas = JOptionPane
				.showInputDialog("Quantidade de aulas ministradas");
		qtde_aulas_assistidas = JOptionPane
				.showInputDialog("Quantidade de aulas assistidas");

		matricula = Integer.parseInt(matricula1);
		nota1 = Integer.parseInt(notaa);
		nota2 = Integer.parseInt(notab);
		nota3 = Integer.parseInt(notac);
		qtde_aulas_assistidas1 = Integer.parseInt(qtde_aulas_assistidas);
		qtde_aulas_ministradas1 = Integer.parseInt(qtde_aulas_ministradas);

	 

	}

}
