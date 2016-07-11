package imooc.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMTest {

	public static void main(String[] args) {
		JDOMTest jdomTest = new JDOMTest();
		jdomTest.xmlCreate();

	}

	public void xmlParse() {
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

	public void xmlCreate() {
		Element rss = new Element("rss");
		rss.setAttribute("version", "2.0");
		Document document = new Document(rss);

		Element channel = new Element("channel");
		Element title = new Element("title");
		title.setText("<![CDATA[上海移动互联网产业促进中心正式揭牌 ]]>");
		rss.addContent(channel);
		channel.addContent(title);

		Format format = Format.getCompactFormat();
		format.setIndent("  ");
		format.setEncoding("GBK");

		XMLOutputter xmlOutputter = new XMLOutputter(format);

		try {
			xmlOutputter.output(document, new FileOutputStream(new File("rssnews2.xml")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
