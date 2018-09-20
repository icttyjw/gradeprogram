package edu.ictt.gradeprogram.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.objenesis.strategy.StdInstantiatorStrategy;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import edu.ictt.gradeprogram.data.Block;
import edu.ictt.gradeprogram.data.Record;



public class KryoHelper {

	/**
     * 区块转字符数组
     */
	public static byte[]  serializeBlock(Block block) throws IOException{
		Kryo kryo=new Kryo();
		kryo.setReferences(false);
	    kryo.setRegistrationRequired(false);
	    kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
		kryo.register(Block.class);
		byte[] bytes;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    Output output = new Output(byteArrayOutputStream, 10000);//后面一个参数不确定应该填多少合理
	    kryo.writeObject(output, block);
	    bytes=output.toBytes();
	    output.close();
	    byteArrayOutputStream.close();
	    return bytes;
	}
	
	/**
     * 字符数组转换区块
     */
	public static Block  deserializeBlock(byte[] bytes) throws IOException{
		Kryo kryo=new Kryo();
		kryo.setReferences(false);
	    kryo.setRegistrationRequired(false);
	    kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
		kryo.register(Block.class);
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
	    Input input = null;
	    input = new Input(byteArrayInputStream);
	    Block block = null;
	    block = kryo.readObject(input, Block.class);

	    input.close();
	    return block;
	}
	
	/**
     * 记录转字符数组
     */
	public static byte[]  serializeRecord(Record record) throws IOException{
		Kryo kryo=new Kryo();
		kryo.setReferences(false);
	    kryo.setRegistrationRequired(false);
	    kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
		kryo.register(Block.class);
		byte[] bytes;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    Output output = new Output(byteArrayOutputStream, 10000);
	    kryo.writeObject(output, record);
	    bytes=output.toBytes();
	    output.close();
	    byteArrayOutputStream.close();
	    return bytes;
	}
	
	
	/**
     * 字符数组转记录
     */
	public static Record  deserializeRecord(byte[] bytes) throws IOException{
		Kryo kryo=new Kryo();
		kryo.setReferences(false);
	    kryo.setRegistrationRequired(false);
	    kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
		kryo.register(Block.class);
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
	    Input input = null;
	    input = new Input(byteArrayInputStream);
	    Record record = null;
	    record = kryo.readObject(input, Record.class);

	    input.close();
	    return record;
	}
}
