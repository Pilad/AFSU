package xbony2.afsu.gui;

import xbony2.afsu.container.ContainerAFSU;
import xbony2.afsu.tileentity.TileEntityAFSU;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
		if (entity instanceof TileEntityAFSU)
			return new ContainerAFSU(player, (TileEntityAFSU)entity);

		return null;
	}

	@Override
    @SideOnly(Side.CLIENT)
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
		if (entity instanceof TileEntityAFSU)
			return new GuiAFSU(new ContainerAFSU(player, (TileEntityAFSU)entity));

		return null;
	}

}
