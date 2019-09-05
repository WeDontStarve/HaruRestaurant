// default package



/**
 * Waiter entity. @author MyEclipse Persistence Tools
 */

public class Waiter  implements java.io.Serializable {


    // Fields    

     private Integer waiterId;
     private String waiterAccount;
     private String waiterPassword;
     private String waiterFaceing;
     private String waiterPhone;
     private Float waiterSalary;
     private Float waiterBonus;


    // Constructors

    /** default constructor */
    public Waiter() {
    }

    
    /** full constructor */
    public Waiter(String waiterAccount, String waiterPassword, String waiterFaceing, String waiterPhone, Float waiterSalary, Float waiterBonus) {
        this.waiterAccount = waiterAccount;
        this.waiterPassword = waiterPassword;
        this.waiterFaceing = waiterFaceing;
        this.waiterPhone = waiterPhone;
        this.waiterSalary = waiterSalary;
        this.waiterBonus = waiterBonus;
    }

   
    // Property accessors

    public Integer getWaiterId() {
        return this.waiterId;
    }
    
    public void setWaiterId(Integer waiterId) {
        this.waiterId = waiterId;
    }

    public String getWaiterAccount() {
        return this.waiterAccount;
    }
    
    public void setWaiterAccount(String waiterAccount) {
        this.waiterAccount = waiterAccount;
    }

    public String getWaiterPassword() {
        return this.waiterPassword;
    }
    
    public void setWaiterPassword(String waiterPassword) {
        this.waiterPassword = waiterPassword;
    }

    public String getWaiterFaceing() {
        return this.waiterFaceing;
    }
    
    public void setWaiterFaceing(String waiterFaceing) {
        this.waiterFaceing = waiterFaceing;
    }

    public String getWaiterPhone() {
        return this.waiterPhone;
    }
    
    public void setWaiterPhone(String waiterPhone) {
        this.waiterPhone = waiterPhone;
    }

    public Float getWaiterSalary() {
        return this.waiterSalary;
    }
    
    public void setWaiterSalary(Float waiterSalary) {
        this.waiterSalary = waiterSalary;
    }

    public Float getWaiterBonus() {
        return this.waiterBonus;
    }
    
    public void setWaiterBonus(Float waiterBonus) {
        this.waiterBonus = waiterBonus;
    }
   








}