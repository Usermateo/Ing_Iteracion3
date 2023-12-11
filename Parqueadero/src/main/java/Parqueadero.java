import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Parqueadero {

   
    private Map<String, Double> pagosMensuales;
    private Map<String, Double> pagosPendientes;
    private List<String> clientesRegistrados;

    public Parqueadero() {
        pagosMensuales = new HashMap<>();
        pagosPendientes = new HashMap<>();
        clientesRegistrados = new ArrayList<>();
    }

   
    public void registrarCliente(String nombre) {
        clientesRegistrados.add(nombre);
    }

  
    public void registrarPagoMensual(String nombreCliente, double monto) {
        pagosMensuales.put(nombreCliente, monto);
        pagosPendientes.remove(nombreCliente);
    }

    
    public void generarRecibosPendientes() {
        for (String cliente : clientesRegistrados) {
            if (!pagosMensuales.containsKey(cliente)) {
                pagosPendientes.put(cliente, pagosMensuales.getOrDefault(cliente, 0.0));
            }
        }
    }

    
    public double obtenerHistorialDePagos(String nombreCliente) {
        return pagosMensuales.getOrDefault(nombreCliente, 0.0);
    }

   
    public void notificarPagosPendientes() {
        for (String cliente : pagosPendientes.keySet()) {
            System.out.println("Notificación: Pago pendiente para " + cliente + ". Monto: $" + pagosPendientes.get(cliente));
        }
    }

    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();

      
        parqueadero.registrarCliente("Cliente1");
        parqueadero.registrarCliente("Cliente2");

        
        parqueadero.registrarPagoMensual("Cliente1", 50.0);

       
        parqueadero.generarRecibosPendientes();

        
        parqueadero.notificarPagosPendientes();
    }
}