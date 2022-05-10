import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        newDir("/Users/a.shalygin", "Games");
        newDir("/Users/a.shalygin/Games", "src");
        newDir("/Users/a.shalygin/Games", "res");
        newDir("/Users/a.shalygin/Games", "savegames");
        newDir("/Users/a.shalygin/Games", "temp");

        newDir("/Users/a.shalygin/Games/src", "main");
        newDir("/Users/a.shalygin/Games/src", "test");

        newFile("/Users/a.shalygin/Games/src/main", "Main.java");
        newFile("/Users/a.shalygin/Games/src/main", "Utils.java");

        newDir("/Users/a.shalygin/Games/res", "drawables");
        newDir("/Users/a.shalygin/Games/res", "vectors");
        newDir("/Users/a.shalygin/Games/res", "icons");

        newFile("/Users/a.shalygin/Games/temp", "temp.txt");


        try (FileWriter writer = new FileWriter("/Users/a.shalygin/Games/temp/temp.txt")) {
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }


    public static void newDir(String path, String name) {
        File file = new File(path, name);
        if (file.mkdir()) {
            sb.append("Директория " + name + " создана \n");
        }
    }

    public static void newFile(String path, String name) {
        File file = new File(path, name);
        try {
            if (file.createNewFile())
                sb.append("Фаил " + name + " создан\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
