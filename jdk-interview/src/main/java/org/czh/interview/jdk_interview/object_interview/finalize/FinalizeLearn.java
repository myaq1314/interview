package org.czh.interview.jdk_interview.object_interview.finalize;

/**
 * @author : czh
 * description :
 * date : 2021-05-19
 * email 916419307@qq.com
 */
public class FinalizeLearn {

    private static Block holder = null;

    public static void main(String[] args) {
        holder = new Block();
        holder = null;
        System.gc();
    }

    /**
     * 没有重写 finalize 方法
     * [GC (System.gc()) [PSYoungGen: 2662K->544K(38400K)] 207462K->205344K(331264K), 0.0079250 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     * [Full GC (System.gc()) [PSYoungGen: 544K->0K(38400K)] [ParOldGen: 204800K->441K(292864K)] 205344K->441K(331264K), [Metaspace: 3191K->3191K(1056768K)], 0.0270064 secs] [Times: user=0.01 sys=0.00, real=0.03 secs]
     * Heap
     * PSYoungGen      total 38400K, used 333K [0x0000000795580000, 0x0000000798000000, 0x00000007c0000000)
     * eden space 33280K, 1% used [0x0000000795580000,0x00000007955d34a8,0x0000000797600000)
     * from space 5120K, 0% used [0x0000000797600000,0x0000000797600000,0x0000000797b00000)
     * to   space 5120K, 0% used [0x0000000797b00000,0x0000000797b00000,0x0000000798000000)
     * ParOldGen       total 292864K, used 441K [0x0000000740000000, 0x0000000751e00000, 0x0000000795580000)
     * object space 292864K, 0% used [0x0000000740000000,0x000000074006e718,0x0000000751e00000)
     * Metaspace       used 3198K, capacity 4496K, committed 4864K, reserved 1056768K
     * class space    used 355K, capacity 388K, committed 512K, reserved 1048576K
     * <p>
     * 有重写 finalize方法，并且不是空方法体
     * [GC (System.gc()) [PSYoungGen: 1997K->528K(38400K)] 206797K->205336K(331264K), 0.0116598 secs] [Times: user=0.00 sys=0.00, real=0.02 secs]
     * [Full GC (System.gc()) [PSYoungGen: 528K->0K(38400K)] [ParOldGen: 204808K->205241K(292864K)] 205336K->205241K(331264K), [Metaspace: 3188K->3188K(1056768K)], 0.0223064 secs] [Times: user=0.01 sys=0.01, real=0.02 secs]
     * invoke finalize
     * Heap
     * PSYoungGen      total 38400K, used 998K [0x0000000795580000, 0x0000000798000000, 0x00000007c0000000)
     * eden space 33280K, 3% used [0x0000000795580000,0x0000000795679b20,0x0000000797600000)
     * from space 5120K, 0% used [0x0000000797600000,0x0000000797600000,0x0000000797b00000)
     * to   space 5120K, 0% used [0x0000000797b00000,0x0000000797b00000,0x0000000798000000)
     * ParOldGen       total 292864K, used 205241K [0x0000000740000000, 0x0000000751e00000, 0x0000000795580000)
     * object space 292864K, 70% used [0x0000000740000000,0x000000074c86e748,0x0000000751e00000)
     * Metaspace       used 3197K, capacity 4500K, committed 4864K, reserved 1056768K
     * class space    used 355K, capacity 388K, committed 512K, reserved 1048576K
     */
    static class Block {
        byte[] _200M = new byte[200 * 1024 * 1024];

        @Override
        protected void finalize() throws Throwable {
            System.out.println("invoke finalize");
        }
    }

}
