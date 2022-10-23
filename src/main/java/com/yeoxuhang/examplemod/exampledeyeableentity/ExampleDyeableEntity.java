package com.yeoxuhang.examplemod.exampledeyeableentity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;


public class ExampleDyeableEntity extends PathfinderMob {

    private static final EntityDataAccessor<Integer> DATA_COLOR = SynchedEntityData.defineId(ExampleDyeableEntity.class, EntityDataSerializers.INT);
    public ExampleDyeableEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
         xpReward = 0;
         setNoAi(false);
    }

    public static AttributeSupplier setAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 18.0D)
                .add(Attributes.ATTACK_DAMAGE, 0.0f)
                .add(Attributes.ATTACK_SPEED, 0.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.3f)
                .add(Attributes.FOLLOW_RANGE, 32D)
                .build();
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 0.8D));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.7D));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 0.7D));
        }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_COLOR, DyeColor.LIGHT_BLUE.getId());
    }
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putByte("Color", (byte)this.getCollarColor().getId());
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("Color", 99)) {
            this.setColor(DyeColor.byId(tag.getInt("Color")));
        }
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        DyeColor dyecolor = ((DyeItem) item).getDyeColor();
        if (dyecolor != this.getCollarColor()) {
            this.setColor(dyecolor);
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            return InteractionResult.SUCCESS;
        }
            return super.mobInteract(player, hand);
        }

    public DyeColor getCollarColor() {
        return DyeColor.byId(this.entityData.get(DATA_COLOR));
    }
    public void setColor(DyeColor id) {
        this.entityData.set(DATA_COLOR, id.getId());
    }
}