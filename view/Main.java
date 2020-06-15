package view;

import java.io.IOException;

import controller.ArquivosController;
import controller.IArquivosController;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IArquivosController IarqCont = new ArquivosController();

		 String diretorioWindows = "C:\\Windows";
		String path = "C:\\TEMP\\Arquivo";
		String nome = "arquivo.csv";
		try {
			IarqCont.criarArq(path, nome);
			IarqCont.lerArq(path, nome);
			IarqCont.abrirArq(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
