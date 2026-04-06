package dev.pessotto.view.components.containers;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import com.formdev.flatlaf.FlatClientProperties;

import dev.pessotto.view.managers.EventBusManager;

public final class NavContainer extends JPanel {
    public NavContainer() {
        putClientProperty(FlatClientProperties.STYLE_CLASS, "NavContainer");

        var layout         = new GridBagLayout();
        var constraints    = new GridBagConstraints();
        var buttonPrevious = new JButton("Previous");
        var buttonNext     = new JButton("Next");

        setLayout(layout);

        buttonPrevious.addActionListener(e -> EventBusManager.publish("PageContainer.previous", null));
        buttonPrevious.setPreferredSize(new Dimension(300, 50));
        buttonPrevious.setMinimumSize(new Dimension(200, 50));

        constraints.weightx = 1d;

        constraints.gridx   = 0;
        constraints.insets  = new Insets(30, 16, 30, 8);
        constraints.anchor  = GridBagConstraints.LINE_END;
        add(buttonPrevious, constraints);

        buttonNext.addActionListener(e -> EventBusManager.publish("PageContainer.next", null));
        buttonNext.setPreferredSize(new Dimension(300, 50));
        buttonNext.setMinimumSize(new Dimension(200, 50));

        constraints.gridx   = 1;
        constraints.insets  = new Insets(30, 8, 30, 16);
        constraints.anchor  = GridBagConstraints.LINE_START;
        add(buttonNext, constraints);
    }
}
