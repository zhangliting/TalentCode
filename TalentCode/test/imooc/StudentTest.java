package imooc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import imooc.hibernate.entity.Grade;
import imooc.hibernate.entity.Student;

public class StudentTest {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	
	

	@Test
	public void testSaveStudent() throws Exception {
		File file = new File("demo/test.jpg");
		InputStream inputStream;
		inputStream = new FileInputStream(file);
//		Blob picture = Hibernate.getLobCreator(session).createBlob(inputStream, inputStream.available());
		
		Student student1 = new Student();
		student1.setAddress("china");
		student1.setBirthday(new Date());
		student1.setGender("boy");
		student1.setSname("Titi");
//		student1.setPicture(picture);
		
		Student student2 = new Student();
		student2.setAddress("china");
		student2.setBirthday(new Date());
		student2.setGender("girl");
		student2.setSname("Bitch");
//		student2.setPicture(picture);

		Grade grade = new Grade();
		grade.setGname("grade-1");
		grade.setGdesc("this is description");
		
		grade.getStudents().add(student1);
		grade.getStudents().add(student2);
		session.save(grade);
		session.save(student1);
		session.save(student2);
		
		
	}

//	@Test
	public void testReadBlob() throws Exception{
		Student student = (Student) session.get(Student.class, 1);
		Blob picture = student.getPicture();
		InputStream binaryStream = picture.getBinaryStream();
		File file = new File("demo/dest.jpg");
		OutputStream outputStream = new FileOutputStream(file);
		byte[] buff = new byte[binaryStream.available()];
		binaryStream.read(buff);
		outputStream.write(buff);
		binaryStream.close();
		outputStream.close();
		
	}
	@Before
	public void init() {
		Configuration configuration = new Configuration().configure();
//		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

	@After
	public void destory() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
