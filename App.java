import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
	
	static final int LINHAS_MATRIZ = 5;
	static final int COLUNAS_MATRIZ = 5;
	
	public static void main(String[] args) {
		List<Figura> listaFiguras;
		List<Forma> listaFormas = new ArrayList<Forma>();;
		List<Cor> listaCores = new ArrayList<Cor>();;
		//List<Neuronio> listaNeuronios;
		//Estimulo estimulos;
		
		try {
			listaFiguras = criarFiguras(listaFormas,listaCores);
			gerarTargetsParciais(listaFormas, listaCores);
			
			/* GERANDO TARGETS ABSOLUTOS */
			
			for(Figura figura : listaFiguras) {
				figura.calcularTarget();
			}
			
			//Cria��o dos neur�nios
			//Cria��o da matriz
			
			/*boolean erro = true;
			
			while (erro) {
				erro = false;
				
				//for (padroes i)
					//for (neuronios j)
						//for (estimulos k)
							//somatorio[i] += estimulo(i,k) * peso(i,k)
						
						//y[j] = somatorio[j] 
				
						//if (y[j] != t[j])
							erro = true;
							//peso[i,j] = (formula);
			}*/
			
			
			/* PRINTANDO AS LISTAS DE FORMAS, CORES E FIGURAS PARA CONFER�NCIA */
			
			System.out.println("LISTA DE FORMAS");
			System.out.println("");
			for(Forma forma : listaFormas) {
				System.out.println("Forma: " + forma.getNome());
				System.out.println("Target da forma: " + forma.getTargetForma());
				System.out.println("");
			}

			System.out.println("Total de Formas: " + Forma.getTotalFormas());
			System.out.println("");
			System.out.println("");
			
			System.out.println("LISTA DE CORES");
			System.out.println("");
			for(Cor cor : listaCores) {
				System.out.println("Cor: " + cor.getNome());
				System.out.println("Target da cor: " + cor.getTargetCor());
				System.out.println("");
			}
			
			System.out.println("Total de Cores: " + Cor.getTotalCores());
			System.out.println("");
			System.out.println("");
			
			System.out.println("LISTA DE FIGURAS");
			System.out.println("");
			for(Figura figura : listaFiguras) {
				System.out.println("Figura: " + figura.getForma().getNome() + " " + figura.getCor().getNome());
				System.out.println("Target da figura: " + figura.getTarget());
				System.out.println("");
			}
			
			System.out.println("Total de Figuras: " + Figura.getTotalFiguras());
			
		} catch (IOException ex) {
			System.out.println("N�o foi poss�vel abrir o arquivo figuras.txt.");
			ex.printStackTrace();
		}
	}
	
	
	public static List<Figura> criarFiguras(List<Forma> listaFormas, List<Cor> listaCores) throws IOException {
		List<Figura> listaFiguras = new ArrayList<Figura>();
		File file = new File(".\\src\\figuras.txt");		
		BufferedReader br = new BufferedReader(new FileReader(file));
					
		String line = null;
		while((line = br.readLine()) != null) {
			Figura figura = new Figura();
			
			/*LEITURA DA FIGURA NO ARQUIVO*/
			
			String nomeForma = line;
			String nomeCor = br.readLine();
			
			/* VERIFICANDO SE A FORMA � REPETIDA */
			
			for(Forma forma : listaFormas) {
				if(forma.getNome().equals(nomeForma)) {
					figura.setForma(forma);
					break;
				}
			}
			
			/* CASO SEJA UMA NOVA FORMA, CRIA NOVO OBJETO */
			
			if(figura.getForma() == null) {
				
				/* POPULANDO A MATRIZ DE CARACTERES */
				
				char [][] matriz = new char[LINHAS_MATRIZ][COLUNAS_MATRIZ];
				for(int i = 0; i < LINHAS_MATRIZ; i++) {
					line = br.readLine();
					for(int j = 0; j < line.length(); j++) {
						matriz[i][j] = line.charAt(j);
					}					
				}
														
				Forma forma = new Forma();
				forma.setNome(nomeForma);
				forma.setMatriz(matriz);
				listaFormas.add(forma);
				figura.setForma(forma);
			} else {
			
				/* CASO SEJA UMA FORMA EXISTENTE, APENAS PERCORRE A MATRIZ */
				
				for(int i = 0; i < LINHAS_MATRIZ; i++) {
					br.readLine();
				}
			}
			
			/* VERIFICA SE A COR � REPETIDA */
			
			for(Cor cor : listaCores) {
				if(cor.getNome().equals(nomeCor)) {
					figura.setCor(cor);
					break;
				}
			}
			
			/* CASO SEJA UMA NOVA COR, CRIA NOVO OBJETO */
			
			if(figura.getCor() == null) {
				Cor cor = new Cor();
				cor.setNome(nomeCor);
				listaCores.add(cor);
				figura.setCor(cor);
			}
			
			listaFiguras.add(figura);
			br.readLine();
		}
		
		br.close();	
		return listaFiguras;
	}
	
	public static void gerarTargetsParciais(List<Forma> listaFormas, List<Cor> listaCores) {
		int count = Forma.getTotalFormas()-1;
			
		for (int i = 0; i < Forma.getTotalFormas(); i++) {
			StringBuilder str = new StringBuilder();
			
			for (int j = 0; j < Forma.getTotalFormas(); j++) {
				if (j == count) {
					str.append("1");
				} else {
					str.append("0");
				}
			}
			
			listaFormas.get(i).setTargetForma(str.toString());
			count--;
		}
		
		count = Cor.getTotalCores()-1;
		for (int i = 0; i < Cor.getTotalCores(); i++) {
			StringBuilder str = new StringBuilder();
			
			for (int j = 0; j < Cor.getTotalCores(); j++) {
				if (j == count) {
					str.append("1");
				} else {
					str.append("0");
				}
			}
			
			listaCores.get(i).setTargetCor(str.toString());
			count--;
		}
	}
	
	public static List<Neuronio> criarNeuronios() {
		List<Neuronio> listaNeuronios = new ArrayList<Neuronio>();
		
		//TO-DO
		
		return listaNeuronios;
	}
	
	public static String palpitesToString(int [] palpites) {
		StringBuilder palpite = new StringBuilder();
		
		//TO-DO
		
		return palpite.toString();
	}
	
	public static boolean checarErro() {
		//TO-DO
		
		return false;
	}
}


	//MSE:  Em = (1/2 *(yi * ti)�)/Somatorio(n)