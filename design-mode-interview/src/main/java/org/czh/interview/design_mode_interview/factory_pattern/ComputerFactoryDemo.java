package org.czh.interview.design_mode_interview.factory_pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.czh.interview.commons.exceptions.CommonException;

/**
 * @author : czh
 * description :
 * date : 2021-05-05
 * email 916419307@qq.com
 */
public class ComputerFactoryDemo {
    public static void main(String[] args) {
        Computer pcComputer = ComputerFactory.getComputer("PcComputer", "2 GB", "500 GB", "2.4 GHz");
        System.out.println("Factory PC Config::" + pcComputer);

        Computer serverComputer = ComputerFactory.getComputer("ServerComputer", "16 GB", "1 TB", "2.9 GHz");
        System.out.println("Factory Server Config::" + serverComputer);
    }
}

@ToString
abstract class Computer {

    public abstract String getRam();

    public abstract String getHdd();

    public abstract String getCpu();

    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static
    class PcComputer extends Computer {
        private String ram;
        private String hdd;
        private String cpu;
    }

    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static
    class ServerComputer extends Computer {
        private String ram;
        private String hdd;
        private String cpu;
    }
}

class ComputerFactory {
    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if ("PcComputer".equals(type)) {
            return new Computer.PcComputer(ram, hdd, cpu);
        } else if ("ServerComputer".equals(type)) {
            return new Computer.ServerComputer(ram, hdd, cpu);
        }
        throw new CommonException("还没有配置生产" + type + "这种电脑的生产线");
    }
}


