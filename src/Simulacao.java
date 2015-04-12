import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Simulacao {
	
	public Simulacao(){
		
	}
	public Simulacao(int hora){
		//System.out.println("Simula��o " + hora);
		
		//Inicializacao do arquivo
		FileWriter arq = null;
		try {
			arq = new FileWriter("simulacaoHora"+hora+".txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter gravarArq = new PrintWriter(arq);
		

		
		
		double novo = Math.random();
		//System.out.println("random: " + novo);
		
		//La�o com a itera��o entre o n�mero de caixas e o n�mero de minutos;
		for (int i = 5; i<=20; i++){
			gravarArq.printf("Simulacao na hora: " + hora + " com " + i + " caixas ");
			FilaNormal filaNormal = new FilaNormal();
			ListaCaixas caixas = new ListaCaixas(i);
			int tempoMaximo = 0;
			
			//N�mero de minutos at� ser gerado uma nova tentativa com mais um caixa
			for (int j = 0; j<120; j++){
				//System.out.println("=== Hora: " + hora + " Minuto: " + j);
				filaNormal.adicionarClienteNaFila(hora);
				int tempo = caixas.chamarCliente(filaNormal);
				filaNormal.atualizarTempos();
				caixas.processarCaixas();
				if(tempo > tempoMaximo){
					tempoMaximo = tempo;
				}
			}
			
			//Valida��o de dados de sa�da
			if(tempoMaximo <= 10){
				gravarArq.printf("tempo de espera m�ximo em minutos: " + tempoMaximo + "%n");
				System.out.printf("Simulacao na hora: " + hora + " com " + i + " caixas ");
				System.out.println("tempo de espera m�ximo em minutos: " + tempoMaximo);
			}
			else{
				gravarArq.printf("Nenhuma configuracao satisfatoria %n");
				//System.out.println("tempo de espera m�ximo em minutos: " + tempoMaximo + "Resultado");
			}
		}

		//filaNormal.imprimirFila();
		
		//Fecha Arquivo
		try {
			arq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
