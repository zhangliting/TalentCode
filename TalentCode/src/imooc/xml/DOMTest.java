package imooc.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {

	public static void main(String[] args) {
		DOMTest domTest = new DOMTest();
		domTest.xmlCreate();
	}

	public DocumentBuilder getDocumentBuilder() {
		// 创建一个DocumentBuilderFactory的对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 创建DocumentBuilder对象
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return db;
	}

	public void xmlCreate() {
		DocumentBuilder documentBuilder = getDocumentBuilder();
		Document document = documentBuilder.newDocument();
		document.setXmlStandalone(true);
		Element bookstore = document.createElement("bookstore");
		Element book = document.createElement("book");
		Element name = document.createElement("name");
		name.setTextContent("zhangliting");
		book.setAttribute("id", "1");
		book.appendChild(name);
		bookstore.appendChild(book);
		document.appendChild(bookstore);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(document), new StreamResult("books1.xml"));
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void xmlParser() {
		try {
			DocumentBuilder documentBuilder = getDocumentBuilder();
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
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
