
package hotel_management_system;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;


public class Checkout extends javax.swing.JFrame {

  
    public Checkout() {
        initComponents();
        //CusID.setEditable(false);
//        mobile.setEditable(false);
//        
       // CusID.setEditable(false);
        checkin.setEditable(false);
        checkout.setEditable(false);
        dayPrice.setEditable(false);
        noDays.setEditable(false);
        Tot.setEditable(false);  
        Connect();
        Show_Checkout();
    }
//int id=0;
String roomNo;
String BId;
    Connection con;
    PreparedStatement pst;// prepare statement object
    DefaultTableModel d;
    
    
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/HotelDB1?useTimezone=true&serverTimezone=UTC","root","");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Show_Checkout()
    {
    int c;
        try {
            pst= con.prepareStatement("select *from Booking where  CheckOut is NULL ");
             ResultSet rs = pst.executeQuery();
             
//            pst=con.prepareStatement("select*from Booking");
//            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsd =rs.getMetaData();
            c = rsd.getColumnCount();
            
            d=(DefaultTableModel)CheckoutTable.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2=new Vector();
                
                for (int i=1; i<=c; i++){
                    
                     v2.add(rs.getString("BookingID"));
                   
                    
                    v2.add(rs.getString("CustomerName"));
                    v2.add(rs.getString("Mobile"));
                    v2.add(rs.getString("Gender"));
                    v2.add(rs.getString("Address"));
                    v2.add(rs.getString("NIC"));
                     v2.add(rs.getString("Email"));
                      v2.add(rs.getString("Category"));
                    v2.add(rs.getString("RoomType"));
                     v2.add(rs.getString("RoomID"));
                      v2.add(rs.getString("CheckIN"));
                    v2.add(rs.getString("Price"));
//                      v2.add(rs.getString("CheckOut"));
//                      v2.add(rs.getString("NoDays"));
//                       v2.add(rs.getString("Total"));
                   
                     
//                    v2.add(rs.getString("BookingID"));
//                    v2.add(rs.getString("Category"));
//                    v2.add(rs.getString("RoomType"));
//                    v2.add(rs.getString("RoomID"));
//                    v2.add(rs.getString("CheckIn"));
//                    v2.add(rs.getString("Price"));
//                   
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
        bookingLnl = new javax.swing.JLabel();
        cusLbl = new javax.swing.JLabel();
        HomeBtn = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        AddBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        dayPrice = new javax.swing.JTextField();
        ClearBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        checkin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        noDays = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Tot = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        checkout = new javax.swing.JTextField();
        bookingID = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rNo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        mobno = new javax.swing.JTextField();
        cusname = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CheckoutTable = new javax.swing.JTable();

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

        bookingLnl.setBackground(new java.awt.Color(204, 255, 255));
        bookingLnl.setFont(new java.awt.Font("Times New Roman", 2, 28)); // NOI18N
        bookingLnl.setForeground(new java.awt.Color(255, 255, 255));
        bookingLnl.setText("CheckOut");
        bookingLnl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookingLnlMouseClicked(evt);
            }
        });

        cusLbl.setBackground(new java.awt.Color(204, 255, 255));
        cusLbl.setFont(new java.awt.Font("Times New Roman", 2, 28)); // NOI18N
        cusLbl.setForeground(new java.awt.Color(255, 255, 255));
        cusLbl.setText("CheckIn");
        cusLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cusLblMouseClicked(evt);
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
                .addGap(53, 53, 53)
                .addComponent(roomLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cusLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(bookingLnl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(cusLbl)
                    .addComponent(bookingLnl)
                    .addComponent(HomeBtn))
                .addContainerGap(20, Short.MAX_VALUE))
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

        jPanel4.setBackground(new java.awt.Color(44, 51, 47));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setForeground(new java.awt.Color(12, 43, 48));

