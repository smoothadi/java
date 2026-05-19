import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class MyRMIServer {
    public static void main(String[] args) {
        try {
            MyRemoteImpl obj = new MyRemoteImpl();
            LocateRegistry.createRegistry(2000);
            Naming.rebind("rmi://localhost:2000/MyRemote", obj);
            System.out.println("RMI Server is ready...");
        } catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}