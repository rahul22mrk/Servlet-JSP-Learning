
package mypkg;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MedicineDao {
    private Connection con;
    
    public MedicineDao(){
        try{
             Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddata","root","root@123RK");
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
    
    
    //we will pass the values for a record and save method should enter those values to db
    public int saveMedicine(Medicine medicine){
        //this method save the details of this object to database
      int status = 0;
        try{
            String sql = "insert into medicines values (?,?,?,?)";  
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, medicine.getCode());
            ps.setString(2, medicine.getName());
            ps.setString(3, medicine.getType());
            ps.setInt(4, medicine.getPrice());
            ps.executeUpdate();
            System.out.println("Data Stored...");
        status =1;
        }catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }
    
    public  Medicine searchMedicine(int code){
           //this method search the data from database
        Medicine medicine = new Medicine();
        try{
            String sql = "select * from medicines where code = ?";  
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,code);
           ResultSet rs = ps.executeQuery();
            //we will store the data of resultset into model and return the model
            rs.next();
            medicine.setCode(rs.getInt("code"));
            medicine.setName(rs.getString("name"));
            medicine.setType(rs.getString("type"));
            medicine.setPrice(rs.getInt("price"));
        
        }catch(Exception e){
            e.printStackTrace();
        }
        return medicine;
    }
    
    public void updateMedicine(){
        
    }
    
    public void deleteMedicine(int code){
         try{
            String sql = "delete from medicines where code = ?";  
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,code);
          ps.executeUpdate();
           System.out.println("Record Deleted");
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
   /* public static void main(String args[]){
        //testing the search and save method
//        Medicine medicine = new Medicine();
//        medicine.setCode(111);
//        medicine.setName("xyz");
//        medicine.setType("abc");
//        medicine.setPrice(56);
//        
//        MedicineDao medicineDao = new MedicineDao();
//        medicineDao.saveMedicine(medicine);

  MedicineDao medicineDao = new MedicineDao();
  //Medicine medicine = medicineDao.searchMedicine(1);
     //   System.out.println(medicine.getName());
     medicineDao.deleteMedicine(111);
     System.out.println("Completed");
    }*/
}
