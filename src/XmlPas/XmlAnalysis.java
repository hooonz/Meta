package XmlPas;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlAnalysis {
	Date startDate = new Date();
	String result = "/TABLE/ROWS/ROW/FILE_ID";
	NodeList baseList;
	NodeList pRowList;
	NodeList list = null;
	NodeList nodeList;
	NodeList nodeList2;
	Node node1 = null;
	Node node2 = null;
	Map<String, Object> map = new HashMap<String, Object>();
	File F_file;
	File P_file;
	String index = "/TABLE/ROWS/ROW/FILE_ID";
	String index1 = "/TABLE/ROWS/ROW[SIMILAR_RATE div 100 > 15]/P_ID";
	String p_filePid = "/TABLE/ROWS/ROW/P_ID";

	public void xmlReader(Document document) {
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Transformer trans = TransformerFactory.newInstance().newTransformer();

			XPath xpath = XPathFactory.newInstance().newXPath();
			baseList = (NodeList) xpath.evaluate(result, document, XPathConstants.NODESET);

			for (int i = 0; i < baseList.getLength(); i++) {

				F_file = new File(
						"C:\\Users\\cpy\\Desktop\\XmlFileExam\\F_" + baseList.item(i).getTextContent() + "_TB.xml");
				P_file = new File(
						"C:\\Users\\cpy\\Desktop\\XmlFileExam\\P_" + baseList.item(i).getTextContent() + "_TB.xml");

				Document document1 = builder.parse(F_file);
				Document document2 = builder.parse(P_file);

				list = (NodeList) xpath.evaluate(index1, document1, XPathConstants.NODESET);
				pRowList = (NodeList) xpath.evaluate("/TABLE/ROWS/ROW/P_ID", document2, XPathConstants.NODESET);

				for (int j = 0; j < pRowList.getLength(); j++) {

					if (list.item(j) == null) {
						continue;
					}

					map.put(pRowList.item(j).getTextContent(), pRowList.item(j).getParentNode());

				}

				for (int j = 0; j < list.getLength(); j++) {

					String fpid = list.item(j).getTextContent();

					if (map.containsKey(fpid)) {

						Node row = (Node) map.get(fpid);


						 nodeList = row.getChildNodes();
						nodeList2 = list.item(j).getParentNode().getChildNodes();

						for (int k = 0; k < nodeList.getLength(); k++) {
							if (nodeList.item(k).getNodeName().compareTo("LICENSE_ID") == 0) {
								node1 = nodeList.item(k);
								break;
							}
						}

						for (int k = 0; k < nodeList2.getLength(); k++) {
							if (nodeList2.item(k).getNodeName().compareTo("COMMENT") == 0) {
								node2 = nodeList2.item(k);
								break;
							}
						}

						if (node1 != null && node2 != null)
							node2.setTextContent(node1.getTextContent());
					}
				}

				DOMSource xmlDOM = new DOMSource(document1);
				StreamResult xmlFile = new StreamResult(
						new File("D:/Test/test/T_" + baseList.item(i).getTextContent() + "_TB.xml"));
				trans.transform(xmlDOM, xmlFile);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

		Date endDate = new Date();

		System.out.println((double) (endDate.getTime() - startDate.getTime()) / 1000 + "초");
	}
}
