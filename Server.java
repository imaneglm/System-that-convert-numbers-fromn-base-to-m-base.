import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            // Start RMI registry within the same process (optional if already running)
            LocateRegistry.createRegistry(1099);

            // Create and bind remote object
            Convertingnumb stub = new ConvertingnumbImpl();
            Naming.rebind("rmi://localhost/NumberService", stub);
            System.out.println("RMI Server is running and ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
