package escape;

/**
 * Clase para crear objetos con los mensajes para el juego de escape room
 */
public class DisplayText {

	/**
	 * Descripciones de las habitaciones
	 */
	private String description;

	/**
	 * Respuestas para escapar
	 */
	private String answer;

	/**
	 * Mensajes de respuestas correctas
	 */
	private String success;

	/**
	 * El mensaje requiere respuesta
	 */
	private boolean needsAnswer;

	/**
	 * Crear texto sin respuesta
	 * 
	 * @param description Descripción a mostrar
	 */
	public DisplayText(String description) {
		this.description = description;
		this.answer = null;
		this.success = null;
		needsAnswer = false;
	}

	/**
	 * Crear texto con respuesta
	 * 
	 * @param description Descripción a mostrar
	 * @param answer      Respuesta correcta
	 * @param success     Mensaje de victoria
	 */
	public DisplayText(String description, String answer, String success) {
		this.description = description;
		this.answer = answer;
		this.success = success;
		needsAnswer = true;
	}

	/**
	 * Mostrar la descripción e indicar si hay que responder
	 * 
	 * @return True si se requiere una respuesta
	 */
	public boolean showMessage() {
		System.out.printf("%s%n", description);
		return needsAnswer;
	}

	/**
	 * Devolver una cadena con la respuesta esperada
	 * 
	 * @return Cadena con la respuesta correcta
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * Mostrar el mensaje de victoria
	 */
	public void showSuccess() {
		System.out.printf("%s%n", success);
	}
}
