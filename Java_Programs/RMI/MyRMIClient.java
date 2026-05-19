import java.rmi.Naming;

public class MyRMIClient {
    public static void main(String[] args) { 
        try {
            MyRemote remoteObj = (MyRemote) Naming.lookup("rmi://localhost:2000/MyRemote");
            String response = remoteObj.sayHello();
            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            System.out.println("Client exception:"+ e.getMessage());
            e.printStackTrace();
        }
    }
}