package javaBeans;

public class Listenear {
	public static void main(String[] args) {
		Publisher shein = new Publisher("Sin ropita", "Shein");
		Subcriber elenaGastona = new Subcriber("Lnita");
		
		// Darle al boton
		shein.addPropertyChangeListener(elenaGastona);
		System.out.println("------");
		shein.setValue("Ropita Linda");
		
		//Lnita compra la Ropita :D
		comprarShein();
		shein.removePropertyChangeListener(elenaGastona);
		System.out.println();
		
		shein.setValue("Sin Ropita");
		
		Subcriber aneleeGastona = new Subcriber("Aneleee");
		shein.addPropertyChangeListener(aneleeGastona);
		shein.addPropertyChangeListener(elenaGastona);
		
		shein.setValue("Ropita Preciosa");
		
		//Lnita compra la Ropita :D
		comprarShein();
		shein.removePropertyChangeListener(elenaGastona);
		comprarShein();
		shein.removePropertyChangeListener(aneleeGastona);
		System.out.println();
		
	}
	
	public static void comprarShein() {
		System.out.println("Lo compro D: D: D:");
		System.out.println("Voy a tener Ropita jiji");
	}

}
