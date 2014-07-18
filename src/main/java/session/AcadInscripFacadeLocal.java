/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.AcadInscrip;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mmarvin
 */
@Local
public interface AcadInscripFacadeLocal {

    void create(AcadInscrip acadInscrip);

    void edit(AcadInscrip acadInscrip);

    void remove(AcadInscrip acadInscrip);

    AcadInscrip find(Object id);

    List<AcadInscrip> findAll();

    List<AcadInscrip> findRange(int[] range);

    int count();

    public int InscripcionesCC(String semesAno);

    public int InscripcionesCentros(String semesAno);

    public List<Object[]> InscripcionesTipoCC(String semesAno,Date fecha);

    public List<Object[]> InscripcionesTipoCentros(String semesAno,Date fecha);

    public Date FechaActual();

    public List<Object[]> InscripCampusCenGen(String semesAno, Date fecha);

    public List<Object[]> InscripCentrosDepGen(String semesAno, Date fecha);

    public List<Object[]> InscripcionesDeptoCC(String semesAno, Date fecha);

    public List<Object[]> InscripcionesDeptoCentros(String semesAno, Date fecha);

    public List<Object[]> InscripcionesCentroCC(String semesAno, Date fecha);

    public List<Object[]> InscripcionesCentroCentrosDep(String semesAno, Date fecha);

    public List<Object[]> InscripcionesCodMadre(String semesAno, Date fecha, String codMadre);

    public List<Object[]> InscripcionesCentroCentrosDepPrimIngre(String semesAno, Date fecha, String Anio);

    public List<Object[]> InscripcionesCentroCentrosDepPrimIngreTotales(String semesAno, Date fecha, String Anio);

    public List<Object[]> InscripcionesCentroCentrosDepReingresoTotales(String semesAno, Date fecha, String Anio);

    public List<Object[]> InscripcionesCCPrimIngre(String semesAno, Date fecha, String Anio);

    public List<Object[]> InscripcionesCCPrimIngreTotales(String semesAno, Date fecha, String Anio);

    public List<Object[]> InscripcionesCCReingresoTotales(String semesAno, Date fecha, String Anio);
    
}
