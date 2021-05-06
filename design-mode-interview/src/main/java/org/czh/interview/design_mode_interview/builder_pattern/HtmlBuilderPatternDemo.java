package org.czh.interview.design_mode_interview.builder_pattern;

import lombok.AllArgsConstructor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author : czh
 * description :
 * date : 2021-05-05
 * email 916419307@qq.com
 */
public class HtmlBuilderPatternDemo {

    public static void main(String[] args) {
        AbstractBuilder textBuilder = HtmlDirector.construct("text");
        assert textBuilder != null;
        System.out.println(textBuilder.getResult());
        System.out.println();

        AbstractBuilder htmlBuilder = HtmlDirector.construct("html");
        assert htmlBuilder != null;
        System.out.println(htmlBuilder.getResult());
        System.out.println();
    }

}

abstract class AbstractBuilder {

    public abstract void makeString(String str);

    public abstract void makeTitle(String title);

    public abstract void makeItems(String[] items);

    public abstract void close();

    public abstract String getResult();

    static class HtmlBuilder extends AbstractBuilder {

        private String filename;
        private PrintWriter printWriter;

        public void makeTitle(String title) {
            filename = "/Users/czh/project/java/own/interview/jdk-interview/design-mode-interview/src/main/resources/" + title + ".html";
            try {
                printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
            printWriter.println("<!Doctype html>");
            printWriter.println("<html lang=\"zh-CN\">");
            printWriter.println("<head>");
            printWriter.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
            printWriter.println(String.format("<title>%s</title>", title));
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<h1>" + title + "</h1>");
        }

        public void makeString(String str) {
            printWriter.println("<p>" + str + "</p>");
        }

        public void makeItems(String[] items) {
            printWriter.println("<ul>");
            for (String item : items) {
                printWriter.println(String.format("<li>%s</li>", item));
            }
            printWriter.println("</ul>");
        }

        public void close() {
            printWriter.println("</body>");
            printWriter.println("</html>");
            printWriter.close();
        }

        public String getResult() {
            return filename;
        }
    }

    static class TextBuilder extends AbstractBuilder {
        StringBuilder builder = new StringBuilder();

        public void makeTitle(String title) {
            builder.append("=====================\n");
            builder.append("[").append(title).append("]").append("\n");
        }

        public void makeString(String str) {
            builder.append("@").append(str).append("\n");
        }

        public void makeItems(String[] items) {
            for (String item : items) {
                builder.append("   .").append(item).append("\n");
            }
        }

        public void close() {
            builder.append("=====================");
        }

        public String getResult() {
            return builder.toString();
        }
    }
}

@AllArgsConstructor
class HtmlDirector {

    public static AbstractBuilder construct(String type) {
        AbstractBuilder builder;
        if ("html".equals(type)) {
            builder = new AbstractBuilder.HtmlBuilder();
        } else if ("text".equals(type)) {
            builder = new AbstractBuilder.TextBuilder();
        } else {
            return null;
        }

        builder.makeTitle("今日头条");

        builder.makeString("毕业典礼");
        builder.makeItems(new String[]{"奏国歌", "升国旗"});

        builder.makeString("典礼结束");
        builder.makeItems(new String[]{"观众鼓掌", "有序撤离"});

        builder.close();

        return builder;
    }
}


