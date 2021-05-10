package org.czh.interview.design_mode_interview.j2ee_patterns.intercepting_filter_pattern;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class InterceptingFilterPatternDemo {

    public static void main(String[] args) {
        // 过滤管理器
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.addFilter(new IFilter.AuthenticationFilter());
        filterManager.addFilter(new IFilter.DebugFilter());

        Client client = new Client();
        client.setFilterManager(filterManager);

        client.sendRequest("HOME");
    }

    // 过滤器
    public interface IFilter {

        void execute(String request);

        // 具体过滤器：权限过滤器
        class AuthenticationFilter implements IFilter {
            public void execute(String request) {
                System.out.println("Authenticating request: " + request);
            }
        }

        // 具体过滤器，断点顾虑器
        class DebugFilter implements IFilter {
            public void execute(String request) {
                System.out.println("request log: " + request);
            }
        }
    }

    // 请求处理程序
    public static class Target {
        public void execute(String request) {
            System.out.println("Executing request: " + request);
        }
    }

    // 过滤器链
    public static class FilterChain {
        private final List<IFilter> filters = new ArrayList<>();
        @Setter
        private Target target;

        public void addFilter(IFilter filter) {
            filters.add(filter);
        }

        public void execute(String request) {
            for (IFilter filter : filters) {
                filter.execute(request);
            }
            target.execute(request);
        }
    }

    // 过滤管理器
    public static class FilterManager {

        FilterChain filterChain;

        public FilterManager(Target target) {
            filterChain = new FilterChain();
            filterChain.setTarget(target);
        }

        public void addFilter(IFilter filter) {
            filterChain.addFilter(filter);
        }

        public void filterRequest(String request) {
            filterChain.execute(request);
        }
    }

    // 客户端，发送请求
    public static class Client {

        @Setter
        private FilterManager filterManager;

        public void sendRequest(String request) {
            filterManager.filterRequest(request);
        }
    }
}
