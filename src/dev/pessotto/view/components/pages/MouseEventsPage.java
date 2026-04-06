package dev.pessotto.view.components.pages;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.formdev.flatlaf.FlatClientProperties;

public final class MouseEventsPage extends JPanel
{
    public MouseEventsPage()
    {
        var layout             = new GridBagLayout();
        var constraints        = new GridBagConstraints();
        var innerPanel         = new JPanel(layout);
        var labelTitle         = new JLabel("Mouse Events 🔥", JLabel.CENTER);
        var labelEnteredExited = new JLabel("In/Out", JLabel.CENTER);
        var labelDownUp        = new JLabel("Down/Up", JLabel.CENTER);
        var labelClicked       = new JLabel("Click", JLabel.CENTER);
        var labelMovedDragged  = new JLabel("Move/Drag", JLabel.CENTER);
        var labelWheelMoved    = new JLabel("Scroll", JLabel.CENTER);

        final int LABEL_WIDTH      = 200;
        final int LABEL_HEIGHT     = 300;
        final int LABEL_MIN_WIDTH  = 100;
        final int LABEL_MIN_HEIGHT = 150;

        setLayout(layout);

        labelTitle.setOpaque(true);
        labelTitle.putClientProperty(FlatClientProperties.STYLE_CLASS, "labelTitle");
        labelTitle.setPreferredSize(new Dimension(0, 100));
        labelTitle.setMinimumSize(new Dimension(0, 100));

        var labels = new JLabel[]
        {labelEnteredExited, labelDownUp, labelClicked, labelMovedDragged, labelWheelMoved};

        for (var label : labels)
        {
            label.setOpaque(true);
            label.putClientProperty(FlatClientProperties.STYLE_CLASS, "labelExample");
            label.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
            label.setMinimumSize(new Dimension(LABEL_MIN_WIDTH, LABEL_MIN_HEIGHT));
        }

        labelEnteredExited.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e)
            {
                labelEnteredExited.putClientProperty(FlatClientProperties.STYLE_CLASS, "mouseEnter");
                labelEnteredExited.setText("Enter");
            }

            public void mouseExited(MouseEvent e)
            {
                labelEnteredExited.putClientProperty(FlatClientProperties.STYLE_CLASS, "mouseExit");
                labelEnteredExited.setText("Exit");
            }
        });

        labelDownUp.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                labelDownUp.putClientProperty(FlatClientProperties.STYLE_CLASS, "mousePressed");
                labelDownUp.setText("Down");
            }

            public void mouseReleased(MouseEvent e)
            {
                labelDownUp.putClientProperty(FlatClientProperties.STYLE_CLASS, "mouseReleased");
                labelDownUp.setText("Up");
            }
        });

        labelClicked.addMouseListener(new MouseAdapter()
        {
            private static int countClicks = 1;

            public void mouseClicked(MouseEvent e)
            {
                labelClicked.putClientProperty(FlatClientProperties.STYLE_CLASS, "mousePressed");
                labelClicked.setText("Clicks: " + countClicks++);
            }
        });

        labelMovedDragged.addMouseMotionListener(new MouseAdapter()
        {
            private static int countMove    = 1;
            private static int countDragged = 1;

            public void mouseMoved(MouseEvent e)
            {
                StringBuilder sb = new StringBuilder("Move: ");
                labelMovedDragged.putClientProperty(FlatClientProperties.STYLE_CLASS, "mouseMoved");
                labelMovedDragged.setText(sb.append(countMove++).toString());
                sb.setLength(0);
            }

            public void mouseDragged(MouseEvent e)
            {
                StringBuilder sb = new StringBuilder("Drag: ");
                labelMovedDragged.putClientProperty(FlatClientProperties.STYLE_CLASS, "mouseDragged");
                labelMovedDragged.setText(sb.append(countDragged++).toString());
                sb.setLength(0);
            }
        });

        labelWheelMoved.addMouseWheelListener(new MouseAdapter()
        {
            private static int countWheelBack  = 1;
            private static int countWheelFront = 1;
            private final StringBuilder sb     = new StringBuilder("Scroll");

            public void mouseWheelMoved(MouseWheelEvent e)
            {
                labelWheelMoved.putClientProperty(FlatClientProperties.STYLE_CLASS, "mouseWheelMoved");
                labelWheelMoved.setText
                                (
                                    e.getPreciseWheelRotation() != 1
                                    ? sb.append("Front ").append(countWheelFront++).toString()
                                    : sb.append("Back ").append(countWheelBack++).toString()
                                );
                sb.setLength(0);
            }
        });

        constraints.insets  = new Insets(5, 5, 5, 5);
        constraints.weightx = 1d;
        constraints.fill    = GridBagConstraints.HORIZONTAL;

        innerPanel.add(labelEnteredExited, constraints);
        innerPanel.add(labelDownUp,        constraints);
        innerPanel.add(labelClicked,       constraints);
        innerPanel.add(labelMovedDragged,  constraints);
        innerPanel.add(labelWheelMoved,    constraints);

        constraints.fill    = GridBagConstraints.BOTH;
        constraints.weightx = 1d;

        constraints.insets  = new Insets(0, 0, 0, 0);
        constraints.gridy = 0;
        add(labelTitle, constraints);

        constraints.gridy   = 1;
        constraints.weighty = 1d;
        add(innerPanel, constraints);
    }
}
