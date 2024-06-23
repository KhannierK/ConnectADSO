import Controlador.Controlador_Residencia;
import Modelo.BD_Entregas;
import Modelo.BD_PQyR;
import Modelo.BD_Residencias;
import Vista.Vista_Residencia;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BD_Residencias modelo = new BD_Residencias();
        Vista_Residencia vista = new Vista_Residencia();
        Controlador_Residencia controladorResidencia = new Controlador_Residencia(modelo, vista);
        controladorResidencia.iniciar();
    }
}