package controlador;

import modelo.Traductor;
import modelo.TraduccionEspanolIngles;
import modelo.TraduccionEspanolItaliano;

public class Controlador {
    private Traductor traductor;

    public Controlador(Traductor traductor) {
        this.traductor = traductor;
    }

    public void agregarTraduccion(String palabraOrigen, String palabraDestino, String idioma) {
        switch (idioma) {
            case "espanol-ingles":
                traductor.agregarTraduccion(idioma, new TraduccionEspanolIngles(palabraOrigen, palabraDestino));
                break;
            case "espanol-italiano":
                traductor.agregarTraduccion(idioma, new TraduccionEspanolItaliano(palabraOrigen, palabraDestino));
                break;
            default:
                throw new IllegalArgumentException("Idioma no soportado: " + idioma);
        }
    }

    public String traducirPalabra(String palabraOrigen, String idioma) {
        return traductor.traducir(idioma, palabraOrigen);
    }

    public int getNumeroTraducciones() {
        return traductor.getNumeroTraducciones(null);
    }
}

