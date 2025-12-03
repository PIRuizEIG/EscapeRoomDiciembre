package escape;

import java.util.Scanner;;

/**
 * Clase para crear un juego tipo Escape Room
 */
public class EscapeRoom {
	/**
	 * Crear juego con la lista de descripciones pasadas
	 * 
	 * @param descriptions Lista de String con las descripciones de las habitaciones
	 */
	/*public EscapeRoom(String[] descriptions, String[] answers, String[] success) {
		this.descriptions = descriptions;
		this.answers = answers;
		this.success = success;
		sc = new Scanner(System.in);
	}*/
	
	/**
	 * Mostrar mensaje introductorio
	 */
	/*public void showInit() {
		showMessage(0);
		waitForInput();
	}*/

	/**
	 * Mostrar un mensaje de la lista
	 * 
	 * @param num Número de mensaje a mostrar
	 */
	/*private void showMessage(int num) {
		if (num >= 0 && num < descriptions.length)
			System.out.printf("%s%n", descriptions[num]);
		else
			System.out.println("Error, sala fuera de rango");
	}*/
	
	/**
	 * Mostrar un mensaje de victoria
	 * 
	 * @param num Número de mensaje a mostrar
	 */
	/*private void showSuccess(int num) {
		if (num >= 0 && num < success.length)
			System.out.printf("%s%n", success[num]);
		else
			System.out.println("Error, sala fuera de rango");
		if (num == success.length-1)
			System.out.println("Fin del juego");
	}*/	

	/**
	 * Entrar a la habitación indicada
	 * 
	 * @param num Habitación a entrar
	 */
	/*public void enterRoom(int num) {
		 String answer;
		do {
			showMessage(num);
			answer = sc.next();
			if (answer.compareToIgnoreCase(answers[num - 1]) != 0)
				System.out.println("Respuesta incorrecta");
		} while (answer.compareToIgnoreCase(answers[num - 1]) != 0);
		showSuccess(num - 1);
	}*/
	
	/**
	 * Scanner para la captura de teclado
	 */
	private Scanner sc;
	
	/**
	 * Textos del juego
	 */
	private DisplayText[] text;
	
	/**
	 * Crear juego con la lista de texto enviada
	 * 
	 * @param text Lista de DisplayText con el texto del juego
	 */
	public EscapeRoom(DisplayText[] text) {
		sc = new Scanner(System.in);
		this.text = text.clone();
	}
	
	/**
	 * Esperar a que el jugador pulse intro para continuar
	 */
	public void waitForInput() {
		System.out.println("Pulse intro para continuar.");
		sc.nextLine();
	}
	
	/**
	 * Entrar al siguiente paso
	 * 
	 * @param num Paso a mostrar
	 */
	public void enterRoom(int num) {
		boolean escapeLoop = true;
		do {
			boolean needAnswer = text[num].showMessage();
			if (needAnswer)
			{
				var answer = sc.next();
				if (answer.compareToIgnoreCase(text[num].getAnswer()) == 0) {
					text[num].showSuccess();
				}
				else
				{
					System.out.println("Respuesta incorrecta");
					escapeLoop = false;
				}
			}
			else
				waitForInput();
		} while (!escapeLoop);
	}
	
	public void enterGameLoop() {
		for(int i = 0; i < text.length; i++) {
			enterRoom(i);
		}
	}

	/**
	 * Método de ejecución
	 */
	public static void main(String args[]) {
		DisplayText[] gameText = new DisplayText[4];
		gameText[0] = new DisplayText("Bienvenido. Hace algún tiempo jugaste con las esperanzas de los demás usando tu talento…\ny ahora, usando ese mismo talento, tendrás que jugar a mi juego.");
		gameText[1] = new DisplayText("Ante ti hay cuatro armarios, cada uno con una terminal. Dentro encontrarás fragmentos de la verdad que intentaste ocultar. Solo realizando las consultas SQL correctas obtendrás las cuatro partes de la clave.\nCuando las unas, podrás desbloquear la terminal principal y ejecutar la consulta final que determinará si mereces salir de este almacén… o quedarte atrapado con tus pecados.");
		gameText[2] = new DisplayText("Tras escuchar este mensaje, el primer armario se abre y el juego comienza. Pero recuerda: en el pasado no fallaste, no te apresuraste y no cometiste errores. Si aquí fuera igual, ¿dónde se encontraría la diversión…? Por cada consulta que realices incorrectamente recibirás un castigo, así que ándate con ojo…");
		gameText[3] = new DisplayText("Dime hola", "hola", "Fin del juego");
		var obj = new EscapeRoom(gameText);
		
		obj.enterGameLoop();
	}
}
