package calculator;

import javax.swing.*;
import java.awt.*;

class RoundButton extends JButton {

    public RoundButton(String label) {
        super(label);
        setContentAreaFilled(false); // Elimină umplerea implicită a butonului
        setFocusPainted(false); // Elimină conturul de focalizare
        setBorderPainted(false); // Elimină marginea butonului
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 100, 100); // Colțuri rotunjite
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.setColor(getForeground());
//        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 100, 100); // Margini rotunjite
//        g2.dispose();

        // le-am comentat pentru a nu-mi aparea marginile
    }

    @Override
    public boolean contains(int x, int y) {
        // Verifică dacă punctul (x, y) se află în interiorul butonului rotund
        Shape shape = new java.awt.geom.RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 100, 100);
        return shape.contains(x, y);
    }
}


    /* Graphics2D este o extensie a clasei Graphics, care oferă funcționalități
    suplimentare pentru desenare avansată. Se creează o copie a obiectului
    grafic original pentru a desena cu mai mult control. */
