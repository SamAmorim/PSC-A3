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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("serial")
public class MainGUI extends JFrame implements ManagerInterface {

	private int cont = 0;
	private JPanel contentPane;
	private JTextField coberturaInput;
	private JTextField recheioInput;
	private JTextField tamanhoInput;
	private JTextField nomeInput;
	private JTextField precoInput;

	private JSpinner idSelector = new JSpinner();
	private JTable donutTable = new JTable();

	// importando o array de objetos
	Donut[] donut = new Donut[1];

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

	//metodos principais
	
	// metodo de inserir objeto um a um e atribuir id
	@Override
	public void insertObject() {

		// criando objeto
		donut[cont] = new Donut(nomeInput.getText().trim(), coberturaInput.getText().trim(),
				precoInput.getText().trim(), recheioInput.getText().trim(), tamanhoInput.getText().trim());

		// redimensionando um array
		Donut[] temp = new Donut[donut.length + 1];
		for (int i = 0; i < donut.length; i++) {
			temp[i] = donut[i];
		}
		donut = temp;

		// Atribuição de ID
		assignID();

		// Adicionar linha na tabela
		DefaultTableModel val = (DefaultTableModel) donutTable.getModel();
		val.addRow(new Object[] { donut[cont].getNome(), donut[cont].getCobertura(), donut[cont].getRecheio(),
				donut[cont].getTamanho(), donut[cont].getPreco() });

		// atualizando campos
		showValuesOfArray();
		clearInputs();

		// inserir sequencialmente
		cont++;

		// realocando valor do spinner
		idSelector.setModel(new SpinnerNumberModel(0, 0, donut.length - 1, 1));

	}
	// metodo de remover objeto por id
	@Override
	public void removeObject(int selectID) {

		if (selectID > 0) {

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

			// atualizando id

			assignID();

			// removendo linha
			((DefaultTableModel) donutTable.getModel()).removeRow(selectID - 1);

			// limpando inputs
			showValuesOfArray();
			cont--;
			clearInputs();

			// atualizr spinner
			idSelector.setModel(new SpinnerNumberModel(0, 0, donut.length - 1, 1));

		} else {
			JOptionPane.showMessageDialog(contentPane, "não existe objeto com id 0", getTitle(), selectID, null);
		}
	}
	// metodo de atualizar um objeto por id
	@Override
	public void updateObject(int selectID) {

		setInputOnArray(selectID - 1);
		drawUpdate(selectID - 1);
		showValuesOfArray();
		clearInputs();
		
		idSelector.setValue(0);
	}
	// retornar todas as caracteristicas de um objeto por id
	@Override
	public void returnObject(int selectID) {

		if (selectID != 0) {

			nomeInput.setText(donut[selectID - 1].getNome());
			coberturaInput.setText(donut[selectID - 1].getCobertura());
			recheioInput.setText(donut[selectID - 1].getRecheio());
			tamanhoInput.setText(donut[selectID - 1].getTamanho());
			precoInput.setText(donut[selectID - 1].getPreco());

		} else {
			clearInputs();
		}
	}


	
	
	private void showValuesOfArray() {
		System.out.println("---------------------------------------------------------");
		for (int i = 0; i < donut.length - 1; i++) {

			System.out.println("ID: " + donut[i].getId() + "\nNome: " + donut[i].getNome() + "\nCobertura: "
					+ donut[i].getCobertura() + "\nRecheio: " + donut[i].getRecheio() + "\nPreco: "
					+ donut[i].getPreco() + "\nTamanho do array: " + donut.length + "\n");
		}
		System.out.println("---------------------------------------------------------\n");

	}

	private void clearInputs() {
		nomeInput.setText("");
		coberturaInput.setText("");
		recheioInput.setText("");
		tamanhoInput.setText("");
		precoInput.setText("");
		nomeInput.requestFocus();
		donutTable.clearSelection();
	}

	public void assignID() {
		for (int i = 0; i < donut.length - 1; i++) {
			donut[i].setId(i+1);
		}

	}

