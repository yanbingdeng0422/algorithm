package com.yanbing.algorithm;

import android.util.Log;

//单链表实现
public class Single_list {
    private static final String TAG= Single_list.class.getSimpleName();

    private class SingleList{
        private Object data;
        private SingleList next = null;

        SingleList(){
            data = null;
        }

        SingleList(Object data){
            this.data = data;
            this.next = null;
        }

        public String toString(){
            return "data="+this.data +" next="+this.next;
        }
    }

    private SingleList head =null;//头节点
    private SingleList temp;//临时节点

    //初始化链表，生成一个无数据的头节点
    Single_list(){
//        head = new SingleList();
    }

    /**
     * 添加至链表尾
     *
     */
    public void addNode_Tail(Object data){
        SingleList node = new SingleList(data);
//        Log.d(TAG,"head="+head.toString() +" head="+(head ==null));
        if(head ==null){
            head =node;
        }else {
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        if(temp!=null){
            Log.d(TAG,"temp="+temp.toString() +" temp="+(temp ==null));
        }
        Log.d(TAG,"head="+head.toString() +" head="+(head ==null));
    }

    /**
     * 添加至链表头
     *
     */
    public void addNode_Head(Object data){
        SingleList node = new SingleList(data);
        if(head == null){
            head = node;
        }else {
            node.next = head;
            head = node;
        }
    }

    //获取链表长度
    public int getLength(){
        int length =0;
        if(head==null){
            return length;
        }
        temp =head;
        if(temp!=null && temp.next ==null){
            return 1;
        }
        while (temp.next!=null){
            length++;
            temp =temp.next;
        }
        return length+1;
    }


    //增加节点到指定的位置
    public void addNote_index(Object data,int index){
        if(index<1 || index> getLength()+1){
            System.out.println("增加节点的位置不合法");
            return;
        }

        int count = 1;//记录遍历的位置

        SingleList singleList = new SingleList(data);

        temp =head;
        while (temp.next!=null){
            count++;
            if(index ==count){
                singleList.next = temp.next;
                temp.next = singleList;
                return;
            }

            temp = temp.next;

        }
//        head =temp;
    }

    //删除指定的节点位置
    public void deleteNoteIndex(int index){
        if(index<1 || index> getLength()+1){
            System.out.println("删除节点的位置不合法");
            return;
        }

        int count =1;
        temp =head;
        SingleList temp_H=null,temp_T=null;
        while (temp.next!=null){
            if(index ==count){
                if(index ==1){
                    head =temp.next;
                    break;
                }else {
                    temp_H.next = temp_T;
                    break;
                }
            }
            temp_H=temp;
            temp = temp.next;
            temp_T = temp.next;
            count ++;
        }
    }

    public void printListFromHead(){

        Log.d(TAG,"length="+getLength());
        SingleList temp1 =head;
        if(getLength()==1){
            Log.d(TAG,"list_data="+temp1.data);
        }else {
            Log.d(TAG,"temp.next="+temp1.next);
            while (temp1.next !=null){
                Log.d(TAG,"list_data="+temp1.data);
                temp1 = temp1.next;
                if(temp1.next==null){
                    Log.d(TAG,"list_data="+temp1.data);
                }

            }
        }

    }



}
