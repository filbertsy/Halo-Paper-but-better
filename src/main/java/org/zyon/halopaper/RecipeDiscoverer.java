package org.zyon.halopaper;

import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;


public class RecipeDiscoverer implements Listener {
    private final NamespacedKey hellkey;
    private final NamespacedKey purekey;
    private final NamespacedKey angelkey;
    private final NamespacedKey halokey;
    public RecipeDiscoverer() {
    hellkey = new NamespacedKey("zyon", "hellish_gold");
    purekey = new NamespacedKey("zyon", "purified_hellish_gold");
    angelkey = new NamespacedKey("zyon", "angelic_gold");
    halokey = new NamespacedKey("zyon", "halo");
    }
    
    @EventHandler
    public void onItemPickup(EntityPickupItemEvent) {
        
    }
}
