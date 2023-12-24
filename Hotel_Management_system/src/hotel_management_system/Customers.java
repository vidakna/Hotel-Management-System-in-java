
package hotel_management_system;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import javafx.scene.control.Dialog;
import javafx.scene.control.Alert.AlertType;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class Customers extends javax.swing.JFrame {

    
    public Customers() {
        initComponents();
         
         roomno.removeAllItems();
          price.setText("");
//            category.setSelectedIndex(-1);
//            roomno.setSelectedIndex(-1);
//            roomtype.setSelectedIndex(-1);
        Connect();
        autoID();
        Show_Customer();
        //autoId();
        RoomNo();
       // roomDetails();
      //   validateEmail();
       //  ValidateEmail();
        
         SimpleDateFormat myformat =new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal =Calendar.getInstance();
        checkin.setText(myformat.format(cal.getTime()));
        
    }

    Connection con;
    PreparedStatement pst;// prepare statement object
    DefaultTableModel d;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/HotelDB?useTimezone=true&serverTimezone=UTC","root","");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     String Category;
    String RoomType;
    String roomNo;
    String Price;
   
public void roomDetails(){
    
    roomno.removeAllItems();
    price.setText("");
    
    Category=(String)category.getSelectedItem();
    RoomType=(String)roomtype.getSelectedItem();
    
    try{
      //  ResultSet rs =Select.getData("select *from Room where Category='"+Category+"' and Type='"+RoomType+"' and Status='Available'");
        
        pst= con.prepareStatement("select *from Room where Category='"+Category+"' and Type='"+RoomType+"' and Status='Available'");
             ResultSet rs = pst.executeQuery();
             
               while(rs.next()){
                 roomno.addItem(rs.getString(1));
             }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
}

//public boolean validateEmail(){
//    
//    Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
//    Matcher m = p.matcher(email.getText());
//    if(m.find() && m.group().equals(email.getText())){
//        return true;
//    }else{
//        Alert alert = new Alert(AlertType.WARNING);
//        alert.setTitle("Validate Email");
//        alert.setHeaderText(null);
//        alert.setContentText("Please Enter valid Email");
//        alert.showAndWait();
//        
//        return false;
//    }
//    
//}
//public void ValidateEmail(){
//    if (!(Pattern.matches("((?=.*\\\\ d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})", email.getText()))) 
//{
//            JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "The email is valid", "Good!", JOptionPane.INFORMATION_MESSAGE);
//
//            }
//
//}


 public void autoID(){
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery("select MAX(BookingID) from Booking");
            rs.next();
            rs.getString("Max(BookingID)");
            
            if(rs.getString ("Max(BookingID)")== null)
            {
                bookingNo.setText("B0001");
               
            }
            else{
                long id = Long.parseLong(rs.getString("Max(BookingID)").substring(2,rs.getString("Max(BookingID"
                        + ")").length()));
                id++;
                bookingNo.setText("B0"+String.format("%03d", id));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


      public void RoomNo(){
        try {
            pst= con.prepareStatement("select Distinct RoomID from Room ");
             ResultSet rs = pst.executeQuery();
             roomno.removeAllItems();
             
             while(rs.next()){
                 roomno.addItem(rs.getString("RoomID"));
             }
        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
         
      }
    
    
      public void Show_Customer()
    {
    int c;
        try {
            pst=con.prepareStatement("select*from Booking");
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsd =rs.getMetaData();
            c = rsd.getColumnCount();
            
            d=(DefaultTableModel)CustomerTable.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2=new Vector();
                
                for (int i=1; i<=c; i++){
                    v2.add(rs.getString("BookingID"));
                    v2.add(rs.getString("RoomID"));
                    v2.add(rs.getString("CustomerName"));
                    v2.add(rs.getString("Mobile"));
                    v2.add(rs.getString("Gender"));
                    v2.add(rs.getString("Address"));
                    v2.add(rs.getString("NIC"));
                     v2.add(rs.getString("Email"));
                    v2.add(rs.getString("Category"));
                    v2.add(rs.getString("RoomType"));
                    
                    v2.add(rs.getString("Price"));
                }
                d.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        roomLbl = new javax.swing.JLabel();
        bookingLbl = new javax.swing.JLabel();
        customerLbl = new javax.swing.JLabel();
        HomeBtn = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cusNo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        AddBtn = new javax.swing.JButton();
        customerMob = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cusGender = new javax.swing.JComboBox<>();
        customerName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        cusAdd = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ClearBtn = new javax.swing.JButton();
        customerNIC = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        category = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        roomno = new javax.swing.JComboBox<>();
        roomtype = new javax.swing.JComboBox<>();
        checkin = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        bookingNo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomerTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 51, 6));

        roomLbl.setBackground(new java.awt.Color(204, 255, 255));
        roomLbl.setFont(new java.awt.Font("Times New Roman", 2, 28)); // NOI18N
        roomLbl.setForeground(new java.awt.Color(255, 255, 255));
        roomLbl.setText("Room");
        roomLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomLblMouseClicked(evt);
            }
        });

        bookingLbl.setBackground(new java.awt.Color(204, 255, 255));
        bookingLbl.setFont(new java.awt.Font("Times New Roman", 2, 28)); // NOI18N
        bookingLbl.setForeground(new java.awt.Color(255, 255, 255));
        bookingLbl.setText("CheckOut");
        bookingLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookingLblMouseClicked(evt);
            }
        });

        customerLbl.setBackground(new java.awt.Color(204, 255, 255));
        customerLbl.setFont(new java.awt.Font("Times New Roman", 2, 28)); // NOI18N
        customerLbl.setForeground(new java.awt.Color(255, 255, 255));
        customerLbl.setText("CheckIn");
        customerLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerLblMouseClicked(evt);
            }
        });

        HomeBtn.setBackground(new java.awt.Color(204, 255, 255));
        HomeBtn.setFont(new java.awt.Font("Times New Roman", 2, 28)); // NOI18N
        HomeBtn.setForeground(new java.awt.Color(255, 255, 255));
        HomeBtn.setText("Home");
        HomeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(roomLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(bookingLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomLbl)
                    .addComponent(customerLbl)
                    .addComponent(bookingLbl)
                    .addComponent(HomeBtn))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 0));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Vivaldi", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(216, 216, 83));
        jLabel1.setText("TongueTaster");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(385, 385, 385))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        cusNo.setBackground(new java.awt.Color(44, 51, 47));
        cusNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cusNo.setForeground(new java.awt.Color(12, 43, 48));

        jLabel3.setBackground(new java.awt.Color(204, 255, 255));
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mobile");

        AddBtn.setBackground(new java.awt.Color(102, 102, 0));
        AddBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AddBtn.setText("Allocate");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        customerMob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerMobActionPerformed(evt);
            }
        });
        customerMob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customerMobKeyReleased(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(204, 255, 255));
        jLabel5.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gender");

        jLabel6.setBackground(new java.awt.Color(204, 255, 255));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Address");

        cusGender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cusGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male", " " }));
        cusGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cusGenderActionPerformed(evt);
            }
        });
        cusGender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cusGenderKeyReleased(evt);
            }
        });

        customerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameActionPerformed(evt);
            }
        });

        cusAdd.setColumns(20);
        cusAdd.setRows(5);
        jScrollPane2.setViewportView(cusAdd);

        jLabel10.setBackground(new java.awt.Color(204, 255, 255));
        jLabel10.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("NIC");

        jLabel12.setBackground(new java.awt.Color(204, 255, 255));
        jLabel12.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Name");

        ClearBtn.setBackground(new java.awt.Color(102, 102, 0));
        ClearBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ClearBtn.setText("Clear");
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        customerNIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNICActionPerformed(evt);
            }
        });
        customerNIC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customerNICKeyReleased(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(44, 51, 47));
        jPanel4.setForeground(new java.awt.Color(12, 43, 48));

        jLabel7.setBackground(new java.awt.Color(204, 255, 255));
        jLabel7.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Room Type");

        jLabel8.setBackground(new java.awt.Color(204, 255, 255));
        jLabel8.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Room No.");

        jLabel9.setBackground(new java.awt.Color(204, 255, 255));
        jLabel9.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Price");

        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });

        category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single Bed", "Double Bed", "Triple Bed", "Family", "VIP" }));
        category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                categoryMousePressed(evt);
            }
        });
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(204, 255, 255));
        jLabel11.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Category");

        jLabel14.setBackground(new java.awt.Color(204, 255, 255));
        jLabel14.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Check In ");

        roomno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        roomno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomnoActionPerformed(evt);
            }
        });

        roomtype.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        roomtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A/C", "Non A/C", " " }));
        roomtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomtypeActionPerformed(evt);
            }
        });

        checkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(roomno, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roomtype, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(category, javax.swing.GroupLayout.Alignment.LEADING, 0, 215, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(price, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addComponent(checkin, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roomtype, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roomno, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        jLabel15.setBackground(new java.awt.Color(204, 255, 255));
        jLabel15.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Email");

        email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emailMouseExited(evt);
            }
        });
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailKeyTyped(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(204, 255, 255));
        jLabel16.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Booking No.");

        bookingNo.setBackground(new java.awt.Color(255, 204, 102));
        bookingNo.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        bookingNo.setForeground(new java.awt.Color(204, 153, 0));
        bookingNo.setText("B0001");

        javax.swing.GroupLayout cusNoLayout = new javax.swing.GroupLayout(cusNo);
        cusNo.setLayout(cusNoLayout);
        cusNoLayout.setHorizontalGroup(
            cusNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cusNoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AddBtn)
                .addGap(47, 47, 47)
                .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(cusNoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(cusNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cusNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                        .addComponent(cusGender, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customerMob, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(customerName, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(customerNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(email)
                    .addGroup(cusNoLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bookingNo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        cusNoLayout.setVerticalGroup(
            cusNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cusNoLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(cusNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cusNoLayout.createSequentialGroup()
                        .addGroup(cusNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(bookingNo))
                        .addGap(45, 45, 45)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerMob, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cusGender, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(cusNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setBackground(new java.awt.Color(51, 51, 0));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 0));
        jLabel2.setText("Customer CheckIn");
        jLabel2.setToolTipText("");

        jScrollPane1.setBorder(new javax.swing.border.MatteBorder(null));

        CustomerTable.setBackground(new java.awt.Color(204, 204, 204));
        CustomerTable.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        CustomerTable.setForeground(new java.awt.Color(0, 102, 102));
        CustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Booking No", "RoomNo", "Name", "Mobile", "Gender", "Address", "NIC", "Email", "Category", "RoomType", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        CustomerTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CustomerTable.setGridColor(new java.awt.Color(0, 102, 102));
        CustomerTable.setRowMargin(3);
        CustomerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CustomerTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cusNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(cusNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeBtnMouseClicked
       
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeBtnMouseClicked

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        
         String BNo= bookingNo.getText().toString();
        String Category= category.getSelectedItem().toString();
        String RoomType= roomtype.getSelectedItem().toString();
        String Roomno= roomno.getSelectedItem().toString();
        String CheckIn=checkin.getText();
        String Price= price.getText().toString();
         // String cusNo= customerNo.getText().toString();
          String cName= customerName.getText().toString();
          String cMob= customerMob.getText().toString();
          String cGen=cusGender.getSelectedItem().toString();
          String cAdd= cusAdd.getText().toString();
         String cNIC= customerNIC.getText().toString();
        String Email=email.getText().toString();
          
          if(customerName.getText().isEmpty() || customerMob.getText().isEmpty() || cusGender.getSelectedIndex()==-1 || customerNIC.getText().isEmpty() || category.getSelectedIndex()==-1 || roomtype.getSelectedIndex()== -1 || roomno.getSelectedIndex()==-1 ||price.getText().isEmpty()||email.getText().isEmpty() ){
            JOptionPane.showMessageDialog(this, "Missing Data! ");
           
    
         }else if(!(cMob.matches("[0][0-9]*$")&& cMob.length()==10) )
         {
             JOptionPane.showMessageDialog(null, "Please enter a valid Phone Number", "Error", JOptionPane.ERROR_MESSAGE);
             
             
         }else if((!(cNIC.matches("[0-9]*[vV]") && cNIC.length()==10 )) && (!(cNIC.matches("[0-9]*") && cNIC.length()==12)))
         {
             JOptionPane.showMessageDialog(null, "Please enter a valid NIC Number", "Error", JOptionPane.ERROR_MESSAGE);
             
           
                 
         }else if(!(Pattern.matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+", email.getText())))
         {
             JOptionPane.showMessageDialog(null, "Please enter a valid Email Address", "Error", JOptionPane.ERROR_MESSAGE);
             
             
         }
          else{
        try {
            
             if(!price.equals("")){
                 
                pst=con.prepareStatement("update Room set Status='Booked' where RoomID='"+roomNo+"'");
                 pst.executeUpdate();
               // InsertUpdateDelete.setData(Quary,"");
               
       }else{
           
        }
            pst=con.prepareStatement("insert into Booking(BookingID,Category,RoomType,RoomID,CheckIn,Price,CustomerName,Mobile,Gender,Address,NIC,Email) values(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, BNo);
            pst.setString(2, Category);
            pst.setString(3, RoomType);
            pst.setString(4, Roomno);
             pst.setString(5,CheckIn);
            pst.setString(6,Price);
           // pst.setString(7,cusNo);
            pst.setString(7,cName);
            pst.setString(8,cMob);
            pst.setString(9,cGen);
            pst.setString(10,cAdd);
            pst.setString(11,cNIC);
             pst.setString(12,Email);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Booking added Succsessfully !!! ");
            
            customerName.setText("");
            customerMob.setText("");
            cusGender.setSelectedIndex(-1);
            cusAdd.setText("");
             customerNIC.setText("");
              price.setText("");
            category.setSelectedIndex(-1);
            roomno.setSelectedIndex(-1);
            roomtype.setSelectedIndex(-1);
              email.setText("");
            autoID();
            
           // autoId();
            Show_Customer();
            AddBtn.setEnabled(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddBtnActionPerformed
    }
    private void customerMobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerMobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerMobActionPerformed

    private void cusGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cusGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cusGenderActionPerformed

    private void customerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameActionPerformed

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
              customerName.setText("");
            customerMob.setText("");
            cusGender.setSelectedIndex(-1);
            cusAdd.setText("");
             customerNIC.setText("");
              price.setText("");
            category.setSelectedIndex(-1);
            roomno.setSelectedIndex(-1);
            roomtype.setSelectedIndex(-1);
              email.setText("");
            autoID();
            Show_Customer();
            ClearBtn.setEnabled(true);
                        AddBtn.setEnabled(true);

    }//GEN-LAST:event_ClearBtnActionPerformed

    private void CustomerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerTableMouseClicked
        d=(DefaultTableModel)CustomerTable.getModel();
        int selectIndex=CustomerTable.getSelectedRow();
          
        bookingNo.setText(d.getValueAt(selectIndex, 0).toString());
         roomno.setSelectedItem(d.getValueAt(selectIndex,1).toString());
        customerName.setText(d.getValueAt(selectIndex, 2).toString());
        customerMob.setText(d.getValueAt(selectIndex, 3).toString());
        cusGender.setSelectedItem(d.getValueAt(selectIndex, 4).toString());
        cusAdd.setText(d.getValueAt(selectIndex, 5).toString());
        customerNIC.setText(d.getValueAt(selectIndex, 6).toString());
         email.setText(d.getValueAt(selectIndex, 7).toString());
          category.setSelectedItem(d.getValueAt(selectIndex,8).toString());
           roomtype.setSelectedItem(d.getValueAt(selectIndex,9).toString());
             price.setText(d.getValueAt(selectIndex, 10).toString());
         
     
        AddBtn.setEnabled(false);
    }//GEN-LAST:event_CustomerTableMouseClicked

    private void roomLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomLblMouseClicked
      new Room_Hibernate_().setVisible(true);
        this.dispose();     
    }//GEN-LAST:event_roomLblMouseClicked

    private void customerLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerLblMouseClicked
    new Customers().setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_customerLblMouseClicked

    private void bookingLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingLblMouseClicked
         new Checkout().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bookingLblMouseClicked

    private void customerNICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNICActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
    
        roomDetails();
    }//GEN-LAST:event_categoryActionPerformed

    private void roomnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomnoActionPerformed
       roomNo=(String)roomno.getSelectedItem();
       try{
           
          pst= con.prepareStatement( "select *from Room where RoomID='"+roomNo+"'");
             ResultSet rs = pst.executeQuery();
             
               while(rs.next()){
                 price.setText(rs.getString(6));
             }                                      
       }catch(Exception e){
           
       }
    }//GEN-LAST:event_roomnoActionPerformed

    private void roomtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomtypeActionPerformed
        roomDetails();
    }//GEN-LAST:event_roomtypeActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
       


    }//GEN-LAST:event_emailActionPerformed

    private void emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyReleased
        // TODO add your handling code here:
        if (!(Pattern.matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+", email.getText()))) 
{
           Border border = new LineBorder(Color.red, 4, true);
            email.setBorder( border);
            }
            else
            {
               Border border = new LineBorder(Color.white, 4, true);
            email.setBorder( border);

            }
    }//GEN-LAST:event_emailKeyReleased

    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_emailKeyTyped

    private void emailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailMouseExited
        // TODO add your handling code here:
        

    }//GEN-LAST:event_emailMouseExited

    private void categoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryMousePressed
        // TODO add your handling code here
//         if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", email.getText()))) 
//{
//            JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//            else
//            {
//               // JOptionPane.showMessageDialog(null, "The email is valid", "Good!", JOptionPane.INFORMATION_MESSAGE);
//
//            }

    }//GEN-LAST:event_categoryMousePressed

    private void cusGenderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cusGenderKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cusGenderKeyReleased

    private void customerMobKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerMobKeyReleased
        // TODO add your handling code here:
        String mob=customerMob.getText();
        if(mob.matches("[0][0-9]*$")&& mob.length()==10){
             Border border = new LineBorder(Color.white, 4, true);
            customerMob.setBorder( border);
        }else{
            Border border = new LineBorder(Color.red, 4, true);
            customerMob.setBorder( border);
        }
        
    }//GEN-LAST:event_customerMobKeyReleased

    private void customerNICKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerNICKeyReleased
        // TODO add your handling code here:
        String NIC=customerNIC.getText();
        if (NIC.matches("[0-9]*[vV]") && NIC.length()==10 )  
{
           Border border = new LineBorder(Color.white, 4, true);
            customerNIC.setBorder( border);
            
            }else if(NIC.matches("[0-9]*") && NIC.length()==12){
                Border border = new LineBorder(Color.white, 4, true);
            customerNIC.setBorder( border);
            }
            else
            {
               Border border = new LineBorder(Color.red, 4, true);
            customerNIC.setBorder( border);

            }
    }//GEN-LAST:event_customerNICKeyReleased

    private void checkinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkinActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JTable CustomerTable;
    private javax.swing.JLabel HomeBtn;
    private javax.swing.JLabel bookingLbl;
    private javax.swing.JLabel bookingNo;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JTextField checkin;
    private javax.swing.JTextArea cusAdd;
    private javax.swing.JComboBox<String> cusGender;
    private javax.swing.JPanel cusNo;
    private javax.swing.JLabel customerLbl;
    private javax.swing.JTextField customerMob;
    private javax.swing.JTextField customerNIC;
    private javax.swing.JTextField customerName;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField price;
    private javax.swing.JLabel roomLbl;
    private javax.swing.JComboBox<String> roomno;
    private javax.swing.JComboBox<String> roomtype;
    // End of variables declaration//GEN-END:variables

}
