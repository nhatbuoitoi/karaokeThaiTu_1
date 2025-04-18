/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.QuanLyHoaDonDAO;
import dao.QuanLyPhongHatDAO;
import db.KetNoiDB;
import dto.HD_CTTP_CTDV_PH_KH_TK_DTO;
import dto.HoaDonChiTietTienPhongDTO;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author This PC
 */
public class XemChiTietPhongHatJFrame extends javax.swing.JFrame {
    QuanLyPhongHatDAO qlphDAO = new QuanLyPhongHatDAO();
    QuanLyHoaDonDAO qlhdDAO = new QuanLyHoaDonDAO();
    public int maPhongHat;
    Timer timer = new Timer(1000, (ActionEvent e) -> chayTime());
    /**
     * Creates new form XemChiTietPhongHatJFrame
     */
    public XemChiTietPhongHatJFrame(int maHoaDon, int maPhongHat) {
        this.maPhongHat = maPhongHat;
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fillTable();
        fillTbl();
        setText();
        timer.start();
        init();
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
    }
//    private void startTimer() {
//        timer = (1000, (ActionEvent e) -> chayTime() );
//        timer.start();
//    }
    
    public void chayTime(){
        fillTable();
        String so5 = tblDanhSach.getValueAt(0, 8).toString();
        txtTongTien.setText(so5);
    }
    
    private XemChiTietPhongHatJFrame() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void fillTbl(){
        int maHoaDon = (int) tblDanhSach.getValueAt(0, 0);
        double tong = qlhdDAO.readGiaTienPhongHat(maHoaDon) + qlhdDAO.readGiaTienDichVu(maHoaDon);
        tblDanhSach.setValueAt(tong, 0, 8);
        tblDanhSach.setValueAt(qlhdDAO.readGiaTienPhongHat(maHoaDon), 0, 6);
        tblDanhSach.setValueAt(qlhdDAO.readGiaTienDichVu(maHoaDon), 0, 7);
    }
    
    public void fillTable(){
        
        List<HD_CTTP_CTDV_PH_KH_TK_DTO> list = qlhdDAO.readHoaDon2(this.maPhongHat);
        
        
        DefaultTableModel model = (DefaultTableModel) tblDanhSach.getModel();
        model.setRowCount(0);
        for(HD_CTTP_CTDV_PH_KH_TK_DTO l : list){
            String trangThaiText = l.isTRANG_THAI() ? "Đang sử dụng" : "Trống";
            model.addRow(new Object[]{
                l.getMA_HOA_DON(),
                l.getMA_PHONG_HAT(),
                l.getTEN_PHONG_HAT(),
                l.getTEN_KHACH_HANG(),
                l.getHO_TEN(),
                l.getTHOI_GIAN_NHAN_PHONG(),
                0,
                0,
                0,
                trangThaiText
            }
            );
        }fillTbl();
    }
    
    public void setText(){
            String so0 = tblDanhSach.getValueAt(0, 0).toString();
            String so1 = tblDanhSach.getValueAt(0, 2).toString();
            String so2 = tblDanhSach.getValueAt(0, 3).toString();
            String so3 = tblDanhSach.getValueAt(0, 4).toString();
            String so4 = tblDanhSach.getValueAt(0, 5).toString();
            String so5 = tblDanhSach.getValueAt(0, 8).toString();
            
            txtMaHoaDon.setText(so0);
            txtTenPhongHat.setText(so1);
            txtTenTaiKhoan.setText(so3);
            txtTenKhachHang.setText(so2);
            txtGioDat.setText(so4);
            txtTongTien.setText(so5);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtTenPhongHat = new javax.swing.JTextField();
        btnlamMoi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGioDat = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        btnDichVu = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        txtTenTaiKhoan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(720, 727));
        setMinimumSize(new java.awt.Dimension(720, 727));
        setPreferredSize(new java.awt.Dimension(720, 727));

        txtTenPhongHat.setEditable(false);
        txtTenPhongHat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenPhongHatActionPerformed(evt);
            }
        });

        btnlamMoi.setText("LÀM MỚI");
        btnlamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlamMoiActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tên Tài Khoản");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tên Khách Hàng");

        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Mã Phòng Hát", "Tên Phòng Hát", "Tên Khách Hàng", "Tên Tài Khoản", "Giờ Đặt", "Tiền Phòng Hát", "Tiền Dịch Vụ", "Tổng Tiền", "Trạng Thái"
            }
        ));
        tblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSach);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(769, 85));
        jPanel1.setMinimumSize(new java.awt.Dimension(769, 85));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        jLabel1.setText("Xem Chi Tiết Phòng Hát");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Xem Chi Tiết Phòng");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Giờ đặt");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mã Hóa Đơn");

        txtMaHoaDon.setEditable(false);
        txtMaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHoaDonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tên Phòng Hát");

        txtGioDat.setEditable(false);
        txtGioDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGioDatActionPerformed(evt);
            }
        });

        jButton4.setText("TRẢ PHÒNG");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnDichVu.setText("DỊCH VỤ");
        btnDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDichVuActionPerformed(evt);
            }
        });

        btnQuayLai.setText("QUAY LẠI");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tổng Tiền");

        txtTongTien.setEditable(false);

        txtTenKhachHang.setEditable(false);

        txtTenTaiKhoan.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenPhongHat, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGioDat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(btnlamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTenPhongHat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtGioDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenPhongHatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenPhongHatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenPhongHatActionPerformed

    private void btnlamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlamMoiActionPerformed
        fillTable();
        String so5 = tblDanhSach.getValueAt(0, 8).toString();
        txtTongTien.setText(so5);
    }//GEN-LAST:event_btnlamMoiActionPerformed

    private void txtMaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHoaDonActionPerformed

    private void txtGioDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGioDatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGioDatActionPerformed

    private void btnDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDichVuActionPerformed
        int i = (int) tblDanhSach.getValueAt(0,1);
        int n = (int) tblDanhSach.getValueAt(0,0);
        DichVuChoPhongJFrame dichVuPhongJframe = new DichVuChoPhongJFrame(i, n);
        dichVuPhongJframe.setVisible(true);
    }//GEN-LAST:event_btnDichVuActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
        boolean ketQua = qlphDAO.traPhong((int) tblDanhSach.getValueAt(0, 1));
        
        if (ketQua) {
            timer.stop();
            qlphDAO.capNhatDonGiaChiTietTienPhong((int) tblDanhSach.getValueAt(0, 0));
            qlphDAO.traTien((int) tblDanhSach.getValueAt(0, 0));
            timer.stop();
            dispose(); // Đóng form hiện tại
            MainForm.setDefaultLookAndFeelDecorated(true);
        } else {
            JOptionPane.showMessageDialog(null, "Trả phòng thất bại!");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButton4ActionPerformed
    
    private void tblDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMouseClicked
            
    }//GEN-LAST:event_tblDanhSachMouseClicked

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        dispose(); // Đóng form hiện tại
        MainForm.setDefaultLookAndFeelDecorated(true);
    }//GEN-LAST:event_btnQuayLaiActionPerformed

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
            java.util.logging.Logger.getLogger(XemChiTietPhongHatJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XemChiTietPhongHatJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XemChiTietPhongHatJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XemChiTietPhongHatJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XemChiTietPhongHatJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDichVu;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnlamMoi;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextField txtGioDat;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTenPhongHat;
    private javax.swing.JTextField txtTenTaiKhoan;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.setLocationRelativeTo(null);
    }
}
