
public class Aluno {
	
	public String nome;
	public int matricula;
	public int nota1 = 0;
	public int nota2 = 0;
	public int nota3 = 0;
	public int qtde_aulas_ministradas = 0;
	public int qtde_aulas_assistidas = 0;
	public String tipo_aluno;
	
public Aluno(){
	this.tipo_aluno = "Normal";
}
public String aprovar(){
	float media = (this.nota1 + this.nota2 + this.nota3)/3;
	float frequencia = (this.qtde_aulas_assistidas * 100)/this.qtde_aulas_ministradas;
	if(media >= 6 && frequencia >= 75)
		return  "Aprovado";
		else 
			return "Reprovado";
		
}
	
	
	
}
