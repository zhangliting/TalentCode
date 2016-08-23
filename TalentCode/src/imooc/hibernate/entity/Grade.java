package imooc.hibernate.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Grade implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int gid;
	private String gname;
	private String gdesc;
	private Set<Student> students = new HashSet<Student>();
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGdesc() {
		return gdesc;
	}
	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
}
