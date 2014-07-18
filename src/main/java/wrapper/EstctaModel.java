/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wrapper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EstctaModel implements Serializable {

    private  String codmov;
    private  Date fecha;
    private  String tipomov;
    private  String abreviatura;
    private  String poliza;
    private  String semesano;
    private  BigDecimal cargos;
    private  BigDecimal abonos;
    private  BigDecimal saldo;
    private  int mes;
    private  int documento;
    
    
    public EstctaModel(){
        
    }
    
    public EstctaModel(String codmov,Date fecha){
        this.codmov=codmov;
        this.fecha=fecha; 
    }
    
     public EstctaModel(String codmov,Date fecha,String tipomov,String abreviatura,
             String poliza,String semesano,BigDecimal cargos,BigDecimal abonos,BigDecimal saldo,int mes,int documento){
       this.codmov=codmov;
       this.fecha=fecha;
       this.tipomov=tipomov;
       this.abreviatura=abreviatura;
       this.poliza =poliza;
       this.semesano=semesano;
       this.cargos =cargos;
       this.abonos =abonos;
       this.saldo =saldo;
       this.mes =mes;
       this.documento=documento;
    }

    public String getCodmov() {
        return codmov;
    }

    public void setCodmov(String codmov) {
        this.codmov = codmov;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipomov() {
        return tipomov;
    }

    public void setTipomov(String tipomov) {
        this.tipomov = tipomov;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public String getSemesano() {
        return semesano;
    }

    public void setSemesano(String semesano) {
        this.semesano = semesano;
    }

    public BigDecimal getCargos() {
        return cargos;
    }

    public void setCargos(BigDecimal cargos) {
        this.cargos = cargos;
    }

    public BigDecimal getAbonos() {
        return abonos;
    }

    public void setAbonos(BigDecimal abonos) {
        this.abonos = abonos;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

   

   
}

