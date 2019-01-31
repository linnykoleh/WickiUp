package com.linnik.wickiup.laakmann.aligor._3_stack_queue.queue_q;


public class Queue
{
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s){
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long j){         // ������� �������� � ����� �������
        if(rear == maxSize-1) {         // ����������� �������
            rear = -1;
        }
        queArray[++rear] = j;           // ���������� rear � �������
        nItems++;                       // ���������� ���������� ���������
    }

    public long remove(){               // ���������� �������� � ������ �������
        long temp = queArray[front++];  // ������� � ���������� front
        if(front == maxSize) {          // ����������� �������
            front = 0;
        }
        nItems--;                       // ���������� ���������� ���������
        return temp;
    }

    public long peekFront(){            // ������ �������� � ������ �������
        return queArray[front];
    }

    public boolean isEmpty(){ // true, ���� ������� �����
        return (nItems==0);
    }

    private boolean ifFull(){
        return (nItems==maxSize);
    }

    public int size(){ // ���������� ��������� � �������
        return nItems;
    }
}
