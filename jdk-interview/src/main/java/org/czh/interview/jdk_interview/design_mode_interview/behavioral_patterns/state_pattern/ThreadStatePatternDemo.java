package org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.state_pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class ThreadStatePatternDemo {

    public static void main(String[] args) {
        ThreadContext context = new ThreadContext();
        // 新建一个线程
        context.start();
        // 线程获取到CPU 时间片
        context.getCPU();
        // 线程中断
        context.suspend();
        // 线程唤醒
        context.resume();
        // 线程获取到CPU 时间片
        context.getCPU();
        // 线程终止
        context.stop();
    }


    // 环境类
    @Data
    @AllArgsConstructor
    public static class ThreadContext {

        private ThreadState state;

        ThreadContext() {
            state = new ThreadState.New();
        }

        public void start() {
            ((ThreadState.New) state).start(this);
        }

        public void getCPU() {
            ((ThreadState.Runnable) state).getCPU(this);
        }

        public void suspend() {
            ((ThreadState.Running) state).suspend(this);
        }

        public void stop() {
            ((ThreadState.Running) state).stop(this);
        }

        public void resume() {
            ((ThreadState.Blocked) state).resume(this);
        }
    }

    // 抽象状态类：线程状态
    public abstract static class ThreadState {
        protected String stateName;

        // 具体状态类：新建状态
        static class New extends ThreadState {

            public New() {
                stateName = "新建状态";
                System.out.println("当前线程处于：新建状态.");
            }

            public void start(ThreadContext hj) {
                System.out.print("调用start()方法-->");
                if (stateName.equals("新建状态")) {
                    hj.setState(new Runnable());
                } else {
                    System.out.println("当前线程不是新建状态，不能调用start()方法.");
                }
            }
        }

        // 具体状态类：就绪状态
        static class Runnable extends ThreadState {

            public Runnable() {
                stateName = "就绪状态";
                System.out.println("当前线程处于：就绪状态.");
            }

            public void getCPU(ThreadContext hj) {
                System.out.print("获得CPU时间-->");
                if (stateName.equals("就绪状态")) {
                    hj.setState(new Running());
                } else {
                    System.out.println("当前线程不是就绪状态，不能获取CPU.");
                }
            }
        }

        // 具体状态类：运行状态
        static class Running extends ThreadState {

            public Running() {
                stateName = "运行状态";
                System.out.println("当前线程处于：运行状态.");
            }

            public void suspend(ThreadContext hj) {
                System.out.print("调用suspend()方法-->");
                if (stateName.equals("运行状态")) {
                    hj.setState(new Blocked());
                } else {
                    System.out.println("当前线程不是运行状态，不能调用suspend()方法.");
                }
            }

            public void stop(ThreadContext hj) {
                System.out.print("调用stop()方法-->");
                if (stateName.equals("运行状态")) {
                    hj.setState(new Dead());
                } else {
                    System.out.println("当前线程不是运行状态，不能调用stop()方法.");
                }
            }
        }

        // 具体状态类：阻塞状态
        static class Blocked extends ThreadState {

            public Blocked() {
                stateName = "阻塞状态";
                System.out.println("当前线程处于：阻塞状态.");
            }

            public void resume(ThreadContext hj) {
                System.out.print("调用resume()方法-->");
                if (stateName.equals("阻塞状态")) {
                    hj.setState(new Runnable());
                } else {
                    System.out.println("当前线程不是阻塞状态，不能调用resume()方法.");
                }
            }
        }

        //具体状态类：死亡状态
        static class Dead extends ThreadState {
            public Dead() {
                stateName = "死亡状态";
                System.out.println("当前线程处于：死亡状态.");
            }
        }
    }
}
