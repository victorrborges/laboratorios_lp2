/* 115210597 - Victor Eduardo Borges de Araujo: LAB 4 - Turma 3 */

package sp2fy;

import java.util.HashSet;

import java.util.ArrayList;

import java.util.HashMap;

public class Musiteca {

	private HashSet<Album> meusAlbuns;
	private HashSet<Album> meusAlbunsFavoritos;
	private HashMap<String, ArrayList<Musica>> playlists;

	public Musiteca(){
		
		this.meusAlbuns = new HashSet<Album>();
		this.meusAlbunsFavoritos = new HashSet<Album>();
		this.playlists = new HashMap<String, ArrayList<Musica>>();
		
	}
	
	public HashSet<Album> getMeusAlbuns(){
		
		return this.meusAlbuns;
		
	}
	
	public void setMeusAlbuns(HashSet<Album> meusAlbuns){
		
		this.meusAlbuns = meusAlbuns;
		
	}
	
	public HashSet<Album> getMeusAlbunsFavoritos(){
		
		return this.meusAlbunsFavoritos;
		
	}
	
	public void setMeusAlbunsFavoritos(HashSet<Album> meusAlbunFavoritos){
		
		this.meusAlbunsFavoritos = meusAlbunFavoritos;
		
	}
	
	public HashMap<String, ArrayList<Musica>> getPlaylists(){
		
		return this.playlists;
		
	}
	
	public void setPlaylists(HashMap<String, ArrayList<Musica>> playlist){
		
		this.playlists = playlist;
		
	}
	
	public boolean addAlbum(Album album) {
		
		if (album == null){
			
			return false;
			
		}
		
		return meusAlbuns.add(album);
			
	}
	
	public boolean removeAlbum(Album album) {
		
		if (album == null){
			
			return false;
			
		} 		
			
		return meusAlbuns.remove(album);
		
	}
	
	public boolean contemAlbum(Album album){
		
		if (album == null){
			
			return false;
			
		} 
		
		return meusAlbuns.contains(album);
		
	}
	
	public HashSet<Album> getAlbuns(String artista){
		
		HashSet<Album> albunsDoArtista = new HashSet<Album>();
		
		for (Album album : meusAlbuns){
			
			if (album.getArtista().equals(artista)){
				
				albunsDoArtista.add(album);
				
			}
			
		}
		
		return albunsDoArtista;
		
	}
	
	public HashSet<Album> getAlbuns(int ano){
		
		HashSet<Album> albunsDesteAno = new HashSet<Album>();
		
		for (Album album : meusAlbuns){
			
			if (album.getAno() == ano){
				
				albunsDesteAno.add(album);
				
			}
			
		}
		
		return albunsDesteAno;
		
	}
	
	public boolean addAosFavoritos(Album album){
		
		if (album == null){
			
			return false;
			
		} 
		
		boolean adicionouAlbum = false;
		
		if (meusAlbuns.contains(album)){
			
			adicionouAlbum = meusAlbunsFavoritos.add(album);
			
		}
		
		return adicionouAlbum;
		
	}
	
	public boolean removeDosFavoritos(Album album){
		
		if (album == null){
			
			return false;
			
		} 
		
		return meusAlbunsFavoritos.remove(album);
		
	}
	
	public int getQtdFavoritos(){
		
		return meusAlbunsFavoritos.size();
		
	}
	
	public boolean criaPlaylist(String nome) {
		
		if (playlists.containsKey(nome)){
			
			return false;
			
		}
		
		if (nome.trim().isEmpty()){
			
			return false;
			
		}
		
		playlists.put(nome, new ArrayList<Musica>());
		return true;
		
	}
	
	public boolean contemPlaylist(String nome){
		
		return playlists.containsKey(nome);
		
	}
	
	public int getPlaylistSize(String nome){
		
		return playlists.get(nome).size();
		
	}
	
	public boolean contemNaPlaylist(String playlist, String nomeMusica){
		
		Musica musica = null;
		
		for (Album album : meusAlbuns){
			
			if (album.contemMusica(nomeMusica)){
				
				musica = album.getMusica(nomeMusica);
				
			}
			
		}
		
		return playlists.get(playlist).contains(musica);
		
	}
	
	
	public boolean addNaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception {
		
		if (!contemPlaylist(nomePlaylist)){
			
			criaPlaylist(nomePlaylist);
			
		}
			
		
		for (Album album : this.meusAlbuns){
			
			if (album.getTitulo().equals(nomeAlbum)){
					
				return playlists.get(nomePlaylist).add(album.getMusica(faixa));
					
			} else {
				
				throw new Exception("Album nao pertence ao Perfil especificado");
				
			}
			
		}
		
		return false;
		
	}

	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((meusAlbuns == null) ? 0 : meusAlbuns.hashCode());
		result = prime * result + ((meusAlbunsFavoritos == null) ? 0 : meusAlbunsFavoritos.hashCode());
		result = prime * result + ((playlists == null) ? 0 : playlists.hashCode());
		return result;
	
	}

	public boolean equals(Object objeto) {
		
		if (objeto instanceof Musiteca){
			
			Musiteca outraMusiteca = (Musiteca) objeto;
			
			if (outraMusiteca.meusAlbuns.equals(this.meusAlbuns)){
				
				if (outraMusiteca.meusAlbunsFavoritos.equals(this.meusAlbunsFavoritos)){
					
					if (outraMusiteca.playlists.equals(this.playlists)){
						
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
			
			
		} else {
			
			return false;
			
		}
	
	
	}
	
	public String toString(){
		
		String FIM_DE_LINHA = System.lineSeparator();
		
		String toString = "Minha Musiteca:" + FIM_DE_LINHA + FIM_DE_LINHA + "=== Meus Albuns ===" + FIM_DE_LINHA + FIM_DE_LINHA;
		
		for (Album album : meusAlbuns){
			
			toString = toString + album.toString() + FIM_DE_LINHA + FIM_DE_LINHA;
			
		}
		
		toString = toString + "=== Meus Albuns Favoritos ===" + FIM_DE_LINHA + FIM_DE_LINHA;
		
		for (Album album : meusAlbunsFavoritos){
			
			toString = toString + album.toString() + FIM_DE_LINHA + FIM_DE_LINHA;
			
		}
		
		toString = toString + "=== Minhas Playlists ===" + FIM_DE_LINHA + FIM_DE_LINHA;
		
		for (String chave : playlists.keySet()){
			
			toString = toString + chave + FIM_DE_LINHA;
			
			for (Musica musica : playlists.get(chave)){
				
				toString = toString + musica.toString() + FIM_DE_LINHA;
				
			}
			
			toString = toString + FIM_DE_LINHA;
			
		}
		
		return toString;
		
	}
	
}
