package org.kisten.dragonslayer;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.RayTraceResult;

public class Reach implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event) {

        //рейтрейс и добавление дамага
        Player p = event.getPlayer();
        ItemStack item = p.getEquipment().getItemInMainHand();
        assert  item.getItemMeta() != null;
        if (event.getAction() == Action.LEFT_CLICK_AIR) {
            RayTraceResult res = p.rayTraceEntities(4, false);
            assert res != null;
            LivingEntity ent = (LivingEntity) res.getHitEntity();
            assert ent != null;
            ent.damage(20);
        }
    }
}