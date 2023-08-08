
package mypkg;

public class TaxBean {
    private int income;
    private int age;
    private int tax;
    
    
    private int computeTax(){
         if(income>500000){
             tax = income *20/100;
         }else{
              tax = income *10/100;
        }
         return tax;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
        computeTax();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }
    
    
    
    
}
