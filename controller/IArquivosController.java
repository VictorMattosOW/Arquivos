package controller;

import java.io.IOException;

public interface IArquivosController {

	public void criarDir(String path) throws IOException;//lendo arquivos do diretório
	public void criarArq(String path, String nome )throws IOException;//caminho onde o arquivo vai ser criado
	public void lerArq(String path, String nome)throws IOException;
	public void abrirArq(String path, String nome)throws IOException;
	
}
