/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.view;

import app.model.Customer;
import app.model.OrderDetail;
import app.service.CustomerService;
import app.util.CheckValidate;
import app.util.SplitString;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CustomerPanel extends javax.swing.JPanel {

    private DefaultTableModel tableModelListCustomer = new DefaultTableModel();
    private DefaultTableModel tableModelListProductBought = new DefaultTableModel();
    private ArrayList<Customer> listCustomers = new ArrayList<>();
    private ArrayList<OrderDetail> listOrderDetailsByCustomer = new ArrayList<>();
    private CustomerService customerService = new CustomerService();
    private Customer customer;

    public CustomerPanel() {
        initComponents();
        tblListCustomer.setModel(tableModelListCustomer);
        tblDisplayProductBought.setModel(tableModelListProductBought);
        addColumnListCustomer();
        addColumnListProductBought();
        refreshTableListProduct();
    }

    private void addColumnListCustomer() {
        tableModelListCustomer.addColumn("Mã Khách Hàng");
        tableModelListCustomer.addColumn("Họ và Tên");
        tableModelListCustomer.addColumn("Số Điện Thoại");
        tableModelListCustomer.addColumn("Email");
        tableModelListCustomer.addColumn("Địa Chỉ");
    }

    private void addColumnListProductBought() {
        tableModelListProductBought.addColumn("Mã Sản Phẩm");
        tableModelListProductBought.addColumn("Tên Sản Phẩm");
        tableModelListProductBought.addColumn("Ngày Mua");
        tableModelListProductBought.addColumn("Số Lượng");
        tableModelListProductBought.addColumn("Đơn Giá");
    }

    private void refreshTableListProduct() {
        listCustomers = customerService.getAll();
        fillTableListCustomer(listCustomers);
    }

    private void fillTableListCustomer(ArrayList<Customer> list) {
        tableModelListCustomer.setRowCount(0);
        for (Customer customer : list) {
            Object[] row = {
                customer.getCode(),
                customer.getFullname(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getAddress()
            };
            tableModelListCustomer.addRow(row);
        }
    }

    private void fillTableListOrder(ArrayList<OrderDetail> list) {
        tableModelListProductBought.setRowCount(0);
        for (OrderDetail orderDetail : list) {
            Object[] row = {
                orderDetail.getOrder().getCode(),
                orderDetail.getProduct().getIdProduct().getName(),
                orderDetail.getOrder().getCreateDate(),
                orderDetail.getQuantity(),
                orderDetail.getUnitPrice()
            };
            tableModelListProductBought.addRow(row);
        }
    }
    
    private void refreshTableListBought(Customer customer){
        listOrderDetailsByCustomer = customerService.getListBought(customer.getCode());
        fillTableListOrder(listOrderDetailsByCustomer);
    }

    private Customer getFormData() {
        String name = "";
        String middleName = "";
        String lastName = "";
        LocalDate dateOfBirth = null;
        String phoneNumber = "";
        String address = "";
        String fullname = "";
        String email = "";
        int countError = 0;

        if (txtFullname.getText().trim().isEmpty()) {
            countError++;
            labelNameError.setText("Bạn Chưa Nhập Vào Tên");
        } else {
            if (txtFullname.getText().length() <= 6) {
                countError++;
                labelNameError.setText("Tên Phải Trên 6 Ký Tự");
            } else {
                fullname = txtFullname.getText();
                String[] splitName = SplitString.splitName(fullname);
                name = splitName[0];
                middleName = splitName[1];
                lastName = splitName[2];
            }
        }

        if (txtDate.getText().trim().isEmpty()) {
            countError++;
            labelDateError.setText("Ngày Sinh Không Được Để Trống");
        } else {
            dateOfBirth = LocalDate.parse(txtDate.getText(), DateTimeFormatter.ISO_DATE);
            labelDateError.setText("");
        }

        if (txtPhoneNumber.getText().trim().isEmpty()) {
            countError++;
            labelPhoneNumberError.setText("Số Điện Thoại Không Được Để Trống");
        } else {
            if (!CheckValidate.validateString(txtPhoneNumber.getText(), CheckValidate.PHONENUMBER_CHECK)) {
                countError++;
                labelPhoneNumberError.setText("Số Điện Thoại Phải Là Số Của Việt Nam");
            } else {
                phoneNumber = txtPhoneNumber.getText();
                labelPhoneNumberError.setText("");
            }
        }

        if (txtAddress.getText().trim().isEmpty()) {
            countError++;
            labelAddressError.setText("Địa Chỉ Không Được Để Trống");
        } else {
            address = txtAddress.getText();
            labelAddressError.setText("");
        }

        if (txtEmail.getText().trim().isEmpty()) {
            countError++;
            labelEmailError.setText("Email Không Được Để Trống");
        } else {
            if (!CheckValidate.validateString(txtEmail.getText(), CheckValidate.EMAIL_CHECK)) {
                countError++;
                labelEmailError.setText("Email Không Đúng Định Dạng");
            } else {
                email = txtEmail.getText();
                labelEmailError.setText("");
            }
        }

        if (countError == 0) {
            Customer customer = new Customer(name, middleName, lastName, dateOfBirth, phoneNumber, address, email);
            return customer;
        }
        return null;
    }

    private void showDetailCustomer(Customer customer) {
        if (customer.getCode().equals("KH0")) {
            txtCode.setText(customer.getCode());
            txtFullname.setText(customer.getName());
        } else {
            txtAddress.setText(customer.getAddress());
            txtCode.setText(customer.getCode());
            txtDate.setText(String.valueOf(customer.getDateOfBirth()));
            txtEmail.setText(customer.getEmail());
            txtFullname.setText(customer.getFullname());
            txtPhoneNumber.setText(customer.getPhoneNumber());
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

        panelCustomerInfor = new javax.swing.JPanel();
        txtPhoneNumber = new app.view.swing.TextField();
        txtEmail = new app.view.swing.TextField();
        txtAddress = new app.view.swing.TextField();
        btnUpdate = new app.view.swing.ButtonGradient();
        btnAdd = new app.view.swing.ButtonGradient();
        txtFullname = new app.view.swing.TextField();
        labelNameError = new javax.swing.JLabel();
        labelPhoneNumberError = new javax.swing.JLabel();
        labelEmailError = new javax.swing.JLabel();
        labelAddressError = new javax.swing.JLabel();
        txtDate = new app.view.swing.TextField();
        labelDateError = new javax.swing.JLabel();
        txtCode = new app.view.swing.TextField();
        labelNameError1 = new javax.swing.JLabel();
        panelCustomerBought = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDisplayProductBought = new javax.swing.JTable();
        panelListCustomer = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListCustomer = new javax.swing.JTable();
        labelPanelCustomer = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelCustomerInfor.setBackground(new java.awt.Color(255, 255, 255));
        panelCustomerInfor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        txtPhoneNumber.setLabelText("Số Điện Thoại");

        txtEmail.setLabelText("Email");

        txtAddress.setLabelText("Địa Chỉ");

        btnUpdate.setText("Sửa");
        btnUpdate.setColor2(new java.awt.Color(23, 35, 51));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm");
        btnAdd.setColor2(new java.awt.Color(23, 35, 51));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtFullname.setLabelText("Họ Và Tên");

        labelNameError.setForeground(new java.awt.Color(255, 0, 51));
        labelNameError.setPreferredSize(new java.awt.Dimension(0, 14));

        labelPhoneNumberError.setForeground(new java.awt.Color(255, 0, 51));
        labelPhoneNumberError.setPreferredSize(new java.awt.Dimension(0, 14));

        labelEmailError.setForeground(new java.awt.Color(255, 0, 51));
        labelEmailError.setPreferredSize(new java.awt.Dimension(0, 14));

        labelAddressError.setForeground(new java.awt.Color(255, 0, 0));
        labelAddressError.setPreferredSize(new java.awt.Dimension(0, 14));

        txtDate.setLabelText("Ngày Sinh");

        labelDateError.setForeground(new java.awt.Color(255, 0, 51));
        labelDateError.setPreferredSize(new java.awt.Dimension(0, 14));

        txtCode.setEditable(false);
        txtCode.setLabelText("Mã");

        labelNameError1.setForeground(new java.awt.Color(255, 0, 51));
        labelNameError1.setPreferredSize(new java.awt.Dimension(0, 14));

        javax.swing.GroupLayout panelCustomerInforLayout = new javax.swing.GroupLayout(panelCustomerInfor);
        panelCustomerInfor.setLayout(panelCustomerInforLayout);
        panelCustomerInforLayout.setHorizontalGroup(
            panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustomerInforLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtFullname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelDateError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelNameError1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCustomerInforLayout.createSequentialGroup()
                        .addComponent(labelAddressError, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerInforLayout.createSequentialGroup()
                        .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEmailError, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPhoneNumberError, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCustomerInforLayout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerInforLayout.createSequentialGroup()
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))))))
        );
        panelCustomerInforLayout.setVerticalGroup(
            panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerInforLayout.createSequentialGroup()
                .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCustomerInforLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCustomerInforLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCustomerInforLayout.createSequentialGroup()
                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(labelPhoneNumberError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCustomerInforLayout.createSequentialGroup()
                                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNameError1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCustomerInforLayout.createSequentialGroup()
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelEmailError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelAddressError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCustomerInforLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDateError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCustomerInforLayout.createSequentialGroup()
                                .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNameError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 97, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelCustomerBought.setBackground(new java.awt.Color(255, 255, 255));
        panelCustomerBought.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản Phẩm Khách Hàng Đã Mua", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        tblDisplayProductBought.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDisplayProductBought);

        javax.swing.GroupLayout panelCustomerBoughtLayout = new javax.swing.GroupLayout(panelCustomerBought);
        panelCustomerBought.setLayout(panelCustomerBoughtLayout);
        panelCustomerBoughtLayout.setHorizontalGroup(
            panelCustomerBoughtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustomerBoughtLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCustomerBoughtLayout.setVerticalGroup(
            panelCustomerBoughtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustomerBoughtLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelListCustomer.setBackground(new java.awt.Color(255, 255, 255));
        panelListCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

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
        tblListCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListCustomerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblListCustomer);

        javax.swing.GroupLayout panelListCustomerLayout = new javax.swing.GroupLayout(panelListCustomer);
        panelListCustomer.setLayout(panelListCustomerLayout);
        panelListCustomerLayout.setHorizontalGroup(
            panelListCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        panelListCustomerLayout.setVerticalGroup(
            panelListCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        labelPanelCustomer.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        labelPanelCustomer.setForeground(new java.awt.Color(0, 0, 0));
        labelPanelCustomer.setText("Quản Lý Khách Hàng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelListCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelCustomerInfor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelCustomerBought, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(580, 580, 580)
                .addComponent(labelPanelCustomer)
                .addContainerGap(584, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPanelCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCustomerInfor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCustomerBought, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(panelListCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Customer customer = getFormData();
        if (customer != null) {
            boolean addSuccess = customerService.add(customer);
            if (addSuccess) {
                refreshTableListProduct();
                JOptionPane.showMessageDialog(this, "Thêm Khách Hàng Thành Công");
            } else {
                JOptionPane.showMessageDialog(this, "Đã Xảy Ra Lỗi");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblListCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListCustomerMouseClicked
        int row = tblListCustomer.getSelectedRow();
        int column_ma = 0;
        if (row >= 0) {
            String customerCode = (String) tblListCustomer.getValueAt(row, column_ma);
            customer = customerService.getCustomer(customerCode);
            showDetailCustomer(customer);
            refreshTableListBought(customer);
        }
    }//GEN-LAST:event_tblListCustomerMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.view.swing.ButtonGradient btnAdd;
    private app.view.swing.ButtonGradient btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAddressError;
    private javax.swing.JLabel labelDateError;
    private javax.swing.JLabel labelEmailError;
    private javax.swing.JLabel labelNameError;
    private javax.swing.JLabel labelNameError1;
    private javax.swing.JLabel labelPanelCustomer;
    private javax.swing.JLabel labelPhoneNumberError;
    private javax.swing.JPanel panelCustomerBought;
    private javax.swing.JPanel panelCustomerInfor;
    private javax.swing.JPanel panelListCustomer;
    private javax.swing.JTable tblDisplayProductBought;
    private javax.swing.JTable tblListCustomer;
    private app.view.swing.TextField txtAddress;
    private app.view.swing.TextField txtCode;
    private app.view.swing.TextField txtDate;
    private app.view.swing.TextField txtEmail;
    private app.view.swing.TextField txtFullname;
    private app.view.swing.TextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
