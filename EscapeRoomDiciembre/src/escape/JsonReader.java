package escape;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.util.List;

/**
 * Clase para leer archivos Json
 */
public class JsonReader {

	/**
	 * Lee archivo Json y devuelve un array de DisplayText
	 * 
	 * @param filename Archivo a leer
	 * @return Array de textos
	 */
	public static DisplayText[] loadTexts(String filename) {
		Gson gson = new Gson();

		try (FileReader reader = new FileReader(filename)) {
			List<DisplayText> list = gson.fromJson(reader, new TypeToken<List<DisplayText>>() {
			}.getType());
			return list.toArray(new DisplayText[0]);
		} catch (Exception e) {
			e.printStackTrace();
			return new DisplayText[0];
		}
	}

}
