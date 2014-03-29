package eu.bbnetz.Service;

import eu.bbnetz.Model.Csv;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 * User: avalarion
 * Date: 26.03.14
 * Time: 12:18
 * To change this template use File | Settings | File Templates.
 */
public class ReadCsv {

    public static Csv read(File file) throws IOException{
        String completeFile = ReadCsv.readFile(file.getPath(), Charset.defaultCharset());
        String[] lines = completeFile.split("\n");
        Csv csv = new Csv(lines.length);
        for(String line: lines) {
            csv.addLine(Csv.separateLine(line));
        }
        return csv;
    }

    protected static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }
}
