import java.util.Random;
public class Desafio {
    
    private static final String[]names = new String[]{"name1","name2","name3","name4","name5","name6","name7","name8","name9","name10"};
    private static final Random random = new Random();

   public static void main(String[] args) {

        Seller []saleMarket1 = new Seller[10];
        Seller []saleMarket2 = new Seller[10];
        Seller []saleMarket3 = new Seller[10];
        
        Market market1 = new Market(saleMarket1,300,"São Paulo","Market 1");
        Market market2 = new Market(saleMarket2,500,"Rio de Janeiro","Market 2");
        Market market3 = new Market(saleMarket3,700,"Pará","Market 3");

        saleMarket1=createSeller(saleMarket1);
        saleMarket2=createSeller(saleMarket2);
        saleMarket3=createSeller(saleMarket3);

        Buyer buyer = new Buyer();
        Regulador regulador = new Regulador();

        for (int i=0;i<10;i++){
            buyer.purchase(market1.sellers[i]);
            buyer.purchase(market2.sellers[i]);
            buyer.purchase(market3.sellers[i]);
        }

        regulador.apply(market1);
        regulador.apply(market2);
        regulador.apply(market3);

        print(market1);
        System.out.printf("\n\n");
        print(market2);
        System.out.printf("\n\n");
        print(market3);
        System.out.printf("\n\n");

        checkGreater(market1,market2,market3);
        System.out.printf("\n\n");

        higherProfit(market1,market2,market3);
    }

    public static void checkGreater(Market market1,Market market2,Market market3){
        Seller []higher= new Seller[3];

        higher[0]=market1.sellers[0];
        higher[0].pagamento(0);
        higher[1]=higher[0];
        higher[2]=higher[0];

        String[] higherMarket= new String[3];

        for (int i=0;i<3;i++){
            for (int j = 0; j < 10; j++) {
                if(i==0) {
                    if (market1.sellers[j].getSales() > higher[i].getSales()) {
                        higher[i] = market1.sellers[j];
                        higherMarket[i] = market1.getNome();
                    }
                    if (market2.sellers[j].getSales() > higher[i].getSales()) {
                        higher[i] = market2.sellers[j];
                        higherMarket[i] = market2.getNome();
                    }
                    if (market3.sellers[j].getSales() > higher[i].getSales()) {
                        higher[i] = market3.sellers[j];
                        higherMarket[i] = market3.getNome();
                    }
                    }
                else{
                    if (market1.sellers[j].getSales()>higher[i].getSales() &&
                            market1.sellers[j].getSales()<higher[i-1].getSales()){
                        higher[i]=market1.sellers[j];
                        higherMarket[i]=market1.getNome();
                    }
                    if (market2.sellers[j].getSales()>higher[i].getSales() &&
                            market2.sellers[j].getSales()<higher[i-1].getSales()){
                        higher[i]=market2.sellers[j];
                        higherMarket[i]=market2.getNome();
                    }
                    if (market3.sellers[j].getSales()>higher[i].getSales() &&
                            market3.sellers[j].getSales()<higher[i-1].getSales()){
                        higher[i]=market3.sellers[j];
                        higherMarket[i]=market3.getNome();
                }
                }
            }
        }

        System.out.println("====== Ranking Market ======");
        for (int i=0;i<3;i++){
            System.out.println((i+1)+"º lugar | "+
                    higher[i].getNomes()+
                    " | Venda: R$ "+ higher[i].getSales() + ",00" +
                    " | " + higherMarket[i]);
        }
    }


    public static Seller[] createSeller(Seller[] salesinto){

        for (int i=0;i< 10;i++){
            int indexName = random.nextInt(names.length);
            String name = names[indexName];
            salesinto[i]=new Seller(name);
        }
        return salesinto;
    }


    public static void print(Market market){
        System.out.println(market);
        System.out.println("\nREMUNERAÇÃO:");

        for(int i=0;i<10;i++){
            System.out.println(market.sellers[i]);
        }
    }


    public static void higherProfit(Market market1, Market market2, Market market3){
        int l1=market1.getTotal();
        int l2=market2.getTotal();
        int l3=market3.getTotal();

        String textoResposta = "MERCADO MAIS LUCRATIVO: \n"; 

        if(l1>l2 && l1>l3){
            System.out.println(textoResposta +market1.getNome());
        }
        if(l2>l1 && l2>l3){
            System.out.println(textoResposta +market2.getNome());
        }
        if(l3>l1 && l3>l2) {
            System.out.println(textoResposta +market3.getNome());
        }
    }

}