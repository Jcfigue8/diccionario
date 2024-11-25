package modelo;

public abstract class Traduccion {
    protected String palabraOrigen;
    protected String palabraDestino;

    public Traduccion(String palabraOrigen, String palabraDestino) {
        if (palabraOrigen == null || palabraOrigen.isEmpty()) {
            throw new IllegalArgumentException("La palabra de origen no puede ser nula ni vacía.");
        }
        if (palabraDestino == null || palabraDestino.isEmpty()) {
            throw new IllegalArgumentException("La palabra traducida no puede ser nula ni vacía.");
        }
        this.palabraOrigen = palabraOrigen;
        this.palabraDestino = palabraDestino;
    }

    public abstract void mostrarTraduccion();

    public String getPalabraOrigen() {
        return palabraOrigen;
    }

    public String getPalabraDestino() {
        return palabraDestino;
    }
}
