import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Simulacao {
	
	public Simulacao(){
		
	}
	public Simulacao(int hora){
		//System.out.println("Simulação " + hora);
		
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
		
		//Laço com a iteração entre o número de caixas e o número de minutos;
		for (int i = 5; i<=20; i++){
			gravarArq.printf("Simulacao na hora: " + hora + " com " + i + " caixas ");
			FilaNormal filaNormal = new FilaNormal();
			ListaCaixas caixas = new ListaCaixas(i);
			int tempoMaximo = 0;
			
			//Número de minutos até ser gerado uma nova tentativa com mais um caixa
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
			
			//Validação de dados de saída
			if(tempoMaximo <= 10){
				gravarArq.printf("tempo de espera máximo em minutos: " + tempoMaximo + "%n");
				System.out.printf("Simulacao na hora: " + hora + " com " + i + " caixas ");
				System.out.println("tempo de espera máximo em minutos: " + tempoMaximo);
			}
			else{
				gravarArq.printf("Nenhuma configuracao satisfatoria %n");
				//System.out.println("tempo de espera máximo em minutos: " + tempoMaximo + "Resultado");
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
