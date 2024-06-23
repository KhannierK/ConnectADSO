package Vista;

import Modelo.Residencia;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Vista_Residencia {
    public Vista_Residencia() { }

    public static int menu() {
        String[] opciones = {"Consultar casas", "Consultar casas por bloque", "Agregar nueva casa", "Eliminar casa", "Salir"};
        int i = JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción",
                "Menú",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]);
        return i + 1;
    }

    public static Residencia detallesResidencia() {
        String propietario = null;
        String strResidentes = null;

        while (true) {
            propietario = JOptionPane.showInputDialog(null, "Introduce el nombre del propietario:", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
            if (propietario == null) {
                return null; // Cancelar o cerrar el cuadro de diálogo
            }
            if (propietario.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error... No puede haber ningún campo vacío", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            strResidentes = JOptionPane.showInputDialog(null, "Residentes (SI o NO):", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
            if (strResidentes == null) {
                return null; // Cancelar o cerrar el cuadro de diálogo
            }
            if (strResidentes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error... No puede haber ningún campo vacío", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            if (!strResidentes.equalsIgnoreCase("SI") && !strResidentes.equalsIgnoreCase("NO")) {
                JOptionPane.showMessageDialog(null, "El campo de residentes debe ser llenado por 'SI' o 'NO'", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            break; // Salir del bucle si todo es válido
        }

        return new Residencia(propietario, strResidentes.equalsIgnoreCase("SI"));
    }

    public String getString(String parametro) {
        String str;
        while (true) {
            str = JOptionPane.showInputDialog(null, "Introduce el " + parametro + ":", "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
            if (str == null) {
                return null; // Cancelar o cerrar el cuadro de diálogo
            }
            if (str.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error... No puede haber ningún campo vacío", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            break;
        }
        return str;
    }

    public void consultarCasas(String bloque, HashMap<String, Residencia> lista) {
        HashMap<String, Residencia> resultados = new HashMap<>();
        for (String key : lista.keySet()) {
            if (key.charAt(0) == bloque.charAt(0)) {
                resultados.put(key, lista.get(key));
            }
        }
        mostrarCasas(resultados);
    }

    public void mostrarCasas(HashMap<String, Residencia> lista) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error... No se encontraron casas", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            StringBuilder resultado = new StringBuilder();
            for (Map.Entry<String, Residencia> entry : lista.entrySet()) {
                String clave = entry.getKey();
                Residencia valor = entry.getValue();
                resultado.append("Casa: ").append(clave).append(" ").append(valor).append("\n");
            }
            JOptionPane.showMessageDialog(null, resultado.toString(), "Casas Encontradas", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
