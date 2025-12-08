package util;

public class ConsoleDebug {

	 // Flag global para activar/desactivar mensajes
    private static volatile boolean enabled = true;

    private ConsoleDebug() {
        // Evita instanciación
    }

    public static void setEnabled(boolean enabled) {
        ConsoleDebug.enabled = enabled;
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void log(String message) {
        if (!enabled) return;
        System.out.println(message);
    }

    public static void log(String prefix, String message) {
        if (!enabled) return;
        System.out.println(prefix +": "+ message);
    }

    public static void logf(String format, Object... args) {
        if (!enabled) return;
        System.out.printf(format + "%n", args);
    }
}
