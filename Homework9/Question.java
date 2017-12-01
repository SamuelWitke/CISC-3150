import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class PrintLetter implements Callable<Integer>{
  int taskId;
  String [] arr;
  int size;
  int i=0;
  public PrintLetter(int taskId, String [] arr) {
    this.taskId = taskId;
    this.arr = arr;
    this.size = arr.length;
  }

  @Override
  public Integer call() throws Exception{
    if(i<this.size){
      System.out.println("excuting task... Task Id: " + this.taskId+" Array: "+this.arr[i]);
      i++;
    }
    return taskId;
  }
}

class Question{
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    String [] arr ={"A","E","I","M","Q","U","Y"};
    String [] arr1 ={"B","F","J","N","R","V","Z"};
    String [] arr2 = {"C","G","K","O","S","W"};
    String [] arr3 = {"D","H","L","P","T","X"};

    PrintLetter task1 = new PrintLetter(1,arr);
    PrintLetter task2 = new PrintLetter(2,arr1);
    PrintLetter task3 = new PrintLetter(3,arr2);
    PrintLetter task4 = new PrintLetter(4,arr3);

    Future<Integer> result = null;
    ExecutorService executor = Executors.newSingleThreadExecutor();

    for(int i=0;i<26;i++) {
      result = executor.submit( task1 );
      result.get();
      result = executor.submit( task2 );
      result.get();
      result = executor.submit( task3 );
      result.get();
      result = executor.submit( task4 );
      result.get();
    }
    executor.shutdown();
  }
}
