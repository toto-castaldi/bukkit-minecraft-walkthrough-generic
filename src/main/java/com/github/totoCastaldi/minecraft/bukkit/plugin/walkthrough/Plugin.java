package com.github.totoCastaldi.minecraft.bukkit.plugin.walkthrough;

import com.google.common.collect.Iterables;
import org.apache.commons.lang.StringUtils;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Plugin extends JavaPlugin {

    public boolean onCommand(
            CommandSender sender,
            Command command,
            String commandLabel,
            String[] args
    ) {

        System.out.println("onCommand command [" + command + "], commandLabel [" + commandLabel + "] args [" + Arrays.asList(args) + "]");

        Player me = (Player) sender;

        if (StringUtils.equalsIgnoreCase("step", commandLabel)) {
            final String firstParameter = StringUtils.stripToEmpty(Iterables.getFirst(Arrays.asList(args), StringUtils.EMPTY));

            if ("1".equalsIgnoreCase(firstParameter)) step1(me);
            if ("2".equalsIgnoreCase(firstParameter)) step2(me);
            if ("3".equalsIgnoreCase(firstParameter)) step3(me);
            if ("4".equalsIgnoreCase(firstParameter)) step4(me);
            if ("5".equalsIgnoreCase(firstParameter)) step5(me);
            if ("6".equalsIgnoreCase(firstParameter)) step6(me);
        }

        return true;
    }

    private void step6(Player player) {
        player.playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
    }

    private void step5(Player player) {
        PlayerInventory inventory = player.getInventory();

        inventory.addItem(new ItemStack(Material.BOOK));

        Integer times = 3;

        for (int i=times;i!=0;i--) {
            inventory.addItem(new ItemStack(Material.DIAMOND_PICKAXE));
        }
    }

    private void step4(Player player) {
        player.playSound(player.getLocation(), Sound.GHAST_SCREAM,  0.1f, 1.0f);
    }

    private void step3(Player player) {
        Location location = player.getLocation();
        World world = location.getWorld();

        Cow cow = world.spawn(player.getLocation(), Cow.class);
        cow.setCustomName("Toto");
        cow.setCustomNameVisible(true);
    }

    private void step2(Player player) {
        Location location = player.getLocation();
        World world = location.getWorld();

        location.add(-2, 0, 0);

        world.getBlockAt(location).setType(Material.BRICK);
    }

    private void step1(Player player) {
        Location location = player.getLocation();
        int result = 5 + 3;
        String playerListName = player.getPlayerListName();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        String operationResultMessage = "The result of the operation 5 + 3 is = " + result;
        String listNameMessage = "Your name is " + playerListName;
        String locationMessage = "Your position is X = " + x + ", Y = " + y + ", Z = " + z;

        player.sendMessage(operationResultMessage);
        player.sendMessage(listNameMessage);
        player.sendMessage(locationMessage);
    }

    public void onEnable() {
        System.out.println("enEnable");
    }


    public void onLoad() {
        System.out.println("onLoad");
    }

    public void onDisable() {
        System.out.println("onDisable");
    }

    public List<String> onTabComplete(
            CommandSender sender,
            Command command,
            String alias,
            String[] args) {

        System.out.println("onTabComplete");
        return new ArrayList<String>();
    }
}