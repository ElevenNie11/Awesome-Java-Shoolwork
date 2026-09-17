// 约瑟夫环：循环单链表（一共n个人，每次数m，m出局）
package AfterSchoolwork.JosephRing;

public class JosephRing {
    // 节点
    static class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
            this.next = null;
        }
    }
    // 主函数
    public static void main(String[] args){
        int n = 7;   // 一共7个人
        int m = 3;   // 每次数到3
        // 创建第一个节点
        Node head = new Node(1);
        Node current = head;
        // 创建2~n
        for(int i = 2; i <= n; i++){
            current.next = new Node(i);
            current = current.next;
        }
        // 最后一个节点指向头节点
        current.next = head;
        // prev 指向要删除节点的前一个节点
        Node prev = current;
        Node currentNode  = head;
        // 只要当前节点和它的下一个节点不是同一个节点，就说明环里还不止一个人
        while(currentNode != currentNode.next){
            // 数m-1次就找到这个前驱节点
            for(int i = 1; i < m; i++){
                prev = currentNode;
                currentNode = currentNode.next;
            }
            System.out.println("出列：" + currentNode.value);

            // 删除currentNode
            prev.next = currentNode.next;
            // 从下一个人继续
            currentNode = currentNode.next;
        }
        System.out.println("最后留下的人的编号是：" + currentNode.value);
    }
}