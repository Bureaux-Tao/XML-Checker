package XML_Checker;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.activation.DataHandler;
import javax.activation.DataSource;

public class MyHandler extends DefaultHandler {
    String errorMessage=null;
    public void error(SAXParseException e) throws SAXException {
        errorMessage=e.getMessage();
        if(errorMessage==null) {
            return;
        } else {
            System.out.println("一般错误:"+errorMessage);
            String a="一般错误:"+errorMessage;
            Unsucceed unsuccess=new Unsucceed(a);
        }
    }

    public void fatalError(SAXParseException e) throws SAXException {
        errorMessage = e.getMessage();
        if(errorMessage==null) {
            return;
        } else {
            System.out.println("致命错误" + errorMessage);
            String b="致命错误:"+errorMessage;
            Unsucceed unsuccess=new Unsucceed(b);
        }
    }
}
