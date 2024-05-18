package competicionAtletas;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaAccion extends JFrame {

	public VistaAccion() {
		
		setTitle("Competición de atletismo");
		setBounds(450,250,700,400);
		setLayout(new BorderLayout());
		
        creaTitulo();
        creaBotones();
        creaComponentesDatos();
        
        atletas = new ArrayList<>();
        agregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				agregarAtleta();
			}

        });

        mostrarGanador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				mostrarGanador();
			}        	
        });
		
	}
	
	private void agregarAtleta() {
		
		try {
			
			int numero = Integer.parseInt(numeroAtleta.getText());
			String nombre = nombreAtleta.getText();
			double tiempo = Double.parseDouble(tiempoAtleta.getText());

			Atleta atleta = new Atleta(numero, nombre, tiempo);
			atletas.add(atleta);
			
			JOptionPane.showMessageDialog(this, "Atleta registrado");
			
			numeroAtleta.setText("");
			nombreAtleta.setText("");
			tiempoAtleta.setText("");
		}
		
		catch(Exception e) {
			
			JOptionPane.showMessageDialog(this, "No se puede agregar, verifique los campos de número o tiempo");
		}
	}
	
	private void mostrarGanador() {
		
		if(atletas.isEmpty()) {
			
			JOptionPane.showMessageDialog(this, "No hay ningún atleta registrado, favor de registrar atletas");
		} else {
			
			Atleta ganador = atletas.get(0);
			
			for(Atleta temp: atletas) {
				
				if(temp.getTiempo() < ganador.getTiempo()) {
					
					ganador = temp;
				}
			}
			
			JOptionPane.showMessageDialog(this, "El ganador con el numero " + ganador.getNumero()+
					" es " + ganador.getNombre() + " con un tiempo de " + ganador.getTiempo() + " segundos");
		}
	}
	
	private void creaTitulo() {
		
		tituloP = new JPanel();
		titulo = new JLabel("Competencia de atletismo");
		tituloP.add(titulo);
		add(tituloP, BorderLayout.NORTH);
	}
	
	private void creaComponentesDatos() {
		
		componentes = new JPanel(new GridLayout(4, 1));
		
		numeroAtleta = new JTextField();
		nombreAtleta = new JTextField();
		tiempoAtleta = new JTextField();
	
		textoNumero  = new JLabel("Ingresa el número del atleta:");
		textoAtleta  = new JLabel("Ingresa el nombre del atleta:");
		textoTiempo = new JLabel("Ingresa el tiempo del atleta:");	
		
		componentes.add(textoNumero);
        componentes.add(numeroAtleta);
        componentes.add(textoAtleta);
        componentes.add(nombreAtleta);
        componentes.add(textoTiempo);
        componentes.add(tiempoAtleta);
        
        add(componentes, BorderLayout.CENTER);
	}
	
	private void creaBotones() {
		
		botones = new JPanel();
		
		agregar = new JButton("Registrar atleta");
		mostrarGanador = new JButton("Mostrar ganador");
		
		botones.add(agregar);
		botones.add(mostrarGanador);
		
		add(botones, BorderLayout.SOUTH);		
	}
	
	private JTextField numeroAtleta, nombreAtleta, tiempoAtleta;
	
	private JLabel titulo, textoNumero, textoAtleta, textoTiempo;

	private JButton agregar, mostrarGanador;
	
	private JPanel tituloP, botones, componentes;
	
	private ArrayList<Atleta> atletas;
	
}