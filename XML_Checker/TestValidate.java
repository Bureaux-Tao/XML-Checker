package XML_Checker;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import org.w3c.dom.*;

public class TestValidate {
    private String fileName;
    TestValidate (String fileName) {
        this.fileName=fileName;
        if(fileName.endsWith(".xml")||fileName.endsWith(".dtd")) {
            Check();
        } else {
            exception_m e=new exception_m("Not an xml file!");
        }
    }

    public void Check() {
        try {
            System.out.println("Directory:");
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            DocumentBuilder builder=factory.newDocumentBuilder();
            MyHandler handler=new MyHandler();
            builder.setErrorHandler(handler);
            org.w3c.dom.Document document=builder.parse(new File(fileName));
            if(handler.errorMessage==null) {
                System.out.println("valid!");
                Succeed success=new Succeed();
            } else {
                System.out.println("Invalid!");
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            exception_m E=new exception_m(e.toString());
        }
    }
}
