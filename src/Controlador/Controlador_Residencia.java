package Controlador;

import Modelo.BD_Residencias;
import Modelo.Residencia;
import Vista.Vista_Residencia;

import java.util.HashMap;

public class Controlador_Residencia {
    BD_Residencias modelo;
    Vista_Residencia vista;
    public Controlador_Residencia(BD_Residencias modelo, Vista_Residencia vista){
        this.modelo = modelo;
        this.vista = vista;
    }
    public void iniciar(){
        String casa;
        int op;
        while (true){
            op = Vista_Residencia.menu();
            switch (op){
                case 1:
                    vista.mostrarCasas(modelo.getResidencias());
                    break;
                case 2:
                    String bloque = vista.getString("BLOQUE");
                    vista.consultarCasas(bloque, modelo.getResidencias());
                    break;
                case 3:
                    casa = vista.getString("CASA");
                    Residencia residencia = Vista_Residencia.detallesResidencia();
                    modelo.agregarCasa(casa.toUpperCase(), residencia);
                    break;
                case 4:
                    casa = vista.getString("CASA");
                    modelo.eliminarCasa(casa.toUpperCase());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Error... Opcion no valida");
            }
        }
    }
}
