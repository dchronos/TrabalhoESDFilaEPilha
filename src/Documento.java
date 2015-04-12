import java.util.Random;


public class Documento {
	public double valor;
	public Documento proximo;
	private double rangeMax = 500.00;
	private double rangeMin = -500.00;
	
	public Documento(){
		Random r = new Random();
		//Preenche o valor do documento com a range double [-500;500]
		double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
		valor = randomValue;
	}

}
