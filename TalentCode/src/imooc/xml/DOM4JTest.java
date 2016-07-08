package imooc.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4JTest {

	public static void main(String[] args) {
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

}
