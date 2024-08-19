package net.sixik.sdmmobstages;

import net.darkhax.gamestages.GameStageHelper;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.sixik.sdmmobstages.stage.StageContainer;
import net.sixik.sdmmobstages.stage.type.MobDimensionReplaceStage;
import net.sixik.sdmmobstages.stage.type.MobDimensionStage;
import net.sixik.sdmmobstages.stage.type.MobReplaceStage;
import net.sixik.sdmmobstages.stage.type.MobStage;
import net.sixik.sdmmobstages.utils.ChunkHelper;

public class ModEvents {

    @SubscribeEvent
    public void onSpawn(MobSpawnEvent.PositionCheck event){
        Entity entity = event.getEntity();
        Level level = entity.level();
        EntityType<?> entityType = entity.getType();

        Player player = ChunkHelper.getNearestPlayer(entity.level(), entity.position());

        for (MobDimensionStage d1 : StageContainer.INSTANCE.getMobDimStage()) {
            if(d1.entityTypeList.contains(entityType) && d1.dimension.equals(entity.level().dimension().location())){

                if(!ChunkHelper.isLevelHavePlayers(entity.level()) || player == null || !GameStageHelper.hasStage(player, d1.stage)) {
                    event.setResult(Event.Result.DENY);
                    entity.checkDespawn();
                    return;
                }

            }
        }

        for (MobDimensionReplaceStage d1 : StageContainer.INSTANCE.getMobDimensionReplaceStage()) {
            if(d1.entityTypeList.contains(entityType) && d1.dimension.equals(level.dimension().location())){

                if(!ChunkHelper.isLevelHavePlayers(entity.level()) || player == null) {
                    event.setResult(Event.Result.DENY);
                    return;
                }

                if(!GameStageHelper.hasStage(player, d1.stage)){
                    Entity e1 = d1.replaceEntity.create(level);
                    e1.setPos(event.getX(), event.getY(), event.getZ());
                    level.addFreshEntity(e1);
                    entity.checkDespawn();
                    event.setResult(Event.Result.DENY);
                }

            }
        }

        for (MobReplaceStage d1 : StageContainer.INSTANCE.getMobReplaceStage()) {
            if(d1.entityTypeList.contains(entityType)){

                if(!ChunkHelper.isLevelHavePlayers(entity.level()) || player == null) {
                    event.setResult(Event.Result.DENY);
                    return;
                }

                if(!GameStageHelper.hasStage(player, d1.stage)){
                    Entity e1 = d1.replaceEntity.create(level);
                    e1.setPos(event.getX(), event.getY(), event.getZ());
                    level.addFreshEntity(e1);
                    entity.checkDespawn();
                    event.setResult(Event.Result.DENY);
                }

            }
        }

        for (MobStage d1 : StageContainer.INSTANCE.getMobStage()) {
            if(d1.entityTypeList.contains(entityType)){

                if(!ChunkHelper.isLevelHavePlayers(entity.level()) || player == null || !GameStageHelper.hasStage(player, d1.stage)) {
                    event.setResult(Event.Result.DENY);
                    entity.checkDespawn();
                    return;
                }

            }
        }
    }
}
