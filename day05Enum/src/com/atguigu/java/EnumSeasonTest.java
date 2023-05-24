package com.atguigu.java;

/**
 * @author wxxstar
 * @create 2023-02-28 17:12
 */
public class EnumSeasonTest {
    public static void main(String[] args) {
        SeasonEnum spring = SeasonEnum.SPRING;
        System.out.println(spring);
        spring.showMyself();
        spring.show();
        SeasonEnum.AUTUMN.showMyself();


    }
}

class Season {
    private final String seasonName;
    private final String seasonDesc;

    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏风习习");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冰天雪地");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

interface Info {
    void show();

    void showMyself();
}

enum SeasonEnum implements Info {
    SPRING("春天", "春暖花开") {
        @Override
        public void showMyself() {
            System.out.println("春天花会开");
        }
    },
    SUMMER("夏天", "夏风习习") {
        @Override
        public void showMyself() {
            System.out.println("浪花一朵朵");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void showMyself() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "冬天雪地") {
        @Override
        public void showMyself() {
            System.out.println("冬日恋歌");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    private SeasonEnum(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public void show() {
        System.out.println("这是一个季节");
    }
}
