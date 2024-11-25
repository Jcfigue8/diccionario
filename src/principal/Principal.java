package principal;

import vista.VentanaTraductor;
import controlador.Controlador;
import modelo.Traductor;

public class Principal {
    public static void main(String[] args) {
        // Crear el modelo
        Traductor traductor = new Traductor();

        // Crear la vista
        VentanaTraductor ventana = new VentanaTraductor();

        // Crear el controlador
        Controlador controlador = new Controlador(traductor);

        // Configurar la interacción entre modelo, vista y controlador
        ventana.setControlador(controlador);

        // Mostrar la ventana
        ventana.setVisible(true);
    }
}

