/* 115210597 - Victor Eduardo Borges de Araujo: LAB 4 - Turma 3 */

package sp2fy;

import java.util.ArrayList;

public class Album{
	
	private ArrayList<Musica> album;
	private String artista;
	private String titulo;
	private int ano;
	
	public Album(String artista, String titulo, int ano) throws Exception {
		
		if (artista == null || artista.trim().isEmpty()){
			
			throw new Exception ("Artista do album nao pode ser nulo ou vazio.");
	
		}
		
		if (titulo == null || titulo.trim().isEmpty()){
		
			throw new Exception ("Titulo do album nao pode ser nulo ou vazio.");
		
		}		
		
		if (ano <= 1900){
		
			throw new Exception ("Ano de lancamento do album nao pode ser inferior a 1900.");
		
		}
		
		this.artista = artista;
		this.titulo = titulo;
		this.ano = ano;		
		this.album = new ArrayList<Musica>();
		
	}
	
	public ArrayList<Musica> getAlbum(){
		
		return album;
		
	}
	
	public void setAlbum(ArrayList<Musica> album){
		
		this.album = album;
		
	}
	
	public String getArtista(){
		
		return artista;
		
	}
	
	public void setArtista(String artista) throws Exception {
		
		if (artista == null || artista.equals("")){
			
			throw new Exception ("Artista do album nao pode ser nulo ou vazio.");
	
		}
		
		this.artista = artista;
		
	}
	
	public String getTitulo(){
		
		return titulo;
		
	}
	
	public void setTitulo(String titulo) throws Exception {
		
		if (titulo == null || titulo.trim().isEmpty()){
			
			throw new Exception ("Titulo do album nao pode ser nulo ou vazio.");
		
		}	
		
		this.titulo = titulo;
		
	}
	
	public int getAno(){
		
		return ano;
		
	}
	
	public void setAno(int ano)throws Exception {
		
		if (ano <= 1900){
			
			throw new Exception ("Ano de lancamento do album nao pode ser inferior a 1900.");
		
		}
		
		this.ano = ano;
		
	}
	
	
	public boolean adicionaMusica(Musica musica) throws Exception {
	
		if (musica == null){
				
			return false;
				
		}
			
		this.album.add(musica);
		return true;
	
		
	}
	
	public boolean removeMusica(Musica musicaParaRemover){
		
		boolean musicaRemovida = false;
		
		for (Musica musica : album){
			
			if (musica.equals(musicaParaRemover)){
				
				this.album.remove(musica);
				musicaRemovida = true;
				
			}
			
		}
		
		return musicaRemovida;
		
	}
	
	public boolean removeMusica(String titulo){
		
		boolean musicaRemovida = false;
		
		for (Musica musica : album){
			
			if (musica.getTitulo().equals(titulo)){
				
				this.album.remove(musica);
				musicaRemovida = true;
				
			}
			
		}
		
		return musicaRemovida;
		
	}
	
	public boolean removeMusica(int faixa){
		
		boolean musicaRemovida = false;
		
		if (faixa >= 0){
			this.album.remove(faixa - 1);
			musicaRemovida = true;
		}
		
		return musicaRemovida;
		
	}
	
	public boolean contemMusica(String tituloMusica){
		
		boolean musicaVerificada = false;
		
		for (Musica musica : this.album){
			
			if (musica.getTitulo().equalsIgnoreCase(tituloMusica)){
				
				musicaVerificada = true;
				
			}
		}
			
		return musicaVerificada;
		
	}
	
	public Musica getMusica(String titulo){
		
		Musica musicaDesejada = null;
		
		for (Musica musica : this.album){
			
			if (musica.getTitulo().equalsIgnoreCase(titulo)){
				
				musicaDesejada = musica;
				
			}
		}
		
		return musicaDesejada;
		
	}
	
	public Musica getMusica(int faixa){
		
		return album.get(faixa - 1);
		
	}
	
	public int getDuracaoTotal(){
		
		int duracao = 0;
		for (Musica musica : this.album){
			
			duracao = duracao + musica.getDuracao();
			
		}
		
		return duracao;
		
	}
	
	public int quantidaDeFaixas(){
		
		return this.album.size();
		
	}

	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	
	}

	public boolean equals(Object objeto) {
		
		if(objeto instanceof Album){
			
			Album outroAlbum = (Album)objeto;
			
			if (outroAlbum.getTitulo().equals(this.getTitulo())){
				
				if (outroAlbum.getArtista().equals(this.getArtista())){
					
					return true;
					
				} else {
					
					return false;
					
				}
				
			} else {
				
				return false;
				
			}
			
		} else {
			
			return false;
			
		}
		
	}
	
	public String toString(){
		
		String FIM_DE_LINHA = System.lineSeparator();
		
		String toString = this.getTitulo() + ", " + this.getArtista() + " (" + this.getAno() + ")";
		
		int indice = 1;
		
		for (Musica musica : this.album){
			
			toString = toString + FIM_DE_LINHA + "   " + indice + ". " + musica.toString();
			indice = indice + 1;
			
		}
		
		return toString;
		
	}
	
	
}