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
public class CuralumModel implements Serializable {
    private String codcarr;
    private String codcur;
    private String seccion;
    private String nomCur;
    private String SemesAno;
    
    public CuralumModel(){
        
    }
    
    public CuralumModel(String Codcarr,String Codcur,String Seccion, String Nomcur,String SemesAno  ){
        this.codcarr =Codcarr;
        this.codcur =Codcur;
        this.seccion =Seccion;
        this.nomCur =Nomcur;
        this.SemesAno=SemesAno;
        
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

    public String getNomCur() {
        return nomCur;
    }

    public void setNomCur(String nomCur) {
        this.nomCur = nomCur;
    }

    public String getSemesAno() {
        return SemesAno;
    }

    public void setSemesAno(String SemesAno) {
        this.SemesAno = SemesAno;
    }
    
    
    
}
