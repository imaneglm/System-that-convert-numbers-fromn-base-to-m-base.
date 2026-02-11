import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Convertingnumb extends Remote {
    String convert(String numb, String base, String c_base) throws RemoteException;
}
