package net.kosssst.uncooked.entity;

import net.kosssst.uncooked.UnCooked;
import net.kosssst.uncooked.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, UnCooked.MOD_ID);

    public static final RegistryObject<BlockEntityType<UnFurnaceBlockEntity>> UNFURNACE = BLOCK_ENTITIES.register("unfurnace", () -> BlockEntityType.Builder.of(UnFurnaceBlockEntity::new, ModBlocks.UNFURNACE_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
