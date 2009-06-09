import javax.swing.JOptionPane;

public class Aluno_Repetente extends Aluno {
	
	public float media_anterior = 0;

		
	public Aluno_Repetente (){
		this.qtde_aulas_assistidas = assistidas;
	}
	
	@Override
	public String aprovar(int ministradas, int assistidas){
		@SuppressWarnings("unused")
		float media_anterior = Float.parseFloat(JOptionPane.showInputDialog("Informe a media anterior"));
		float media = (this.nota1 + this.nota2 + this.nota3)/3 + this.media_anterior;
		
		float frequencia = (assistidas * 100)/ministradas;
		if(media >= 6 && frequencia >= 75)
			return  "Aprovado";
			else 
				return "Reprovado";
			
	} 
}
