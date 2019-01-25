/**
 * Las tareas tienen una descripcion y pueden estar completadas o no.
 * Además también tienen una prioridad, que puede ser de 1 (prioridad maxima) a 5
 * (prioridad minima)
 */
import java.time.LocalDate;

public class Tarea
{
    private String descripcion;
    private boolean estaCompletada;
    private int prioridad;
    private boolean conFechaFijada;
    private LocalDate fechaVencimiento;
    
    
    public Tarea(String textoDescripcion) {
        descripcion = textoDescripcion;
        estaCompletada = false;
        prioridad = 5;
        //fechaVencimiento = null;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public boolean getEstaCompletada() {
        return estaCompletada;
    }
    
    public int getPrioridad(){
        return prioridad;
    }
    
    public void marcarComoCompletada() {
        estaCompletada = true;
    }
    
    public void setPrioridad(int nuevaPrioridad){
        if (nuevaPrioridad >= 1 && nuevaPrioridad <= 5) {
            prioridad = nuevaPrioridad;
        }        
    }
    
    public void setFechaVencimiento(int dia, int mes, int ano) {
        fechaVencimiento = fechaVencimiento.of(ano, mes, dia);
        conFechaFijada = true;
    }
    
    /** 
     * Devuelve la cadena vacia si la tarea no tiene fecha de 
     * vencimiento o un texto incluyendo la fecha de vencimiento
     * en caso de que si la tenga
     */
    public String getFecha() {
        String fecha = "";

        if (conFechaFijada) {
             String diaNuevo ="" + fechaVencimiento.getDayOfMonth();
             String mesNuevo ="" + fechaVencimiento.getMonthValue();
            if ( fechaVencimiento.getDayOfMonth() < 10) {
                diaNuevo = "0" + fechaVencimiento.getDayOfMonth() ;
            }
   
            if ( fechaVencimiento.getMonthValue() < 10) {
                mesNuevo = "0" + fechaVencimiento.getMonthValue() ;
            }
            
            fecha = diaNuevo + "/" + mesNuevo + "/" + fechaVencimiento.getYear();            
        }        
        return fecha;
    }
    
    public boolean tieneFechaDeVecimiento() {
        return conFechaFijada;
    }
    
 }


