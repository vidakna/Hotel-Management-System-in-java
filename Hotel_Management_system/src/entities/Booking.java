package entities;
// Generated Aug 6, 2022 11:15:07 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Booking"
    ,catalog="HotelDB1"
)
public class Booking  implements java.io.Serializable {


     private String bookingId;
     private String category;
     private String roomType;
     private String roomId;
     private Date checkIn;
     private float price;
     private String customerName;
     private String mobile;
     private String gender;
     private String address;
     private String nic;
     private String email;
     private Date checkOut;
     private Integer noDays;
     private Double total;

    public Booking() {
    }

	
    public Booking(String bookingId, String category, String roomType, String roomId, Date checkIn, float price, String customerName, String mobile, String gender, String address, String nic, String email) {
        this.bookingId = bookingId;
        this.category = category;
        this.roomType = roomType;
        this.roomId = roomId;
        this.checkIn = checkIn;
        this.price = price;
        this.customerName = customerName;
        this.mobile = mobile;
        this.gender = gender;
        this.address = address;
        this.nic = nic;
        this.email = email;
    }
    public Booking(String bookingId, String category, String roomType, String roomId, Date checkIn, float price, String customerName, String mobile, String gender, String address, String nic, String email, Date checkOut, Integer noDays, Double total) {
       this.bookingId = bookingId;
       this.category = category;
       this.roomType = roomType;
       this.roomId = roomId;
       this.checkIn = checkIn;
       this.price = price;
       this.customerName = customerName;
       this.mobile = mobile;
       this.gender = gender;
       this.address = address;
       this.nic = nic;
       this.email = email;
       this.checkOut = checkOut;
       this.noDays = noDays;
       this.total = total;
    }
   
     @Id 

    
    @Column(name="BookingID", unique=true, nullable=false, length=50)
    public String getBookingId() {
        return this.bookingId;
    }
    
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    
    @Column(name="Category", nullable=false, length=50)
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    
    @Column(name="RoomType", nullable=false, length=10)
    public String getRoomType() {
        return this.roomType;
    }
    
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    
    @Column(name="RoomID", nullable=false, length=50)
    public String getRoomId() {
        return this.roomId;
    }
    
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CheckIN", nullable=false, length=10)
    public Date getCheckIn() {
        return this.checkIn;
    }
    
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    
    @Column(name="Price", nullable=false, precision=12, scale=0)
    public float getPrice() {
        return this.price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }

    
    @Column(name="CustomerName", nullable=false)
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    
    @Column(name="Mobile", nullable=false, length=10)
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    
    @Column(name="Gender", nullable=false, length=10)
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    
    @Column(name="Address", nullable=false)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="NIC", nullable=false, length=12)
    public String getNic() {
        return this.nic;
    }
    
    public void setNic(String nic) {
        this.nic = nic;
    }

    
    @Column(name="Email", nullable=false, length=50)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CheckOut", length=10)
    public Date getCheckOut() {
        return this.checkOut;
    }
    
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    
    @Column(name="NoDays")
    public Integer getNoDays() {
        return this.noDays;
    }
    
    public void setNoDays(Integer noDays) {
        this.noDays = noDays;
    }

    
    @Column(name="Total", precision=22, scale=0)
    public Double getTotal() {
        return this.total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }




}


