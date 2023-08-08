
package mypkg;

import mypkg.Medicine;
import mypkg.MedicineDao;

public class MedicineService {
    private MedicineDao dao;
    
    public MedicineService(){
        dao = new MedicineDao();
    }
    public int getDiscounterPrice(int price){
        if(price>500){
            price = price - (price*20/100);
        }else{
            price = price - (price*10/100);
        }
        return price;
    }
    
    public int save(Medicine medicine){
        int status= 0;
        try{
             
             status =dao.saveMedicine(medicine); 
        }catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }
    
    public Medicine search(int code){
        Medicine medicine = null;
         try{
             medicine= dao.searchMedicine(code);
        }catch(Exception e){
            e.printStackTrace();
        }
         return  medicine;
    }
    
    public void delete(int code){
         try{
             dao.deleteMedicine(code);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
