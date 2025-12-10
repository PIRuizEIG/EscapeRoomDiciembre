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
	 * Formato del texto
	 */
	private Formato formatoTexto;

	/**
	 * Color del texto
	 */
	private Formato colorTexto;

	/**
	 * Fondo del texto
	 */
	private Formato fondoTexto;

	/**
	 * Crear texto sin respuesta sin formato
	 * 
	 * @param description Descripción a mostrar
	 */
	public DisplayText(String description) {
		this(description, Formato.Normal, Formato.Normal, Formato.Normal);
	}

	/**
	 * Crear texto sin respuesta con formato
	 * 
	 * @param description  Descripción a mostrar
	 * @param formatoTexto Formato del texto
	 * @param colorTexto   Color del texto
	 * @param fondoTexto   Color del fondo
	 */
	public DisplayText(String description, Formato formatoTexto, Formato colorTexto, Formato fondoTexto) {
		this.description = description;
		this.answer = null;
		this.success = null;
		needsAnswer = false;
		this.formatoTexto = formatoTexto;
		this.colorTexto = colorTexto;
		this.fondoTexto = fondoTexto;
	}

	/**
	 * Crear texto con respuesta y formato
	 * 
	 * @param description  Descripción a mostrar
	 * @param answer       Respuesta correcta
	 * @param success      Mensaje de victoria
	 * @param formatoTexto Formato del texto
	 * @param colorTexto   Color del texto
	 * @param fondoTexto   Color del fondo
	 */
	public DisplayText(String description, String answer, String success, Formato formatoTexto, Formato colorTexto,
			Formato fondoTexto) {
		this.description = description;
		this.answer = answer;
		this.success = success;
		needsAnswer = true;
		this.formatoTexto = formatoTexto;
		this.colorTexto = colorTexto;
		this.fondoTexto = fondoTexto;
	}

	/**
	 * Crear texto con respuesta y sin formato
	 * 
	 * @param description Descripción a mostrar
	 * @param answer      Respuesta correcta
	 * @param success     Mensaje de victoria
	 */
	public DisplayText(String description, String answer, String success) {
		this(description, answer, success, Formato.Normal, Formato.Normal, Formato.Normal);
	}

	/**
	 * Objeto vacío para JSON
	 */
	public DisplayText() {
	}

	/**
	 * Mostrar la descripción e indicar si hay que responder
	 * 
	 * @return True si se requiere una respuesta
	 */
	public boolean showMessage() {
		System.out.print(applyFormat());
		System.out.printf("%s%n", description);
		System.out.print(JavaFormat.RESET);
		return needsAnswer;
	}

	/**
	 * Obtener formato del texto
	 * 
	 * @return Cadena con el formato a aplicar
	 */
	private String applyFormat() {
		String texto = "";
		switch (formatoTexto) {
		case Negrita:
			texto += JavaFormat.BOLD;
			break;
		case Cursiva:
			texto += JavaFormat.ITALIC;
			break;
		case Subrayado:
			texto += JavaFormat.UNDERLINE;
			break;
		case Tachado:
			texto += JavaFormat.STRIKETHROUGH;
			break;
		default:
		}
		switch (colorTexto) {
		case TextoNegro:
			texto += JavaFormat.BLACK;
			break;
		case TextoGris:
			texto += JavaFormat.BRIGHT_BLACK;
			break;
		case TextoBlanco:
			texto += JavaFormat.WHITE;
			break;
		case TextoVerde:
			texto += JavaFormat.GREEN;
			break;
		case TextoAzul:
			texto += JavaFormat.BLUE;
			break;
		case TextoRojo:
			texto += JavaFormat.RED;
			break;
		case TextoCian:
			texto += JavaFormat.CYAN;
			break;
		case TextoMagenta:
			texto += JavaFormat.MAGENTA;
			break;
		case TextoAmarillo:
			texto += JavaFormat.YELLOW;
			break;
		default:
		}
		switch (fondoTexto) {
		case FondoNegro:
			texto += JavaFormat.BLACK_BG;
			break;
		case FondoBlanco:
			texto += JavaFormat.WHITE_BG;
			break;
		case FondoVerde:
			texto += JavaFormat.GREEN_BG;
			break;
		case FondoAzul:
			texto += JavaFormat.BLUE_BG;
			break;
		case FondoRojo:
			texto += JavaFormat.RED_BG;
			break;
		case FondoCian:
			texto += JavaFormat.CYAN_BG;
			break;
		case FondoAmarillo:
			texto += JavaFormat.YELLOW_BG;
			break;
		case FondoMagenta:
			texto += JavaFormat.MAGENTA_BG;
			break;
		default:
		}
		return texto;
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
		System.out.print(applyFormat());
	    System.out.printf("%s%n", success);
	    System.out.print(JavaFormat.RESET);
	}
}
