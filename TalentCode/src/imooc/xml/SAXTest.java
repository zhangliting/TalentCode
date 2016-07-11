package imooc.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class SAXTest {

	public static void main(String[] args) {
		SAXTest saxTest = new SAXTest();
		saxTest.xmlCreate();
	}

	public void xmlParse() {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			saxParser.parse("demo/books.xml", new SAXParserHandler());
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void xmlCreate() {
		Book b1 = new Book();
		b1.setId("1");
		b1.setName("冰与火之歌");
		b1.setAuthor("乔治马丁");
		b1.setYear("2014");
		b1.setPrice("89");
		Book b2 = new Book();
		b2.setId("2");
		b2.setName("安徒生童话");
		b2.setAuthor("乔治马丁");
		b2.setYear("2004");
		b2.setPrice("77");
		b2.setLanguage("English");
		ArrayList<Book> bookList = new ArrayList<Book>();
		bookList.add(b1);
		bookList.add(b2);

		SAXTransformerFactory saxTransformerFactory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		try {
			TransformerHandler transformerHandler = saxTransformerFactory.newTransformerHandler();
			Transformer transformer = transformerHandler.getTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			File file = new File("newbooks.xml");
			if (!file.exists()) {
				file.createNewFile();
			}
			Result result = new StreamResult(new FileOutputStream(file));
			transformerHandler.setResult(result);
			transformerHandler.startDocument();
			AttributesImpl attr = new AttributesImpl();
			transformerHandler.startElement("", "", "bookstore", attr);

			for (Book book : bookList) {
				attr.clear();
				attr.addAttribute("", "", "id", "", book.getId());
				transformerHandler.startElement("", "", "book", attr);
				// 创建name节点
				if (book.getName() != null && !book.getName().trim().equals("")) {
					attr.clear();
					transformerHandler.startElement("", "", "name", attr);
					transformerHandler.characters(book.getName().toCharArray(), 0, book.getName().length());
					transformerHandler.endElement("", "", "name");
				}
				// 创建year节点
				if (book.getYear() != null && !book.getYear().trim().equals("")) {
					attr.clear();
					transformerHandler.startElement("", "", "year", attr);
					transformerHandler.characters(book.getYear().toCharArray(), 0, book.getYear().length());
					transformerHandler.endElement("", "", "year");
				}
				// 创建author节点
				if (book.getAuthor() != null && !book.getAuthor().trim().equals("")) {
					attr.clear();
					transformerHandler.startElement("", "", "author", attr);
					transformerHandler.characters(book.getAuthor().toCharArray(), 0, book.getAuthor().length());
					transformerHandler.endElement("", "", "author");
				}
				// 创建price节点
				if (book.getPrice() != null && !book.getPrice().trim().equals("")) {
					attr.clear();
					transformerHandler.startElement("", "", "price", attr);
					transformerHandler.characters(book.getPrice().toCharArray(), 0, book.getPrice().length());
					transformerHandler.endElement("", "", "price");
				}
				// 创建language节点
				if (book.getLanguage() != null && !book.getLanguage().trim().equals("")) {
					attr.clear();
					transformerHandler.startElement("", "", "language", attr);
					transformerHandler.characters(book.getLanguage().toCharArray(), 0, book.getLanguage().length());
					transformerHandler.endElement("", "", "language");
				}
				transformerHandler.endElement("", "", "book");
			}

			transformerHandler.endElement("", "", "bookstore");
			transformerHandler.endDocument();

		} catch (TransformerConfigurationException | IOException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
