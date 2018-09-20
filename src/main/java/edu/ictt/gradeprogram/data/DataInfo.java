package edu.ictt.gradeprogram.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import edu.ictt.gradeprogram.util.GetNTP;



public class DataInfo {

private void dataInfo(){}
    
    public static int rstamp=1000;
    
    /**
     * 缓存区块
     */
    public static final LinkedList<Block> blocks= new LinkedList<Block>();
    /**
     * 验证完脚本后的纪录池
     */
    public static LinkedBlockingQueue<Record> effectiveRecord = new LinkedBlockingQueue<Record>();
    /**
     * 验证完时间与顺序戳后的未使用纪录池，类似于 未使用的UTXO
     */
    public static ConcurrentHashMap<String,Record> freshRecord =new ConcurrentHashMap<String, Record>();
    /**
     * 验证完成后的记录池，用以创建默克尔树。
     */
    public static ArrayList<Record> identifedRecord=new ArrayList<Record>();
    /**
     * 打包生成区块时保存的记录
     */
    public static ArrayList<Record> unPackageRecord=new ArrayList<Record>();

    /**
     * 缓存区块中的记录
     */
    public static ArrayList<Record> PackageRecord=new ArrayList<Record>();
    
    /**
     * timeRecord  时间纪录，用以存储adjustCount个区块时间
     * adjustCount 需要多少个区块进行一次难度调整
     */
    public static ArrayList<Integer> timeRecord=new ArrayList<Integer>();
    public static int adjustCount=10;
    /**
     * 区块能包含的最大条目数
     */
    public static int merkleTreeLimitation=64;

    public static MessageDigest SHA256x;

    /**
     *  exceptTime 目标时间，期望平均多长时间产生一个区块，proof of work中为定值。
     *  errorTime 时间误差，误差范围内时间不变
     */
//    public static final int exceptTime=1920;//单位：秒
    public static final int exceptTime=600;//单位：秒
    public static final int errorTime=50;//单位：秒
    public static final int TTL=5;
    /**
     * 区块存储位置
     */
    public static final String location="blockTest";
    /**
     * 区块索引
     */
    public static ArrayList<Long> indexBlock=new ArrayList<Long>();
    /**
     * 缓存区块数量
     */
    public static final int cacheBlockCount=1000;
    /**
     * 核心线程，用来进行pow 广播 写入硬盘的顺序执行，将其线程模块化用以同步block时进行
     */
    public static ExecutorService coreWork=Executors.newSingleThreadExecutor();
    /**
     * pow中断信号
     */
    public static boolean interupt =false;
    /**
     * 期待的块号
     */
    public static int num=0;
    /**
     * NTP时间
     */
    public static int NTPTime;
    public static int localTimeInStart;

    public static final String ECNAME="secp160r1";

    //public static final int PORT=49999;
     public static final int PORT=49998;

    public static String ROOTIP="";
    public static final String IPLOCATION="ip.txt";
    public static String localIp;

    public static HashSet<String> IPList= new HashSet<String>();
    static {//dataInfo全局初始化
        try {
            setIP();
            setNTPtimeAndLocalTime();
        } catch (IOException e) {
            System.out.println("IP设置error");
            System.exit(1);
        }
    }

    private static void setNTPtimeAndLocalTime() {
        System.out.println("set ntptime");
        try {
            NTPTime= GetNTP.start();
        } catch (Exception e) {
            System.out.println("error in get NTP time");
            System.exit(1);
        }
        System.out.println(NTPTime);
         localTimeInStart = getSystemTime();
    }

    private static void setIP() throws IOException {
        System.out.println("set ip");
        BufferedReader reader=new BufferedReader(new FileReader(IPLOCATION));
        String IP=reader.readLine();//取文件中第一个IP作为ROOTIP
        ArrayList<String> ipList=new ArrayList<String>();
        while (true){
            String temIP=reader.readLine();
            if (temIP==null)
                break;
            ipList.add(temIP);
        }
        reader.close();
        if (checkIP(IP))
            ROOTIP=IP;
        else
            throw new IOException();
        Iterator<String> it=ipList.iterator();
        while (it.hasNext()){
            String temIP=it.next();
            if (!checkIP(temIP))//应该是随checkIP函数完善实现功能
                it.remove();
        }
        IPList.add(ROOTIP);
        IPList.addAll(ipList);
    }

    public static boolean checkIP(String ip) {//待补充？？
        return true;
    }

    public static int getTime(){
        int systemTimeNow=getSystemTime();
        return systemTimeNow- localTimeInStart+NTPTime;
    }


    public static int getSystemTime(){
        return (int) (System.currentTimeMillis()/1000);
    }
  /*  public static int getNTPtime(){
        System.out.println("get ntp time");
        Date date=null;
        try {
            NTPUDPClient timeClient = new NTPUDPClient();
            String timeServerURL = "s1a.time.edu.cn";
            InetAddress timeServerAddress = InetAddress.getByName(timeServerURL);
            TimeInfo timeInfo = timeClient.getTime(timeServerAddress);
            TimeStamp timestamp = timeInfo.getMessage().getTransmitTimeStamp();
            date = timestamp.getDate();
        }catch (Exception e){
            System.out.println("get NTPtime error System shutDown");
            System.exit(1);
        }
        return (int) (date.getTime() / 1000);
    }*/

    public static void interuptCoreThread(){
        interupt=true;
    }
    public static void interuptReset(){
        interupt=false;
    }
}
