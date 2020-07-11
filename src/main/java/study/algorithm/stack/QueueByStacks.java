package study.algorithm.stack;

import java.util.Stack;

public class QueueByStacks {

    public static void main(String[] args) {

    }

    static class MyQueue<T>{

        private Stack<T> enqueueStack = new Stack<>();

        private Stack<T> dequeueStack = new Stack<>();

        public void enqueue(T newEle){
            enqueueStack.push(newEle);

        }

        public void dequeue(){
            if (dequeueStack.isEmpty()){
                while (!enqueueStack.isEmpty()){
                    dequeueStack.push(enqueueStack.pop());
                }
            }

            dequeueStack.pop();
        }

        public T peek(){
            if (dequeueStack.isEmpty()){
                while (!enqueueStack.isEmpty()){
                    dequeueStack.push(enqueueStack.pop());
                }
            }

            return dequeueStack.peek();
        }
    }
}
