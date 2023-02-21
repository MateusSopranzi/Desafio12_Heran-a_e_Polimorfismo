package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Lesson> list = new ArrayList<>();
		int total = 0;
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i=1; i<=n; i++) {
			System.out.printf("Dados da %da aula: ", i);
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char op = sc.nextLine().charAt(0);
			while(op != 'c' && op != 't') {
				System.out.println("Opção errada, digite c para Conteúdo ou t para Tarefa: ");
				op = sc.nextLine().charAt(0);
			}
			
			System.out.println("Título");
			String title = sc.nextLine();
			
			if(op == 'c') {
				System.out.println("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.println("Duração em segundos: ");
				int seconds = sc.nextInt();
				sc.nextLine();
				list.add(new Video(title, url, seconds));
			}else {
				System.out.println("Descrição: ");
				String description = sc.nextLine();
				System.out.println("Quantidade de questões: ");
				int questionCount = sc.nextInt();
				sc.nextLine();
				list.add(new Task(title, description, questionCount));
			}
			
		}
		
		for(Lesson lesson: list) {
			total += lesson.duration();
		}
		
		System.out.printf("DURAÇÃO TOTAL DO CURSO = %d segundos", total);
		
		
		sc.close();
	}
}
