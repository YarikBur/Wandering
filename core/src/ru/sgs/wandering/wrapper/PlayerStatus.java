package ru.sgs.wandering.wrapper;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sgstudio.sgs02.utils.Settings;
import com.sgstudio.sgs02.utils.Variables;

import ru.sgs.wandering.gui.PlayerStatusIcon;
import ru.sgs.wandering.gui.PlayerStatusLines;

public class PlayerStatus extends WrapperSuper {
	PlayerStatusIcon icon;
	PlayerStatusLines linesHp;
	PlayerStatusLines linesEnergy;
	PlayerStatusLines linesStamina;
	
	public PlayerStatus() {
		this.setCoordinates(((Variables.stringToInt(Settings.getProperty("width"))/100)*4f)/2, 
				(Variables.stringToInt(Settings.getProperty("height"))/100)*40.2f);
		
		icon = new PlayerStatusIcon("Player.png", 2);
		
		linesHp = new PlayerStatusLines("linesHP.png");
		linesEnergy = new PlayerStatusLines("linesEN.png");
		linesStamina = new PlayerStatusLines("linesST.png");
		
		linesHp.setNewCol(5, false);
		linesEnergy.setNewCol(4, true);
		linesStamina.setColColor(1, 0);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		icon.render(batch, x, y);
		
		linesHp.render(batch, x+icon.getWigth()+4, y*2+68);
		linesEnergy.render(batch, x+icon.getWigth()+4, y*2+38);
		linesStamina.render(batch, x+icon.getWigth()+4, y*2+8);
	}
}
