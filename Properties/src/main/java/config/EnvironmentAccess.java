package config;

import java.io.InputStream;
import java.util.Properties;

public class EnvironmentAccess {
	
	private static final String DEFAULT_PROPERTIES_FILE = "application.properties";
	private final Properties props = new Properties();

	private EnvironmentAccess() {
        loadFromClasspath(DEFAULT_PROPERTIES_FILE);
    }

	// Singleton “clean”: lazy + thread-safe sin synchronized en cada llamada
	private static class Holder {
		private static final EnvironmentAccess INSTANCE = new EnvironmentAccess();
	}

	public static EnvironmentAccess getInstance() {
		return Holder.INSTANCE;
	}

	/**
	 * Lectura genérica. Devuelve null si no existe.
	 */
	public String getValue(String key) {
		validateKey(key);

		// 1) Prioridad: variables de entorno (estilo deploy moderno)
		// Ej: bbdd.url -> BBDD_URL
		String envKey = toEnvKey(key);
		String envValue = System.getenv(envKey);
		if (hasText(envValue)) {
			return envValue;
		}

		// 2) Fallback: application.properties
		return props.getProperty(key);
	}

	/**
	 * Lectura con valor por defecto.
	 */
	public String getValue(String key, String defaultValue) {
		String value = getValue(key);
		return hasText(value) ? value : defaultValue;
	}

	/**
	 * Lectura obligatoria: si falta, explota con mensaje claro. Best practice:
	 * fail-fast.
	 */
	public String getRequired(String key) {
		String value = getValue(key);
		if (!hasText(value)) {
			throw new IllegalStateException("Falta configuración requerida: '" + key + "' (env: " + toEnvKey(key)
					+ " o " + DEFAULT_PROPERTIES_FILE + ")");
		}
		return value;
	}

	private void loadFromClasspath(String fileName) {
		try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
			if (input == null) {
				throw new IllegalStateException("No se encuentra '" + fileName + "' en resources");
			}
			props.load(input);
		} catch (Exception e) {
			throw new IllegalStateException("Error cargando '" + fileName + "'", e);
		}
	}

	private static void validateKey(String key) {
		if (!hasText(key)) {
			throw new IllegalArgumentException("La key de property no puede ser null/vacía");
		}
	}

	private static boolean hasText(String s) {
		return s != null && !s.trim().isEmpty();
	}

	private static String toEnvKey(String key) {
		// bbdd.url -> BBDD_URL
		return key.trim().toUpperCase().replace('.', '_');
	}
}
