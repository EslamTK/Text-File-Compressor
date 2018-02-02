

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class TxtFileFilter extends FileFilter {

    @Override
    public String getDescription() {
        return "Text Files (*.txt)";
    }

    @Override
    public boolean accept(File file) {
        String fileName = file.getName();
        int exIndex = fileName.lastIndexOf('.');
        if (exIndex > -1) {
            if (fileName.substring(exIndex + 1).equals("txt")) {
                return true;
            }
        }
        return file.isDirectory();
    }
}
