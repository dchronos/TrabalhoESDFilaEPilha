
public class Caixa {
	public int id;
	public Cliente atendimento;
	private int tempoGastoNoAtendimento;
	public Caixa proximo;
	public boolean livre;
	
	public Caixa(){
		atendimento = null;
		tempoGastoNoAtendimento = 0;
		proximo = null;
		livre = true;
	}
	
	public void processarDocumento(){
		if(atendimento.documentos.remover()){
			//System.out.println("Documento processado");
		}
		else{
			//System.out.println("Sem documentos para processar");
			livre = true;
			atendimento = null;
		}
	}
	
	
}
