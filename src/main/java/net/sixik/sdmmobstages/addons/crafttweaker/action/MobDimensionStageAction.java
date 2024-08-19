package net.sixik.sdmmobstages.addons.crafttweaker.action;

import com.blamejared.crafttweaker.api.action.base.IRuntimeAction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.sixik.sdmmobstages.stage.StageContainer;
import net.sixik.sdmmobstages.stage.type.MobDimensionStage;

import java.util.ArrayList;
import java.util.List;

public class MobDimensionStageAction implements IRuntimeAction {

    public final String stage;
    public final EntityType<Entity>[] entityTypes;
    public final ResourceLocation dimension;

    public MobDimensionStageAction(String stage, EntityType<Entity>[] entityTypes, ResourceLocation dimension) {
        this.stage = stage;
        this.entityTypes = entityTypes;
        this.dimension = dimension;
    }

    @Override
    public void apply() {
        StageContainer.INSTANCE.put(new MobDimensionStage(stage, new ArrayList<>(List.of(entityTypes)), dimension));
    }

    @Override
    public String describe() {
        return "Mobs " + entityTypes.toString() + " added to " + stage + ".stage on " + dimension + ".dimension";
    }

    @Override
    public String systemName() {
        return "Mob Stages";
    }
}
