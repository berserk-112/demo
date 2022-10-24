package com.example.patter.singleTest;

public class SingleTest {
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            new Thread(
                    () -> {
                        HungrySingle a = HungrySingle.getHungrySingle();
                        HungrySingle b = HungrySingle.getHungrySingle();
                        System.out.println(HungrySingle.getHungrySingle());
                        System.out.println(a == b);
                    })
            .start();
            new Thread(() -> {
                System.out.println(LazySingle.getLazySingle());
            }).start();
            new Thread(() -> {
                System.out.println(DoubleCheckLazySingle.getSingle());
            }).start();
            i++;
        }
    }
}

class HungrySingle {
    private static HungrySingle hungrySingle = new HungrySingle();

    private HungrySingle() {
    }

    public static HungrySingle getHungrySingle() {
        return hungrySingle;
    }
}

class LazySingle {
    private static LazySingle lazySingle;

    private LazySingle() {
    }

    public static synchronized LazySingle getLazySingle() {
        if (lazySingle == null) {
            lazySingle = new LazySingle();
        }
        return lazySingle;
    }
}

class DoubleCheckLazySingle {
    private static volatile DoubleCheckLazySingle single;

    private DoubleCheckLazySingle() {
    }

    public static DoubleCheckLazySingle getSingle() {
        if (single == null) {
            synchronized (DoubleCheckLazySingle.class) {
                if (single == null) {
                    single = new DoubleCheckLazySingle();
                }
            }
        }

        return single;
    }
}
