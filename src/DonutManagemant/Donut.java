package DonutManagemant;

public class Donut implements ManagerInterface {

	public int id;
	private String nome;
	private String cobertura;
	private int preco;
	private String recheio;
	private String tamanho;
	private Donut[] donut = new Donut[5];

	public Donut() {
	}

	public Donut(String nome, String cobertura, int preco, String recheio, String tamanho) {
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
		donut[0] = new Donut(getNome(), getCobertura(), getPreco(), getRecheio(), getTamanho());

	}

	// metodo para remover objetos por id
	@Override
	public void removeObject() {
		// TODO Auto-generated method stub

	}

	// metodo para atualizar um atributo por id
	@Override
	public void updateObject() {
		// TODO Auto-generated method stub

	}

	// metodo para retornar tudo sobre o objeto
	@Override
	public void returnObject() {
		System.out.println(donut[0].getNome() + "\n" + donut[0].getCobertura() + "\n" + donut[0].getPreco() + "\n"
				+ donut[0].getRecheio() + "\n" + donut[0].getTamanho());

	}

	// metodo que retorna a posição do objeto no array
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}