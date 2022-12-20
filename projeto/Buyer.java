import java.util.Random;

public class Buyer{

    private int purchasing;
    private int totalPurchasing;

    private static final Random random = new Random();

    public int getTotalPurchasing(){
        return totalPurchasing;
    }

    public void purchase(Seller salesinto){
        purchasing = random.nextInt(1000);
        salesinto.pagamento(purchasing);
        totalPurchasing+=purchasing;
    }

}