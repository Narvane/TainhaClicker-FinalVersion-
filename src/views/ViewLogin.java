package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jogo.Mercado;
import jogo.Mundo;
import jogo.MundoDAO;
import jogo.Pescador;
import jogo.PescadorDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passField;
	private JTextField cadTextField;
	private JPasswordField cadPassField;
	private JPasswordField cfCadPassField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin frame = new ViewLogin();
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
	public ViewLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if("Windows".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					
					break;
				}
			}
		} catch (Exception e) {
			
		}
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(365, 0, 312, 369);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Login", null, panel, null);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(102, 112, 109, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		passField = new JPasswordField();
		passField.setBounds(102, 170, 109, 20);
		panel.add(passField);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pescador Pescador = new Pescador();
				Mercado Mercado = new Mercado();
				Mundo Mundo = new Mundo();
				
				PescadorDAO pdao = new PescadorDAO();
				
				
				Pescador.setNome(textField.getText());
				Pescador.setSenha(passField.getText());
				
				
				pdao.LogarPescador(Pescador, Mercado, Mundo);
				if(pdao.Acesso) {
					ViewGame VG = new ViewGame(Pescador, Mercado, Mundo);
					VG.setVisible(true);
					setVisible(false);
					System.out.println(Pescador.getPraiaAtual().getNome());
				}
			}
		});
		btnLogar.setBounds(99, 221, 112, 42);
		panel.add(btnLogar);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setBounds(102, 87, 109, 14);
		panel.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(102, 145, 109, 14);
		panel.add(lblSenha);
	
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Cadastro", null, panel_1, null);
		panel_1.setLayout(null);
		
		cadTextField = new JTextField();
		cadTextField.setBounds(41, 92, 158, 20);
		panel_1.add(cadTextField);
		cadTextField.setColumns(10);
		
		cadPassField = new JPasswordField();
		cadPassField.setBounds(41, 148, 158, 20);
		panel_1.add(cadPassField);
		
		cfCadPassField = new JPasswordField();
		cfCadPassField.setBounds(40, 196, 159, 20);
		panel_1.add(cfCadPassField);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mundo Jogo = new Mundo();
				Jogo.Pescador.setNome(cadTextField.getText());
				Jogo.Pescador.setSenha(cadPassField.getText());
				if(Arrays.equals(cadPassField.getPassword(), cfCadPassField.getPassword())) {
					Pescador p = new Pescador();
					p.setNome(cadTextField.getText());
					p.setSenha(cadPassField.getText());
					
					PescadorDAO pdao = new PescadorDAO();
					pdao.CadastrarPescador(p);
				}else {
					JOptionPane.showMessageDialog(contentPane,"Senhas não coincidem!");
				}
			}
		});
		btnCadastrar.setBounds(41, 237, 89, 38);
		panel_1.add(btnCadastrar);
		
		JLabel lblCadUsuario = new JLabel("Informe um nome de usu\u00E1rio");
		lblCadUsuario.setBounds(42, 67, 158, 14);
		panel_1.add(lblCadUsuario);
		
		JLabel lblCadSenha = new JLabel("Informe uma senha");
		lblCadSenha.setBounds(41, 123, 158, 14);
		panel_1.add(lblCadSenha);
		
		JLabel lblCfCadSenha = new JLabel("Confirme sua senha");
		lblCfCadSenha.setBounds(41, 179, 158, 14);
		panel_1.add(lblCfCadSenha);
		
		JLabel ImagemLogin = new JLabel("");
		ImagemLogin.setBounds(0, 0, 366, 369);
		contentPane.add(ImagemLogin);
	}
}
