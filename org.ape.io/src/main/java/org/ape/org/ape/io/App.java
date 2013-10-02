package org.ape.org.ape.io;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   	
        TOFileWriter fileWriter = new TOFileWriter();
        File testFile = new File("/home/niclex/temp/test.txt");
        fileWriter.writeFile("123", "CM", "TOObject", testFile);
    }
}
