package net.runelite.client.plugins.actionoptions;


import com.google.common.base.MoreObjects;
import com.google.inject.Inject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.inject.Singleton;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.HyperlinkEvent;
import net.runelite.api.Client;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.events.*;
import net.runelite.client.events.SessionClose;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.account.SessionManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.info.JRichTextPane;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.LinkBrowser;

@Singleton
public class ActionOptionsPanel extends PluginPanel {

    private final JLabel loggedLabel = new JLabel();
    private final JRichTextPane emailLabel = new JRichTextPane();
    private JPanel syncPanel;
    //private JPanel actionsContainer;

    private static int items = 0;
    private static int npcs = 0;
    private static int gameobjects = 0;

    private static JPanel counterPanel;
    private static JLabel itemlabel;
    private static JLabel npclabel;
    private static JLabel objectlabel;

    @Inject
    @Nullable
    private Client client;

    @Inject
    private EventBus eventBus;

    @Inject
    private SessionManager sessionManager;

    @Inject
    private ScheduledExecutorService executor;

    @Inject
    private ConfigManager configManager;

    void init() {
        setLayout(new BorderLayout());
        setBackground(ColorScheme.DARK_GRAY_COLOR);
        setBorder(new EmptyBorder(10, 10, 10, 10));

        counterPanel = new JPanel();
        counterPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        counterPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        counterPanel.setLayout(new GridLayout(0, 1));

        final Font smallFont = FontManager.getRunescapeSmallFont();

        itemlabel = new JLabel(htmlLabel("Interactable Items: ", String.valueOf(items)));
        itemlabel.setFont(smallFont);

        npclabel = new JLabel();
        npclabel.setFont(smallFont);
        npclabel.setText(htmlLabel("Active NPCs: ", String.valueOf(npcs)));

        objectlabel = new JLabel(htmlLabel("Game Objects: ", String.valueOf(gameobjects)));
        objectlabel.setFont(smallFont);

        counterPanel.add(itemlabel);
        counterPanel.add(npclabel);
        counterPanel.add(objectlabel);

        JPanel container = new JPanel();
        container.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        container.setLayout(new BorderLayout());
        container.setBorder(new EmptyBorder(10, 10, 10, 10));

        add(counterPanel, BorderLayout.NORTH);

        // updateLoggedIn();
        eventBus.register(this);

    }

    private static String htmlLabel(String key, String value) {
        return "<html><body style = 'color:#a5a5a5'>" + key + "<span style = 'color:white'>" + value + "</span></body></html>";
    }


    private void updatePanel(){
        //remove(counterPanel);
        //counterPanel.remove(itemlabel);
        //counterPanel.remove(npclabel);
        //counterPanel.remove(objectlabel);

        itemlabel.setText(htmlLabel("Interactable Items: ", String.valueOf(items)));
        npclabel.setText(htmlLabel("Active NPCs: ", String.valueOf(npcs)));
        objectlabel.setText(htmlLabel("Game Objects: ", String.valueOf(gameobjects)));

        //counterPanel.add(itemlabel);
        //counterPanel.add(npclabel);
        //counterPanel.add(objectlabel);

        //add(counterPanel, BorderLayout.NORTH);
        repaint();
    }


    @Subscribe
    public void onItemSpawned(ItemSpawned itemSpawned)
    {
        //TileItem item = itemSpawned.getItem();
        //Tile tile = itemSpawned.getTile();

        items++;
        //System.out.println(items);
        updatePanel();



    }

    @Subscribe
    public void onItemDespawned(ItemDespawned itemDespawned)
    {
        //TileItem item = itemDespawned.getItem();
        //Tile tile = itemDespawned.getTile();

        items--;
        //System.out.println(items);
        updatePanel();

    }

    @Subscribe
    public void onNpcSpawned(NpcSpawned npcSpawned){
        npcs++;
        updatePanel();
    }

    @Subscribe
    public void onNpcDespawned(NpcDespawned npcDespawned){
        npcs--;
        updatePanel();
    }

    @Subscribe
    public void onGameObjectSpawned(GameObjectSpawned gameObjectSpawned){
        gameobjects++;
        updatePanel();
    }

    @Subscribe
    public void onGameObjectDespawned(GameObjectDespawned gameObjectDespawned){
        gameobjects--;
        updatePanel();
    }





}