package com.sigurd4.bioshock.proxy;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.sigurd4.bioshock.event.HandlerServer;
import com.sigurd4.bioshock.event.HandlerServerFML;

public class ProxyServer extends ProxyCommon
{
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		
		MinecraftForge.EVENT_BUS.register(new HandlerServer());
		FMLCommonHandler.instance().bus().register(new HandlerServerFML());
	}
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
	}
	
	@Override
	public World world(int dimension)
	{
		return MinecraftServer.getServer().worldServers[dimension];
	}
}
