package org.zyon.halopaper;

import org.bukkit.plugin.java.JavaPlugin;

public class HaloPaper extends JavaPlugin {

    private HaloItem haloItem;

    @Override
    public void onEnable() {

        haloItem = new HaloItem(this);

        getServer().getPluginManager().registerEvents(
            new HaloJoinListener(this),
            this
        );

        HellishGold hellishGold = new HellishGold();
        hellishGold.registerRecipe();

        PHGold phgold = new PHGold();
        phgold.registerRecipe();

        AngelicGold angelicgold = new AngelicGold();
        angelicgold.registerRecipe();

        haloItem.registerRecipe();

        getLogger().info("HaloPaper enabled!");
    }

    public HaloItem getHaloItem() {
        return haloItem;
    }
}