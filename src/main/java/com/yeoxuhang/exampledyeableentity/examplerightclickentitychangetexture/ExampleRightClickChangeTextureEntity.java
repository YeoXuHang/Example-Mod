package com.yeoxuhang.exampledyeableentity.examplerightclickentitychangetexture;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;


public class ExampleRightClickChangeTextureEntity extends PathfinderMob {

    private static final EntityDataAccessor<Boolean> CLICKED = SynchedEntityData.defineId(ExampleRightClickChangeTextureEntity.class, EntityDataSerializers.BOOLEAN);
    public ExampleRightClickChangeTextureEntity(EntityType<? extends PathfinderMob> type, Level level) {
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
        this.entityData.define(CLICKED, false);
    }
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        this.entityData.set(CLICKED, this.isClicked());
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);

    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!this.isClicked() && itemstack.is(Items.DIAMOND)) {
            this.setClicked(true);
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            return InteractionResult.SUCCESS;
        }
        if (this.isClicked() && itemstack.is(Items.NETHERITE_INGOT)) {
            this.setClicked(false);
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }
            return InteractionResult.SUCCESS;
        }
            return super.mobInteract(player, hand);
        }

    public Boolean isClicked() {
        return this.entityData.get(CLICKED);
    }
    public void setClicked(boolean id) {
        this.entityData.set(CLICKED, id);
    }
}