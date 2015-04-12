
public class ListaCaixas {
	private Caixa inicial;
	
	public ListaCaixas () {
		inicial = new Caixa();
		inicial.id = 1;
		for (int i = 1; i < 5; i++) {
			Caixa novo = new Caixa();
			novo.id = i+1;
			insere(novo);
		}
	}
	public ListaCaixas(int qty){
		inicial = new Caixa();
		inicial.id = 1;
		for (int i = 1; i < qty; i++) {
			Caixa novo = new Caixa();
			novo.id = i+1;
			insere(novo);
		}
	}
	
	//Insere um novo caixa na Lista
	private void insere (Caixa novo) {
		Caixa p = inicial;
		while(p.proximo != null){
			p = p.proximo;
		}
		p.proximo = novo;
	}
	
	
	//Valida se tem um caixa livre e retorna o tempo que o cliente ficou esperado até o momento que ele chegou no caixa
	public int chamarCliente(FilaNormal fila){
		Caixa p = caixaDisponivel();
		
		if(p != null){
			//System.out.println("Caixa "+ p.id +" Livre");
			if(fila.inicio != null){
				p.atendimento = fila.inicio;
				p.livre = false;
				fila.remove();
				return p.atendimento.tempoDeEspera;
			}
		}
		return 0;
	}
	
	//Valida qual caixa está disponível no minuto
	public Caixa caixaDisponivel(){
		Caixa p = inicial;
		while(p != null){
			if(p.livre){
				return p;
			}
			p = p.proximo;
		}
		return null;
	}
	
	//Executa a ação de processar documentos da lista de caixas
	public void processarCaixas(){
		Caixa p = inicial;
		while (p != null){
			if(!p.livre){
				p.processarDocumento();
			}
			p = p.proximo;
		}
		
	}

}
