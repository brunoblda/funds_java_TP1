import java.util.Scanner;

public class ControleAcademico {

	private static int tamanhoVetor = 100;
	private static String[] nomes = new String[tamanhoVetor];
	private static float[] notasAvaliacoes1 = new float[tamanhoVetor];
	private static float[] notasAvaliacoes2 = new float[tamanhoVetor];
	private static String opcao;
	private static int index = 0;

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("\t\tAplicativo de Controle Academico");
		
		do {
			cabecalho();
			opcao = sc.next();
		
			System.out.println();
			
			switch (opcao) {
			case "1":
				
				adicionarNotasAluno();
				break;
				
			case "2":
				
				System.out.print("\tDigite o ID do aluno: ");	
				int idAluno = sc.nextInt();
				
				if(index > 0) {
					
				System.out.println();
				
				cabecalhoNotas();
				
				printNota(idAluno);
				
				}else {
					System.out.println("\n\tN�o h� nenhum aluno cadastrado.");
				}
				break;
				
			case "3":
				if (index > 0) {
					
				System.out.println("\n\tNotas da Turma: ");
				
				cabecalhoNotas();
				
				printNotas();
				
				}else {
					System.out.println("\n\tN�o h� nenhum aluno cadastrado.");
				}
				break;
				
			case "4": 
				
				System.out.println("\n\tPrograma Finalizado!!!");
				break;
				
			default:
				
				System.out.println("\n\tOp��o inv�lida!!! ");
				break;
			}
			
		}while(!opcao.equals("4"));
	}
	
	public static void cabecalho() {
		
		System.out.println("");
		System.out.println("\t\t[1] Registrar as notas de um novo aluno.");
		System.out.println("\t\t[2] Consultar boletim de um aluno.");
		System.out.println("\t\t[3] Consultar notas da turma.");
		System.out.println("\t\t[4] Sair.");
		System.out.println("");
		System.out.print("\tDigite uma das op��es acima: ");
	}
	
	public static void printNotas() {
		
		if (index > 0) {
			for(int i = 0; i < index; i++) {
				printNota(i);
			}
		}
	}
	
	public static void adicionarNotasAluno() {
	
		if(index < tamanhoVetor) {
		
		System.out.print("\tDigite o nome do Aluno: ");
		sc.nextLine();
		String nome = sc.nextLine();
		
		System.out.println();
		
		System.out.print("\tDigite a primeira nota do Aluno: ");
		float nota1 = sc.nextFloat();
		
		System.out.println();
		
		System.out.print("\tDigite a segunda nota do Aluno: ");
		float nota2 = sc.nextFloat();
		
		System.out.println();
		
		nomes[index] = nome;
		notasAvaliacoes1[index] = nota1;
		notasAvaliacoes2[index] = nota2;
		
		System.out.println("\tO aluno "+ nome + " foi registrado no ID: " + index);
		
		index++;
		
		}else {
			
			System.out.println("\tN�o � poss�vel adicionar mais alunos, o sistema alcan�ou o limite de " + tamanhoVetor + " alunos armazenados.");
		}
	}
		
	public static void printNota(int indice) {
		
		if(index > indice) {
			
			String av1String = String.format("%.2f", notasAvaliacoes1[indice]);
			String av2String = String.format("%.2f", notasAvaliacoes2[indice]);
			String indexString = Integer.toString(indice);
			float mediaNotas = calculaMedia(indice);
			String mediaString = String.format("%.2f", mediaNotas);			
			String situacao = situacaoAluno(mediaNotas);
					
			System.out.println("\n\t"+ centerString(4, indexString)+ centerString(30, nomes[indice])+
					centerString(7, av1String )+ centerString(7, av2String)+ centerString(13, mediaString)+
					centerString(13, situacao));
		}else {
			System.out.println("\n\tN�o h� alunos cadastrados nesse indice.");
		}
	}

	public static float calculaMedia(int index) {
		return (notasAvaliacoes1[index] + notasAvaliacoes2[index])/2; 
	}
	
	public static String situacaoAluno(float mediaNotas) {
		String result;
		
		if(mediaNotas  < 4 ) {
			result = "Reprovado";
		}else if(mediaNotas < 7 ) {
			result = "Prova Final";
		}else {
			result = "Aprovado";
		}
		return result;
		
	}
		
	public static void cabecalhoNotas() {
		
		System.out.println("\n\t"+ centerString(4, "ID")+ centerString(30, "Nome") + centerString(7, "AV1") +
				centerString(7, "AV2")+ centerString(13, "M�dia final")+ centerString(13, "Situa��o"));
	}
	
	public static String centerString (int width, String s) {
	    return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
	}
	
}
