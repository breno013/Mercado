public class Market {
    
    private int goal;
    private int totalSold;
    private String localization;
    private String name;

    Seller[] sellers;

    public int getTotal(){
        return totalSold;
    }    

    public String getLocal(){
        return localization;
    }

    public Seller[] getSelleres(){
        return sellers;
    }

    public int getMeta(){
        return this.goal;
    }

    public void createTotal(){
        for (int i=0;i<10;i++){
            totalSold+=sellers[i].getSales();
        }
    }

    public String getNome(){
        return name;
    }

    public String toString(){
        return 
                "================================" +
                "\nLocal: " + getLocal()+
                "\nNome: " + getNome()+
                "\nMeta de vendas: R$" + getMeta() + ",00" +
                "\nTotal vendido: R$" + getTotal() + ",00";
    }

    public Market(Seller[] sellers, int goal, String localization, String nameMarket) {
        this.sellers = sellers;
        this.goal = goal;
        this.localization = localization;
        name = nameMarket;
    }


}