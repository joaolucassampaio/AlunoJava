package exercicio1;
import java.util.ArrayList;

import io.InOut;

public class UsaListaAluno {

	public static void main(String[] args) {
		ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
		
		String opcao;
		
		do {
			opcao = exibirMenu();
			
			switch(opcao) {
				case "1":
					insereAluno(listaAlunos);
					break;
				
				case "2":
					removeAluno(listaAlunos);
					break;
					
				case "3":
					alteraNota(listaAlunos);
					break;
					
				case "4":
					mostraAluno(listaAlunos);
					break;
					
				case "5":
					imprimeTodos(listaAlunos);
					break;
					
				case "6":
					InOut.msgDeAviso("Alerta:", "Encerrando o programa...");
					break;
					
				default:
					InOut.msgDeAviso("Alerta:", "Opção inválida! Tente novamente.");
					break;
			}
			
		} while(!opcao.equals("6"));
			
		InOut.msgDeAviso("Alerta:", "Programa encerrado com sucesso!");
	}
	
	private static void imprimeTodos(ArrayList<Aluno> listaAlunos) {
		if(listaAlunos.isEmpty()) {
			InOut.msgDeAviso("Alerta:", "Não há alunos cadastrados no sistema!");
			return;
		} else {
			for(int i=0; i<listaAlunos.size(); i++) {
				Aluno arrAluno = listaAlunos.get(i);
				
				InOut.msgDeAviso("Alerta:", 
						"Nome: " + arrAluno.getNome()
						+"\nMatricula: " + arrAluno.getMatricula()
						);
			}
			return;
		}
	}

	private static void mostraAluno(ArrayList<Aluno> listaAlunos) {
		String nome = InOut.leString("Qual é o nome do aluno a ser removido?");
				
		for(int i=0; i<listaAlunos.size(); i++) {
			Aluno arrAluno = listaAlunos.get(i);
			String arrNome = arrAluno.getNome();
			if(nome.equals(arrNome)) {
				InOut.msgDeAviso("Alerta:", 
						"Dados do aluno " + nome + ":"
						+"\nMatricula: " + arrAluno.getMatricula()
						+"\nNota 1: " + arrAluno.getNota1()
						+"\nNota 2: " + arrAluno.getNota2()
						+"\nMédia: " + arrAluno.media()
						);
				return;
			}
		}
		InOut.msgDeAviso("Alerta:", "Não existe um aluno com esse nome!");
	}

	private static void alteraNota(ArrayList<Aluno> listaAlunos) {
		String nome = InOut.leString("Qual é o nome do aluno que deseja alterar a nota?");
		
		for(int i=0; i<listaAlunos.size(); i++) {
			Aluno arrAluno = listaAlunos.get(i);
			String arrNome = arrAluno.getNome();
			if(nome.equals(arrNome)) {
				double nota1 = InOut.leDouble("Qual será a nova nota 1?");
				double nota2 = InOut.leDouble("Qual será a nova nota 2?");
				arrAluno.setNota1(nota1);
				arrAluno.setNota2(nota2);
				InOut.msgDeAviso(
						"Alerta:", "As notas do aluno " + nome 
						+ " foram alteradas com sucesso!"
						+ "\nNota 1 = " + arrAluno.getNota1()
						+ "\nNota 2 = " + arrAluno.getNota2()
						);
				return;
			}
		}
		InOut.msgDeAviso("Alerta:", "Não existe um aluno com esse nome!");
	}

	private static void removeAluno(ArrayList<Aluno> listaAlunos) {
		String nome = InOut.leString("Qual é o nome do aluno a ser removido?");
		
		for(int i=0; i<listaAlunos.size(); i++) {
			Aluno arrAluno = listaAlunos.get(i);
			String arrNome = arrAluno.getNome();
			if(nome.equals(arrNome)) {
				listaAlunos.remove(i);
				InOut.msgDeAviso("Alerta:", "Aluno " + nome + " removido com sucesso!");
				return;
			}
		}
		InOut.msgDeAviso("Alerta:", "Não existe um aluno com esse nome!");
	}

	private static void insereAluno(ArrayList<Aluno> listaAlunos) {
		String nome = InOut.leString("Informe o nome do aluno:");
		int matricula = InOut.leInt("Informe a matrícula do aluno:");
		double nota1 = InOut.leDouble("Informe a nota 1 do aluno:");
		double nota2 = InOut.leDouble("Informe a nota 2 do aluno:");
		
		Aluno aluno = new Aluno(nome, matricula, nota1, nota2);
		
		listaAlunos.add(aluno);
	}

	public static String exibirMenu() {
		String opcao = InOut.leString(
				"Bem-vindo(a) ao Sistema de Notas da Escola Genius!"
				+ "\nEm que posso ajudar hoje?\n"
				+ "\n1. Insere Aluno;"
				+ "\n2. Remove Aluno;"
				+ "\n3. Altera Nota;"
				+ "\n4. Mostra Aluno;"
				+ "\n5. Imprime todos;"
				+ "\n6. Sair."
				);
		return opcao;
	}

}
