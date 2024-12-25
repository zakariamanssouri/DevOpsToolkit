import proxy.BanqueService;
import proxy.BanqueServiceService;
import proxy.Compte;

public class ClientWs {
    
    public static void main(String args[])
    {
        BanqueService stub = new BanqueServiceService().getBanqueServicePort();

        System.out.println(stub.conversionEuroToDH(100));
        Compte cp = stub.getCompte(5);
        System.out.println(cp.getCode());
        System.out.println(cp.getSolde());
    }
}
