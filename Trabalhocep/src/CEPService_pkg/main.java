package CEPService_pkg;

//Permite leitura de textos maiores/
import java.io.BufferedReader;
//Classe base para abrir excecoes que sao criadas ao acessar informacoes dde fluxos/
import java.io.IOException;
import java.io.InputStreamReader;
//abre uma excecao para determinadas partes do codigo/
import javax.xml.rpc.ServiceException;

public class main {
	public static void main(String[] args) throws ServiceException, IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		// Declaracao de variaveis/
		String cep;
		String logradouro;
		String cidade;
		String estado;

		// Pegar o CEP/
		System.out.println("executando código");
			CEPService servico = new CEPServiceLocator();
			CEPServicePort porta = servico.getCEPServicePort();
		System.out.println("====OBTER ENDEREÇO====");
		System.out.println("Digite o CEP: ");
		System.out.println();
			cep = teclado.readLine();
		// Pegar o endereco/
		System.out.println("====RESULTADO ENDEREÇO====");
		System.out.println(porta.obterLogradouroAuth(cep, "danieldev345", "Nobre706"));
		System.out.println();
		// Pegar o logadouro/
		System.out.println("====OBTER CEP====");
		System.out.println("Digite o logradouro: ");
		System.out.println();
			logradouro = teclado.readLine();
		// Pegar a cidade/
		System.out.println("Digite a cidade: ");
		System.out.println();
			cidade = teclado.readLine();
		// Pegar o UF/
		System.out.println("Digite o estado (UF): ");
		System.out.println();
			estado = teclado.readLine();
		// Autentificacao/
		String[] resultadocep = porta.obterCEPAuth(logradouro, cidade, estado, "danieldev345", "Nobre706");
			for (int i = 0; i < resultadocep.length; i++) {
			System.out.println(resultadocep[i]);
		}
		System.out.println("Total de resultados apresentados: " + resultadocep.length);
	}
}
