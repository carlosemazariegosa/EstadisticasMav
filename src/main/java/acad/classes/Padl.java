/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acad.classes;

public class Padl {

    public Padl() {
    }

    public String getFullString(String cadena, String prefijo, int longitudMaxima) {

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < (longitudMaxima - cadena.trim().length()); i++) {
            res.append(prefijo);
        }
        res.append(cadena);
        return res.toString();
    }

    public String Padl(String cadena, String prefijo, int longitudMaxima) {
        String resultado = "";
        cadena=cadena.trim();
        String Prefx = "";
        for (int i = 0; i < longitudMaxima - cadena.trim().length(); i++) {
            Prefx = Prefx + prefijo;
        }
        resultado = Prefx + cadena;
        return resultado;

    }
}