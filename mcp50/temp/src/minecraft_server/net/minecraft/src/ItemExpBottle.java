// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, EntityPlayer, PlayerCapabilities, ItemStack, 
//            World, EntityExpBottle

public class ItemExpBottle extends Item
{

    public ItemExpBottle(int p_i1030_1_)
    {
        super(p_i1030_1_);
    }

    public ItemStack func_6152_a(ItemStack p_6152_1_, World p_6152_2_, EntityPlayer p_6152_3_)
    {
        if(!p_6152_3_.field_35214_K.field_35657_d)
        {
            p_6152_1_.field_853_a--;
        }
        p_6152_2_.func_506_a(p_6152_3_, "random.bow", 0.5F, 0.4F / (field_4154_b.nextFloat() * 0.4F + 0.8F));
        if(!p_6152_2_.field_792_x)
        {
            p_6152_2_.func_526_a(new EntityExpBottle(p_6152_2_, p_6152_3_));
        }
        return p_6152_1_;
    }
}
