public class Aluno_Alistado extends Aluno {
	
	public Aluno_Alistado(){
		this.tipo_aluno = "Alistado no CPOR";
	}
	
	@Override
	public String aprovar(){
		float media = (this.nota1 + this.nota2 + this.nota3)/3;
		float frequencia = (this.qtde_aulas_assistidas / this.qtde_aulas_ministradas);
		if(media >= 6 && frequencia >= 50)
			return  "Aprovado";
			else 
				return "Reprovado";
			
	}
}

