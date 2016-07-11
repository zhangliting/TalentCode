package imooc.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DOM4JTest {

	public static void main(String[] args) {
		DOM4JTest dom4jTest = new DOM4JTest();
		dom4jTest.createXml();
	}

	public void xmlParse() {
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(new File("demo/books.xml"));
			Element rootElement = document.getRootElement();
			Iterator elementIterator = rootElement.elementIterator();
			while (elementIterator.hasNext()) {
				Element book = (Element) elementIterator.next();
				List<Attribute> attributes = book.attributes();
				for (Attribute attribute : attributes) {
					System.out.println(attribute.getName() + "=" + attribute.getValue());
				}
				Iterator iterator = book.elementIterator();
				while (iterator.hasNext()) {
					Element element = (Element) iterator.next();
					System.out.println("\t" + element.getName() + "=" + element.getStringValue());
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createXml() {
		Document document = DocumentHelper.createDocument();
		Element rss = document.addElement("rss");
		rss.addAttribute("version", "2.0");

		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
		title.setText("<![CDATA[上海移动互联网产业促进中心正式揭牌 ]]>");

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");

		File file = new File("rssnews.xml");
		XMLWriter xmlWriter;

		try {
			xmlWriter = new XMLWriter(new FileOutputStream(file), format);
			xmlWriter.setEscapeText(false);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
