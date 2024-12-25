package ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;

@WebService
public class BanqueService {
    @WebMethod(operationName = "conversionEuroToDH")
    public double conversion(double montant) {
        return montant * 10.54;
    }
    @WebMethod
    public Compte getCompte(int code){
        return new Compte(code, Math.random() * 9000, new Date());
    }

    @WebMethod
    public List<Compte> listComptes(){
        return List.of(
                new Compte(1, Math.random() * 9000, new Date()),
                new Compte(2, Math.random() * 9000, new Date()),
                new Compte(3, Math.random() * 9000, new Date())
        );
    }
}
