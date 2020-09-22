public class ThreadImpar implements Runnable {



    public ThreadImpar() {
        Thread thread = new Thread(this);
        thread.start();


    }

    @Override
    public void run() {


        for(float i = 0; i < 50; i++){
            float ale = Math.round(Math.random() * i);
            if(ale%2 != 0)
            System.out.println(ale);
            try{
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}

