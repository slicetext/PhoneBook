import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVSerializer implements Serializer{
    @Override
    public void write(ArrayList<Contact> data) throws IOException {
        // Clear file
        new PrintWriter("data.csv").close();
        // Write new content
        FileWriter writer = new FileWriter("data.csv", true);
        for(Contact contact : data) {
            writer.write(contact.getName() + "," + contact.getNumber() + "\n");
        }
        writer.close();
    }

    @Override
    public ArrayList<Contact> read() throws IOException {
        ArrayList<Contact> result = new ArrayList<>();
        File file = new File("data.csv");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            result.add(new Contact(
                    parts[0],
                    Integer.parseInt(parts[1])
            ));
        }
        return result;
    }
}
