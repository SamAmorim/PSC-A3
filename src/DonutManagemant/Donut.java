package DonutManagemant;

public class Donut {

	public int id;
	private String nome;
	private String cobertura = null;
	private String preco;
	private String recheio;
	private String tamanho;

	public Donut() {
	}

	public Donut(String nome, String cobertura, String preco, String recheio, String tamanho) {
		
		this.setNome(nome);
		this.setCobertura(cobertura);
		this.setPreco(preco);
		this.setRecheio(recheio);
		this.setTamanho(tamanho);
	}


	// Setters and getters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco2) {
		this.preco = preco2;
	}

	public String getRecheio() {
		return recheio;
	}

	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id + 1;
	}


}