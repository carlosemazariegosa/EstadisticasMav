/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrapper;

import java.io.Serializable;

/**
 *
 * @author mmarvin
 */
public class CursosDetModel implements Serializable {

    private String semesAno;
    private String codcarr;
    private String codcur;
    private String seccion;
    private String nomcur;

    public CursosDetModel() {

    }

    public CursosDetModel(String SemesAno, String Codcarr, String Codcur, String Seccion, String Nomcur) {
        this.semesAno = SemesAno;
        this.codcarr = Codcarr;
        this.codcur = Codcur;
        this.seccion = Seccion;
        this.nomcur = Nomcur;
    }

    public String getSemesAno() {
        return semesAno;
    }

    public void setSemesAno(String semesAno) {
        this.semesAno = semesAno;
    }

    public String getCodcarr() {
        return codcarr;
    }

    public void setCodcarr(String codcarr) {
        this.codcarr = codcarr;
    }

    public String getCodcur() {
        return codcur;
    }

    public void setCodcur(String codcur) {
        this.codcur = codcur;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getNomcur() {
        return nomcur;
    }

    public void setNomcur(String nomcur) {
        this.nomcur = nomcur;
    }

}
