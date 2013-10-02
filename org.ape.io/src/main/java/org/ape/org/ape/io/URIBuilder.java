package org.ape.org.ape.io;

import java.net.URI;
import java.net.URISyntaxException;

public class URIBuilder {

	public enum URISchema{
		file, http, ftp
	}
	
	private StringBuilder uriString;
	
	public URIBuilder(URISchema uriSchema) {
		uriString = new StringBuilder(uriSchema.name()).append(":").append("/");
	}
	
	public URIBuilder append(String pathElement) {
		uriString.append("/").append(pathElement);
		return this;
	}
	
	public URI toURI() throws URISyntaxException {
		return new URI(uriString.toString());
	}

	@Override
	public String toString() {
		return uriString.toString();
	}
	
	
}
