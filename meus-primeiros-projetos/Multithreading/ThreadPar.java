public class ThreadPar implements Runnable {

    public ThreadPar() {
        Thread thread = new Thread(this);
        thread.start();


    }

    @Override
    public void run() {

        for (float i = 0; i < 50; i++) {
            float ale = Math.round(Math.random() * i);
            if (ale % 2 == 0) {
                System.out.println("Este número é par: " + ale);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

