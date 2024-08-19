package net.sixik.sdmmobstages.stage.type;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.List;

public class MobReplaceStage extends MobStage{

    public EntityType<Entity> replaceEntity;

    public MobReplaceStage(String stage, List<EntityType<Entity>> entityTypeList, EntityType<Entity> replaceEntity) {
        super(stage, entityTypeList);
        this.replaceEntity = replaceEntity;
    }

    @Override
    public boolean add(AbstractStage someStage) {
        if(someStage instanceof MobReplaceStage mobStage){
            if(mobStage.stage.equals(this.stage) && mobStage.replaceEntity.equals(this.replaceEntity)){
                this.entityTypeList.addAll(mobStage.entityTypeList);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getID() {
        return "mobReplaceSpawn";
    }
}
