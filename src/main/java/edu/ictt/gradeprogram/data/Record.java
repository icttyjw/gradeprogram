package edu.ictt.gradeprogram.data;



public class Record {
	
	private int schoolId;
	private int departmentId;//学院ID
	private int courseId;
	private int studentId;
	private int grade;
	private int isRe;//重修，不会命名，先放着
	//命名现在还能改，先列出来大概需要的，可能有缺的
	private byte[] teacherpublickey;//教师公钥
	private byte[] tsignature;//教师签名
	private byte[] departmentpkey;//学院公钥
	private byte[] dsignature;//学院签名
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getIsRe() {
		return isRe;
	}
	public void setIsRe(int isRe) {
		this.isRe = isRe;
	}
	public byte[] getTeacherpublickey() {
		return teacherpublickey;
	}
	public void setTeacherpublickey(byte[] teacherpublickey) {
		this.teacherpublickey = teacherpublickey;
	}
	public byte[] getTsignature() {
		return tsignature;
	}
	public void setTsignature(byte[] tsignature) {
		this.tsignature = tsignature;
	}
	public byte[] getDepartmentpkey() {
		return departmentpkey;
	}
	public void setDepartmentpkey(byte[] departmentpkey) {
		this.departmentpkey = departmentpkey;
	}
	public byte[] getDsignature() {
		return dsignature;
	}
	public void setDsignature(byte[] dsignature) {
		this.dsignature = dsignature;
	}
	@Override
    public String toString() {
        return "Record{" +
                "schoolId=" + schoolId +
                ", departmentId=" + departmentId +
                ", courseId=" + courseId +
                ",studentId=" +studentId+
                ",grade=" + grade +
                ",=" + isRe +
                '}';
    }
}
