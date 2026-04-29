import java.io.IOException;
import java.util.ArrayList;

public interface Serializer {
    public void write(ArrayList<Contact> data) throws IOException;

    public ArrayList<Contact> read() throws IOException;
}
