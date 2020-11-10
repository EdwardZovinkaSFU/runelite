package net.runelite.client.plugins.actionoptions;

//Imports
import net.runelite.api.Client;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.ItemDespawned;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.concurrent.ScheduledExecutorService;

public class ActionOptionsPanel extends PluginPanel{

    @Inject
    ScheduledExecutorService executor;

    @Inject
    @Nullable
    private Client client;

    private final JPanel statsPanel = new JPanel();


    @Inject
    public ActionOptionsPanel() {

        ////Formatting code below taken from https://github.com/osrsbox/runelite/blob/master/runelite-client/src/main/java/net/runelite/client/plugins/hiscore/HiscorePanel.java

        // The layout seems to be ignoring the top margin and only gives it
        // a 2-3 pixel margin, so I set the value to 18 to compensate
        // TODO: Figure out why this layout is ignoring most of the top margin
        setBorder(new EmptyBorder(18, 10, 0, 10));
        setBackground(ColorScheme.DARK_GRAY_COLOR);
        setLayout(new GridBagLayout());

        // Expand sub items to fit width of panel, align to top of panel
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 0;
        c.insets = new Insets(0, 0, 10, 0);

        ////End Code from OSRSBox Github


    }


}
