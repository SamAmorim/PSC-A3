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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DonutManagemant.Donut;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField coberturaInput;
	private JTextField recheioInput;
	private JTextField tamanhoInput;
	private JTextField nomeInput;
	private JTable JTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public main() {
		setTitle("Donutlandia");
		setIconImage(Toolkit.getDefaultToolkit().getImage(main.class.getResource("/images/_iconDonut.png")));
		setBackground(new Color(204, 255, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 668);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Donut donut = new Donut();
		//Atribuição dos botões de add 
		JButton addButton = new JButton("Adicionar");
		//metodo de clicar no botao
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
	
		addButton.setBounds(31, 357, 104, 38);
		contentPane.add(addButton);
		
		//atribuição botão remove
		JButton RemoveButton = new JButton("Remover");
		//metodo de clicar no botao romove
		RemoveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		RemoveButton.setBounds(400, 357, 104, 38);
		contentPane.add(RemoveButton);
		
		
		//Criação dos paineis e etiquetas
		
		//titulos
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
		
		//etiquetas e paineis
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
		tamanhoPanel.setBounds(31, 309, 473, 38);
		contentPane.add(tamanhoPanel);
		tamanhoPanel.setLayout(null);
		
		JLabel tamanhoLabel = new JLabel("Tamanho");
		tamanhoLabel.setBounds(15, 11, 64, 17);
		tamanhoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		tamanhoLabel.setFont(new Font("TT Berlinerins", Font.ITALIC, 16));
		tamanhoPanel.add(tamanhoLabel);
		
		
		//TextFields inputs
		
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
		
		
		//teste tabela
		JTable = new JTable();
		JTable.setEnabled(false);
		JTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null , null, null, null},
				{null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Tamaho", "Cobertura", "Recheio", "Tamanho"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		JTable.setBounds(31, 439, 473, 160);
		contentPane.add(JTable);
	}
}
