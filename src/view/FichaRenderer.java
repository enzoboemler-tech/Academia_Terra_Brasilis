package view;

import javax.swing.*;
import java.awt.*;

public class FichaRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {

        JLabel label = (JLabel) super.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);

        label.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY),
                BorderFactory.createEmptyBorder(0, 15, 0, 15)));
        label.setFont(new Font("SansSerif", Font.PLAIN, 16));

        if (!isSelected) {
            label.setBackground(Color.WHITE);
        }
        return label;
    }
}