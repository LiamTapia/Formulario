package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.controladorBoton;
import modelo.Genero;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;

public class Formulario extends JFrame implements FormularioInterface{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JPasswordField txtContrasena;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(Color.PINK);
		btnEnviar.setForeground(Color.RED);
		panelBotones.add(btnEnviar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.ORANGE);
		btnSalir.setForeground(Color.RED);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panelBotones.add(btnSalir);
		
		JPanel panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.NORTH);
		panelPrincipal.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lbNombre = new JLabel("Nombre:");
		lbNombre.setForeground(Color.GRAY);
		panelPrincipal.add(lbNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(Color.GREEN);
		txtNombre.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 19));
		txtNombre.setForeground(Color.YELLOW);
		panelPrincipal.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBackground(Color.BLUE);
		lblGenero.setForeground(Color.LIGHT_GRAY);
		panelPrincipal.add(lblGenero);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panelPrincipal.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBackground(Color.MAGENTA);
		rdbtnHombre.setSelected(true);
		panel_1.add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBackground(Color.PINK);
		panel_1.add(rdbtnMujer);
		
		ButtonGroup grupoGenero = new ButtonGroup(); //Hace que solo se elija un boton u otro.
		grupoGenero.add(rdbtnHombre);
		grupoGenero.add(rdbtnMujer);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setForeground(Color.RED);
		lblContrasena.setBackground(Color.RED);
		panelPrincipal.add(lblContrasena);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setForeground(Color.CYAN);
		txtContrasena.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 29));
		txtContrasena.setBackground(Color.DARK_GRAY);
		panelPrincipal.add(txtContrasena);
		
		controladorBoton controlador = new controladorBoton(this);
		btnSalir.setActionCommand("SALIR");
		btnSalir.addActionListener(controlador);
		
		btnEnviar.setActionCommand("ENVIAR");
		btnEnviar.addActionListener(controlador);
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return txtNombre.getText();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return new String(txtContrasena.getPassword());
	}

	@Override
	public Genero getGenero() {
		// TODO Auto-generated method stub
		Genero genero = (rdbtnHombre.isSelected())?Genero.HOMBRE:Genero.MUJER;
		return genero;
	}

}
