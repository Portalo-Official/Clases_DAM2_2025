package antes;

public class App {
	   public static void main(String[] args) throws InterruptedException {
	        Freezer freezer = new Freezer(5000.0, 100, 7.0);

	        freezer.atacar(); // primera forma

	        freezer.transformar(Frezzer_Transfomation_Enum.SEGUNDA_FORMA);
	        freezer.atacar();

	        freezer.transformar(Frezzer_Transfomation_Enum.FORMA_FINAL);
	        freezer.doMovimientoInstantaneo();
	        freezer.doMovimientoInstantaneo(); // puede que ya no le queden usos

	        // Simular espera
	        Thread.sleep(6000); // 6 segundos
	        freezer.doMovimientoInstantaneo();

	        freezer.transformar(Frezzer_Transfomation_Enum.GOLDEN_FREEZER);
	        freezer.recargarKi(10);
	        freezer.atacar();
	    }
}
