/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.view;

import app.model.Customer;
import app.service.CustomerService;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CustomerView extends javax.swing.JFrame {
    
    private Customer customer;
    private DefaultTableModel tableModel;
    private CustomerService service;
    private ArrayList<Customer> listCustomers;
    
    public CustomerView() {
        initComponents();
        listCustomers = new ArrayList<>();
        service = new CustomerService();
        tableModel = new DefaultTableModel();
        tblListCustomer.setModel(tableModel);
        listCustomers = service.getAll();
        addColumns();
        fillTable(listCustomers);
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    private void addColumns() {
        tableModel.addColumn("Mã Khách Hàng");
        tableModel.addColumn("Tên Khách Hàng");
        tableModel.addColumn("Số Điện Thoại");
    }
    
    private void fillTable(ArrayList<Customer> list) {
        tableModel.setRowCount(0);
        for (Customer cus : list) {
            Object[] row = {
                cus.getCode(),
                cus.getFullname(),
                cus.getPhoneNumber()
            };
            tableModel.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanelCustomer = new app.view.swing.TabbedPaneCustom();
        panelListCustomer = new javax.swing.JPanel();
        labelListCustomer = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListCustomer = new javax.swing.JTable();
        txtSearchCustomer = new app.view.swing.TextField();
        btnAccept = new app.view.swing.Button();
        btnCustomerLe = new app.view.swing.Button();
        panelAddCustomer = new javax.swing.JPanel();
        txtEmail = new app.view.swing.TextField();
        txtCode = new app.view.swing.TextField();
        txtAddress = new app.view.swing.TextField();
        btnUpdate = new app.view.swing.ButtonGradient();
        btnAdd = new app.view.swing.ButtonGradient();
        txtFullname1 = new app.view.swing.TextField();
        txtPhoneNumber = new app.view.swing.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabPanelCustomer.setBackground(new java.awt.Color(255, 255, 255));
        tabPanelCustomer.setSelectedColor(new java.awt.Color(0, 153, 255));

        labelListCustomer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelListCustomer.setForeground(new java.awt.Color(0, 0, 0));
        labelListCustomer.setText("Danh Sách Khách Hàng");

        tblListCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblListCustomer);

        txtSearchCustomer.setLabelText("Tìm Kiếm");

        btnAccept.setText("Xác Nhận");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnCustomerLe.setText("Khách Lẻ");
        btnCustomerLe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerLeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelListCustomerLayout = new javax.swing.GroupLayout(panelListCustomer);
        panelListCustomer.setLayout(panelListCustomerLayout);
        panelListCustomerLayout.setHorizontalGroup(
            panelListCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListCustomerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelListCustomer)
                .addGap(184, 184, 184))
            .addGroup(panelListCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelListCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelListCustomerLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelListCustomerLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCustomerLe, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );
        panelListCustomerLayout.setVerticalGroup(
            panelListCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelListCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(panelListCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelListCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCustomerLe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabPanelCustomer.addTab("Danh Sách Khách Hàng", panelListCustomer);

        txtEmail.setLabelText("Email");

        txtCode.setLabelText("Mã Khách Hàng");

        txtAddress.setLabelText("Địa Chỉ");

        btnUpdate.setText("Sửa");
        btnUpdate.setColor2(new java.awt.Color(23, 35, 51));

        btnAdd.setText("Thêm");
        btnAdd.setColor2(new java.awt.Color(23, 35, 51));

        txtFullname1.setLabelText("Họ Và Tên");

        txtPhoneNumber.setLabelText("Số Điện Thoại");

        javax.swing.GroupLayout panelAddCustomerLayout = new javax.swing.GroupLayout(panelAddCustomer);
        panelAddCustomer.setLayout(panelAddCustomerLayout);
        panelAddCustomerLayout.setHorizontalGroup(
            panelAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddCustomerLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panelAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAddCustomerLayout.createSequentialGroup()
                        .addGroup(panelAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFullname1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addGroup(panelAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        panelAddCustomerLayout.setVerticalGroup(
            panelAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddCustomerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddCustomerLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtFullname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelAddCustomerLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelAddCustomerLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tabPanelCustomer.addTab("Thêm Khách Hàng", panelAddCustomer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanelCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanelCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        int row = tblListCustomer.getSelectedRow();
        if (row >= 0) {
            int columnCode = 0;
            String customerCode = (String) tblListCustomer.getValueAt(row, columnCode);
            Customer customerSelected = service.getCustomer(customerCode);
            if (customerSelected != null) {
                this.customer = customerSelected;
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Khách Hàng");
        }

    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnCustomerLeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerLeActionPerformed
        String customerCode = "KL";
        this.customer = service.getCustomer(customerCode);
        this.dispose();
    }//GEN-LAST:event_btnCustomerLeActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.view.swing.Button btnAccept;
    private app.view.swing.ButtonGradient btnAdd;
    private app.view.swing.Button btnCustomerLe;
    private app.view.swing.ButtonGradient btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelListCustomer;
    private javax.swing.JPanel panelAddCustomer;
    private javax.swing.JPanel panelListCustomer;
    private app.view.swing.TabbedPaneCustom tabPanelCustomer;
    private javax.swing.JTable tblListCustomer;
    private app.view.swing.TextField txtAddress;
    private app.view.swing.TextField txtCode;
    private app.view.swing.TextField txtEmail;
    private app.view.swing.TextField txtFullname1;
    private app.view.swing.TextField txtPhoneNumber;
    private app.view.swing.TextField txtSearchCustomer;
    // End of variables declaration//GEN-END:variables
}
