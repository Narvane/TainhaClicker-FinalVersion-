package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import jogo.Mundo;
import jogo.Pescador;
import jogo.PescadorDAO;
import jogo.Mercado;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class ViewGame extends JFrame{

	private JPanel contentPane;

	private int x= 0;
	private int y = 0;
	private int z = 0;		
	
	JLabel lblArremesse = new JLabel("Arremesse!");
	//
	private JPanel Praias;
	private JPanel Hud;
	private JPanel Mercado;
	private JPanel Pescaria;
	private JPanel Sambura;
	private JPanel Ranking;
	private JPanel Home;
	private Pescador Pescador;
	private Mercado mercado;
	private Mundo mundo;
	//PescadorDAO pescDAO = new PescadorDAO();
	
	//
	private JLabel lblPescHud;
	private JLabel lblDinheiroHub;
	private JLabel lblScoreHud;
	private JLabel lblXpHub;
	private JLabel lblSamburaHud;
	private JLabel lblPraiaAtual;
	private JLabel lblPraiaEscolhida;
	private JLabel lblImagem;
	private JLabel lblPeixePPraia;
	//
	@SuppressWarnings("unused")
	private DefaultTableModel tableModel;
	private JButton btnPegarPeixe;
	private DefaultTableModel dtm;
	//======
	private JLabel lblVara1;
	private JButton btnVara1; 
	private JButton btnVara2;
	private JButton btnVara3;
	private JButton btnVara4;
	private JButton btnVara5;
	private JLabel lblVara2;
	private JLabel lblVara3;
	private JLabel lblVara4;
	private JLabel lblVara5;
	//=========
	private JButton btnMolinete1;
	private JButton btnMolinete2;
	private JButton btnMolinete3;
	private JButton btnMolinete4; 
	private JButton btnMolinete5; 
	private JLabel lblMolinete1; 
	private JLabel lblMolinete2;
	private JLabel lblMolinete3; 
	private JLabel lblMolinete4; 
	private JLabel lblMolinete5; 
	//=========
	private JButton btnIsca1;
	private JButton btnIsca2;
	private JButton btnIsca3;
	private JButton btnIsca4;
	private JButton btnIsca5;
	private JLabel lblIsca1;
	private JLabel lblIsca2;
	private JLabel lblIsca3;
	private JLabel lblIsca4;
	private JLabel lblIsca5;
	//=========
	private JLabel lblAprimorarS;
	private JButton btnAprimorarS;
	private JLabel ImagemPeixe;
	private JButton btnFisgar;
	private JButton btnJogarNaAgua;
	private JLabel lblPeixePescado;
	private JCheckBox chckbxComoPuxar;
	private JLabel lblTutorial;
	private JLabel lblLblfundo;
	private JPanel MiniSambura;
	private JTable table;
	private JScrollPane scrollPane;
	@SuppressWarnings("rawtypes")
	private JList list;
	private JLabel lblMiniVara1;
	private JLabel lblMiniVara2;
	private JLabel lblMiniVara3;
	private JLabel lblMiniVara4;
	private JLabel lblMiniVara5;
	private JLabel lblMolMini1;
	private JLabel lblMolMini2;
	private JLabel lblMolMini3;
	private JLabel lblMolMini4; 
	private JLabel lblMolMini5;
	private JLabel lblIscMini1;
	private JLabel lblIscMini2;
	private JLabel lblIscMini3;
	private JLabel lblIscMini14; 
	private JLabel lblIscMini5;
	private JLabel lblMiniMol;
	private JLabel lblMiniIsca;
	private JLabel lblMiniVara;
	private JLabel label_2;
	private JLabel label;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewGame frame = new ViewGame(null, null, null);
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
	
	public ViewGame(Pescador P, Mercado M, Mundo MN) {
		this.Pescador = P;
		this.mercado = M;
		this.mundo = MN;
		
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing (WindowEvent e)
            {
                int resposta = JOptionPane.showConfirmDialog(null,"Deseja salvar o progreso?","Finalizar",JOptionPane.YES_NO_OPTION);
                 
                //sim = 0, nao = 1
                if (resposta == 0)
                {
                	try {
						PescadorDAO pdao = new PescadorDAO();
						pdao.SalvarEquips(Pescador);
						pdao.SalvarPeixes(Pescador);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    System.exit(0);
                }
                 
            }
        });
	
		setResizable(false);
		setBounds(100, 100, 622, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		mercado.Cliente = Pescador;
		mundo.Pescador = Pescador;
		
		Sambura = new JPanel();
		Sambura.setBackground(new Color(153, 153, 51));
		Sambura.setVisible(false);
		
		Mercado = new JPanel();
		Mercado.setBackground(new Color(153, 153, 51));
		Mercado.setForeground(new Color(255, 255, 255));
		Mercado.setVisible(false);
		
		Pescaria = new JPanel();
		Pescaria.setVisible(false);
		
		Ranking = new JPanel();
		Ranking.setBackground(new Color(153, 153, 51));
		Ranking.setVisible(false);
		
		
		
		System.out.println(mundo.PraiasDoJogo);
		
		Home = new JPanel();
		Home.setVisible(true);
		
		Praias = new JPanel();
		Praias.setBackground(new Color(189, 183, 107));
		Praias.setVisible(false);
		Praias.setEnabled(false);
		
		
		Praias.setBounds(0, 0, 606, 429);
		contentPane.add(Praias);
		Praias.setLayout(null);
		
		JButton btnPraia2 = new JButton(mundo.GetPraiasDoJogo(1).getNome());
		btnPraia2.setForeground(new Color(51, 51, 0));
		btnPraia2.setBackground(new Color(153, 153, 51));
		btnPraia2.setFont(new Font("Super Mario Bros.", Font.PLAIN, 16));
		btnPraia2.setVerticalAlignment(SwingConstants.TOP);
		btnPraia2.setHorizontalAlignment(SwingConstants.LEFT);
		btnPraia2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pescador.EscolherPraia(mundo.GetPraiasDoJogo(1));		
				Atualizar();
				}
		});
		
		JButton btnPraia5 = new JButton(mundo.GetPraiasDoJogo(4).getNome());
		btnPraia5.setForeground(new Color(51, 51, 0));
		btnPraia5.setBackground(new Color(153, 153, 51));
		btnPraia5.setFont(new Font("Super Mario Bros.", Font.PLAIN, 16));
		btnPraia5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pescador.EscolherPraia(mundo.GetPraiasDoJogo(4));	
				Atualizar();
				}
		});
		btnPraia5.setHorizontalAlignment(SwingConstants.LEFT);
		btnPraia5.setVerticalAlignment(SwingConstants.TOP);
		btnPraia5.setBounds(24, 316, 275, 59);
		Praias.add(btnPraia5);
		
		JButton btnPraia4 = new JButton(mundo.GetPraiasDoJogo(3).getNome());
		btnPraia4.setForeground(new Color(51, 51, 0));
		btnPraia4.setBackground(new Color(153, 153, 51));
		btnPraia4.setFont(new Font("Super Mario Bros.", Font.PLAIN, 16));
		btnPraia4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pescador.EscolherPraia(mundo.GetPraiasDoJogo(3));		
				Atualizar();
				}
		});
		btnPraia4.setVerticalAlignment(SwingConstants.TOP);
		btnPraia4.setHorizontalAlignment(SwingConstants.LEFT);
		btnPraia4.setBounds(24, 253, 275, 59);
		Praias.add(btnPraia4);
		
		JButton btnPraia3 = new JButton(mundo.GetPraiasDoJogo(2).getNome());
		btnPraia3.setForeground(new Color(51, 51, 0));
		btnPraia3.setBackground(new Color(153, 153, 51));
		btnPraia3.setFont(new Font("Super Mario Bros.", Font.PLAIN, 16));
		btnPraia3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pescador.EscolherPraia(mundo.GetPraiasDoJogo(2));	
				Atualizar();
				}
		});
		btnPraia3.setHorizontalAlignment(SwingConstants.LEFT);
		btnPraia3.setVerticalAlignment(SwingConstants.TOP);
		btnPraia3.setBounds(24, 190, 275, 59);
		Praias.add(btnPraia3);
		btnPraia2.setBounds(24, 127, 275, 59);
		Praias.add(btnPraia2);
		
		JButton btnPraia1 = new JButton(mundo.GetPraiasDoJogo(0).getNome());
		btnPraia1.setForeground(new Color(51, 51, 0));
		btnPraia1.setBackground(new Color(204, 153, 51));
		btnPraia1.setFont(new Font("Super Mario Bros.", Font.PLAIN, 16));
		btnPraia1.setHorizontalAlignment(SwingConstants.LEFT);
		btnPraia1.setVerticalAlignment(SwingConstants.TOP);
		btnPraia1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pescador.setPraiaAtual(mundo.GetPraiasDoJogo(0));
				Atualizar();
			}
		});
		btnPraia1.setBounds(24, 64, 275, 59);
		Praias.add(btnPraia1);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(new Color(51, 51, 0));
		btnNewButton.setFont(new Font("Super Mario Bros.", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(250, 250, 210));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setOpaque(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbrirHome();
			}
		});
		btnNewButton.setBounds(24, 386, 111, 26);
		Praias.add(btnNewButton);
		
		lblImagem = new JLabel("");
		lblImagem.setBorder(new LineBorder(new Color(51, 51, 0)));
		lblImagem.setIcon(mundo.Pescador.getPraiaAtual().getImagem());
		//lblImagem.setIcon(Jogo.Pescador.getPraiaAtual().getImagem().openStream());
		lblImagem.setBounds(317, 64, 253, 186);
		Praias.add(lblImagem);
		
		JButton btnPescar_1 = new JButton("Pescar");
		btnPescar_1.setFont(new Font("Chlorinap", Font.PLAIN, 24));
		btnPescar_1.setBackground(new Color(51, 51, 0));
		btnPescar_1.setForeground(new Color(51, 51, 0));
		btnPescar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Atualizar();
				AbrirPescaria();
			}
		});
		btnPescar_1.setBounds(317, 316, 253, 59);
		Praias.add(btnPescar_1);
		
		lblPraiaEscolhida = new JLabel(mundo.Pescador.getPraiaAtual().getNome());
		lblPraiaEscolhida.setForeground(new Color(51, 51, 0));
		lblPraiaEscolhida.setFont(new Font("Chlorinap", Font.PLAIN, 24));
		lblPraiaEscolhida.setBounds(317, 253, 253, 39);
		Praias.add(lblPraiaEscolhida);
		Praias.setEnabled(false);
		
		JLabel lblPraias = new JLabel("Praias");
		lblPraias.setForeground(new Color(255, 255, 255));
		lblPraias.setFont(new Font("Chlorinap", Font.BOLD, 28));
		lblPraias.setBounds(24, 12, 134, 39);
		Praias.add(lblPraias);
		
		lblPeixePPraia = new JLabel("Peixes");
		lblPeixePPraia.setForeground(new Color(153, 153, 0));
		lblPeixePPraia.setBounds(317, 296, 253, 16);
		Praias.add(lblPeixePPraia);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ViewGame.class.getResource("/Imagens/praia-icon.png")));
		label_2.setBounds(143, -28, 616, 489);
		Praias.add(label_2);
		Home.setBackground(new Color(189, 183, 107));
		Home.setForeground(new Color(255, 255, 255));
		Home.setBounds(0, 0, 606, 429);
		contentPane.add(Home);
		Home.setLayout(null);
		
			
			JButton btnPescar = new JButton("Pescar");
			btnPescar.setForeground(Color.WHITE);
			btnPescar.setFont(new Font("Super Mario Bros.", Font.PLAIN, 18));
			btnPescar.setHorizontalAlignment(SwingConstants.LEFT);
			btnPescar.setBorderPainted(false);
			btnPescar.setOpaque(false);
			btnPescar.setBackground(new Color(135, 206, 250));
			btnPescar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AbrirPraias();
					Atualizar();
				}
			});
			btnPescar.setBounds(12, 158, 207, 28);
			Home.add(btnPescar);
			
			JButton btnSambura = new JButton("Sambur\u00E1");
			btnSambura.setHorizontalAlignment(SwingConstants.LEFT);
			btnSambura.setForeground(new Color(255, 255, 255));
			btnSambura.setFont(new Font("Super Mario Bros.", Font.PLAIN, 18));
			btnSambura.setBackground(new Color(173, 216, 230));
			btnSambura.setOpaque(false);
			btnSambura.setBorderPainted(false);
			btnSambura.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Atualizar();
					AbrirSambura();
					
				}
			});
			btnSambura.setBounds(12, 199, 207, 28);
			Home.add(btnSambura);
			
			JButton btnMercado = new JButton("Mercado");
			btnMercado.setForeground(new Color(255, 255, 255));
			btnMercado.setFont(new Font("Super Mario Bros.", Font.PLAIN, 18));
			btnMercado.setBorderPainted(false);
			btnMercado.setHorizontalAlignment(SwingConstants.LEFT);
			btnMercado.setBackground(new Color(173, 216, 230));
			btnMercado.setOpaque(false);
			btnMercado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AbrirMercado();
				}
			});
			btnMercado.setBounds(12, 237, 207, 28);
			Home.add(btnMercado);
			
			JLabel lblTainhaClicker = new JLabel("Tainha Clicker");
			lblTainhaClicker.setForeground(new Color(0, 0, 0));
			lblTainhaClicker.setFont(new Font("Chlorinap", Font.BOLD, 31));
			lblTainhaClicker.setBounds(12, 67, 299, 65);
			Home.add(lblTainhaClicker);
			
			JButton btnRanking = new JButton("Ranking");
			btnRanking.setForeground(new Color(255, 255, 255));
			btnRanking.setFont(new Font("Super Mario Bros.", Font.PLAIN, 18));
			btnRanking.setBorderPainted(false);
			btnRanking.setHorizontalAlignment(SwingConstants.LEFT);
			btnRanking.setBackground(new Color(250, 250, 210));
			btnRanking.setOpaque(false);
			btnRanking.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AbrirRanking();
				}
			});
			btnRanking.setBounds(12, 278, 207, 28);
			Home.add(btnRanking);
			
			JLabel lblL = new JLabel("l");
			lblL.setIcon(new ImageIcon(ViewGame.class.getResource("/Imagens/CoolClips_vc019674.png")));
			lblL.setBounds(128, 60, 561, 416);
			Home.add(lblL);
		Ranking.setBounds(0, 0, 606, 429);
		contentPane.add(Ranking);
		Ranking.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(102, 51, 0));
		btnVoltar.setFont(new Font("Super Mario Bros.", Font.BOLD, 18));
		btnVoltar.setOpaque(false);
		btnVoltar.setBackground(new Color(255, 255, 204));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbrirHome();
			}
		});
		btnVoltar.setBounds(12, 394, 117, 26);
		Ranking.add(btnVoltar);
		
		JLabel lblRanking = new JLabel("Ranking");
		lblRanking.setForeground(Color.WHITE);
		lblRanking.setFont(new Font("Super Mario Bros.", Font.PLAIN, 26));
		lblRanking.setBounds(12, 79, 149, 34);
		Ranking.add(lblRanking);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 137, 571, 248);
		Ranking.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Pescador", "Score"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		Hud = new JPanel();
		Hud.setOpaque(false);
		Hud.setBackground(new Color(204, 153, 51));
		Hud.setVisible(false);
		Hud.setBounds(12, 12, 582, 59);
		contentPane.add(Hud);
		Hud.setLayout(null);
		
		lblPescHud = new JLabel("Pescador");
		lblPescHud.setForeground(new Color(102, 51, 0));
		lblPescHud.setBackground(new Color(255, 255, 255));
		lblPescHud.setFont(new Font("Lucida Sans", Font.BOLD, 16));
		lblPescHud.setBounds(12, 12, 181, 16);
		Hud.add(lblPescHud);
		
		lblDinheiroHub = new JLabel("Dinheiro");
		lblDinheiroHub.setForeground(new Color(102, 51, 0));
		lblDinheiroHub.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		lblDinheiroHub.setBounds(22, 31, 171, 16);
		Hud.add(lblDinheiroHub);
		
		lblScoreHud = new JLabel("Score");
		lblScoreHud.setForeground(new Color(102, 51, 0));
		lblScoreHud.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		lblScoreHud.setBounds(438, 12, 132, 16);
		Hud.add(lblScoreHud);
		
		lblXpHub = new JLabel("Xp");
		lblXpHub.setFont(new Font("Lucida Sans", Font.PLAIN, 18));
		lblXpHub.setForeground(new Color(102, 51, 0));
		lblXpHub.setBounds(230, 12, 122, 35);
		Hud.add(lblXpHub);
		
		lblSamburaHud = new JLabel("Sambur\u00E1");
		lblSamburaHud.setForeground(new Color(102, 51, 0));
		lblSamburaHud.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		lblSamburaHud.setBounds(448, 31, 122, 16);
		Hud.add(lblSamburaHud);
		
		MiniSambura = new JPanel();
		MiniSambura.setBackground(new Color(153, 153, 51));
		MiniSambura.setVisible(false);
		MiniSambura.setBounds(12, 137, 199, 231);
		contentPane.add(MiniSambura);
		MiniSambura.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 12, 175, 180);
		MiniSambura.add(scrollPane_2);
		
		list = new JList();
		scrollPane_2.setViewportView(list);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setFont(new Font("Super Mario Bros.", Font.PLAIN, 18));
		btnFechar.setForeground(new Color(102, 51, 0));
		btnFechar.setOpaque(false);
		btnFechar.setBackground(new Color(102, 51, 0));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MiniSambura.setVisible(false);
			}
		});
		btnFechar.setBounds(42, 193, 113, 26);
		MiniSambura.add(btnFechar);
		
		
		System.out.println("========="+mundo.PraiasDoJogo.get(1).GetPeixe(0).getNome());
		System.out.println("========="+mundo.PraiasDoJogo.get(1).GetPeixe(1).getNome());
		System.out.println("========="+mundo.PraiasDoJogo.get(1).GetPeixe(2).getNome());

		Pescaria.setBounds(0, 0, 606, 429);
		contentPane.add(Pescaria);
		Pescaria.setLayout(null);
		
		JButton btnArremessar = new JButton("Arremessar");
		btnArremessar.setForeground(new Color(102, 51, 0));
		btnArremessar.setFont(new Font("Super Mario Bros.", Font.PLAIN, 16));
		btnArremessar.setBackground(new Color(153, 153, 51));
		btnArremessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					new Thread(new Runnable() {
						   public void run() {
						    try {
						    btnArremessar.setEnabled(false);
						    
						   
						    lblArremesse.setText("Arremessando...");
						     Thread.sleep(Pescador.getVara().getTempoDeArremesso()); //vara 
						     lblArremesse.setText("Esperando...");
						     Thread.sleep(Pescador.getIsca().getTempoDeEspera());
						     lblArremesse.setText("Fisque!");
						 	if(chckbxComoPuxar.isSelected()) {
								lblTutorial.setText("<html>Para puxar, clique nas teclas Cima e Baixo do seu teclado alternadamente até o peixer vir.<html>");
							}
							    btnFisgar.setEnabled(true);
							    Pescador.puxar();
							    
						    } catch (InterruptedException e) {
						     e.printStackTrace();
						    }
						   }
						  }).start();	
				}
						});
		
		btnArremessar.setBounds(221, 241, 153, 51);
		Pescaria.add(btnArremessar);
		
		btnPegarPeixe = new JButton("Pegar Peixe");
		btnPegarPeixe.setFont(new Font("Jokerman", Font.PLAIN, 12));
		btnPegarPeixe.setForeground(UIManager.getColor("Button.foreground"));
		btnPegarPeixe.setBackground(UIManager.getColor("Button.darkShadow"));
		btnPegarPeixe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnArremessar.setEnabled(true);
				lblArremesse.setText("Arremesse!");
				btnPegarPeixe.setEnabled(false);
				btnJogarNaAgua.setEnabled(false);
				Pescador.PegarPeixe();
				Atualizar();
			}
		});
		btnPegarPeixe.setEnabled(false);
		btnPegarPeixe.setBounds(305, 335, 117, 39);
		Pescaria.add(btnPegarPeixe);
		
		btnJogarNaAgua = new JButton("Jogar na agua");
		btnJogarNaAgua.setForeground(UIManager.getColor("Button.foreground"));
		btnJogarNaAgua.setFont(new Font("Jokerman", Font.PLAIN, 12));
		btnJogarNaAgua.setBackground(UIManager.getColor("Button.darkShadow"));
		btnJogarNaAgua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnArremessar.setEnabled(true);
				lblArremesse.setText("Arremesse!");
				btnPegarPeixe.setEnabled(false);
				btnJogarNaAgua.setEnabled(false);
				Pescador.JogarPeixeFora();
				Atualizar();
			}
		});
		btnJogarNaAgua.setEnabled(false);
		btnJogarNaAgua.setBounds(175, 335, 117, 39);
		Pescaria.add(btnJogarNaAgua);
		
		JButton btnSambur = new JButton("Sambur\u00E1");
		btnSambur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbrirMiniSambura();
				Atualizar();
			}
		});
		btnSambur.setBounds(33, 92, 90, 33);
		Pescaria.add(btnSambur);
		
		JButton btnSairDaPraia = new JButton("Sair da praia");
		btnSairDaPraia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbrirHome();
			}
		});
		btnSairDaPraia.setBounds(8, 380, 123, 26);
		Pescaria.add(btnSairDaPraia);
		
		lblPraiaAtual = new JLabel("New label");
		lblPraiaAtual.setHorizontalAlignment(SwingConstants.CENTER);
		lblPraiaAtual.setForeground(new Color(255, 255, 255));
		lblPraiaAtual.setFont(new Font("Super Mario Bros.", Font.PLAIN, 32));
		lblPraiaAtual.setBounds(152, 67, 278, 59);
		Pescaria.add(lblPraiaAtual);
		
		lblPeixePescado = new JLabel("NomePeixe");
		lblPeixePescado.setForeground(new Color(0, 0, 0));
		lblPeixePescado.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblPeixePescado.setBounds(310, 198, 178, 16);
		Pescaria.add(lblPeixePescado);
		
		ImagemPeixe = new JLabel("ImagemPeixe");
		ImagemPeixe.setBounds(202, 185, 90, 44);
		Pescaria.add(ImagemPeixe);
		
		btnFisgar = new JButton("Fisgar");
		btnFisgar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblArremesse.setText("Puxe!");
			}
		});
		btnFisgar.setForeground(UIManager.getColor("Button.foreground"));
		btnFisgar.setFont(new Font("Jokerman", Font.PLAIN, 14));
		btnFisgar.setBackground(UIManager.getColor("Button.darkShadow"));
		btnFisgar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == 38) {
					x++;
					if(x == 2) {
						x=1;
						
					}
				}
				if(e.getKeyCode() == 40) {
					y++;
					if(y == 2) {
						y=1;
					}
				}
				if(x == 1 && y ==1) {
					z++;
					x = 0;
					y = 0;
					if(z == Pescador.getMolinete().getTempoDePuxe()) {
						z = 0;
							Pescador.puxar();
						if (Pescador.getSambura().getEspaco() != Pescador.getSambura().QuantidadePeixe()) {
							btnPegarPeixe.setEnabled(true);
						}else {
							btnPegarPeixe.setEnabled(false);
						}
						btnJogarNaAgua.setEnabled(true);
						lblTutorial.setText("");
						Atualizar();
						
						btnFisgar.setEnabled(false);
					}
				}
			}
		});
		btnFisgar.setEnabled(false);
		btnFisgar.setBounds(247, 297, 98, 33);
		Pescaria.add(btnFisgar);
		
		chckbxComoPuxar = new JCheckBox("Como puxar");
		chckbxComoPuxar.setSelected(true);
		chckbxComoPuxar.setBounds(488, 381, 112, 24);
		Pescaria.add(chckbxComoPuxar);
		
		lblTutorial = new JLabel("");
		lblTutorial.setHorizontalTextPosition(SwingConstants.LEADING);
		lblTutorial.setHorizontalAlignment(SwingConstants.LEFT);
		lblTutorial.setVerticalAlignment(SwingConstants.TOP);
		lblTutorial.setBounds(404, 212, 106, 105);
		Pescaria.add(lblTutorial);
		
		lblMiniVara = new JLabel("New label");
		lblMiniVara.setBounds(522, 194, 55, 51);
		Pescaria.add(lblMiniVara);
		
		lblMiniMol = new JLabel("New label");
		lblMiniMol.setBounds(522, 241, 55, 51);
		Pescaria.add(lblMiniMol);
		
		lblMiniIsca = new JLabel("New label");
		lblMiniIsca.setBounds(522, 289, 55, 51);
		Pescaria.add(lblMiniIsca);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ViewGame.class.getResource("/Imagens/placa2.png")));
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setBackground(new Color(139, 69, 19));
		lblNewLabel_4.setBounds(142, 1, 305, 158);
		Pescaria.add(lblNewLabel_4);
		lblArremesse.setBorder(new LineBorder(new Color(102, 51, 0)));
		lblArremesse.setOpaque(true);
		lblArremesse.setHorizontalAlignment(SwingConstants.CENTER);
		lblArremesse.setForeground(new Color(0, 0, 153));
		lblArremesse.setFont(new Font("Chiller", Font.BOLD, 32));
		
		
		lblArremesse.setBounds(175, 125, 232, 33);
		Pescaria.add(lblArremesse);
		Pescaria.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnSairDaPraia, btnArremessar, btnPegarPeixe, lblArremesse, btnJogarNaAgua, btnSambur, lblPraiaAtual, lblPeixePescado}));
		
		label = new JLabel("");
		label.setBorder(new LineBorder(new Color(102, 51, 0)));
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(192, 183, 215, 51);
		Pescaria.add(label);
		
		
		
		lblLblfundo = new JLabel("");
		lblLblfundo.setBounds(0, 0, 600, 429);
		Pescaria.add(lblLblfundo);
		Mercado.setBounds(0, 0, 606, 429);
		contentPane.add(Mercado);
		Mercado.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 111, 577, 277);
		Mercado.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Varas", null, panel, null);
		panel.setLayout(null);
		
		lblVara1 = new JLabel("New label");
		lblVara1.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblVara1.setBounds(94, 36, 149, 16);
		panel.add(lblVara1);
		
		btnVara1 = new JButton("New button");
		btnVara1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mercado.ComprarVara(mercado.GetVaraDoMercado(0));
				Atualizar();
			}
		});
		btnVara1.setBounds(261, 32, 98, 26);
		panel.add(btnVara1);
		
		btnVara2 = new JButton("New button");
		btnVara2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mercado.ComprarVara(mercado.GetVaraDoMercado(1));
				Atualizar();
			}
		});
		btnVara2.setBounds(261, 70, 98, 26);
		panel.add(btnVara2);
		
		btnVara3 = new JButton("New button");
		btnVara3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mercado.ComprarVara(mercado.GetVaraDoMercado(2));
				Atualizar();
			}
		});
		btnVara3.setBounds(261, 108, 98, 26);
		panel.add(btnVara3);
		
		btnVara4 = new JButton("New button");
		btnVara4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mercado.ComprarVara(mercado.GetVaraDoMercado(3));
				Atualizar();
			}
		});
		btnVara4.setBounds(261, 146, 98, 26);
		panel.add(btnVara4);
		
		btnVara5 = new JButton("New button");
		btnVara5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mercado.ComprarVara(mercado.GetVaraDoMercado(4));
				Atualizar();
			}
		});
		btnVara5.setBounds(261, 184, 98, 26);
		panel.add(btnVara5);
		
		lblVara2 = new JLabel("New label");
		lblVara2.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblVara2.setBounds(94, 74, 149, 16);
		panel.add(lblVara2);
		
		lblVara3 = new JLabel("New label");
		lblVara3.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblVara3.setBounds(94, 112, 149, 16);
		panel.add(lblVara3);
		
		lblVara4 = new JLabel("New label");
		lblVara4.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblVara4.setBounds(94, 150, 149, 16);
		panel.add(lblVara4);
		
		lblVara5 = new JLabel("New label");
		lblVara5.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblVara5.setBounds(94, 188, 149, 16);
		panel.add(lblVara5);
		
		lblMiniVara1 = new JLabel("");
		lblMiniVara1.setBounds(12, 32, 70, 36);
		panel.add(lblMiniVara1);
		
		lblMiniVara2 = new JLabel("");
		lblMiniVara2.setBounds(12, 70, 70, 36);
		panel.add(lblMiniVara2);
		
		lblMiniVara3 = new JLabel("");
		lblMiniVara3.setBounds(12, 108, 70, 36);
		panel.add(lblMiniVara3);
		
		lblMiniVara4 = new JLabel("");
		lblMiniVara4.setBounds(12, 146, 70, 36);
		panel.add(lblMiniVara4);
		
		lblMiniVara5 = new JLabel("");
		lblMiniVara5.setBounds(12, 172, 70, 36);
		panel.add(lblMiniVara5);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Molinetes", null, panel_1, null);
		panel_1.setLayout(null);
		
		btnMolinete1 = new JButton("New button");
		btnMolinete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mercado.ComprarMolinete(mercado.GetMolineteDoMercado(0));
				Atualizar();
			}
		});
		btnMolinete1.setBounds(261, 34, 98, 26);
		panel_1.add(btnMolinete1);
		
		btnMolinete2 = new JButton("New button");
		btnMolinete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mercado.ComprarMolinete(mercado.GetMolineteDoMercado(1));
				Atualizar();
			}
		});
		btnMolinete2.setBounds(261, 72, 98, 26);
		panel_1.add(btnMolinete2);
		
		btnMolinete3 = new JButton("New button");
		btnMolinete3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mercado.ComprarMolinete(mercado.GetMolineteDoMercado(2));
				Atualizar();
			}
		});
		btnMolinete3.setBounds(261, 110, 98, 26);
		panel_1.add(btnMolinete3);
		
		btnMolinete4 = new JButton("New button");
		btnMolinete4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mercado.ComprarMolinete(mercado.GetMolineteDoMercado(2));
				Atualizar();
			}
		});
		btnMolinete4.setBounds(261, 148, 98, 26);
		panel_1.add(btnMolinete4);
		
		btnMolinete5 = new JButton("New button");
		btnMolinete5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mercado.ComprarMolinete(mercado.GetMolineteDoMercado(3));
				Atualizar();
			}
		});
		btnMolinete5.setBounds(261, 186, 98, 26);
		panel_1.add(btnMolinete5);
		
		lblMolinete1 = new JLabel("New label");
		lblMolinete1.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblMolinete1.setBounds(98, 34, 145, 16);
		panel_1.add(lblMolinete1);
		
		lblMolinete2 = new JLabel("New label");
		lblMolinete2.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblMolinete2.setBounds(98, 72, 145, 16);
		panel_1.add(lblMolinete2);
		
		lblMolinete3 = new JLabel("New label");
		lblMolinete3.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblMolinete3.setBounds(98, 110, 145, 16);
		panel_1.add(lblMolinete3);
		
		lblMolinete4 = new JLabel("New label");
		lblMolinete4.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblMolinete4.setBounds(98, 148, 145, 16);
		panel_1.add(lblMolinete4);
		
		lblMolinete5 = new JLabel("New label");
		lblMolinete5.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblMolinete5.setBounds(98, 186, 145, 16);
		panel_1.add(lblMolinete5);
		
		lblMolMini1 = new JLabel("");
		lblMolMini1.setBounds(12, 24, 70, 36);
		panel_1.add(lblMolMini1);
		
		lblMolMini2 = new JLabel("");
		lblMolMini2.setBounds(12, 62, 70, 36);
		panel_1.add(lblMolMini2);
		
		lblMolMini3 = new JLabel("");
		lblMolMini3.setBounds(12, 100, 70, 36);
		panel_1.add(lblMolMini3);
		
		lblMolMini4 = new JLabel("");
		lblMolMini4.setBounds(12, 138, 70, 36);
		panel_1.add(lblMolMini4);
		
		lblMolMini5 = new JLabel("");
		lblMolMini5.setBounds(12, 176, 70, 36);
		panel_1.add(lblMolMini5);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Iscas", null, panel_2, null);
		panel_2.setLayout(null);
		
		btnIsca1 = new JButton("New button");
		btnIsca1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mercado.ComprarIsca(mercado.GetIscaDoMercado(0));
				Atualizar();
			}
		});
		btnIsca1.setBounds(259, 40, 98, 26);
		panel_2.add(btnIsca1);
		
		btnIsca2 = new JButton("New button");
		btnIsca2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mercado.ComprarIsca(mercado.GetIscaDoMercado(1));
				Atualizar();
			}
		});
		btnIsca2.setBounds(259, 77, 98, 26);
		panel_2.add(btnIsca2);
		
		btnIsca3 = new JButton("New button");
		btnIsca3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mercado.ComprarIsca(mercado.GetIscaDoMercado(2));
				Atualizar();
			}
		});
		btnIsca3.setBounds(259, 115, 98, 26);
		panel_2.add(btnIsca3);
		
		btnIsca4 = new JButton("New button");
		btnIsca4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mercado.ComprarIsca(mercado.GetIscaDoMercado(0));
				Atualizar();
			}
		});
		btnIsca4.setBounds(259, 153, 98, 26);
		panel_2.add(btnIsca4);
		
		btnIsca5 = new JButton("New button");
		btnIsca5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mercado.ComprarIsca(mercado.GetIscaDoMercado(4));
				Atualizar();
			}
		});
		btnIsca5.setBounds(259, 192, 98, 26);
		panel_2.add(btnIsca5);
		
		lblIsca1 = new JLabel("New label");
		lblIsca1.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblIsca1.setBounds(105, 44, 147, 16);
		panel_2.add(lblIsca1);
		
		lblIsca2 = new JLabel("New label");
		lblIsca2.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblIsca2.setBounds(105, 82, 147, 16);
		panel_2.add(lblIsca2);
		
		lblIsca3 = new JLabel("New label");
		lblIsca3.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblIsca3.setBounds(105, 120, 147, 16);
		panel_2.add(lblIsca3);
		
		lblIsca4 = new JLabel("New label");
		lblIsca4.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblIsca4.setBounds(105, 158, 147, 16);
		panel_2.add(lblIsca4);
		
		lblIsca5 = new JLabel("New label");
		lblIsca5.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		lblIsca5.setBounds(105, 196, 147, 16);
		panel_2.add(lblIsca5);
		
		lblIscMini1 = new JLabel("");
		lblIscMini1.setBounds(12, 29, 70, 36);
		panel_2.add(lblIscMini1);
		
		lblIscMini2 = new JLabel("");
		lblIscMini2.setBounds(12, 67, 70, 36);
		panel_2.add(lblIscMini2);
		
		lblIscMini3 = new JLabel("");
		lblIscMini3.setBounds(12, 105, 70, 36);
		panel_2.add(lblIscMini3);
		
		lblIscMini14 = new JLabel("");
		lblIscMini14.setBounds(12, 143, 70, 36);
		panel_2.add(lblIscMini14);
		
		lblIscMini5 = new JLabel("");
		lblIscMini5.setBounds(12, 181, 70, 36);
		panel_2.add(lblIscMini5);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Sambur\u00E1", null, panel_4, null);
		panel_4.setLayout(null);
		
		btnAprimorarS = new JButton("New button");
		btnAprimorarS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pescador.AprimorarSambura();
				Atualizar();
			}
		});
		btnAprimorarS.setBounds(230, 120, 98, 26);
		panel_4.add(btnAprimorarS);
		
		lblAprimorarS = new JLabel("Aprimore seu Sambur\u00E1 em espa\u00E7os");
		lblAprimorarS.setBounds(173, 70, 222, 16);
		panel_4.add(lblAprimorarS);
		
		JButton btnNewButton_3 = new JButton("Vender Peixes");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mercado.Vender();
				Atualizar();
			}
		});
		btnNewButton_3.setBounds(467, 79, 122, 34);
		Mercado.add(btnNewButton_3);
		
		JButton btnVoltar_2 = new JButton("Voltar");
		btnVoltar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbrirHome();
			}
		});
		btnVoltar_2.setBounds(12, 398, 98, 26);
		Mercado.add(btnVoltar_2);
		
		JLabel lblMercado = new JLabel("Mercado");
		lblMercado.setForeground(new Color(255, 255, 255));
		lblMercado.setFont(new Font("Jokerman", Font.PLAIN, 18));
		lblMercado.setBounds(12, 79, 132, 26);
		Mercado.add(lblMercado);
		Sambura.setBounds(0, 0, 606, 429);
		contentPane.add(Sambura);
		Sambura.setLayout(null);
		
		JButton btnVoltar_1 = new JButton("Voltar");
		btnVoltar_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnVoltar_1.setBackground(new Color(102, 51, 0));
		btnVoltar_1.setBorderPainted(false);
		btnVoltar_1.setOpaque(false);
		btnVoltar_1.setFont(new Font("Super Mario Bros.", Font.PLAIN, 17));
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbrirHome();
			}
		});
		//table.setModel(tableModel);
		btnVoltar_1.setBounds(12, 398, 117, 26);
		Sambura.add(btnVoltar_1);
		
		JLabel lblSambur = new JLabel("Sambur\u00E1");
		lblSambur.setForeground(Color.WHITE);
		lblSambur.setFont(new Font("Super Mario Bros.", Font.PLAIN, 26));
		lblSambur.setBounds(12, 82, 156, 34);
		Sambura.add(lblSambur);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 138, 582, 248);
		Sambura.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(204, 255, 102));
		table.setSelectionForeground(new Color(204, 153, 0));
		table.setForeground(new Color(102, 51, 0));
		table.setGridColor(new Color(102, 51, 0));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		
		scrollPane.setViewportView(table);
		
		if(Pescador.getMao() == null) {
			lblPeixePescado.setText("");
			lblImagem.setText("");
		}
			
		Atualizar();
	}
	@SuppressWarnings("unchecked")
	public void Atualizar() {
		lblPescHud.setText(Pescador.getNome());
		lblDinheiroHub.setText("Dinheiro: "+Pescador.getDinheiro()+" R$");
		lblScoreHud.setText("Score: "+ Pescador.getScore());
		lblXpHub.setText("XP: "+Pescador.getXpBar().getXp1()+"/"+Pescador.getXpBar().getXp2());
		lblSamburaHud.setText("Samburá: "+ Pescador.getSambura().QuantidadePeixe() + "/"+ Pescador.getSambura().getEspaco());
		lblPraiaAtual.setText(Pescador.getPraiaAtual().getNome());
		lblPraiaEscolhida.setText(Pescador.getPraiaAtual().getNome());
		lblImagem.setIcon(Pescador.getPraiaAtual().getImagem());
		lblPeixePPraia.setText(Pescador.getPraiaAtual().GetPeixe(0).getNome()+", "
		+Pescador.getPraiaAtual().GetPeixe(1).getNome()+ ", "
				+ Pescador.getPraiaAtual().GetPeixe(2).getNome());
		dtm = new DefaultTableModel(new String[] {"Peixe", "Preço"}, 0);
		
		 for (int i =0 ; i < Pescador.getSambura().QuantidadePeixe(); i++) {
            String nomeP = Pescador.getSambura().GetPeixe(i).getNome();
            double preco = Pescador.getSambura().GetPeixe(i).getPreco();
            Object[] data = {nomeP, preco};
            dtm.addRow(data);
		 }
		 
		 table.setModel(dtm);
		lblVara1.setText(mercado.GetVaraDoMercado(0).getNome());
		btnVara1.setText(mercado.GetVaraDoMercado(0).getPreco()+ " R$");
		lblVara2.setText(mercado.GetVaraDoMercado(1).getNome());
		btnVara2.setText(mercado.GetVaraDoMercado(1).getPreco()+ " R$");
		lblVara3.setText(mercado.GetVaraDoMercado(2).getNome());
		btnVara3.setText(mercado.GetVaraDoMercado(2).getPreco()+ " R$");
		lblVara4.setText(mercado.GetVaraDoMercado(3).getNome());
		btnVara4.setText(mercado.GetVaraDoMercado(3).getPreco()+ " R$");
		lblVara5.setText(mercado.GetVaraDoMercado(4).getNome());
		btnVara5.setText(mercado.GetVaraDoMercado(4).getPreco()+ " R$");
		
		lblMolinete1.setText(mercado.GetMolineteDoMercado(0).getNome());
		btnMolinete1.setText(mercado.GetMolineteDoMercado(0).getPreco()+ " R$");
		lblMolinete2.setText(mercado.GetMolineteDoMercado(1).getNome());
		btnMolinete2.setText(mercado.GetMolineteDoMercado(1).getPreco()+ " R$");
		lblMolinete3.setText(mercado.GetMolineteDoMercado(2).getNome());
		btnMolinete3.setText(mercado.GetMolineteDoMercado(2).getPreco()+ " R$");
		lblMolinete4.setText(mercado.GetMolineteDoMercado(3).getNome());
		btnMolinete4.setText(mercado.GetMolineteDoMercado(3).getPreco()+ " R$");
		lblMolinete5.setText(mercado.GetMolineteDoMercado(4).getNome());
		btnMolinete5.setText(mercado.GetMolineteDoMercado(4).getPreco()+ " R$");
		
		lblIsca1.setText(mercado.GetIscaDoMercado(0).getNome());
		btnIsca1.setText(mercado.GetIscaDoMercado(0).getPreco()+ " R$");
		lblIsca2.setText(mercado.GetIscaDoMercado(1).getNome());
		btnIsca2.setText(mercado.GetIscaDoMercado(1).getPreco()+ " R$");
		lblIsca3.setText(mercado.GetIscaDoMercado(2).getNome());
		btnIsca3.setText(mercado.GetIscaDoMercado(2).getPreco()+ " R$");
		lblIsca4.setText(mercado.GetIscaDoMercado(3).getNome());
		btnIsca4.setText(mercado.GetIscaDoMercado(3).getPreco()+ " R$");
		lblIsca5.setText(mercado.GetIscaDoMercado(4).getNome());
		btnIsca5.setText(mercado.GetIscaDoMercado(4).getPreco()+ " R$");
		
		lblAprimorarS.setText("Aprimore seu sambura em "+ Pescador.getSambura().getEspaco()*2 +" espaços");
		btnAprimorarS.setText(Pescador.getSambura().getPreco()*2+ " R$");
		
		if(Pescador.getMao() == null) {
			lblPeixePescado.setText("");
			ImagemPeixe.setIcon(null);
			ImagemPeixe.setText("");
		}else {
			lblPeixePescado.setText(Pescador.getMao().getNome());
			ImagemPeixe.setIcon(Pescador.getMao().getImagem());
		}
		lblLblfundo.setIcon(Pescador.getPraiaAtual().getFundo());
	
		@SuppressWarnings("rawtypes")
		DefaultListModel listModel = new DefaultListModel();
		   for (int i =0 ; i < Pescador.getSambura().QuantidadePeixe(); i++) {
		               listModel.addElement(Pescador.getSambura().GetPeixe(i).getNome());
		       
		            }
		list.setModel(listModel);
		
		
		lblMiniVara1.setIcon(mercado.GetVaraDoMercado(0).getMiniatura());
		lblMiniVara2.setIcon(mercado.GetVaraDoMercado(1).getMiniatura());
		lblMiniVara3.setIcon(mercado.GetVaraDoMercado(2).getMiniatura());
		lblMiniVara4.setIcon(mercado.GetVaraDoMercado(3).getMiniatura());
		lblMiniVara5.setIcon(mercado.GetVaraDoMercado(4).getMiniatura());
		
		lblMolMini1.setIcon(mercado.GetMolineteDoMercado(0).getMiniatura());
		lblMolMini2.setIcon(mercado.GetMolineteDoMercado(1).getMiniatura());
		lblMolMini3.setIcon(mercado.GetMolineteDoMercado(2).getMiniatura());
		lblMolMini4.setIcon(mercado.GetMolineteDoMercado(3).getMiniatura());
		lblMolMini5.setIcon(mercado.GetMolineteDoMercado(4).getMiniatura());
		
		lblIsca1.setIcon(mercado.GetIscaDoMercado(0).getMiniatura());
		lblIsca2.setIcon(mercado.GetIscaDoMercado(1).getMiniatura());
		lblIsca3.setIcon(mercado.GetIscaDoMercado(2).getMiniatura());
		lblIsca4.setIcon(mercado.GetIscaDoMercado(3).getMiniatura());
		lblIsca5.setIcon(mercado.GetIscaDoMercado(4).getMiniatura());
		
		lblMiniVara.setIcon(Pescador.getVara().getMiniatura());
		lblMiniMol.setIcon(Pescador.getMolinete().getMiniatura());
		lblMiniIsca.setIcon(Pescador.getIsca().getMiniatura());
	}
	public void AbrirPraias() {
		Praias.setVisible(true);
		Hud.setVisible(false);
		Home.setVisible(false);
		Pescaria.setVisible(false);
		Ranking.setVisible(false);
		Mercado.setVisible(false);
		Sambura.setVisible(false);
	}
	public void AbrirSambura() {
		Praias.setVisible(false);
		Hud.setVisible(true);
		Home.setVisible(false);
		Pescaria.setVisible(false);
		Ranking.setVisible(false);
		Mercado.setVisible(false);
		Sambura.setVisible(true);
	}
	public void AbrirMercado() {
		Praias.setVisible(false);
		Hud.setVisible(true);
		Home.setVisible(false);
		Pescaria.setVisible(false);
		Ranking.setVisible(false);
		Mercado.setVisible(true);
		Sambura.setVisible(false);
	}
	public void AbrirRanking() {
		Praias.setVisible(false);
		Hud.setVisible(true);
		Home.setVisible(false);
		Pescaria.setVisible(false);
		Ranking.setVisible(true);
		Mercado.setVisible(false);
		Sambura.setVisible(false);
	}
	public void AbrirPescaria() {
		Praias.setVisible(false);
		Hud.setVisible(true);
		Home.setVisible(false);
		Pescaria.setVisible(true);
		Ranking.setVisible(false);
		Mercado.setVisible(false);
		Sambura.setVisible(false);
	}
	public void AbrirHome() {
		Praias.setVisible(false);
		Hud.setVisible(false);
		Home.setVisible(true);
		Pescaria.setVisible(false);
		Ranking.setVisible(false);
		Mercado.setVisible(false);
		Sambura.setVisible(false);
	}
	public void AbrirMiniSambura() {
		MiniSambura.setVisible(true);
	}
	}
