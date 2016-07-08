package imooc.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {

	public static void main(String[] args) {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse("demo/books.xml");
			NodeList nodeListBook = document.getElementsByTagName("book");
			System.out.println("books sum:" + nodeListBook.getLength());
			for (int i = 0; i < nodeListBook.getLength(); i++) {
				Node nodeBook = nodeListBook.item(i);
				NamedNodeMap namedNodeMap = nodeBook.getAttributes();
				for (int j = 0; j < namedNodeMap.getLength(); j++) {
					String name = namedNodeMap.item(j).getNodeName();
					String value = namedNodeMap.item(j).getNodeValue();
					System.out.println(name + "=" + value);
				}

				NodeList childNodesList = nodeBook.getChildNodes();
				for (int k = 0; k < childNodesList.getLength(); k++) {
					if (childNodesList.item(k).getNodeType() == Node.ELEMENT_NODE) {
						String name = childNodesList.item(k).getNodeName();
						String value = childNodesList.item(k).getTextContent();
						System.out.println("\t" + name + "=" + value);
					}

				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
