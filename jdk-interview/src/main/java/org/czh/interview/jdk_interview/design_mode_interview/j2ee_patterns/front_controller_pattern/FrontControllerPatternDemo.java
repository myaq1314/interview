package org.czh.interview.jdk_interview.design_mode_interview.j2ee_patterns.front_controller_pattern;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class FrontControllerPatternDemo {

    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("HOME");
        System.out.println();
        frontController.dispatchRequest("STUDENT");
        System.out.println();
    }

    // Home 视图
    public static class HomeView {
        public void show() {
            System.out.println("Displaying Home Page");
        }
    }

    // 学生 视图
    public static class StudentView {
        public void show() {
            System.out.println("Displaying Student Page");
        }
    }

    // 调度器
    public static class Dispatcher {

        private final StudentView studentView;
        private final HomeView homeView;

        public Dispatcher() {
            studentView = new StudentView();
            homeView = new HomeView();
        }

        public void dispatch(String request) {
            if (request.equalsIgnoreCase("STUDENT")) {
                studentView.show();
            } else {
                homeView.show();
            }
        }
    }

    // 前端控制器
    public static class FrontController {

        private final Dispatcher dispatcher;

        public FrontController() {
            dispatcher = new Dispatcher();
        }

        private boolean isAuthenticUser() {
            System.out.println("User is authenticated successfully.");
            return true;
        }

        private void trackRequest(String request) {
            System.out.println("Page requested: " + request);
        }

        public void dispatchRequest(String request) {
            // 记录每一个请求
            trackRequest(request);
            // 对用户进行身份验证
            if (isAuthenticUser()) {
                dispatcher.dispatch(request);
            }
        }
    }
}