	public void setInputOnArray(int id) {

		donut[id].setNome(nomeInput.getText().trim());
		donut[id].setCobertura(coberturaInput.getText().trim());
		donut[id].setRecheio(recheioInput.getText().trim());
		donut[id].setTamanho(tamanhoInput.getText().trim());
		donut[id].setPreco(precoInput.getText().trim());
	}

	public void drawUpdate(int id) {
		donutTable.setValueAt(donut[id].getNome(), donutTable.getSelectedRow(), 0);
		donutTable.setValueAt(donut[id].getCobertura(), donutTable.getSelectedRow(), 1);
		donutTable.setValueAt(donut[id].getRecheio(), donutTable.getSelectedRow(), 2);
		donutTable.setValueAt(donut[id].getTamanho(), donutTable.getSelectedRow(), 3);
		donutTable.setValueAt(donut[id].getPreco(), donutTable.getSelectedRow(), 4);
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() {

		// title, icon, window
		setTitle("Donutlandia");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/images/_iconDonut.png")));
		setBackground(new Color(204, 255, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1074, 508);
		contentPane = new JPanel();// painel principal

		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Atribuição dos botões de add
		JButton addButton = new JButton("Adicionar");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertObject();
			}
		});

		addButton.setBounds(31, 401, 104, 38);
		contentPane.add(addButton);

