public class Seller{
    private int valueSales;
    private int bonus;

    private String name;
    
    public int getSales(){
        return valueSales;
    }

    public String getNomes(){
        return name;
    }

    public int getBonus(){
        return bonus;
    }

    public void pagamento(int value){
        this.valueSales+=value;
    }

    public Seller(String name){
        this.name=name;
    }

    public void setBonus(){
        bonus = (int) (valueSales*0.1);
    }

    public String toString(){
        return getNomes() +
                " vendeu R$" + getSales()+
                ",00 e foi bonificado com R$"
                 + getBonus()+ ",00";
    }

}