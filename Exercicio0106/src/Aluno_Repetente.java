public class Aluno_Repetente extends Aluno {
	
	public float media_anterior = 0;
		
	public Aluno_Repetente (){
		this.tipo_aluno = "Aluno Repetente";
	}
	
	@Override
	public String aprovar(){
		float media = (this.nota1 + nota2 + nota3)/3 + this.media_anterior;
		float frequencia = (this.qtde_aulas_assistidas / this.qtde_aulas_ministradas);
		if(media >= 6 && frequencia >= 75)
			return  "Aprovado";
			else 
				return "Reprovado";
			
	} 
}
