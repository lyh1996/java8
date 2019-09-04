package snowFlake;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 雪花算法----id的生成策略
 * @create 2018-10-17 14:21
 * @since 1.7
 */
public class IdWorker {

    private long workerId;
    private long datacenterId;
    private long sequence;

    /**
     * 2018/10/17.从此时开始计算69年，可以用到2089年
     */
    private long twepoch = 1538211907857L;

    private long workerIdBits = 5L;
    private long datacenterIdBits = 5L;
    private long sequenceBits = 12L;

    private long workerIdShift = sequenceBits;
    private long datacenterIdshift = sequenceBits + workerIdBits;
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    //得到000000000000000000000000000000000000000011111111111111111111
    private long sequenceMask = -1L ^ (-1L << sequenceBits);  // 4095

    private long lastTimestamp = -1L;

    public IdWorker(long workerId, long datacenterId) {
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }
    public synchronized long nextId() {
        long  timestamp = timeGen();
        //时间回拨抛出异常
        if (timestamp < lastTimestamp) {
            System.err.printf("clock moving backwards, Rejecting requests until %d", lastTimestamp);
            throw new RuntimeException(String.format("Clock moved backwards.  Refushing to generate id for %d millseconds", lastTimestamp = timestamp));
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if(sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = timestamp;
        return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdshift) | (workerId << workerIdShift) | sequence;
    }

    /**
     * 当前ms已经满了
     * @param lastTimestamp
     * @return
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        IdWorker worker =new IdWorker(1,1);
        for (int i = 0; i < 30; i++) {
            System.out.println(worker.nextId());
        }
    }
}
