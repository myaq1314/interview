package org.czh.interview.design_mode_interview.factory_pattern;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Arrays;

/**
 * @author : czh
 * description :
 * date : 2021-05-04
 * email 916419307@qq.com
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        IFactory factory1 = new IFactory.ConcreteFactory1();
        IProduct product1 = factory1.newProduct();
        product1.show();

        IFactory factory2 = new IFactory.ConcreteFactory2();
        IProduct product2 = factory2.newProduct();
        product2.show();

        IFactory[] factories = ReadXML.getFactoryFromConfig();
        assert factories != null;
        Arrays.stream(factories).forEach(factory -> factory.newProduct().show());
    }

    public interface IProduct {
        void show();

        class ConcreteProduct1 implements IProduct {
            @Override
            public void show() {
                System.out.println("具体产品1\n");
            }
        }

        class ConcreteProduct2 implements IProduct {
            @Override
            public void show() {
                System.out.println("具体产品2\n");
            }
        }
    }

    public interface IFactory {

        IProduct newProduct();

        class ConcreteFactory1 implements IFactory {
            @Override
            public IProduct newProduct() {
                System.out.println("具体工厂1 生成 具体产品1");
                return new IProduct.ConcreteProduct1();
            }
        }

        class ConcreteFactory2 implements IFactory {
            @Override
            public IProduct newProduct() {
                System.out.println("具体工厂2 生成 具体产品2");
                return new IProduct.ConcreteProduct2();
            }
        }
    }

    public static class ReadXML {
        public static IFactory[] getFactoryFromConfig() {
            try {
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document document = builder.parse(new File("design-mode-interview/src/main/resources/factory_pattern_config.xml"));

                NodeList nodeList = document.getElementsByTagName("className");
                IFactory[] factories = new IFactory[nodeList.getLength()];
                for (int i = 0; i < nodeList.getLength(); i++) {
                    String nodeValue = nodeList.item(i).getFirstChild().getNodeValue().trim();
                    factories[i] = (IFactory) Class.forName(nodeValue).newInstance();
                }
                return factories;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}