		// atribuição botão remove
		JButton RemoveButton = new JButton("Remover");
		RemoveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeObject((int) idSelector.getValue());
			}
		});

		RemoveButton.setBounds(412, 401, 92, 21);
		contentPane.add(RemoveButton);

		// Botão de atualizar
		JButton upButton = new JButton("Atualizar");
		// função botão atyalizar
		upButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateObject((int) idSelector.getValue());

			}
		});
		upButton.setActionCommand("Atualizar");
		upButton.setBounds(412, 418, 92, 21);
		contentPane.add(upButton);

		// Criação dos paineis e etiquetas

		// titulos
		JLabel tittleColor = new JLabel("DONUTLANDIA");
		tittleColor.setForeground(new Color(255, 102, 102));
		tittleColor.setFont(new Font("TT Berlinerins", Font.PLAIN, 52));
		tittleColor.setBounds(411, 35, 238, 53);
		contentPane.add(tittleColor);

		JLabel tittleShadow = new JLabel("DONUTLANDIA");
		tittleShadow.setForeground(new Color(0, 0, 0));
		tittleShadow.setFont(new Font("TT Berlinerins", Font.PLAIN, 52));
		tittleShadow.setBounds(411, 32, 238, 53);
		contentPane.add(tittleShadow);

		JLabel SubTitle = new JLabel("FAÇA SEU PRÓPRIO DONUT");
		SubTitle.setForeground(new Color(255, 153, 102));
		SubTitle.setBackground(new Color(255, 153, 102));
		SubTitle.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		SubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		SubTitle.setBounds(388, 76, 284, 38);
		contentPane.add(SubTitle);

		// etiquetas e paineis
		JPanel namePanel = new JPanel();
		namePanel.setBackground(new Color(255, 204, 102));
		namePanel.setBounds(31, 160, 473, 38);
		contentPane.add(namePanel);
		namePanel.setLayout(null);

		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setBounds(15, 10, 85, 17);
		nomeLabel.setFont(new Font("TT Berlinerins", Font.ITALIC, 16));
		nomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		namePanel.add(nomeLabel);

		JPanel coberturaPanel = new JPanel();
		coberturaPanel.setBackground(new Color(255, 204, 102));
		coberturaPanel.setBounds(31, 208, 473, 38);
		contentPane.add(coberturaPanel);
		coberturaPanel.setLayout(null);

		JLabel coberturaLabel = new JLabel("Cobertura");
		coberturaLabel.setBounds(15, 11, 121, 17);
		coberturaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		coberturaLabel.setFont(new Font("TT Berlinerins", Font.ITALIC, 16));
		coberturaPanel.add(coberturaLabel);

		JPanel recheioPanel = new JPanel();
		recheioPanel.setBackground(new Color(255, 204, 102));
		recheioPanel.setBounds(31, 256, 473, 38);
		contentPane.add(recheioPanel);
		recheioPanel.setLayout(null);

		JLabel recheioLabel = new JLabel("Recheio");
		recheioLabel.setBounds(15, 11, 104, 17);
		recheioLabel.setHorizontalAlignment(SwingConstants.LEFT);
		recheioLabel.setFont(new Font("TT Berlinerins", Font.ITALIC, 16));
		recheioPanel.add(recheioLabel);

		JPanel tamanhoPanel = new JPanel();
		tamanhoPanel.setBackground(new Color(255, 204, 102));
		tamanhoPanel.setBounds(31, 304, 473, 38);
		contentPane.add(tamanhoPanel);
		tamanhoPanel.setLayout(null);

		JLabel tamanhoLabel = new JLabel("Tamanho");
		tamanhoLabel.setBounds(15, 11, 96, 17);
		tamanhoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		tamanhoLabel.setFont(new Font("TT Berlinerins", Font.ITALIC, 16));
		tamanhoPanel.add(tamanhoLabel);

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

		// TextFields inputs

		nomeInput = new JTextField();
		nomeInput.setToolTipText("Digite o nome do seu donut");
		nomeInput.setColumns(10);
		nomeInput.setBounds(367, 10, 96, 19);
		namePanel.add(nomeInput);

		coberturaInput = new JTextField();
		coberturaInput.setToolTipText("Digite a cobertura do seu donut");
		coberturaInput.setBounds(367, 10, 96, 19);
		coberturaInput.setColumns(10);
		coberturaPanel.add(coberturaInput);

		recheioInput = new JTextField();
		recheioInput.setToolTipText("Digite qual o recheio do seu donut");
		recheioInput.setBounds(367, 10, 96, 19);
		recheioInput.setColumns(10);
		recheioPanel.add(recheioInput);

		tamanhoInput = new JTextField();
		tamanhoInput.setToolTipText("Digite o tamanho do seu donut");
		tamanhoInput.setBounds(367, 10, 96, 19);
		tamanhoInput.setColumns(10);
		tamanhoPanel.add(tamanhoInput);

		precoInput = new JTextField();
		precoInput.setToolTipText("Digite o preço do seu donut");
		precoInput.setColumns(10);
		precoInput.setBounds(367, 10, 96, 19);
		pecoPanel.add(precoInput);
		idSelector.setToolTipText("Entre com o ID");

		// metodo que vai chamar o atualizar
		idSelector.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				if ((int) idSelector.getValue() > 0) {
					returnObject((int) idSelector.getValue());
					donutTable.setRowSelectionInterval((int) idSelector.getValue() - 1,
							(int) idSelector.getValue() - 1);
				} else {
					donutTable.clearSelection();
				}

			}

		});

		idSelector.setModel(new SpinnerNumberModel(0, 0, 0, 1));
		idSelector.setBounds(378, 403, 35, 35);
		contentPane.add(idSelector);

		JPanel ID = new JPanel();
		ID.setLayout(null);
		ID.setBackground(new Color(255, 204, 102));
		ID.setBounds(335, 401, 170, 38);
		contentPane.add(ID);

		JLabel idLabel = new JLabel("ID:");
		idLabel.setHorizontalAlignment(SwingConstants.LEFT);
		idLabel.setFont(new Font("TT Berlinerins", Font.ITALIC, 16));
		idLabel.setBounds(4, 10, 24, 18);
		ID.add(idLabel);

		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(null);
		tablePanel.setBackground(new Color(255, 204, 102));
		tablePanel.setBounds(523, 162, 505, 229);
		contentPane.add(tablePanel);
		donutTable.setEnabled(false);
		donutTable.setBounds(0, 0, 505, 229);
		tablePanel.add(donutTable);
		donutTable.setShowGrid(false);
		donutTable.setOpaque(false);
		donutTable.setVerifyInputWhenFocusTarget(false);
		donutTable.setName("donutTable");

		donutTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Cobertura", "Recheio", "Tamanho", "Preco" }));

	}
}