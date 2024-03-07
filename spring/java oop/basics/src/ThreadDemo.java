public class ThreadDemo extends Thread {
    private Thread t;
   private String threadName;
   


   /*
    New − A new thread begins its life cycle in the new state. It remains in this state until the program starts the thread. 
        It is also referred to as a born thread.
    
    Runnable − After a newly born thread is started, the thread becomes runnable. A thread in this state is considered to be executing its task.

    Waiting − Sometimes, a thread transitions to the waiting state while the thread waits for another thread to perform a task. 
            A thread transitions back to the runnable state only when another thread signals the waiting thread to continue executing.

    Timed Waiting − A runnable thread can enter the timed waiting state for a specified interval of time.
                 A thread in this state transitions back to the runnable state when that time interval expires or when the event it is waiting 
                 for occurs.

    Terminated (Dead) − A runnable thread enters the terminated state when it completes its task or otherwise terminates. */

   ThreadDemo( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName );
      try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(50);
         }
      } catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }
   
   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}
