package me.waterbroodje.treecutting.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.LOG && e.getPlayer().getItemInHand().getType() == Material.DIAMOND_AXE) {
            e.setCancelled(true);
            breakTree(e.getBlock());
        }
    }

    public void breakTree(Block tree){
        if(tree.getType()!=Material.LOG && tree.getType()!= Material.LEAVES) return;
        tree.breakNaturally();
        for(BlockFace face: BlockFace.values()) {
            breakTree(tree.getRelative(face));
        }
    }
}
