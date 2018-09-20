package edu.ictt.gradeprogram.data;

public class Record {
	
	private int schoolId;
	private int deopartmnetId;//学院ID
	private int courseId;
	private int studentId;
	private int grade;
	private int isRe;//重修，不会命名，先放着
	//命名现在还能改，先列出来大概需要的，可能有缺的
	private byte[] teacherpublickey;//教师公钥
	private byte[] tsignature;//教师签名
	private byte[] departmentpkey;//学院公钥
	private byte[] dsignature;//学院签名

}
