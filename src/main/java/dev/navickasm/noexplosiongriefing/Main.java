package dev.navickasm.noexplosiongriefing;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void clearCreeperExplosionBlockList(EntityExplodeEvent event) {
        if (event.getEntityType() == EntityType.CREEPER) {
            event.blockList().clear();
        }
    }

    @EventHandler
    public void cancelItemFrameDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Creeper && event.getEntityType() == EntityType.ITEM_FRAME) {
            event.setCancelled(true);
        }
    }
}
