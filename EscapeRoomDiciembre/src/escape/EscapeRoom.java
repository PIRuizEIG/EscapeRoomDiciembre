package escape;

import java.util.Scanner;;

/**
 * Clase para crear un juego tipo Escape Room
 */
public class EscapeRoom {
	/**
	 * Descripciones de las habitaciones
	 */
	private String[] descriptions;

	/**
	 * Respuestas para escapar
	 */
	private String[] answers;
	
	/**
	 * Mensajes de respuestas correctas
	 */
	private String[] success;

	private Scanner sc;

	/**
	 * Crear juego con la lista de descripciones pasadas
	 * 
	 * @param descriptions Lista de String con las descripciones de las habitaciones
	 */
	public EscapeRoom(String[] descriptions, String[] answers, String[] success) {
		this.descriptions = descriptions;
		this.answers = answers;
		this.success = success;
		sc = new Scanner(System.in);
	}

	/**
	 * Mostrar mensaje introductorio
	 */
	public void showInit() {
		showMessage(0);
		waitForInput();
	}

	/**
	 * Mostrar un mensaje de la lista
	 * 
	 * @param num Número de mensaje a mostrar
	 */
	private void showMessage(int num) {
		if (num >= 0 && num < descriptions.length)
			System.out.printf("%s%n", descriptions[num]);
		else
			System.out.println("Error, sala fuera de rango");
	}
	
	/**
	 * Mostrar un mensaje de victoria
	 * 
	 * @param num Número de mensaje a mostrar
	 */
	private void showSuccess(int num) {
		if (num >= 0 && num < success.length)
			System.out.printf("%s%n", success[num]);
		else
			System.out.println("Error, sala fuera de rango");
		if (num == success.length-1)
			System.out.println("Fin del juego");
	}

	/**
	 * Esperar a que el jugador pulse intro para continuar
	 */
	public void waitForInput() {
		System.out.println("Pulse intro para continuar.");
		sc.nextLine();
	}

	/**
	 * Entrar a la habitación indicada
	 * 
	 * @param num Habitación a entrar
	 */
	public void enterRoom(int num) {
		 String answer;
		do {
			showMessage(num);
			answer = sc.next();
			if (answer.compareToIgnoreCase(answers[num - 1]) != 0)
				System.out.println("Respuesta incorrecta");
		} while (answer.compareToIgnoreCase(answers[num - 1]) != 0);
		showSuccess(num - 1);
	}

	/**
	 * Método de ejecución
	 */
	public static void main(String args[]) {
		String desc[] = { "Bienvenidos a SAW", "Estás en la habitación 1" };
		String answ[] = { "Paco" };
		String succ[] = { "Has ganado" };
		var obj = new EscapeRoom(desc, answ, succ);
		obj.showInit();
		obj.enterRoom(1);
	}
}
