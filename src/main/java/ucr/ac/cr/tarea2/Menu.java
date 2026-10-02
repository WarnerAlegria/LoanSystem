/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tarea2;

import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Menu {
    LoanSystem loanSystem;
    
    public Menu() {
        loanSystem=new LoanSystem();
        iniciar();
    }
    
    public void iniciar(){
        String dato1="";
        boolean dato2=false;
        int dato3=0;
        int opcion=0;
        do{
            opcion=Integer.parseInt(getMessage("SISTEMA DE PRESTAMO DE EQUIPOS\n1-Consultar catálogo\n2-Prestar equipo\n3-Devolver equipo\n4-Consultar multas\n5-Mostrar resumen\n6-Salir"));
            switch(opcion){
                case 1:
                    showMessage(loanSystem.consultarCatalogo());
                    break;
                    
                case 2:
                    dato1=getMessage("ingrese el código del equipo que desea solicitar");
                    dato2=getConfirm("¿Desea continuar con la solicitud?");
                    showMessage(loanSystem.prestarEquipo(dato1, dato2));
                    break;
                case 3:
                    dato1=getMessage("ingrese el código del equipo que dessea devolver");
                    dato2=getConfirm("¿Desea continuar con la devolución?");
                    if(loanSystem.devolverEquipo(dato1, dato2).equalsIgnoreCase("la devolución se completó correctamente")){
                        showMessage("la devolución se completó correctamente");
                        dato3=Integer.parseInt(getMessage("Ingrese la cantidad de dias atrasados"));
                        loanSystem.registrarAtraso(dato3, dato1);
                    }else{
                        showMessage(loanSystem.devolverEquipo(dato1, dato2));
                    }
                    break;
                    
                case 4:
                    showMessage(loanSystem.consultaMultas());
                    break;
                    
                case 5:
                    showMessage(loanSystem.resumen());
                    break;
                    
                case 6:
                    showMessage("¡Gracias por elegirnos!");
                    break;
                default:
                    showMessage("Opción invalida");
                    break;
            }
        }while(opcion!=6);
    }
    
    public String getMessage(String message){
        return JOptionPane.showInputDialog(message);
    }
    
    public void showMessage(String message){
        JOptionPane.showMessageDialog(null,message);
    }
    
    public boolean getConfirm(String message) {
    return JOptionPane.showConfirmDialog(
        null,
        message,
        "Confirmación",
        JOptionPane.YES_NO_OPTION
        ) == JOptionPane.YES_OPTION;
    }
}
