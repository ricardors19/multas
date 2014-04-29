package br.com.cleiberio.pdf;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PDFReader {
	private String enderecoRecurso;

	public void setEnderecoRecurso(String enderecoRecurso) {
		this.enderecoRecurso = enderecoRecurso; //endere�o dos ficheiros
	}

	public String getConteudo() {
		try {
			URL url = new URL(this.enderecoRecurso);
			HttpURLConnection connection =  (HttpURLConnection) url.openConnection();
			
			InputStream is = connection.getInputStream();
			PDDocument pdfDocument = null;
			try{
				PDFParser parser = new PDFParser(is);
				parser.parse();
				pdfDocument = parser.getPDDocument();
				PDFTextStripper stripper = new PDFTextStripper();
				return stripper.getText(pdfDocument);
			} catch (IOException e){
				return "ERRO: N�o � poss�vel abrir a stream" + e;
			} catch (Throwable e){
				e.printStackTrace();
				// Fazemos um catch, uma vez que precisamos de fechar o recurso
				return "ERRO: Um erro ocorreu enquanto tentava obter o conte�do do PDF" + e;
			} finally {
				if (pdfDocument != null){
					try {
						pdfDocument.close();
					} catch (IOException e){
						return "ERRO: N�o foi poss�vel fechar o PDF." + e;
					}
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "";
	}
}
