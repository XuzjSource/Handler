# Handler
handler的简单用法

Handler主要接收子线程发送的数据, 并用此数据配合主线程更新UI，用来跟UI主线程交互用。
handler可以分发Message对象和Runnable对象到主线程中, 每个Handler实例,都会绑定到创建他的线程中(一般是位于主线程),
也就是说Handler对象初始化后，就默认与对它初始化的进程的消息队列绑定，因此可以利用Handler所包含的消息队列，制定一些操作的顺序。
Handler中分发消息的一些方法
 post(Runnable)

postAtTime(Runnable,long)

postDelayed(Runnable long)

   post类方法允许你排列一个Runnable对象到主线程队列中

sendEmptyMessage(int)

sendMessage(Message)

sendMessageAtTime(Message,long)

sendMessageDelayed(Message,long)

    sendMessage类方法, 允许你安排一个带数据的Message对象到队列中，等待更新.

1，传递Message。用于接受子线程发送的数据, 并用此数据配合主线程更新UI。

          在Android中，对于UI的操作通常需要放在主线程中进行操作。如果在子线程中有关于UI的操作，
          那么就需要把数据消息作为一个Message对象发送到消息队列中，然后，用Handler中的handlerMessge方法处理传过来的数据信息，并操作UI。类sendMessage(Message msg)方法实现发送消息的操作。 在初始化Handler对象时重写的handleMessage方法来接收Messgae并进行相关操作。

  2，传递Runnable对象。用于通过Handler绑定的消息队列，安排不同操作的执行顺序。

Handler对象在进行初始化的时候，会默认的自动绑定消息队列。利用类post方法，可以将Runnable对象发送到消息队列中，按照队列的机制按顺序执行不同的Runnable对象中的run方法。

另外，Android的CPU分配的最小单元是线程，Handler一般是在某个线程里创建的，因而Handler和Thread就是相互绑定的，一一对应。而Runnable是一个接口，Thread是Runnable的子类。所以说，他俩都算一个进程。








