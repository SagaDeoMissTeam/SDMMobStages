package net.sixik.sdmmobstages.addons.crafttweaker.action;

import com.blamejared.crafttweaker.api.action.base.IRuntimeAction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.sixik.sdmmobstages.stage.StageContainer;
import net.sixik.sdmmobstages.stage.type.MobDimensionReplaceStage;
import net.sixik.sdmmobstages.stage.type.MobReplaceStage;

import java.util.ArrayList;
import java.util.List;

public class MobDimensionReplaceStageAction implements IRuntimeAction {

    public final String stage;
    public final EntityType<Entity>[] entityTypes;
    public final EntityType<Entity> replaceEntity;
    public final ResourceLocation dimension;

    public MobDimensionReplaceStageAction(String stage, EntityType<Entity>[] entityTypes, EntityType<Entity> replaceEntity, ResourceLocation dimension) {
        this.stage = stage;
        this.entityTypes = entityTypes;
        this.replaceEntity = replaceEntity;
        this.dimension = dimension;
    }

    @Override
    public void apply() {
        StageContainer.INSTANCE.put(new MobDimensionReplaceStage(stage, new ArrayList<>(List.of(entityTypes)), replaceEntity, dimension));
    }

    @Override
    public String describe() {
        return "Mobs " + entityTypes.toString() + " added to " + stage + ".stage and replace to " + replaceEntity.toString() + " on " + dimension.toString() + ".dimension";
    }

    @Override
    public String systemName() {
        return "Mob Stages";
    }
}
