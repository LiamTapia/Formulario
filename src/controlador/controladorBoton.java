package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.FormularioInterface;

public class controladorBoton implements ActionListener {
	private FormularioInterface vista;
	
	public controladorBoton(FormularioInterface vista){
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		String comando = e.getActionCommand();
		switch(comando){
		case "SALIR":
			int opcion = JOptionPane.showConfirmDialog((Component) vista, "Seguro que quieres salir?", "SALIR", JOptionPane.YES_NO_OPTION);
			if(opcion == JOptionPane.YES_OPTION)
				System.exit(0); //Con 0 dice que se cierra sin errores.
			break;
		case "ENVIAR":
			String mensaje = "Nombre: " + vista.getNombre() + "\nContraseña: " + vista.getPassword() + "\nGenero" + vista.getGenero().toString();
			if(vista.getNombre().isEmpty()){
				JOptionPane.showMessageDialog((Component)vista, "Error. Nombre incompleto", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else JOptionPane.showMessageDialog((Component)vista, mensaje, "Datos", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}
}
