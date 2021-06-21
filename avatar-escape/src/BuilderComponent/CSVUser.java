package BuilderComponent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVUser {
    private String dataSource;
    private String[][] commands;

    public CSVUser() {
        this.commands = null;
        this.dataSource = null;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
        if (dataSource == null) {
            commands = null;
        } else
            readCSV();
    }

    public String[][] requestCommands() {
        return commands;
    }

    private void readCSV() {
        try {
            BufferedReader file = new BufferedReader(new FileReader(dataSource));

            String line = file.readLine();
            int i = 0;
            commands = new String[36][];
            while (line != null) {
                commands[i] = line.split(",");
                line = file.readLine();
                i++;
            }
            file.close();
        } catch (IOException erro) {
            erro.printStackTrace();
        }
    }
}
