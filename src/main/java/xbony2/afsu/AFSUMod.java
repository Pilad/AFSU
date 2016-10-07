package xbony2.afsu;

import xbony2.afsu.blocks.AFSUBlock;
import xbony2.afsu.blocks.ItemBlockAFSU;
import xbony2.afsu.gui.GuiHandler;
import xbony2.afsu.items.AFB;
import xbony2.afsu.tileentity.TileEntityAFSU;
import ic2.api.item.IC2Items;
import ic2.api.recipe.Recipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = AFSUMod.AFSU_MODID, name = "AFSU Mod", version = "@VERSION@", dependencies = "required-after:IC2")
public class AFSUMod {

    public static final String AFSU_MODID = "AFSU";

	@Instance(AFSUMod.AFSU_MODID)
	public static AFSUMod instance;

	public static final Block AFSU = new AFSUBlock();
	public static final Item ALC = new AFB();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
        ConfigHandler.init(event.getSuggestedConfigurationFile());

        GameRegistry.registerTileEntity(TileEntityAFSU.class, "AFSU");

		GameRegistry.registerBlock(AFSU, ItemBlockAFSU.class, "AFSU");
		GameRegistry.registerItem(ALC, "ALC");
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
        NetworkRegistry.INSTANCE.registerGuiHandler(AFSUMod.instance, new GuiHandler());
		Recipes.advRecipes.addRecipe(new ItemStack(ALC),
			"GIG", "IUI", "GIG",
				'G', IC2Items.getItem("glassFiberCableItem"),
				'I', IC2Items.getItem("iridiumPlate"),
				'U', IC2Items.getItem("uuMatterCell"));
		
		Recipes.advRecipes.addRecipe(new ItemStack(AFSU),
			"MGM", "IAI", "MGM",
				'I', IC2Items.getItem("iridiumPlate"),
				'G', IC2Items.getItem("glassFiberCableItem"),
				'M', IC2Items.getItem("mfsUnit"),
				'A', AFSUMod.ALC);
	}
}
