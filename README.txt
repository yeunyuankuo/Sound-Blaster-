Yeun-Yuan(Jessie) Kuo
CSE 373 Summer
June 28, 2017
Homework #1 - Sound Blaster!

1. I wrote a smaller client program that have 10 lines in it so it's easier to 
   tell if my stack stored all the items in the correct order. I also wrote a 
   System.out.println before push() and pop() method is called inside the 
   Reverse.java so I can see what is being stored in my stack. 
   
2. "The scent of bitter almonds always reminded him of the fate of unrequited love."

3. Assuming I started with an array size of 2, then...
   Resize approximately 2^20 times to one million because 2^20 = 1,048,576.
   Resize approximately 2^30 times to one billion because 2^30 = 1,073,741,824.
   Resize approximately 2^40 times to one trillion because 2^40 = 1,099,511,627,776.

4. First set a new Queue<Double> q = new Queue<Double> to store all the values.

   push(d)
	-> if the queue is empty(q.size == 0), then [q.enqueue(d)] putting d to 
	   the end of the queue.
	-> else [q.enqueue(d)] putting d to the end of the queue, then have a for 
	   loop iterate over the queue (q.size - 1) times, and each time 
	   [q.enqueue(q.dequeue)] putting what is in front of d to the end of d 
	   so that the newly enqueued item (d) can be placed to the front of the 
	   queue for easier access later on for pop().
	
   pop()
	-> if the queue is empty(q.size == 0), then throw EmptyStackException.
	-> else return the the value for q.dequeue.
	
5. I think the down side for using a queue is that every time I add a new 
   element into the queue, I would have to move all the previous items to 
   the rear of the queue in order so that the new element enqueued is always 
   at the very front of the queue. And that would be very inefficient and 
   tedious to do when the number of items in the queue gets bigger. Therefore, 
   I would choose to use Array over Queue since it is more efficient in turns 
   of adding and removing items inside of the stack.

6. I did the 1-point extra credit implementation and I think this is a good 
   design decision because it saves unneeded space for my array.

7. I'm not sure about the exact time, but I started on Tuesday and have 
   been working on it on and off since. Sometimes even just thinking and 
   reading the assignments and not actually typing the answer. But I would 
   say roughly 24 hours total.

8. It is really satisfying to get the answer for secret.wav, even though the 
   phrase is kind of weird. I would say the part I could've done better is 
   to come up with more cases that I can test my solutions with.

9. I would say the instruction for the sox part could have been a little bit 
   more detailed. I spent quite a while just trying to get .dat file convert 
   into .wav. Also I would really appreciate a bit more review on previous 
   materials for 143. I feel like most of the time i spent on this homework 
   is to clarify and review how to use LinkedList and Array haha, but thats 
   just maybe me cuz I took 143 more than a year ago.