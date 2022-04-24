import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        File dir = new File("/Users/a.shalygin/Games/");
        File dir1 = new File("/Users/a.shalygin/Games/src");
        File dir2 = new File("/Users/a.shalygin/Games/res");
        File dir3 = new File("/Users/a.shalygin/Games/savegames");
        File dir4 = new File("/Users/a.shalygin/Games/temp");
        char space = ' ';

        if (dir1.mkdir() && dir2.mkdir() && dir3.mkdir() && dir4.mkdir()) {
            sb.append("Директории")
                    .append(space);
            for (File item : dir.listFiles()) {
                sb.append(item.getName())
                        .append(space);
            }
            sb.append("созданы")
                    .append("\n");
            File dir5 = new File("/Users/a.shalygin/Games/src/main");
            File dir6 = new File("/Users/a.shalygin/Games/src/test");
            if (dir5.mkdir() && dir6.mkdir()) {
                sb.append("Директории")
                        .append(space);
                for (File item : dir1.listFiles()) {
                    sb.append(item.getName())
                            .append(space);
                }
                sb.append("в папке")
                        .append(space)
                        .append(dir1.getName())
                        .append(space)
                        .append("созданы")
                        .append("\n");
                File file1 = new File(dir5, "Main.java");
                File file2 = new File(dir5, "Utils.java");
                try {
                    if (file1.createNewFile() && file2.createNewFile()) {
                        for (File item : dir5.listFiles()) {
                            sb.append("Фаил")
                                    .append(space)
                                    .append(item.getName())
                                    .append(space)
                                    .append("создан\n");
                        }
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            File dir7 = new File("/Users/a.shalygin/Games/res/drawables");
            File dir8 = new File("/Users/a.shalygin/Games/res/vectors");
            File dir9 = new File("/Users/a.shalygin/Games/res/icons");
            if (dir7.mkdir() && dir8.mkdir() && dir9.mkdir()) {
                sb.append("Директории")
                        .append(space);
                for (File item : dir2.listFiles()) {
                    sb.append(item.getName())
                            .append(space);
                }
                sb.append("в папке")
                        .append(space)
                        .append(dir2.getName())
                        .append(space)
                        .append("созданы\n");
            }
        }
        File file3 = new File(dir4, "temp.txt");
        try {
            if (file3.createNewFile()) {
                sb.append("Фаил")
                        .append(space)
                        .append(file3.getName())
                        .append(space)
                        .append("создан\n");

                FileWriter writer = new FileWriter(file3);
                writer.write(sb.toString());
                writer.flush();
                writer.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
