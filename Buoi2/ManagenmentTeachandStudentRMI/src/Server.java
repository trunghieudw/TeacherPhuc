import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            RemoteImplementation remoteObj = new RemoteImplementation();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RemoteObject", remoteObj);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
