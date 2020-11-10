package net.runelite.client.plugins.actionoptions;

//Imports
import net.runelite.api.Client;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.info.InfoPanel;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.awt.image.BufferedImage;

@PluginDescriptor(
        name = "ActionOptions",
        description = "Lists the number of interactable entities and NPCs in the rendered area." +
                "To Do: List of actions available in the rendered area.",
        tags = {"panel","actions"},
        loadWhenOutdated = true
)

public class ActionOptionsPlugin extends Plugin{

    @Inject
    @Nullable
    private Client client;

    @Inject
    private ClientToolbar clientToolbar;

    private NavigationButton navButton;
    private ActionOptionsPanel actionoptionspanel;

    @Override
    protected void startUp() throws Exception {

        final ActionOptionsPanel panel = injector.getInstance(ActionOptionsPanel.class);
        panel.init();
        final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "normal.png");

        navButton = NavigationButton.builder()
                .tooltip("ActionOptions")
                .icon(icon)
                .priority(12)
                .panel(actionoptionspanel)
                .build();

        clientToolbar.addNavigation(navButton);

    }

    @Override
    protected void shutDown() throws Exception{
        clientToolbar.removeNavigation(navButton);
    }






}
