package cc.procon;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * @author procon
 * @since 2022-12-22
 */
public class Test {
    public static void main(String[] args) {


        try  {
            List<String> ids = Files.readAllLines(new File("E:\\AppData\\UEStudio\\2.txt").toPath());
            int count = 0;
            for (String id : ids) {
                count = count + Integer.parseInt(id.trim());

            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
