package com.waibizi.demo04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * @Author 吴典秋
 * @Date 2020/6/2 8:11
 * @Description:
 * @Version 1.0
 */

public class AdapterTestGUI extends JPanel{

    private JSplitPane splitPane;
    private JScrollPane btnPane,textPane;
    private JPanel UIPanel;
    private JTextArea dataTextArea;
    private JTextField txtCustomerName, txtAddress,
            txtZip,txtCellPhone, txtSSN,txtEmail;
    private JLabel lblCustomerName, lblAddress,
            lblZip, lblCellphone, lblSSN,lemail;
    public static final String VALIDATE = "Validate";
    public static final String EXIT = "Exit";

    public AdapterTestGUI(){
        super(new GridLayout(1,0));
        buildUpScrollGUI();
    }

    private void buildUpScrollGUI(){
        setUpButtonPanel();

        dataTextArea = new JTextArea(6, 10);
        btnPane = new JScrollPane(UIPanel);
        textPane = new JScrollPane(dataTextArea);

        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setLeftComponent(btnPane);
        splitPane.setRightComponent(textPane );

        btnPane.setMinimumSize(new Dimension(500, 100));
        textPane.setMinimumSize(new Dimension(500, 200));
        splitPane.setDividerLocation(230);
        splitPane.setPreferredSize(new Dimension(500, 400));

        add(splitPane);
        setSize(new Dimension(500, 400));
    }

    private void setUpButtonPanel(){
        txtCustomerName = new JTextField(20);
        txtAddress = new JTextField(20);
        txtZip = new JTextField(20);
        txtCellPhone = new JTextField(20);
        txtSSN = new JTextField(20);
        txtEmail = new JTextField(20);

        lblCustomerName = new JLabel("Customer Name:");
        lblAddress = new JLabel("Address:");
        lblZip = new JLabel("Zip Code:");
        lblCellphone = new JLabel("Cellphone Num:");
        lblSSN = new JLabel("SSN :");
        lemail = new JLabel("email :");

        //Create the open button
        JButton validateButton = new JButton(VALIDATE);
        validateButton.setMnemonic(KeyEvent.VK_V);
        JButton exitButton = new JButton(EXIT);
        exitButton.setMnemonic(KeyEvent.VK_X);
        ButtonListener objButtonHandler = new ButtonListener();

        validateButton.addActionListener(objButtonHandler);
        exitButton.addActionListener(objButtonHandler);

        UIPanel = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        UIPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        UIPanel.add(lblCustomerName);
        UIPanel.add(txtCustomerName);
        UIPanel.add(lblAddress);
        UIPanel.add(txtAddress);
        UIPanel.add(lblZip);
        UIPanel.add(txtZip);
        UIPanel.add(lblCellphone);
        UIPanel.add(txtCellPhone);
        UIPanel.add(lblSSN);
        UIPanel.add(txtSSN);
        UIPanel.add(lemail);
        UIPanel.add(txtEmail);
        UIPanel.add(validateButton);
        UIPanel.add(exitButton);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblCustomerName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(txtCustomerName, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblAddress, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(txtAddress, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gridbag.setConstraints(lblZip, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gridbag.setConstraints(txtZip, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gridbag.setConstraints(lblCellphone, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gridbag.setConstraints(txtCellPhone, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gridbag.setConstraints(lblSSN, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gridbag.setConstraints(txtSSN, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gridbag.setConstraints(lemail, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gridbag.setConstraints(txtEmail, gbc);
        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 40;

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(validateButton);
        buttonPanel.add(exitButton);
        UIPanel.add(buttonPanel);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gridbag.setConstraints(buttonPanel, gbc);
    }

    public String getName(){
        return txtCustomerName.getText();
    }
    public String getAddress(){
        return txtAddress.getText();
    }
    public String getZipCode(){
        return txtZip.getText();
    }
    public String getCellNum(){
        return txtCellPhone.getText();
    }
    public String getSSNNum(){
        return txtSSN.getText();
    }
    public String getEmail(){
        return txtEmail.getText();
    }

    class ButtonListener implements ActionListener {
        CusInfoValidator cusInfo = new InformationAdapter();
        public void actionPerformed(ActionEvent e){

            if (e.getActionCommand().equals(EXIT)){
                System.exit(1);
            }
            if (e.getActionCommand().equals(VALIDATE)){
                String name = getName();
                String address = getAddress();
                String zip = getZipCode();
                String cellNum = getCellNum();
                String ssn = getSSNNum();
                String email = getEmail();

                if(cusInfo.isValidName(name)==false){
                    dataTextArea.append("\n名字不合法");
                }
                else{
                    dataTextArea.append("\n名字合法");
                }

                if(cusInfo.isValidAddress(address)==false){
                    dataTextArea.append("\n错误的地址");
                }
                else{
                    dataTextArea.append("\n正确的地址");
                }

                if(cusInfo.isValidZipCode(zip)==false){
                    dataTextArea.append("\n错误的邮政编码");
                }
                else{
                    dataTextArea.append("\n正确的邮政编码");
                }


                if(cusInfo.isValidCellPhoneNum(cellNum)==false){
                    dataTextArea.append("\n错误的手机号码");
                }
                else{
                    dataTextArea.append("\n正确的手机号码");
                }

                if(cusInfo.isValidSSNNum(ssn)==false){
                    dataTextArea.append("\n社会安全号码错误");
                }
                else{
                    dataTextArea.append("\n社会安全号码正确");
                }
                if (cusInfo.isValidEmail(email)){
                    dataTextArea.append("\n邮箱格式错误");
                }else{
                    dataTextArea.append("\n邮箱格式正确");
                }

            }
        }
    } // End of class ButtonListener

    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Adapter pattern demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        AdapterTestGUI newContentPane = new AdapterTestGUI();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }

    static public void main(String argv[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
}
