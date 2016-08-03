package org.bitbucket.ilucheti.deathbanplus.utils.models;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	
	private File mFile;
	private String mFileName;
	private YamlConfiguration mYaml;
	
	public Config(String fileName) {
		mFileName = fileName;
	}
	
	public File getFile() {
		return mFile;
	}
	
	public void setFile(File file) {
		mFile = file;
	}
	
	public YamlConfiguration getYaml() {
		return mYaml;
	}
	
	public void setYaml(YamlConfiguration yaml) {
		mYaml = yaml;
	}
	
	public String getFileName() {
		return mFileName;
	}
	
	public void setFileName(String fileName) {
		mFileName = fileName;
	}
	
	public void load() {
		try {
			mYaml.load(mFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
