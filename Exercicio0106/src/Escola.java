import javax.print.attribute.standard.Media;
import javax.swing.JOptionPane;

public class Escola {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aluno aluno = new Aluno();
		Aluno_Repetente ar = new Aluno_Repetente ();
		Aluno_Alistado al = new Aluno_Alistado ();
		
		aluno.tipo_aluno = JOptionPane.showInputDialog("Tipo de Aluno(Normal, Repetente ou Alistado)");
		
		aluno.nome = JOptionPane.showInputDialog("Nome Aluno");
		aluno.matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a Matricula"));
		aluno.nota1 = Integer.parseInt(JOptionPane.showInputDialog("Informe a primeira Nota"));
		aluno.nota2 = Integer.parseInt(JOptionPane.showInputDialog("Informe a segunda Nota"));
		aluno.nota3 = Integer.parseInt(JOptionPane.showInputDialog("Informe a terceira Nota"));
		aluno.qtde_aulas_ministradas = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de aulas ministradas"));
		aluno.qtde_aulas_assistidas = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de aulas assistidas"));
		
		if(aluno.tipo_aluno.equals("normal")){
			aluno.aprovar();
		}
		else if(aluno.tipo_aluno.equals("alistado")){
			al.aprovar();
		}
		else if(aluno.tipo_aluno.equals("repetente")){
			ar.aprovar(aluno.qtde_aulas_ministradas, aluno.qtde_aulas_assistidas);
		}
		else
			JOptionPane.showInputDialog("Nada: " + aluno.tipo_aluno);
		
		System.out.println("O aluno "+ aluno.nome +" "+ aluno.matricula +" "+ "foi: "+aluno.aprovar());
	}

}

