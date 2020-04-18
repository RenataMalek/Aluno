
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GestaoAlunos {

	Aluno[] alunos = new Aluno[50];
	int indice = 0;

	public static void main(String[] args) {

		GestaoAlunos a1 = new GestaoAlunos();

		for (int j = 0; j < a1.alunos.length; j++) {
			a1.alunos[j] = new Aluno();
		}

		a1.menu();

	}

	public void criar() {

		alunos[indice].id = indice;
		alunos[indice].nome = JOptionPane.showInputDialog("Informe o nome do aluno");
		alunos[indice].ra = JOptionPane.showInputDialog("Informe o RA do aluno");
		alunos[indice].nascimento = JOptionPane.showInputDialog("Informe a data de nascimento do aluno");

		JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");

		indice++;

	}

	void atualizar(String ra) {

		int i;

		try {
			for (i = 0; i < alunos.length; i++) {
				if (alunos[i].ra.equalsIgnoreCase(ra)) {
					JOptionPane.showMessageDialog(null, "Atualize os dados:");
					alunos[i].nome = JOptionPane.showInputDialog("Nome: ");
					alunos[i].nascimento = JOptionPane.showInputDialog("Data de nascimento: ");
					JOptionPane.showMessageDialog(null, "Cadastro do aluno " + alunos[i].nome + " atualizado!\n");

					break;
				}
			}
			if (i == (alunos.length)) {
				System.out.println("Aluno não cadastrado!");
			}
		} catch (Exception e) {
			System.out.println("\nNão foi possivel localizar, tente novamente ou escolha outra opção\n");
		}
	}

	void exibir(String ra) {

		int i;

		try {
			for (i = 0; i < alunos.length; i++) {
				if (alunos[i].ra.equalsIgnoreCase(ra)) {

					int id = alunos[i].id;
					String nome = alunos[i].nome;
					String nascimento = alunos[i].nascimento;

					JOptionPane.showMessageDialog(null, "ID: " + id + "\nRA: " + ra + "\nNome: " + nome
							+ "\nData nascimento: " + nascimento + "\n");

					break;
				}
			}

			if (i == (alunos.length)) {
				System.out.println("Nenhum dado foi encontrado!");
			}
		} catch (Exception e) {
			System.out.println("\nNão foi possivel localizar, tente novamente ou escolha outra opção\n");
		}

	}

	void remover(String ra) {

		int i;

		try {
			for (i = 0; i < alunos.length; i++) {
				if (alunos[i].ra.equalsIgnoreCase(ra)) {

					JOptionPane.showMessageDialog(null, "Aluno " + alunos[i].nome + "excluido do sistema\n");
					alunos[i] = null;
				}
			}

			if (i == (alunos.length)) {
				System.out.println("Nenhum dado foi encontrado!");
			}
		} catch (Exception e) {
			System.out.println("\nNão foi possivel localizar, tente novamente ou escolha outra opção\n");
		}

	}

	void menu() {

		Scanner scan = new Scanner(System.in);

		String opc = "";
		String ra = "";

		while (opc != "S") {

			System.out.println("DIGITE A OPÇÃO DESEJADA \n\nCriar \nExibir \nAtualizar \nRemover \nSair");

			opc = scan.nextLine().toUpperCase();
			char letra = opc.charAt(0);

			switch (letra) {
			case 'C':
				criar();
				break;
			case 'E':
				ra = JOptionPane.showInputDialog("Digite o numero do RA do aluno: ");
				exibir(ra);
				break;
			case 'A':
				ra = JOptionPane.showInputDialog("Digite o numero do RA do aluno: ");
				atualizar(ra);
				break;
			case 'R':
				ra = JOptionPane.showInputDialog("Digite o numero do RA do aluno: ");
				remover(ra);
				break;
			case 'S':
				JOptionPane.showMessageDialog(null, "FIM");
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA");
			}

		}

		scan.close();
	}

}
