package com.github.totoCastaldi.minecraft.bukkit.plugin.walkthrough;

import com.google.common.collect.Iterables;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
        }

        return true;
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