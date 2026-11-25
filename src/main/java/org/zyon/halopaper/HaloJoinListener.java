package org.zyon.halopaper;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class HaloJoinListener implements Listener {

    private final HaloPaper plugin;

    public HaloJoinListener(HaloPaper plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        event.getPlayer().getInventory().addItem(
            plugin.getHaloItem().getHalo()
        );

    }
}