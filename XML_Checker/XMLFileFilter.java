package XML_Checker;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class XMLFileFilter extends FileFilter {

        public String getDescription() {
            return "*.xml;*.dtd";
        }

        public boolean accept(File file) {
            String name = file.getName();
            return file.isDirectory() || name.toLowerCase().endsWith(".xml") || name.toLowerCase().endsWith(".dtd");
        }
}
