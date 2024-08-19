package net.sixik.sdmmobstages.addons.crafttweaker.action;

import com.blamejared.crafttweaker.api.action.base.IRuntimeAction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.sixik.sdmmobstages.stage.StageContainer;
import net.sixik.sdmmobstages.stage.type.MobReplaceStage;

import java.util.ArrayList;
import java.util.List;

public class MobReplaceStageAction implements IRuntimeAction {

    public final EntityType<Entity> replaceEntity;
    public final String stage;
    public final EntityType<Entity>[] entityTypes;

    public MobReplaceStageAction(String stage,  EntityType<Entity>[] entityTypes, EntityType<Entity> replaceEntity) {
        this.replaceEntity = replaceEntity;
        this.stage = stage;
        this.entityTypes = entityTypes;
    }

    @Override
    public void apply() {
        StageContainer.INSTANCE.put(new MobReplaceStage(stage, new ArrayList<>(List.of(entityTypes)), replaceEntity));
    }

    @Override
    public String describe() {
        return "Mobs " + entityTypes.toString() + " added to " + stage + ".stage and replace to " + replaceEntity.toString();
    }

    @Override
    public String systemName() {
        return "Mob Stages";
    }
}
