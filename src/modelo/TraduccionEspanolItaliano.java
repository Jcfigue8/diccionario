package modelo;

public class TraduccionEspanolItaliano extends Traduccion {
    public TraduccionEspanolItaliano(String palabraOrigen, String palabraDestino) {
        super(palabraOrigen, palabraDestino);
    }

    @Override
    public void mostrarTraduccion() {
        System.out.println("Español a Italiano: " + palabraOrigen + " -> " + palabraDestino);
    }
}
