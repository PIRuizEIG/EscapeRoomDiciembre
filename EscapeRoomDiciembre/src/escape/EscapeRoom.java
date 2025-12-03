package escape;

import java.util.Scanner;;

/**
 * Clase para crear un juego tipo Escape Room
 */
public class EscapeRoom {

	/**
	 * Scanner para la captura de teclado
	 */
	private Scanner sc;

	/**
	 * Textos del juego
	 */
	private DisplayText[] text;
	
	/**
	 * Respuestas incorrectas
	 */
	private String[] wrong;
	
	/**
	 * Contador de respuescas incorrectas
	 */
	private int counter = 0;

	/**
	 * Crear juego con la lista de texto enviada
	 * 
	 * @param text Lista de DisplayText con el texto del juego
	 */
	public EscapeRoom(DisplayText[] text) {
		sc = new Scanner(System.in);
		this.text = text.clone();
		String failed[] = {"Fallo 1", "Fallo 2", "Fallo 3"};
		wrong = failed;
	}

	/**
	 * Esperar a que el jugador pulse intro para continuar
	 */
	public void waitForInput() {
		System.out.println("\nPulse intro para continuar.");
		sc.nextLine();
	}

	/**
	 * Devuelve una cadena sin espacios ni puntuaciones
	 * 
	 * @param s Cadena Original
	 * @return Cadena normalizada
	 */
	private String normalize(String s) {
		// trim elimina espacios del principio y final
		return s.trim() 
				// eliminar puntuación . , ; : ! ? etc.
				.replaceAll("\\p{Punct}", ""); 
	}

	/**
	 * Entrar al siguiente paso
	 * 
	 * @param num Paso a mostrar
	 */
	public void enterRoom(int num) {
		// Variable para salir del bucle
		boolean escapeLoop = true;
		do {
			// Mostrar mensaje y comprobar si necesitamos respuesta
			boolean needAnswer = text[num].showMessage();
			if (needAnswer) {
				// Cogemos la respuesta correcta
				String answer = normalize(sc.nextLine());

				// Si había salto de línea en buffer volvemos a pedir la respuesta
				if (answer.isBlank())
					answer = normalize(sc.nextLine());

				// Comparamos la respuesta del jugador con la de DisplayText
				if (answer.compareToIgnoreCase(text[num].getAnswer()) == 0) {
					text[num].showSuccess();
					escapeLoop = true;
				} else {
					System.out.printf("%s%n", wrong[counter]);
					counter++;
					escapeLoop = false;
				}
			} else
				waitForInput();
			// Una vez que se acierta o se acaban los intentos salimos del bucle
		} while (!escapeLoop && counter < wrong.length);
	}

	/**
	 * Bucle de juego
	 */
	public void enterGameLoop() {
		// Entramos a cada entrada de texto
		for (int i = 0; i < text.length; i++) {
			enterRoom(i);
			// Si nos hemos quedado sin turnos se llama el fin del juego
			if (counter >= wrong.length)
			{
				System.out.println("Game Over");
				break;
			}
		}
	}

	/**
	 * Método de ejecución
	 */
	public static void main(String args[]) {
		DisplayText[] gameText = JsonReader.loadTexts("data/game_data.json");
		var obj = new EscapeRoom(gameText);

		obj.enterGameLoop();
	}
}
