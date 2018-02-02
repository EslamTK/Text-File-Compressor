

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class ExtractPanel extends javax.swing.JPanel {

    JFileChooser fileChooser,fileSaver;
    public ExtractPanel() {
        initComponents();
        fileChooser = new JFileChooser();
	fileChooser.setFileFilter(new FileFilter()
        {
            @Override
            public boolean accept(File file) {
            String fileName = file.getName();
            int exIndex = fileName.lastIndexOf('.');
            if (exIndex > -1) {
            if (fileName.substring(exIndex + 1).equals("comp")) {
                return true;
            }
            }
        return file.isDirectory();    
            }

            @Override
            public String getDescription() {
                return "Compressed Files (*.comp)";
            }
            
        });
	fileChooser.setAcceptAllFileFilterUsed(false);
        fileSaver = new JFileChooser();
        fileSaver.setAcceptAllFileFilterUsed(false);
        fileSaver.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        CompressBtn = new javax.swing.JButton();
        FileLabel = new javax.swing.JLabel();
        FilesTextBox = new javax.swing.JTextField();
        FilesSelectBtn = new javax.swing.JButton();
        ExtractLabel = new javax.swing.JLabel();
        SaveChangeBtn = new javax.swing.JButton();
        SaveTextBox = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(400, 125));
        setPreferredSize(new java.awt.Dimension(400, 125));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {65, 250, 50};
        layout.rowHeights = new int[] {30};
        setLayout(layout);

        CompressBtn.setText("Extract");
        CompressBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompressBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 0, 0);
        add(CompressBtn, gridBagConstraints);

        FileLabel.setText("File :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(FileLabel, gridBagConstraints);

        FilesTextBox.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(FilesTextBox, gridBagConstraints);

        FilesSelectBtn.setText("Select");
        FilesSelectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilesSelectBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        add(FilesSelectBtn, gridBagConstraints);

        ExtractLabel.setText("Extract To :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(ExtractLabel, gridBagConstraints);

        SaveChangeBtn.setText("Change");
        SaveChangeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveChangeBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        add(SaveChangeBtn, gridBagConstraints);

        SaveTextBox.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(SaveTextBox, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void CompressBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompressBtnActionPerformed
        if(fileChooser.getSelectedFile()!=null)
        {
        FileReader fileReader = new FileReader();
        try{
            String password = "";
            if(fileReader.isPasswordProtected(fileChooser.getSelectedFile()))
            {
                PasswordDialog passwordDialog = new PasswordDialog((JFrame)this.getParent().getParent().getParent().getParent().getParent(), true);
                passwordDialog.setVisible(true);
                password = String.valueOf(passwordDialog.getPassword());
                if(!fileReader.isPasswordCorrect(fileChooser.getSelectedFile(), password))
                {
                    JOptionPane.showMessageDialog(this, "Wrong Password!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            LoadingDialog loadingDialog = new LoadingDialog((JFrame)this.getParent().getParent().getParent().getParent().getParent(), true);
            loadingDialog.extractFile(fileChooser.getSelectedFile(), fileSaver.getSelectedFile().getAbsolutePath()+"\\"+
                              getFileName(fileChooser.getSelectedFile().getName()), password);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Please Choose A File To Extract!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CompressBtnActionPerformed
    private String getFileName(String name)
    {
            return name.substring(0,name.lastIndexOf('.'));
    }
    private void FilesSelectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilesSelectBtnActionPerformed
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            File file = fileChooser.getSelectedFile();
            FilesTextBox.setText(file.getAbsolutePath());
            SaveTextBox.setText(file.getParent());
            fileSaver.setSelectedFile(new File(file.getParent()));
        }
    }//GEN-LAST:event_FilesSelectBtnActionPerformed

    private void SaveChangeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveChangeBtnActionPerformed
        if (fileSaver.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            SaveTextBox.setText(fileSaver.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_SaveChangeBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CompressBtn;
    private javax.swing.JLabel ExtractLabel;
    private javax.swing.JLabel FileLabel;
    private javax.swing.JButton FilesSelectBtn;
    private javax.swing.JTextField FilesTextBox;
    private javax.swing.JButton SaveChangeBtn;
    private javax.swing.JTextField SaveTextBox;
    // End of variables declaration//GEN-END:variables
}
