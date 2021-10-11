import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
	
	public static boolean Escreve(String caminho, String texto) {
		try {
			FileWriter arquivo = new FileWriter(caminho);
			PrintWriter gravarArquivo = new PrintWriter(arquivo);
			gravarArquivo.println(texto);
			gravarArquivo.close();
			return true;
		}catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
