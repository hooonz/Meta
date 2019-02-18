package XmlPas;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlAnalysisMain {

public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
	File basefile = new File("C:\\Users\\cpy\\Desktop\\XmlFileExam\\T_BASEFILE_TB.xml");
//	InputSource is = new InputSource(new FileReader(basefile));
	Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(basefile);
	XmlAnalysis name = new XmlAnalysis();
	name.xmlReader(document);
//	---------------------BaseFile-------------------------
}
}
