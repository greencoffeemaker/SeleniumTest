package jp.seleniumtest;

import java.util.ResourceBundle;

public class SeleniumResource {

	private static ResourceBundle resource = ResourceBundle.getBundle("selenium");

	public static ResourceBundle getInsetance() {
		return SeleniumResource.resource;
	}

}
