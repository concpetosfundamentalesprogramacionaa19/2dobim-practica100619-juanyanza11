/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ADMIN-HP
 */
public class LeerArchivoTexto {

    public static void leerRegistrosFifa() {
        try // lee registros del archivo, usando el objeto Scanner
        {
            double sumaH = 0, promH = 0, sumaG = 0, promG = 0;
            int c = 1, j = 1;
            Scanner entrada = new Scanner(new File("data/tabula-FWC_2018_Squadlists_4.csv"));

            while (entrada.hasNext()) {
                String linea = entrada.nextLine();

                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split("\\|")));
                //System.out.println(linea_partes.get(3));
                // Obtener datos de la posición 9
                double dheight = Double.parseDouble(linea_partes.get(9));
                // Obtener datos de la posición 11
                double dGoles = Double.parseDouble(linea_partes.get(11));
                sumaH = sumaH + dheight; // Acumulación de estaturas en cm
                sumaG = sumaG + dGoles; // Acumulación de goles
                c = c + 1;
                j = j + 1;
            } // fin de while
            entrada.close();
            promH = sumaH / c; // Promedio de Estaturas
            promG = sumaG / j; // Promedio de Goles
            System.out.printf("Promedio de Estatura = %.3f\n"
                    + "Promedio de goles: %.3f\n", promH, promG);
        } // fin de try
        catch (Exception e) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del m�todo leerRegistros
    // cierra el archivo y termina la aplicaci�n
}
