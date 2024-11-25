package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Traductor {
    private HashMap<String, ArrayList<Traduccion>> diccionarios;

    public Traductor() {
        diccionarios = new HashMap<>();
        diccionarios.put("espanol-ingles", new ArrayList<>());
        diccionarios.put("espanol-frances", new ArrayList<>());
        diccionarios.put("espanol-italiano", new ArrayList<>());
        diccionarios.put("ingles-espanol", new ArrayList<>());
        diccionarios.put("frances-espanol", new ArrayList<>());
        diccionarios.put("italiano-espanol", new ArrayList<>());
    }

    public void agregarTraduccion(String idioma, Traduccion traduccion) {
        if (!diccionarios.containsKey(idioma)) {
            throw new IllegalArgumentException("El idioma no es válido.");
        }

        ArrayList<Traduccion> lista = diccionarios.get(idioma);

        // Verificar duplicados
        for (Traduccion t : lista) {
            if (t.getPalabraOrigen().equalsIgnoreCase(traduccion.getPalabraOrigen())) {
                throw new IllegalArgumentException("La palabra ya existe en el diccionario.");
            }
        }

        lista.add(traduccion);
    }

    public String traducir(String idioma, String palabra) {
        if (!diccionarios.containsKey(idioma)) {
            throw new IllegalArgumentException("El idioma no es válido.");
        }

        ArrayList<Traduccion> lista = diccionarios.get(idioma);

        for (Traduccion traduccion : lista) {
            if (traduccion.getPalabraOrigen().equalsIgnoreCase(palabra)) {
                return traduccion.getPalabraDestino();
            }
        }
        return "Traducción no encontrada.";
    }

    public int getNumeroTraducciones(String idioma) {
        if (!diccionarios.containsKey(idioma)) {
            return 0;
        }
        return diccionarios.get(idioma).size();
    }
}


