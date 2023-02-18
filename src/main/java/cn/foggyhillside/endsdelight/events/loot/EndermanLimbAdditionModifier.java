package cn.foggyhillside.endsdelight.events.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class EndermanLimbAdditionModifier extends LootModifier {

    public static final Supplier<Codec<EndermanLimbAdditionModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst)
                    .and(ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter((m) -> m.item))
                    .apply(inst, EndermanLimbAdditionModifier::new)));

    private final Item item;

    protected EndermanLimbAdditionModifier(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        generatedLoot.add(new ItemStack(item, 1));
        if (context.getRandom().nextFloat() > 0.7) {
            generatedLoot.add(new ItemStack(item, 1));
        };
        if (context.getRandom().nextFloat() > 0.7) {
            generatedLoot.add(new ItemStack(item, 1));
        };
        if (context.getRandom().nextFloat() > 0.7) {
            generatedLoot.add(new ItemStack(item, 1));
        };
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
