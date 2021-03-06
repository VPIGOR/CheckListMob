package util;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public static Iterator<Object> names() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class
                        .getResourceAsStream("/names.data")));

        List<Object> userData = new ArrayList<>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line);
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }
}
