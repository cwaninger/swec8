package com.github.lhrb.nemo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.github.lhrb.nemo.KillingNemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		//LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//new LwjglApplication(new KillingNemo(), config);
	    new LwjglApplication(new KillingNemo(), "Killing Nemo", 800, 600);
	}
}
