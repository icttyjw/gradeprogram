package edu.ictt.gradeprogram.data;

public class Block {
	
	private byte[] lasthash;
	private byte[] merkleroot;
	private byte[] diffity;
	private byte[] culdiffity;
	private byte[] time;
	private int recordcount;
	public byte[] getLasthash() {
		return lasthash;
	}
	public void setLasthash(byte[] lasthash) {
		this.lasthash = lasthash;
	}
	public byte[] getMerkleroot() {
		return merkleroot;
	}
	public void setMerkleroot(byte[] merkleroot) {
		this.merkleroot = merkleroot;
	}
	public byte[] getDiffity() {
		return diffity;
	}
	public void setDiffity(byte[] diffity) {
		this.diffity = diffity;
	}
	public byte[] getCuldiffity() {
		return culdiffity;
	}
	public void setCuldiffity(byte[] culdiffity) {
		this.culdiffity = culdiffity;
	}
	public byte[] getTime() {
		return time;
	}
	public void setTime(byte[] time) {
		this.time = time;
	}
	public int getRecordcount() {
		return recordcount;
	}
	public void setRecordcount(int recordcount) {
		this.recordcount = recordcount;
	}
	
	@Override
    public String toString() {
        return "Block{" +
                "schoolId=" + lasthash +
                ", departmentId=" + merkleroot +
                ", courseId=" + diffity +
                ",studentId=" + culdiffity +
                ",grade=" + time +
                ",=" + recordcount +
                '}';
	}

}
