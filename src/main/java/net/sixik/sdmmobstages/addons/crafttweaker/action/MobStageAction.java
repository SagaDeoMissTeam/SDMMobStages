package net.sixik.sdmmobstages.addons.crafttweaker.action;

import com.blamejared.crafttweaker.api.action.base.IRuntimeAction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.sixik.sdmmobstages.stage.StageContainer;
import net.sixik.sdmmobstages.stage.type.MobStage;

import java.util.ArrayList;
import java.util.List;

public class MobStageAction implements IRuntimeAction {

    public final String stage;
    public final EntityType<Entity>[] entityTypes;

    public MobStageAction(String stage, EntityType<Entity>[] entityTypes) {
        this.stage = stage;
        this.entityTypes = entityTypes;
    }

    @Override
    public void apply() {
        StageContainer.INSTANCE.put(new MobStage(stage, new ArrayList<>(List.of(entityTypes))));
    }

    @Override
    public String describe() {
        return "Mobs " + entityTypes.toString() + " added to " + stage + ".stage";
    }

    @Override
    public String systemName() {
        return "Mob Stages";
    }
}
