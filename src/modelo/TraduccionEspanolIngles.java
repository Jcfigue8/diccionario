package modelo;

public class TraduccionEspanolIngles extends Traduccion {

    public TraduccionEspanolIngles(String palabraOrigen, String palabraDestino) {
        super(palabraOrigen, palabraDestino);
    }

    @Override
    public void mostrarTraduccion() {
        System.out.println(palabraOrigen + " en inglés es " + palabraDestino);
    }
}
