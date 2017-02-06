/* 115210597 - Victor Eduardo Borges de Araujo: LAB 4 - Turma 3 */

package sp2fy;

public class Musica{
	
	private String titulo;
	private String genero;
	private int duracao;
	
	public Musica(String titulo, int duracao, String genero) throws Exception {
		if (titulo == null || titulo.trim().isEmpty()){
			
			throw new Exception ("O titulo da musica nao pode ser nulo ou vazio");
		
		}
		
		if (duracao <= 0){
			
			throw new Exception ("A duracao da musica menor ou igual a 0");
		
		}
		
		if (genero == null || genero.trim().isEmpty()){
			
			throw new Exception ("O genero da musica nao pode ser nulo ou vazio");
		
		}
		
		this.titulo = titulo;
		this.duracao = duracao;
		this.genero = genero;
	
	}
	
	public String getTitulo(){
		
		return titulo;
		
	}
	
	public void setTitulo(String titulo) throws Exception {
		
		if (titulo.trim().isEmpty() || titulo == null){
			
			throw new Exception ("O titulo da musica nao pode ser nulo ou vazio");
		
		}
		
		this.titulo = titulo;
		
	}
	
	public int getDuracao(){
		
		return duracao;
		
	}
	
	public void setDuracao(int duracao) throws Exception {
		
		if (duracao < 0){
			
			throw new Exception ("A duracao da musica menor ou igual a 0");
		
		}
		
		this.duracao = duracao;
		
	}
	
	public String getGenero(){
		
		return genero;
		
	}
	
	public void setGenero(String genero) throws Exception {
		
		if (genero.trim().isEmpty() || titulo == null){
			
			throw new Exception ("O genero da musica nao pode ser nulo ou vazio");
		
		}
		
		this.genero = genero;
		
	}

	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
		
	}

	public boolean equals(Object objeto){
		
		if(objeto instanceof Musica){
			
			Musica outraMusica = (Musica)objeto;
			
			if (outraMusica.getTitulo().equals(this.getTitulo())){
				
				if (outraMusica.getDuracao() == (this.getDuracao())){
					
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
		
		return this.getTitulo() + " (" + this.getGenero() + " - " + this.getDuracao() + " minutos)";
		
	}
	
}