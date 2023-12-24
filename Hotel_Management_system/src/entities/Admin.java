package entities;
// Generated Aug 6, 2022 11:15:07 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Admin"
    ,catalog="HotelDB1"
)
public class Admin  implements java.io.Serializable {


     private String adminId;
     private String userName;
     private String password;

    public Admin() {
    }

    public Admin(String adminId, String userName, String password) {
       this.adminId = adminId;
       this.userName = userName;
       this.password = password;
    }
   
     @Id 

    
    @Column(name="AdminID", unique=true, nullable=false, length=10)
    public String getAdminId() {
        return this.adminId;
    }
    
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    
    @Column(name="UserName", nullable=false, length=40)
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    @Column(name="Password", nullable=false, length=40)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


