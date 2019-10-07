/* 115210597 - Victor Eduardo Borges de Araujo: LAB 4 - Turma 3 */

package sp2fy;

import java.util.HashSet;

public class Perfil {

	private String nome;
	private Musiteca musiteca;
	
	public Perfil (String nome){
		
		this.nome = nome;
		this.musiteca = new Musiteca();
		
	}
	
	public String getNome(){
		
		return nome;
		
	}
	
	public void setNome(String nome){
		
		this.nome = nome;
		
	}
	
	public Musiteca getMusiteca(){
		
		return musiteca;
		
	}
	
	public void setMusiteca(Musiteca musiteca){
		
		this.musiteca = musiteca;
		
	}
	
	public boolean adicionaAlbum(Album album){
		
		try{
		
			return musiteca.addAlbum(album);
		
		} catch (Exception excecao){
			
			System.out.println("Erro na adicao de musicas no album");
		    System.out.println(excecao.getMessage());
			return false;
		}
	
	}
	
	public boolean adicionaAlbum(String tituloAlbum, String artista, int ano) {
		
		try{
			
			Album album = new Album(tituloAlbum, artista, ano);	
			return musiteca.addAlbum(album);
			
		} catch(Exception excecao){
		     
			 System.out.println("Erro na adicao de musicas no album");
		     System.out.println(excecao.getMessage());
		     return false;
		     
		   }
		}
	
	public boolean removaAlbum(Album album){
		
		try {
			
			return musiteca.removeAlbum(album);
		
		} catch (Exception excecao){
			
			System.out.println("Erro na remocao de musicas no album");
		    System.out.println(excecao.getMessage());
			return false;
			
		}
		
	}
	
	public boolean verificaAlbum(Album album){
		
		try{
			
			return musiteca.contemAlbum(album);
		
		} catch (Exception excecao){
			
			System.out.println("Erro na busca de albuns na Musiteca");
		    System.out.println(excecao.getMessage());
			return false;
			
		}
		
	}
	
	public HashSet<Album> albunsPorArtista(String artista){
			
		return musiteca.getAlbuns(artista);
	
	}
		
	
	public HashSet<Album> albunsPorAno(int ano){
		
		return musiteca.getAlbuns(ano);
		
	}
	
	public boolean addAosFavoritos(Album album){
		
		return musiteca.addAosFavoritos(album);
		
	}
	
	public boolean removeDosFavoritos(Album album){
		
		return musiteca.removeDosFavoritos(album);
		
	}
	
	public int getQtdFavoritos(){
		
		return musiteca.getQtdFavoritos();
		
	}
	
	public void novaPlaylist(String nome){
		
		musiteca.criaPlaylist(nome);
		
	}
	
	public boolean verificaPlaylist(String nome){
		
		return musiteca.contemPlaylist(nome);
		
	}
	
	public boolean addNaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception {
		
		try{ 
			
			return musiteca.addNaPlaylist(nomePlaylist, nomeAlbum, faixa);
		
		} catch (Exception excecao){
			
			System.out.println("Erro na adicao de musica na Playlist");
			System.out.println(excecao);
			return false;
			
		}
		
	}

	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((musiteca == null) ? 0 : musiteca.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	
	}

	public boolean equals(Object objeto) {

		if (objeto instanceof Perfil){
			
			Perfil outroPerfil = (Perfil) objeto;
			
			if (outroPerfil.getNome().equals(this.getNome())){
				
				if (outroPerfil.getMusiteca().equals(this.getMusiteca())){
					
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
		
		return "Meu Perfil:" + FIM_DE_LINHA + FIM_DE_LINHA + musiteca.toString();
		
	}

}
	

