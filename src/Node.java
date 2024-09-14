
    public class Node {
        //SinhVienObj student{name, mark, id, YOB}
        int value; // mac dinh value = 0
        Node next; // contr o de tro toi phan tu tiep theo

        public Node() {
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this.value = value;
            this.next = null; //them 1 node voi only value thi next auto ve null
        }

        
    }

