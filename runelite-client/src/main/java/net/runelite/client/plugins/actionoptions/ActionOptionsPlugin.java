package net.runelite.client.plugins.actionoptions;

//Imports
import net.runelite.api.Client;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemSpawned;
import net.runelite.client.eventbus.Subscribe;
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

    public static int items = 0;
    public static int npcs = 0;
    public static int gameobjects = 0;

    @Override
    protected void startUp() throws Exception {

        final ActionOptionsPanel actionoptionspanel = injector.getInstance(ActionOptionsPanel.class);
        actionoptionspanel.init();
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

    @Subscribe
    public void onItemSpawned(ItemSpawned itemSpawned)
    {
        TileItem item = itemSpawned.getItem();
        Tile tile = itemSpawned.getTile();

        items++;
    }

    @Subscribe
    public void onItemDespawned(ItemDespawned itemDespawned)
    {
        TileItem item = itemDespawned.getItem();
        Tile tile = itemDespawned.getTile();

        items--;
        
    }


}
