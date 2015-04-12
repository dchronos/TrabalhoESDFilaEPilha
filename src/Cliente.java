
public class Cliente {
	public double id;
	public int tempoDeEspera;
	public PilhaDeDocumentos documentos;
	public Cliente proximo;
	
	public Cliente(){
		id = Math.random();
		proximo = null;
		tempoDeEspera = 0;
		documentos = new PilhaDeDocumentos();
	}

}
