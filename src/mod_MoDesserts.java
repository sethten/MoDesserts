package net.minecraft.src;

public class mod_MoDesserts extends BaseMod
{
	public static int cupcakeMakerTop;
	public static final Block cupcakeMaker = new BlockCupcakeMaker().setBlockName("cupcakeMaker").setHardness(3.5F);
	public void load()
	{
		ModLoader.registerBlock(cupcakeMaker);
		ModLoader.addName(cupcakeMaker, "Cupcake Maker");
		cupcakeMaker.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/MoDesserts/cupcakeMaker.png");
		cupcakeMakerTop = ModLoader.addOverride("/terrain.png", "/MoDesserts/cupcakeMakerTop.png");
		ModLoader.addShapelessRecipe(new ItemStack(cupcakeMaker, 24), new Object[]{
			Block.dirt
		});
		ModLoader.addShapelessRecipe(new ItemStack(Item.pickaxeGold, 12), new Object[]{
			Block.dirt, Block.dirt
		});
	}
	public String getVersion()
	{
		return "1.0";
	}
}