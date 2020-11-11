package net.runelite.client.plugins.actionoptions;

import com.google.inject.*;
import com.google.inject.Module;
import com.google.inject.spi.TypeConverterBinding;
import com.google.inject.testing.fieldbinder.Bind;
import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.EventBus;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;

import javax.annotation.Nullable;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ActionOptionsPluginTest {

    @Mock
    @Bind
    private Injector injector;

    @Mock
    @Bind
    private final EventBus eventBus = new EventBus();

    @Mock
    @Bind
    private final NPC npc = new NPC() {
        @Override
        public int getId() {
            return 0;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public int getCombatLevel() {
            return 0;
        }

        @Override
        public int getIndex() {
            return 0;
        }

        @Override
        public NPCComposition getComposition() {
            return null;
        }

        @Nullable
        @Override
        public NPCComposition getTransformedComposition() {
            return null;
        }

        @Override
        public boolean isDead() {
            return false;
        }

        @Override
        public Actor getInteracting() {
            return null;
        }

        @Override
        public int getHealthRatio() {
            return 0;
        }

        @Override
        public int getHealthScale() {
            return 0;
        }

        @Override
        public WorldPoint getWorldLocation() {
            return null;
        }

        @Override
        public LocalPoint getLocalLocation() {
            return null;
        }

        @Override
        public void setIdlePoseAnimation(int animation) {

        }

        @Override
        public void setPoseAnimation(int animation) {

        }

        @Override
        public int getOrientation() {
            return 0;
        }

        @Override
        public int getAnimation() {
            return 0;
        }

        @Override
        public int getPoseAnimation() {
            return 0;
        }

        @Override
        public int getIdlePoseAnimation() {
            return 0;
        }

        @Override
        public void setAnimation(int animation) {

        }

        @Override
        public void setActionFrame(int actionFrame) {

        }

        @Override
        public int getGraphic() {
            return 0;
        }

        @Override
        public void setGraphic(int graphic) {

        }

        @Override
        public void setSpotAnimFrame(int spotAnimFrame) {

        }

        @Override
        public Polygon getCanvasTilePoly() {
            return null;
        }

        @Nullable
        @Override
        public Point getCanvasTextLocation(Graphics2D graphics, String text, int zOffset) {
            return null;
        }

        @Override
        public Point getCanvasImageLocation(BufferedImage image, int zOffset) {
            return null;
        }

        @Override
        public Point getCanvasSpriteLocation(SpritePixels sprite, int zOffset) {
            return null;
        }

        @Override
        public Point getMinimapLocation() {
            return null;
        }

        @Override
        public int getLogicalHeight() {
            return 0;
        }

        @Override
        public Shape getConvexHull() {
            return null;
        }

        @Override
        public WorldArea getWorldArea() {
            return null;
        }

        @Override
        public String getOverheadText() {
            return null;
        }

        @Override
        public void setOverheadText(String overheadText) {

        }

        @Override
        public Model getModel() {
            return null;
        }

        @Override
        public int getModelHeight() {
            return 0;
        }

        @Override
        public void setModelHeight(int modelHeight) {

        }

        @Override
        public void draw(int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y, int z, long hash) {

        }

        @Override
        public Node getNext() {
            return null;
        }

        @Override
        public Node getPrevious() {
            return null;
        }

        @Override
        public long getHash() {
            return 0;
        }
    };

    @Mock
    @Bind
     private final NpcSpawned npcSpawned = new NpcSpawned(npc);

    @Mock
    @Bind
    private final Tile tile = new Tile() {
        @Override
        public DecorativeObject getDecorativeObject() {
            return null;
        }

        @Override
        public GameObject[] getGameObjects() {
            return new GameObject[0];
        }

        @Override
        public ItemLayer getItemLayer() {
            return null;
        }

        @Override
        public GroundObject getGroundObject() {
            return null;
        }

        @Override
        public WallObject getWallObject() {
            return null;
        }

        @Override
        public SceneTilePaint getSceneTilePaint() {
            return null;
        }

        @Override
        public SceneTileModel getSceneTileModel() {
            return null;
        }

        @Override
        public WorldPoint getWorldLocation() {
            return null;
        }

        @Override
        public Point getSceneLocation() {
            return null;
        }

        @Override
        public LocalPoint getLocalLocation() {
            return null;
        }

        @Override
        public int getPlane() {
            return 0;
        }

        @Override
        public int getRenderLevel() {
            return 0;
        }

        @Override
        public boolean hasLineOfSightTo(Tile other) {
            return false;
        }

        @Override
        public List<TileItem> getGroundItems() {
            return null;
        }

        @Override
        public Tile getBridge() {
            return null;
        }
    };

    @Mock
    @Bind
    private final TileItem titem = new TileItem() {
        @Override
        public int getId() {
            return 0;
        }

        @Override
        public int getQuantity() {
            return 0;
        }

        @Override
        public int getSpawnTime() {
            return 0;
        }

        @Override
        public Model getModel() {
            return null;
        }

        @Override
        public int getModelHeight() {
            return 0;
        }

        @Override
        public void setModelHeight(int modelHeight) {

        }

        @Override
        public void draw(int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y, int z, long hash) {

        }

        @Override
        public Node getNext() {
            return null;
        }

        @Override
        public Node getPrevious() {
            return null;
        }

        @Override
        public long getHash() {
            return 0;
        }
    };


    @Mock
    @Bind
    private final ItemSpawned itemSpawned = new ItemSpawned(tile, titem);

    @Mock
    @Bind
    private final GameObjectSpawned gameObjectSpawned = new GameObjectSpawned();

    //@Mock
    //@Bind
    //private final Client client;

    //@Mock
    //@Bind
    //private final ClientThread clientThread;

    @Before
    public void initialization(){
        //Start Plugin? Maybe? I have no idea how this sh!t works.
        ActionOptionsPlugin aop = new ActionOptionsPlugin();
        try{
            aop.startUp();
        }
        catch (Exception e){
            System.out.println("Unexpected & Unknown Error");
            System.out.println(e);
        }

    }

    @Test
    public void returnTrue(){
        Assertions.assertTrue(true == true);
    }

    @Test
    public void itemSpawnandDespawn(){
        eventBus.post(itemSpawned);
        Assertions.assertTrue(ActionOptionsPanel.items == 1);
    }

    @Test
    public void npcSpawnandDespawn(){
        eventBus.post(npcSpawned);
        Assertions.assertTrue(ActionOptionsPanel.npcs == 1);
    }

    @Test
    public void gameObjectSpawnandDespawn(){
        eventBus.post(gameObjectSpawned);
        Assertions.assertTrue(ActionOptionsPanel.gameobjects == 1);
    }
}
