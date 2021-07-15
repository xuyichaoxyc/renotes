package com.xyc.learn.test.jvm.ch3;

/**
 * 此代码演示两点：
 * 1. 对象可以在被GC时自我拯救
 * 2. 这种自救机会只有一次，因为一个对象的 finalize() 方法最多只会被系统自动调用一次
 *
 */
public class FinalizeEscapGV {
    public static FinalizeEscapGV SAVE_HOOK= null;

    public void isAlive() {
        System.out.println("yes, i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapGV.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapGV();

        // 对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();

        // Finalizer 方法优先级很低，暂停 0.5s 等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead");
        }


        // 对象再次拯救失败
        SAVE_HOOK = null;
        System.gc();

        // Finalizer 方法优先级很低，暂停 0.5s 等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead");
        }
    }
}
