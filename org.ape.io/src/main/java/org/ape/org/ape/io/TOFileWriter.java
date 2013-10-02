package org.ape.org.ape.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Files;

public class TOFileWriter {

	private static Logger logger = LoggerFactory.getLogger(TOFileWriter.class);
	
	private static final String basePath = "/home/niclex/temp";
	private static final String fileExtension = "dhef";
	
	public boolean writeFile(String clientId, String systemId, String toObjectType, File sourceFile) {
		boolean returnValue = false;
		
		UUID uuid = UUID.randomUUID();
		URIBuilder uriBuilder = new URIBuilder(URIBuilder.URISchema.file);
		uriBuilder.append(basePath).append(clientId).append(systemId).append(toObjectType).append(uuid+"."+fileExtension);
		
		URI fileUri = null;
		try {
			fileUri = uriBuilder.toURI();
		} catch (URISyntaxException e) {
			logger.error("Failed to build uri: "+uriBuilder.toString(), e);
		}
		
		File targetFile = new File(fileUri);

		//create directories if necessary
		if(!targetFile.getParentFile().exists()) {
			targetFile.getParentFile().mkdir();		}
		
		//create file and copy source file to target file
		try {
			if(targetFile.createNewFile()) {
				Files.copy(sourceFile, targetFile);
				returnValue = true;
			}
		} catch (IOException e) {
			logger.error("Failed to create and copy file.", e);
		}

		logger.info("file "+targetFile.getAbsolutePath()+" successful written: "+returnValue);
		return returnValue;
	}
	
}
