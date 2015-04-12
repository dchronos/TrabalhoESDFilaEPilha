import java.util.Random;


public class PilhaDeDocumentos {
	public Documento inicio;
	public Documento fim;
	
	public PilhaDeDocumentos(){
		inicio = null;

		
		Documento inicial = new Documento();
		inicio = inicial;
		Documento p = inicio;
		int docs = randInt(5,40);
		for(int i=0; i< docs; i++){
			Documento novo = new Documento();
			p.proximo = novo;
			p = p.proximo;
			fim = p;
		}
	}
	
	public void imprimir(){
		Documento p = inicio;
		int count = 0;
		while(p.proximo != null){
			//System.out.println("Valor do documento "+ count + ": " + p.valor);
			count ++;
			p = p.proximo;
		}
	}
	//Metodo de retornar numero randomico para uma determinada range
	public static int randInt(int min, int max) {

	   
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	//Remove da pilha um documento e retorna true ou false, considerando false o cliente não possui mais documentos
	public boolean remover(){
		Documento p = inicio;
		if(p==null){
			return false;
		}
		else if(p == fim){
			fim = null;
			inicio = null;
			return true;
		}
		else{
			while(p != fim){
				if(p.proximo == fim){
					fim = p;
					fim.proximo = null;
					return true;
				}
				p = p.proximo;
			}
		}
		return false;
		
	}

}
