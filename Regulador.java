public class Regulador{

    public void apply(Market market){

        for(int i=0;i<10;i++){

            if(market.sellers[i].getSales()> market.getMeta()){
                market.sellers[i].setBonus();
            }
        }

        market.createTotal();
    
    }
}