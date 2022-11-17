import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import DonutManagemant.Donut;

public class MainGUI extends JFrame implements ManagerInterface {

	private JPanel contentPane;
	private JTextField coberturaInput;
	private JTextField recheioInput;
	private JTextField tamanhoInput;
	private JTextField nomeInput;
	int cont = 0;

	// importando o array de objetos
	Donut[] donut = new Donut[2];
	
	
	private JTextField precoInput;

	// metodo principal
	public static void main(String[] args) {
		// rodando a interface
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
	
	// metodo de inserir objeto um a um e atribuir id
	@Override
	public void insertObject() {

		// criando objeto
		donut[cont] = new Donut(nomeInput.getText(), coberturaInput.getText(), precoInput.getText(), recheioInput.getText(),
				tamanhoInput.getText());
		//Atribuição de ID
		donut[cont].setId(cont);
	
		//monstrando no console
		System.out.println("contagem: " + cont);
		System.out.println("ID: " + donut[cont].getId());
		System.out.println("nome " + donut[cont].getNome() + "\ncobertura " + donut[cont].getCobertura() + "\npreco"
				+ donut[cont].getPreco() + "\nrecheio" + donut[cont].getRecheio() + "\n");
		
		
		// inserindo sequencialmente
		cont += 1;
		
		
		//redimensionando o array donut
		
		Donut[] temp = new Donut[donut.length + 1];
		donut = temp;
		}

	// metodo de remover objeto por id
	@Override
	public void removeObject() {

	}

	// metodo de atualizar um objeto por id
	@Override
	public void updateObject() {

	}

	// retornar todas as caracteristicas de um objeto por id
	@Override
	public void returnObject() {

	}

	// metodo para retornar id de um objeto
	@Override
	public int getId() {

		return 0;
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		// titulo, icon, janela
		setTitle("Donutlandia");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/images/_iconDonut.png")));
		setBackground(new Color(204, 255, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 668);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Atribuição dos botões de add
		JButton addButton = new JButton("Adicionar");
		// ação ao clicar no botao
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insertObject();
			}
		});

		addButton.setBounds(31, 401, 104, 38);
		contentPane.add(addButton);

		// atribuição botão remove
		JButton RemoveButton = new JButton("Remover");
		// ação clicar no botao romove
		RemoveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		RemoveButton.setBounds(400, 401, 104, 38);
		contentPane.add(RemoveButton);

		// Criação dos paineis e etiquetas

		// titulos
		JLabel tittleColor = new JLabel("DONUTLANDIA");
		tittleColor.setForeground(new Color(255, 102, 102));
		tittleColor.setFont(new Font("TT Berlinerins", Font.PLAIN, 52));
		tittleColor.setBounds(152, 35, 238, 53);
		contentPane.add(tittleColor);

		JLabel tittleShadow = new JLabel("DONUTLANDIA");
		tittleShadow.setForeground(new Color(0, 0, 0));
		tittleShadow.setFont(new Font("TT Berlinerins", Font.PLAIN, 52));
		tittleShadow.setBounds(152, 32, 238, 53);
		contentPane.add(tittleShadow);

		JLabel SubTitle = new JLabel("FAÇA SEU PRÓPRIO DONUT");
		SubTitle.setForeground(new Color(255, 153, 102));
		SubTitle.setBackground(new Color(255, 153, 102));
		SubTitle.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		SubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		SubTitle.setBounds(129, 76, 284, 38);
		contentPane.add(SubTitle);

		// etiquetas e paineis
		JPanel namePanel = new JPanel();
		namePanel.setBackground(new Color(255, 204, 102));
		namePanel.setBounds(31, 160, 473, 38);
		contentPane.add(namePanel);
		namePanel.setLayout(null);

		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setBounds(15, 10, 37, 17);
		nomeLabel.setFont(new Font("TT Berlinerins", Font.ITALIC, 16));
		nomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		namePanel.add(nomeLabel);

		JPanel coberturaPanel = new JPanel();
		coberturaPanel.setBackground(new Color(255, 204, 102));
		coberturaPanel.setBounds(31, 208, 473, 38);
		contentPane.add(coberturaPanel);
		coberturaPanel.setLayout(null);

		JLabel coberturaLabel = new JLabel("Cobertura");
		coberturaLabel.setBounds(15, 11, 72, 17);
		coberturaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		coberturaLabel.setFont(new Font("TT Berlinerins", Font.ITALIC, 16));
		coberturaPanel.add(coberturaLabel);

		JPanel recheioPanel = new JPanel();
		recheioPanel.setBackground(new Color(255, 204, 102));
		recheioPanel.setBounds(31, 256, 473, 38);
		contentPane.add(recheioPanel);
		recheioPanel.setLayout(null);

		JLabel recheioLabel = new JLabel("Recheio");
		recheioLabel.setBounds(15, 11, 56, 17);
		recheioLabel.setHorizontalAlignment(SwingConstants.LEFT);
		recheioLabel.setFont(new Font("TT Berlinerins", Font.ITALIC, 16));
		recheioPanel.add(recheioLabel);

		JPanel tamanhoPanel = new JPanel();
		tamanhoPanel.setBackground(new Color(255, 204, 102));
		tamanhoPanel.setBounds(31, 304, 473, 38);
		contentPane.add(tamanhoPanel);
		tamanhoPanel.setLayout(null);

		JLabel tamanhoLabel = new JLabel("Tamanho");
		tamanhoLabel.setBounds(15, 11, 64, 17);
		tamanhoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		tamanhoLabel.setFont(new Font("TT Berlinerins", Font.ITALIC, 16));
		tamanhoPanel.add(tamanhoLabel);

		// TextFields inputs

		nomeInput = new JTextField();
		nomeInput.setColumns(10);
		nomeInput.setBounds(367, 10, 96, 19);
		namePanel.add(nomeInput);

		coberturaInput = new JTextField();
		coberturaInput.setBounds(367, 10, 96, 19);
		coberturaInput.setColumns(10);
		coberturaPanel.add(coberturaInput);

		recheioInput = new JTextField();
		recheioInput.setBounds(367, 10, 96, 19);
		recheioInput.setColumns(10);
		recheioPanel.add(recheioInput);

		tamanhoInput = new JTextField();
		tamanhoInput.setBounds(367, 10, 96, 19);
		tamanhoInput.setColumns(10);
		tamanhoPanel.add(tamanhoInput);
		
		JPanel tamanhoPanel_1 = new JPanel();
		tamanhoPanel_1.setLayout(null);
		tamanhoPanel_1.setBackground(new Color(255, 204, 102));
		tamanhoPanel_1.setBounds(31, 353, 473, 38);
		contentPane.add(tamanhoPanel_1);
		
		JLabel precoLabel = new JLabel("preço");
		precoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		precoLabel.setFont(new Font("TT Berlinerins", Font.ITALIC, 16));
		precoLabel.setBounds(15, 11, 64, 17);
		tamanhoPanel_1.add(precoLabel);
		
		precoInput = new JTextField();
		precoInput.setColumns(10);
		precoInput.setBounds(367, 10, 96, 19);
		tamanhoPanel_1.add(precoInput);

	}
}