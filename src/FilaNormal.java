
public class FilaNormal {
	public Cliente inicio;
	private double probabilidadeDeEntrada;
	
	public FilaNormal(){
		inicio = null;
	}
	
	//Tabela de porcentagem de entrada de pessoas na fila. 
	private void atualizaProbabilidade(int hora){
		switch (hora) {
		case 10:
			probabilidadeDeEntrada = 0.3;
			break;
		case 11:
			probabilidadeDeEntrada = 0.7;
			break;
		case 12:
			probabilidadeDeEntrada = 0.9;
			break;
		case 13: 
			probabilidadeDeEntrada = 0.8;
			break;
		case 14:
			probabilidadeDeEntrada = 0.7;
			break;
		case 15:
			probabilidadeDeEntrada = 0.9;
			break;
		default:
			probabilidadeDeEntrada = 0.9;
			break;
		}
	}
	
	
	//Adiciona cliente na fila considerando a probabilidade para o horario dado como parametro.
	public void adicionarClienteNaFila(int hora){
		Cliente p = inicio;
		atualizaProbabilidade(hora);
		if(Math.random() <= probabilidadeDeEntrada){
			//System.out.println("Cliente Novo");
			if(inicio == null){
				Cliente novo = new Cliente();
				inicio = novo;
			}
			else{
				while(p.proximo != null){
					p = p.proximo;
				}
				Cliente novo = new Cliente();
				p.proximo = novo;
			}
		}
	}
	
	public void imprimirFila(){
		Cliente p = inicio;
		int count = 0;
		while(p.proximo != null){
			System.out.println(count + ": Cliente: " + p.id);
			System.out.println(count + ": Tempo: " + p.tempoDeEspera);
			//p.documentos.imprimir();
			count ++;
			p = p.proximo;
			
		}
	}
	
	//Remove cliente da fila
	public void remove(){
		Cliente p = inicio;
		if(inicio!=null){
			inicio = inicio.proximo;
			//System.out.println("Tempo Gasto: " + p.tempoDeEspera);
			p.proximo = null;
		}
	}
	
	//Itinera na fila atualizando o tempo de espera
	public void atualizarTempos(){
		Cliente p = inicio;
		while(p != null){
			p.tempoDeEspera++;
			p = p.proximo;
		}
			
	}

}
