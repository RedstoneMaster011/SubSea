package net.mcreator.subsea.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.subsea.world.inventory.CompresserGuiRecipesPage1Menu;
import net.mcreator.subsea.network.CompresserGuiRecipesPage1ButtonMessage;
import net.mcreator.subsea.SubseaMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CompresserGuiRecipesPage1Screen extends AbstractContainerScreen<CompresserGuiRecipesPage1Menu> {
	private final static HashMap<String, Object> guistate = CompresserGuiRecipesPage1Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;

	public CompresserGuiRecipesPage1Screen(CompresserGuiRecipesPage1Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("subsea:textures/screens/compresser_gui_recipes_page_1.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.subsea.compresser_gui_recipes_page_1.label_compresser"), 38, 6, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.subsea.compresser_gui_recipes_page_1.label_page_1"), 71, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.subsea.compresser_gui_recipes_page_1.label_oxo1"), 10, 41, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.subsea.compresser_gui_recipes_page_1.label_x"), 15, 33, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.subsea.compresser_gui_recipes_page_1.label_x1"), 15, 48, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.subsea.compresser_gui_recipes_page_1.label_x_iron_nugget"), 34, 33, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.subsea.compresser_gui_recipes_page_1.label_result_iron_ingot"), 34, 46, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.subsea.compresser_gui_recipes_page_1.label_empty"), 26, 32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.subsea.compresser_gui_recipes_page_1.label_empty1"), 26, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.subsea.compresser_gui_recipes_page_1.label_empty2"), 26, 48, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.subsea.compresser_gui_recipes_page_1.label_empty3"), 4, 32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.subsea.compresser_gui_recipes_page_1.label_empty4"), 4, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.subsea.compresser_gui_recipes_page_1.label_empty5"), 4, 48, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.subsea.compresser_gui_recipes_page_1.button_empty"), e -> {
			if (true) {
				SubseaMod.PACKET_HANDLER.sendToServer(new CompresserGuiRecipesPage1ButtonMessage(0, x, y, z));
				CompresserGuiRecipesPage1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 137, this.topPos + 6, 30, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
	}
}
