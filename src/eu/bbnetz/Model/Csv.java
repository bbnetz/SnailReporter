package eu.bbnetz.Model;

/**
 * Created with IntelliJ IDEA.
 * User: avalarion
 * Date: 26.03.14
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public class Csv {

    protected String[][] fields;

    protected String[] identifier;

    protected int lastLine = 0;

    public Csv(int fieldSize) {
        this.fields = new String[fieldSize][];
    }

    public void addLine(String[] line) {
        if(this.lastLine == 0) {
            this.identifier = line;
        }else{
            this.fields[this.lastLine - 1] = line;
        }
        this.lastLine++;
    }

    public int getLineCounter() {
        return fields.length;
    }

    public String getLineValue(int line, String value) {
        return this.fields[line][this.getIdentifierPosition(value)];
    }

    protected int getIdentifierPosition(String value) {
        int position = -1;
        for(int i = 0; i < this.identifier.length; i++)
            if(this.identifier[i].equals(value))
                position = i;
        if(position == -1)
            throw new RuntimeException("No Csv Value for " + value + " found.");
        return position;
    }

    public boolean isEmptyLine(int lineNumber) {
        if(this.fields[lineNumber] == null) return true;
        return false;
    }

    public static String[] separateLine(String line) {
        // [\"](.*?)[\"],
        return line.split(",");
    }


}
