package dev.pessotto.view.components.pages;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.formdev.flatlaf.FlatClientProperties;

public final class KeyboardEventsPage extends JPanel
{
    public KeyboardEventsPage()
    {
        var layout           = new GridBagLayout();
        var constraints      = new GridBagConstraints();
        var innerPanel       = new JPanel(layout);
        var labelTitle       = new JLabel("Key Event 🚀", JLabel.CENTER);
        var labelShowMessage = new JLabel("", JLabel.CENTER);
        var textField        = new JTextField();

        setLayout(layout);

        labelTitle.setOpaque(true);
        labelTitle.putClientProperty(FlatClientProperties.STYLE_CLASS, "labelTitle");
        labelTitle.setPreferredSize(new Dimension(0, 100));
        labelTitle.setMinimumSize(new Dimension(0, 100));

        labelShowMessage.putClientProperty(FlatClientProperties.STYLE_CLASS, "labelKey");

        textField.setPreferredSize(new Dimension(500, 30));
        textField.setMinimumSize(new Dimension(250, 30));
        textField.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                labelShowMessage.setText(KeyEvent.getKeyText(e.getKeyCode()));
            }
        });

        constraints.gridy   = 0;
        constraints.weightx = 1d;
        constraints.insets  = new Insets(10, 10, 10, 10);
        innerPanel.add(textField, constraints);

        constraints.gridy  = 1;
        constraints.insets = new Insets(0, 0, 0, 0);
        innerPanel.add(labelShowMessage, constraints);

        constraints.gridy   = 0;
        constraints.weightx = 1d;
        constraints.fill    = GridBagConstraints.BOTH;
        add(labelTitle, constraints);

        constraints.gridy   = 1;
        constraints.weightx = 0d;
        constraints.weighty = 1d;
        constraints.fill    = GridBagConstraints.VERTICAL;
        add(innerPanel, constraints);
    }
}
