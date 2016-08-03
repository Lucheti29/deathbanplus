package org.bitbucket.ilucheti.deathbanplus.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.bitbucket.ilucheti.deathbanplus.utils.models.Config;
import org.bukkit.configuration.file.YamlConfiguration;

public class IOUtils {
	
	public static void copy(InputStream in, File file) {
	    try {
	        OutputStream out = new FileOutputStream(file);
	        byte[] buf = new byte[1024];
	        int len;
	        while((len=in.read(buf))>0){
	            out.write(buf,0,len);
	        }
	        out.close();
	        in.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static void loadFile(Config config) {
		config.setYaml(new YamlConfiguration());
	    config.load();
	}
}
