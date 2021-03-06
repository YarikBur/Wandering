package ru.sgs.wandering.desktop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sgstudio.sgs02.utils.Language;
import com.sgstudio.sgs02.utils.Settings;

import ru.sgs.wandering.Start;

public class DesktopLauncher {
	static String locale;
	
	static Language lan;
	static Settings cfg;
	
	public static void main (String[] arg) throws FileNotFoundException, IOException {
		locale = Locale.getDefault() + "";
//		locale = "en_UK";
		
		lan = new Language(locale);
		cfg = new Settings();
		Settings.setProperty("language", locale);
		if(Settings.out())
			System.out.println(Language.getMessage(2) + locale);
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Wandering";
		config.resizable = false;
		config.width = 800;
		config.height = 600;
		new LwjglApplication(new Start(), config);
	}
}
