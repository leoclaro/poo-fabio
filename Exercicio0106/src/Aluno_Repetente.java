import javax.swing.JOptionPane;

public class Aluno_Repetente extends Aluno {
	
	public float media_anterior = 0;

		
	public Aluno_Repetente (){
		this.tipo_aluno = "repetente";
	}
	

	@Override
	public String aprovar(){
		this.media_anterior = Float.parseFloat(JOptionPane.showInputDialog("Informe a media anterior"));
		float media = (this.nota1 + this.nota2 + this.nota3)/3 + this.media_anterior;
		
		float frequencia = (this.qtde_aulas_assistidas * 100)/this.qtde_aulas_ministradas;
		if(media >= 6 && frequencia >= 75)
			return  "Aprovado";
			else 
				return "Reprovado";
			
	} 
}
