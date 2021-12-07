package com.company;

public class Leg implements Runnable {
    final String name;
    private Object mon;

    public Leg(String name, Object mon) {
        this.name = name;
        this.mon = mon;
    }

    @Override
    public void run() {
        synchronized (mon) {
            while (true) {
                step();
                mon.notifyAll();
                try {
                    mon.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void step()
    {
        System.out.println(name);
    }
}
