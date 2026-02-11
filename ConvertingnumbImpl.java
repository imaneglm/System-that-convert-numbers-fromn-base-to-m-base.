import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConvertingnumbImpl extends UnicastRemoteObject implements Convertingnumb {
    protected ConvertingnumbImpl() throws RemoteException {
        super();
    }
    public String convert(String numb, String base, String c_base) throws RemoteException {
        int fromBase = convertBase(base);
        int toBase = convertBase(c_base);
        int decimalValue = Integer.parseInt(numb, fromBase);
        return Integer.toString(decimalValue, toBase).toUpperCase();
    }
    private int convertBase(String base) {
        try {
            return Integer.parseInt(base);
        } catch (NumberFormatException e) {
            switch (base.toLowerCase()) {
                case "binary": return 2;
                case "octal": return 8;
                case "decimal": return 10;
                case "hex": return 16;
                default: throw new IllegalArgumentException("non exesited base" );
            }
        }
    }
}
