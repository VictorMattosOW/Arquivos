package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ArquivosController implements IArquivosController {

	public ArquivosController() {
		super();
	}

	@Override
	public void criarDir(String path) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File[] listFiles = dir.listFiles();
			for (File f : listFiles) {
				if (f.isFile()) {
					System.out.println("     \t" + f.getName());
				} else {
					System.out.println("<DIR> \t" + f.getName());
				}
			}

		} else {
			throw new IOException("Diretório inválido");

		}
	}

	@Override
	public void criarArq(String path, String nome) throws IOException {
		boolean existe;
		File dir = new File(path);
		File arq = new File(path, nome );

		if (dir.exists() && dir.isDirectory()) {
			existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String conteudo = gerarTxt();
			FileWriter fileWriter = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWriter.close();
		} else {

			throw new IOException("Diretório inválido, ou seja, não existe ou não é diretório");

		}
	}

	private String gerarTxt() {
		Scanner in = new Scanner(System.in);
		StringBuffer buffer = new StringBuffer();
		String linha = "";
		while (linha.equalsIgnoreCase("fim")) {
			System.out.println("Digite");
			linha = JOptionPane.showInputDialog(null, "Digite algo", "Entrada de texto",
					JOptionPane.INFORMATION_MESSAGE);
			linha = in.next();

			if (!linha.equalsIgnoreCase("fim")) {
				buffer.append(linha+"\r\n");
			}

		}
		return buffer.toString();
	}

	@Override
	public void lerArq(String path, String nome) throws IOException {
		File arq= new File(path,nome);
		if(arq.exists()&& arq.isFile()){
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor= new InputStreamReader(fluxo);
			BufferedReader buffer= new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha !=null){
				System.out.println(linha);
				linha = buffer.readLine();
				
			}buffer.close();
			leitor.close();
			fluxo.close();
		}else{
			throw new IOException("Arquivo inválido");
			
		}
	}

	@Override
	public void abrirArq(String path, String nome) throws IOException {
		File arq = new File(path,nome);
		if(arq.exists()&& arq.isFile()){
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arq);
		}else{
			throw new IOException("Arquivo válido");
		}
	}


}
