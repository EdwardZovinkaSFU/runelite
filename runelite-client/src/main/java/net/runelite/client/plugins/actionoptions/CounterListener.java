package net.runelite.client.plugins.actionoptions;

import net.runelite.api.events.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterListener implements ActionListener {

    public static int items = 0;
    public static int npcs = 0;
    public static int gameobjects = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        //I have no idea what I'm doing.
    }

    //Item Spawn Listener
    public void actionPerformed(ItemSpawned is) {
        items++;
    }

    //Item Despawn Listener
    public void actionPerformed(ItemDespawned id){
        items--;
    }

    //Game Object Spawn Listener
    public void actionPerformed (GameObjectSpawned gos){
        gameobjects++;
    }

    //Game Object Despawn Listener
    public void actionPerformed (GameObjectDespawned god){
        gameobjects--;
    }

    //NPC Spawn Listener
    public void actionPerformed (NpcSpawned npc){
        npcs++;
    }

    //NPC Despawn Listener
    public void actionPerformed (NpcDespawned npcd){
        npcs--;
    }

}
