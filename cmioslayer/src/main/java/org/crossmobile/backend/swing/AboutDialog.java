/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import org.crossmobile.bind.system.AppConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class AboutDialog extends javax.swing.JDialog {

    private final String[] icons;

    public AboutDialog(String[] icons) {
        super(SwingGraphicsBridge.frame, true);
        this.icons = icons;
        initComponents();
        setLocationRelativeTo(null);
    }

    private String getCopyright() {
        String vendor = System.getProperty("cm.vendor", "");
        return vendor.isEmpty() ? "" : "(C) " + vendor;
    }

    private Icon getIcon() {
        for (int i = icons.length - 1; i >= 0; i--) {
            try {
                BufferedImage image = ImageIO.read(new URL(icons[i]));
                if (image != null)
                    return new ImageIcon(image.getScaledInstance(128, 128, Image.SCALE_SMOOTH));
            } catch (Exception ignored) {
            }
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconL = new javax.swing.JLabel();
        nameL = new javax.swing.JLabel();
        versionL = new javax.swing.JLabel();
        vendorL = new javax.swing.JLabel();
        poweredby = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        iconL.setIcon(getIcon());
        iconL.setAlignmentX(0.5F);
        iconL.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 90, 15, 90));
        getContentPane().add(iconL);

        nameL.setFont(nameL.getFont().deriveFont(nameL.getFont().getStyle() | java.awt.Font.BOLD));
        nameL.setText(org.crossmobile.bind.system.AppConstants.DISPLAY_NAME);
        nameL.setAlignmentX(0.5F);
        getContentPane().add(nameL);

        versionL.setFont(versionL.getFont().deriveFont(versionL.getFont().getSize()-1f));
        versionL.setText("Version " + AppConstants.DISPLAY_VERSION);
        versionL.setAlignmentX(0.5F);
        versionL.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        getContentPane().add(versionL);

        vendorL.setFont(vendorL.getFont().deriveFont(vendorL.getFont().getSize()-2f));
        vendorL.setText(getCopyright());
        vendorL.setAlignmentX(0.5F);
        getContentPane().add(vendorL);

        poweredby.setFont(poweredby.getFont().deriveFont(poweredby.getFont().getSize()-2f));
        poweredby.setText("Powered by CrossMobile");
        poweredby.setAlignmentX(0.5F);
        poweredby.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 0, 8, 0));
        getContentPane().add(poweredby);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconL;
    private javax.swing.JLabel nameL;
    private javax.swing.JLabel poweredby;
    private javax.swing.JLabel vendorL;
    private javax.swing.JLabel versionL;
    // End of variables declaration//GEN-END:variables
}
