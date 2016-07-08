package imooc.xml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JDOMTest {

	public static void main(String[] args) {
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			FileInputStream fileInputStream = new FileInputStream("demo/books.xml");
			InputStreamReader in = new InputStreamReader(fileInputStream);
			Document document = saxBuilder.build(in);
			Element rootElement = document.getRootElement();
			List<Element> bookList = rootElement.getChildren();
			for (Element book : bookList) {
				List<Attribute> attributes = book.getAttributes();
				for (Attribute attribute : attributes) {
					System.out.println(attribute.getName() + "=" + attribute.getValue());
				}
				List<Element> children = book.getChildren();
				for (Element element : children) {
					System.out.println("\t" + element.getName() + "=" + element.getValue());
				}
			}
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
