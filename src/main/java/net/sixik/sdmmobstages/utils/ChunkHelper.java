package net.sixik.sdmmobstages.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class ChunkHelper {

    public static boolean isLevelHavePlayers(Level level) {
        return !level.players().isEmpty();
    }

    public static Player getNearestPlayer(LevelAccessor level, BlockPos pos){
        List<? extends Player> players = level.players();

        Player nearestPlayer = null;
        double minDistance = Double.MAX_VALUE;

        for (Player player : players) {
            double distance = player.distanceToSqr(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
            if (distance < minDistance) {
                minDistance = distance;
                nearestPlayer = player;
            }
        }

        return nearestPlayer;
    }

    public static Player getNearestPlayer(Level level, Vec3 position) {
        List<? extends Player> players = level.players();

        Player nearestPlayer = null;
        double minDistance = Double.MAX_VALUE;

        for (Player player : players) {
            double distance = player.distanceToSqr(position.x + 0.5, position.y + 0.5, position.z + 0.5);
            if (distance < minDistance) {
                minDistance = distance;
                nearestPlayer = player;
            }
        }

        return nearestPlayer;
    }
}
