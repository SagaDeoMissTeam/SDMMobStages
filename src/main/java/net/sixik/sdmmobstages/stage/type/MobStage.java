package net.sixik.sdmmobstages.stage.type;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class MobStage extends AbstractStage{

    public List<EntityType<Entity>> entityTypeList = new ArrayList<>();

    public MobStage(String stage, List<EntityType<Entity>> entityTypeList) {
        super(stage);
        this.entityTypeList = entityTypeList;
    }

    @Override
    public void execute(Object object1, Object object2, Object object3) {

    }

    @Override
    public boolean add(AbstractStage someStage) {
        if(someStage instanceof MobStage mobStage){
            if(mobStage.stage.equals(this.stage)){
                this.entityTypeList.addAll(mobStage.entityTypeList);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getID() {
        return "mobSpawn";
    }
}
