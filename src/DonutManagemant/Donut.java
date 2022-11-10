package DonutManagemant;

public class Donut implements ManagerInterface {

	private int id;
	private String nome;
	private String cobertura;
	private int preco;
	private String recheio;
	private String tamanho;
	
	
	public Donut() {
	}
	
	public Donut(String nome, String Cobertura, int preco, String recheio, String tamanho) {
		this.nome = nome;
		this.cobertura = Cobertura;
		this.preco = preco;
		this.recheio = recheio;
	}
	
	
	//Setters and getters
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

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
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
	
	
	// metodo para inserir objetos
	@Override
	public void insertObject() {
		
		
	}

	//metodo para remover objetos por id
	@Override
	public void removeObject() {
		// TODO Auto-generated method stub
		
	}
	
	//metodo para atualizar um atributo por id
	@Override
	public void updateObject() {
		// TODO Auto-generated method stub
		
	}
	//metodo para retornar tudo sobre o objeto
	@Override
	public void returnObject() {
		// TODO Auto-generated method stub
		
	}
	
	//metodo que retorna a posição do objeto no array
	@Override
	public int returnObjectIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

}