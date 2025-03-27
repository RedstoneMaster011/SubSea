package net.mcreator.subsea.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.subsea.world.inventory.CompresserGuiMenu;
import net.mcreator.subsea.network.CompresserGuiButtonMessage;
import net.mcreator.subsea.SubseaMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CompresserGuiScreen extends AbstractContainerScreen<CompresserGuiMenu> {
	private final static HashMap<String, Object> guistate = CompresserGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_compress;

	public CompresserGuiScreen(CompresserGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("subsea:textures/screens/compresser_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.subsea.compresser_gui.label_empty"), 126, 37, -13421773, false);
	}

	@Override
	public void init() {
		super.init();
		button_compress = Button.builder(Component.translatable("gui.subsea.compresser_gui.button_compress"), e -> {
			if (true) {
				SubseaMod.PACKET_HANDLER.sendToServer(new CompresserGuiButtonMessage(0, x, y, z));
				CompresserGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 101, this.topPos + 58, 67, 20).build();
		guistate.put("button:button_compress", button_compress);
		this.addRenderableWidget(button_compress);
	}
}
