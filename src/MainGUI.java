import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DonutManagemant.Donut;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainGUI extends JFrame implements ManagerInterface {

	private JPanel contentPane;
	private JTextField coberturaInput;
	private JTextField recheioInput;
	private JTextField tamanhoInput;
	private JTextField nomeInput;
	int cont = 0;
	static JSpinner idSelector = new JSpinner();
	// importando o array de objetos
	Donut[] donut = new Donut[2];

	private JTextField precoInput;
	private JTable table;
	private JTextField textField;

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
		donut[cont] = new Donut(nomeInput.getText(), coberturaInput.getText(), precoInput.getText(),
				recheioInput.getText(), tamanhoInput.getText());

		// redimensionando um array
		Donut[] temp = new Donut[donut.length + 1];
		for (int i = 0; i < donut.length; i++) {
			temp[i] = donut[i];
		}
		donut = temp;

		// Atribuição de ID
		for (int i = 0; i < donut.length - 1; i++) {
			donut[cont].setId(i + 1);
		}

		// inserindo sequencialmente
		cont += 1;

		// realocando valor do spinner
		idSelector.setModel(new SpinnerNumberModel(0, 0, donut.length - 1, 1));
	}

	// metodo de remover objeto por id

	@Override
	public void removeObject(int selectID) {

		Donut[] tempRemove = new Donut[donut.length - 1];

		// removendo valor e redimensionando array
		int arrayPos = selectID - 1;

		for (int i = 0; i < arrayPos; i++) {
			tempRemove[i] = donut[i];
		}
		for (int i = arrayPos + 1; i < donut.length; i++) {
			tempRemove[i - 1] = donut[i];
		}

		donut = tempRemove;

		// atribuindo id
		for (int i = 0; i < donut.length - 1; i++) {
			donut[i].setId(i + 1);
		}

		// atribuição sequencial
		cont -= 1;

		// atualizr spinner
		idSelector.setModel(new SpinnerNumberModel(0, 0, donut.length - 1, 1));

	}

	// metodo de atualizar um objeto por id
	@Override
	public void updateObject() {

	}

	// retornar todas as caracteristicas de um objeto por id
	@Override
	public void returnObject() {

	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public MainGUI() {
		// titulo, icon, janela
		setTitle("Donutlandia");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/images/_iconDonut.png")));
		setBackground(new Color(204, 255, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 725);
		contentPane = new JPanel();// painel principal

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
				removeObject((int) idSelector.getValue());
			}
		});
		RemoveButton.setBounds(431, 401, 73, 21);
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

		JPanel pecoPanel = new JPanel();
		pecoPanel.setLayout(null);
		pecoPanel.setBackground(new Color(255, 204, 102));
		pecoPanel.setBounds(31, 353, 473, 38);
		contentPane.add(pecoPanel);

		JLabel precoLabel = new JLabel("preço");
		precoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		precoLabel.setFont(new Font("TT Berlinerins", Font.ITALIC, 16));
		precoLabel.setBounds(15, 11, 64, 17);
		pecoPanel.add(precoLabel);

		precoInput = new JTextField();
		precoInput.setColumns(10);
		precoInput.setBounds(367, 10, 96, 19);
		pecoPanel.add(precoInput);
		idSelector.setToolTipText("Selecione ID");

		idSelector.setModel(new SpinnerNumberModel(0, 0, 0, 1));
		idSelector.setBounds(399, 403, 35, 35);
		contentPane.add(idSelector);

		table = new JTable();
		table.setEnabled(false);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setToolTipText("");

		table.setModel(new DefaultTableModel(new String[][] { { null, null, null, null, null, null }, },
				new String[] { "ID", "Nome", "Cobertura", "Recheio", "Tamanho", "Pre\u00E7o" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(36, 446, 463, 16);
		contentPane.add(table);
		
		JPanel pecoPanel_1 = new JPanel();
		pecoPanel_1.setLayout(null);
		pecoPanel_1.setBackground(new Color(255, 204, 102));
		pecoPanel_1.setBounds(200, 401, 131, 38);
		contentPane.add(pecoPanel_1);
		
		JLabel precoLabel_1 = new JLabel("preço");
		precoLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		precoLabel_1.setFont(new Font("TT Berlinerins", Font.ITALIC, 16));
		precoLabel_1.setBounds(15, 11, 64, 17);
		pecoPanel_1.add(precoLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(367, 10, 96, 19);
		pecoPanel_1.add(textField);

	}
}