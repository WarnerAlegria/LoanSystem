package ucr.ac.cr.tarea2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author LENOVO
 */
public class Equipment {
    private int tarifaMulta;
    private String nombre, tipo, codigo;
    private boolean disponible;

    public Equipment() {
        
    }

    public Equipment(String codigo, String nombre, String tipo, boolean disponible, int tarifaMulta) {
        this.tarifaMulta = tarifaMulta;
        this.nombre = nombre;
        this.tipo = tipo;
        this.codigo = codigo;
        this.disponible = disponible;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getTarifaMulta() {
        return tarifaMulta;
    }

    public void setTarifaMulta(int tarifaMulta) {
        this.tarifaMulta = tarifaMulta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public void prestar(){
        disponible=false;
    }
    public void devolver(){
        disponible=true;
    }
    public String infoEquipo(){
        String estadoProducto="";
        if(disponible==true){
            estadoProducto="Disponible";
        }else{
            estadoProducto="Prestado";
        }
        return "Código: "+codigo+"\nNombre: "+nombre+"\nTipo: "+tipo+"\nEstado: "+estadoProducto;
    }
    public int multa(int diasAtraso){
        return tarifaMulta*diasAtraso;
    }
}
