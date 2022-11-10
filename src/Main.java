import DonutManagemant.*;
public class Main {

	public static void main(String[] args) {

		Donut donut = new Donut();
		donut.setNome("manuel gomes caneta azul");
		donut.setCobertura("caneta");
		donut.setPreco(12345);
		donut.setRecheio("azul");
		donut.setTamanho("grande de mais");
		
		donut.insertObject();
		donut.returnObject();

	}
}