        AddBtn.setBackground(new java.awt.Color(102, 102, 0));
        AddBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AddBtn.setText("Enter");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 255, 255));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price Per Day");

        dayPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayPriceActionPerformed(evt);
            }
        });

        ClearBtn.setBackground(new java.awt.Color(102, 102, 0));
        ClearBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ClearBtn.setText("Clear");
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(204, 255, 255));
        jLabel11.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Check In ");

        jLabel8.setBackground(new java.awt.Color(204, 255, 255));
        jLabel8.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("No. of Days");

        noDays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noDaysActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(204, 255, 255));
        jLabel9.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total Amount");

        Tot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(204, 255, 255));
        jLabel12.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Check Out ");

        bookingID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingIDActionPerformed(evt);
            }
        });

        search.setBackground(new java.awt.Color(102, 102, 0));
        search.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(204, 255, 255));
        jLabel13.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("BookingID");

        jLabel10.setBackground(new java.awt.Color(204, 255, 255));
        jLabel10.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Room No");

        rNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rNoActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(204, 255, 255));
        jLabel14.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Customer Name");

        cusname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cusnameActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(204, 255, 255));
        jLabel15.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Mobile No");

        jLabel16.setBackground(new java.awt.Color(204, 255, 255));
        jLabel16.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Email");

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Tot, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mobno, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cusname, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(22, 22, 22)
                                .addComponent(bookingID, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rNo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dayPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(noDays, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(AddBtn)
                        .addGap(52, 52, 52)
                        .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search)
                    .addComponent(bookingID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cusname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rNo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dayPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noDays, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tot, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(51, 51, 0));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 0));
        jLabel2.setText("Check Out");
        jLabel2.setToolTipText("");

        jScrollPane1.setBorder(new javax.swing.border.MatteBorder(null));

        CheckoutTable.setBackground(new java.awt.Color(204, 204, 204));
        CheckoutTable.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        CheckoutTable.setForeground(new java.awt.Color(0, 102, 102));
        CheckoutTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookingID", "Name", "MobileNo", "Gender", "Address", "NIC", "Email", "Category", "RoomType", "RoomNo", "CheckIn", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        CheckoutTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CheckoutTable.setGridColor(new java.awt.Color(0, 102, 102));
        CheckoutTable.setRowMargin(3);
        CheckoutTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CheckoutTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CheckoutTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 41, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roomLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomLblMouseClicked
         new Room_Hibernate_().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_roomLblMouseClicked

    private void bookingLnlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingLnlMouseClicked
        new Checkout().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bookingLnlMouseClicked

    private void cusLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cusLblMouseClicked
        new Customers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cusLblMouseClicked

    private void HomeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeBtnMouseClicked

        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeBtnMouseClicked

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
       bookingID.setEditable(true);
        String Name=cusname.getText();
        String Mobile=mobno.getText();
        String Checkin=checkin.getText();
       String Checkout=checkout.getText().toString();
       String Room=rNo.getText();
       String price=dayPrice.getText().toString();
       String nodays=noDays.getText().toString();
       String total=Tot.getText().toString();
        String Bid=bookingID.getText().toString();
        String Email=email.getText().toString();
          // roomNo=bookingID.getText().toString();
          
          String Path="E:\\";
          com.itextpdf.text.Document doc=new com.itextpdf.text.Document();
         
         try{
              pst= con.prepareStatement("Update Booking set NoDays='"+nodays+"',Total='"+total+"',CheckOut='"+Checkout+"'where BookingID='"+Bid+"' ");
              pst.executeUpdate();
              if(!Checkin.equals("")){
                 
                pst=con.prepareStatement("update room set Status='Available' where RoomID='"+Room+"'");
                 pst.executeUpdate();
               // InsertUpdateDelete.setData(Quary,"");
               
               PdfWriter.getInstance(doc, new FileOutputStream(Path+""+Bid+".pdf"));
                doc.open();
                Paragraph paragraph1=new Paragraph("                                                Hotel Management System\\n");      
                doc.add(paragraph1);
                   Paragraph paragraph2=new Paragraph("************************************************************************************");      
                doc.add(paragraph2);
                Paragraph paragraph3=new Paragraph("\tBill ID:"+Bid+"\nCustomer Details:\nName:"+Name+"\nMobile Number:"+Mobile+"\nEmail:"+Email+"\nRoom Details:\nRoom Number:"+Room+"\nPrice Per Day:"+price+"\n");      
                doc.add(paragraph3);
                 doc.add(paragraph2);
                 PdfPTable tb1=new PdfPTable(4);
                 tb1.addCell("Check IN Date: "+checkin.getText());
                  tb1.addCell("Check Out Date: "+checkout.getText());
                   tb1.addCell("No of Days Stay: "+noDays.getText());
                    tb1.addCell("Total Amount Paid: "+Tot.getText());
                    doc.add(tb1);
                    doc.add(paragraph2);
                     Paragraph paragraph4=new Paragraph(" Thank You, Please Visit Again... ");      
                doc.add(paragraph4);
                 
       }else{         
             
        }

//          pst=con.prepareStatement("update Booking set NoDays= ?,CheckOut= ?,Total=? where BookingID=? ");
//            pst.setString(1, nodays);
//            pst.setString(2, total);
//            pst.setString(3, Checkout);
//            pst.setString(4, RoomNo);
//            pst.executeUpdate();        
           
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
         doc.close();
         int a=JOptionPane.showConfirmDialog(null, "Do you want to print Bill","Select",JOptionPane.YES_NO_CANCEL_OPTION);
       if(a==0){
           try{
               if((new File("E:\\"+Bid+".pdf")).exists())
               {
                   Process p=Runtime
                           .getRuntime()
                           .exec("rundll32 url.dll,FileProtocolHandler E:\\"+Bid+".pdf");
                   
               }else{
                   System.out.println("File is not Exists");
               }
                   
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
           }
       }

    }//GEN-LAST:event_AddBtnActionPerformed

    private void dayPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayPriceActionPerformed

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
            bookingID.setText("");
            checkin.setText("");
            cusname.setText("");
            mobno.setText("");
            checkout.setText("");
            dayPrice.setText("");
            noDays.setText("");
            Tot.setText("");
            rNo.setText("");
             email.setText("");
   
            Show_Checkout();
            ClearBtn.setEnabled(true);
                        AddBtn.setEnabled(true);
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void noDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noDaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noDaysActionPerformed

    private void TotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotActionPerformed

    private void bookingIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookingIDActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String BId =bookingID.getText();
        try{

                pst= con.prepareStatement("select *from Booking where BookingID='"+BId+"' and CheckOut is NULL ");
             ResultSet Rs = pst.executeQuery();
             
              if(Rs.next()){
                 bookingID.setEditable(false);
                 cusname.setText(Rs.getString(7));
                 mobno.setText(Rs.getString(8));
                 checkin.setText(Rs.getString(5));
                 dayPrice.setText(Rs.getString(6));
                 email.setText(Rs.getString(12));
                  rNo.setText(Rs.getString(4));
                  bookingID.setText(Rs.getString(1));
                  SimpleDateFormat myformat =new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal =Calendar.getInstance();
        checkout.setText(myformat.format(cal.getTime()));
        String datebeforeString=Rs.getString(5);
        java.util.Date datebefore=myformat.parse(datebeforeString);
        String dateAfterString=myformat.format(cal.getTime());
         java.util.Date dateAfter=myformat.parse(dateAfterString);
         long difference=dateAfter.getTime()-datebefore.getTime();
         int noOfDayStay=(int)(difference/(1000*60*60*24));
         if(noOfDayStay==0)
             noOfDayStay=1;
         noDays.setText(String.valueOf(noOfDayStay));
         float Price=Float.parseFloat(dayPrice.getText());
         
         Tot.setText(String.valueOf(noOfDayStay*Price));
         
         
         
        
             }
              else{
              JOptionPane.showMessageDialog(null, "That Room is not booked or does not exist");
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_searchActionPerformed

    private void CheckoutTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckoutTableMouseClicked
//        d=(DefaultTableModel)CheckoutTable.getModel();
//        int selectIndex=CheckoutTable.getSelectedRow();
//
//        bookingNo.setText(d.getValueAt(selectIndex, 0).toString());
//        category.setSelectedItem(d.getValueAt(selectIndex, 1).toString());
//        roomtype.setSelectedItem(d.getValueAt(selectIndex, 2).toString());
//        roomno.setSelectedItem(d.getValueAt(selectIndex,3).toString());
//        checkin.setText(d.getValueAt(selectIndex, 4).toString());
//        price.setText(d.getValueAt(selectIndex, 5).toString());
//        AddBtn.setEnabled(false);
    }//GEN-LAST:event_CheckoutTableMouseClicked

    private void rNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rNoActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void cusnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cusnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cusnameActionPerformed

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
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Checkout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JTable CheckoutTable;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JLabel HomeBtn;
    private javax.swing.JTextField Tot;
    private javax.swing.JTextField bookingID;
    private javax.swing.JLabel bookingLnl;
    private javax.swing.JTextField checkin;
    private javax.swing.JTextField checkout;
    private javax.swing.JLabel cusLbl;
    private javax.swing.JTextField cusname;
    private javax.swing.JTextField dayPrice;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mobno;
    private javax.swing.JTextField noDays;
    private javax.swing.JTextField rNo;
    private javax.swing.JLabel roomLbl;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
