/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tarea2;

/**
 *
 * @author LENOVO
 */
public class LoanSystem {
   private Equipment[] equipos = new Equipment[5];
    private int[] diasAtraso = new int[5];
    int cantMulta=0;
    public LoanSystem() {
        equipos[0]=new Equipment("EQ01", "Cámara DSLR", "Cámara", true, 500);
        equipos[1]=new Equipment("EQ02", "Trípode", "Soporte", true, 500);
        equipos[2]=new Equipment("EQ03", "Micrófono", "Audio", true, 500);
        equipos[3]=new Equipment("EQ04", "Tableta gráfica", "Diseño", true, 500);
        equipos[4]=new Equipment("EQ05", "Kit de iluminación", "Iluminación", true, 800);
    }
    
    public String consultarCatalogo(){
        String salida="";
        for (int i = 0; i < equipos.length; i++) {
            salida+="EQUIPO "+(i+1)+"\n"+equipos[i].infoEquipo()+"\n";
        }
        return salida;
    }
    
    public String prestarEquipo(String equipo, boolean confirmacion){
        for (int i = 0; i < equipos.length; i++) {
            if(equipos[i].getCodigo().equalsIgnoreCase(equipo)){
                if(equipos[i].isDisponible()==false){
                    return "Este equipo no se encuentra disponible";
                }else{
                    equipos[i].setDisponible(false);
                    return "la solicitud de prestamo se confirmo correctamente";
                }
            }
        }
        return "EL código ingresado no es válido";
    }
    
    public String devolverEquipo(String equipo, boolean confirmacion){
        for (int i = 0; i < equipos.length; i++) {
            if(equipos[i].getCodigo().equalsIgnoreCase(equipo)){
                if(equipos[i].isDisponible()==true){
                    return "Este equipo no ah sido prestado";
                }else{
                    equipos[i].setDisponible(confirmacion);
                    return "la devolución se completó correctamente";
                }
            }
        }
        return "EL código ingresado no es válido";
    }
    
    public void registrarAtraso(int cantDias, String codigo){
        for (int i = 0; i < diasAtraso.length; i++) {
            if(equipos[i].getCodigo().equalsIgnoreCase(codigo)){
                diasAtraso[i]=cantDias;
                cantMulta++;
            }
        }
    }
    
    public String consultaMultas(){
        String salida="";
        for (int i = 0; i < equipos.length; i++) {
            salida+="EQUIPO "+(i+1)+"--"+equipos[i].getNombre()+"\nDias de atraso: "+diasAtraso[i]+"\nTotal de la multa: "+equipos[i].multa(diasAtraso[i])+"\n";
        }
        return salida;
    }
    
    public String resumen(){
        String disponibles="";
        String prestados="";
        for (int i = 0; i < equipos.length; i++) {
            if(equipos[i].isDisponible()==true){
                disponibles+="\nEQUIPO "+(i+1);
            }else{
                prestados+="\nEQUIPO "+(i+1);
            }
        }
        
        return "DISPONIBLES"+disponibles+"\nPRESTADOS"+prestados+"\n\nCantidad de multas registradas: "+cantMulta;
    }
}
