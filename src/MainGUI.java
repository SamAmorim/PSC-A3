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
		for (int i = 0; i < donut.length - 1; i++) {
			donut[i].setId(i);
		}

		// Adicionar linha na tabela
		DefaultTableModel val = (DefaultTableModel) donutTable.getModel();
		val.addRow(new Object[] { donut[cont].getNome(), donut[cont].getCobertura(), donut[cont].getRecheio(),
				donut[cont].getTamanho(), donut[cont].getPreco() });

		// atualizando campos
		clearInputs();

		// inserir sequencialmente
		cont += 1;

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
			for (int i = 0; i < donut.length - 1; i++) {
				donut[i].setId(i);
			}

			// removendo linha
			((DefaultTableModel) donutTable.getModel()).removeRow(selectID - 1);

			// limpando inputs
			clearInputs();

			// atribuição sequencial
			cont -= 1;

			// atualizr spinner
			idSelector.setModel(new SpinnerNumberModel(0, 0, donut.length - 1, 1));
		} else {
			JOptionPane.showMessageDialog(contentPane, "não existe objeto com id 0", getTitle(), selectID, null);
		}
	}

	// metodo de atualizar um objeto por id
	@Override
	public void updateObject(int selectID) {

			
				donut[selectID - 1].setNome(nomeInput.getText().trim());
				donut[selectID - 1].setCobertura(coberturaInput.getText().trim());
				donut[selectID - 1].setRecheio(recheioInput.getText().trim());
				donut[selectID - 1].setTamanho(tamanhoInput.getText().trim());
				donut[selectID - 1].setPreco(precoInput.getText().trim());

				donutTable.setValueAt(donut[selectID - 1].getNome(), donutTable.getSelectedRow(), 0);
				donutTable.setValueAt(donut[selectID - 1].getCobertura(), donutTable.getSelectedRow(), 1);
				donutTable.setValueAt(donut[selectID - 1].getRecheio(), donutTable.getSelectedRow(), 2);
				donutTable.setValueAt(donut[selectID - 1].getTamanho(), donutTable.getSelectedRow(), 3);
				donutTable.setValueAt(donut[selectID - 1].getPreco(), donutTable.getSelectedRow(), 4);
		
				clearInputs();
	}

	// retornar todas as caracteristicas de um objeto por id
	@Override
	public void returnObject(int selectID) {

		int arrayPos = selectID - 1;

		if (selectID != 0) {

			nomeInput.setText(donut[arrayPos].getNome());
			coberturaInput.setText(donut[arrayPos].getCobertura());
			coberturaInput.setText(donut[arrayPos].getCobertura());
			recheioInput.setText(donut[arrayPos].getRecheio());
			tamanhoInput.setText(donut[arrayPos].getTamanho());
			precoInput.setText(donut[arrayPos].getPreco());

		} else {
			clearInputs();
		}
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

		precoInput = new JTextField();
		precoInput.setColumns(10);
		precoInput.setBounds(367, 10, 96, 19);
		pecoPanel.add(precoInput);

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
		donutTable.setShowGrid(false);
		donutTable.setOpaque(false);
		donutTable.setVerifyInputWhenFocusTarget(false);
		donutTable.setName("donutTable");

		donutTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Cobertura", "Recheio", "Tamanho", "Preco" }));
		donutTable.setBounds(522, 160, 460, 229);
		contentPane.add(donutTable);

	}
}