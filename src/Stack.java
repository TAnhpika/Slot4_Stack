public class Stack {
    Node head;
    Node tail;

    public Stack() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = tail = null;
    }

    int top() {
        if (isEmpty())
            return -1;
        else
            return head.value;
    }

    int getSize() {
        if (isEmpty())
            return 0;
        int count = 0;
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    void push(int value) {
        Node nn = new Node(value);
        if (isEmpty()) {
            head = tail = nn;
        } else {
            nn.next = head;
            head = nn;
        }
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else {
            Node cur = head;
            while (cur != null) {
                System.out.print(cur.value + " ");
                cur = cur.next;
            }
            System.out.println("");
        }
    }

    void pop1() {
        if (isEmpty())
            System.out.println("Empty");
        else
            head = head.next;
    }

    int pop2() {
        if (isEmpty())
            return -1;
        int value = head.value;
        head = head.next;
        return value;
    }

    // --------------------------------------------------------
    // -------------------------SLOT 3-------------------------
    // --------------------------------------------------------
    int getIndex(int index) {
        if (isEmpty() || index < 0)
            return -1;
        if (index == 0)
            return head.value;

        Node cur = head;
        int i = 0;
        while (cur != null) {
            if (i == index)
                return cur.value;
            i++;
            cur = cur.next;
        }
        return -1; // index > size
    }

    void updateAtIndex(int x, int index) {
        if (isEmpty() || index < 0) {
            System.out.println("Empty or index < 0");
            return;
        }
        if (index == 0)
            head.value = x;

        Node cur = head;
        int i = 0;
        while (cur != null) {
            if (i == index) {
                cur.value = x;
                return;
            }
            i++;
            cur = cur.next;
        }
        System.out.println("Out of size");
    }

    int findIndex(int x) {
        if (isEmpty())
            return -1;
        Node cur = head;
        int i = 0;
        while (cur != null) {
            if (cur.value == x) { // findLast - dung continue
                return i;
            }
            cur = cur.next;
            i++;
        }
        return -1;// not found
    }

    void sort() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        boolean swapped;
        do {
            Node cur = head;
            swapped = false;
            while (cur.next != null) {
                if (cur.value > cur.next.value) {// cur.next null at the end of list
                    int value = cur.value;
                    cur.value = cur.next.value;
                    cur.next.value = value;
                    swapped = true;
                }
                cur = cur.next;
            }
        } while (swapped);
    }

    int findMax() {
        if (isEmpty()) {
            return -1;
        }
        Node cur = head;
        int maxValue = -1;
        while (cur.next != null) {
            if (cur.value < cur.next.value) {
                maxValue = cur.next.value;
            }
            cur = cur.next;
        }
        return maxValue;
    }

    void findMax2() {
        if (isEmpty()) {
            return;
        }
        Node cur = head;
        int maxValue = -1;
        while (cur.next != null) {
            if (cur.value < cur.next.value) {
                maxValue = cur.next.value;
            }
            cur = cur.next;
        }
        System.out.println("Max value is: " + maxValue + " at index: " + findIndex(maxValue));
    }

    // --------------------------------------------------------
    // -------------------------SLOT 4-------------------------
    // --------------------------------------------------------
    int iMax() {
        if (isEmpty())
            return -1;
        // 1 phan tu
        if (head == tail)
            return 0;
        int maxValue = head.value;
        int i = 0, maxIndex = 0;
        Node cur = head;
        while (cur != null) {
            if (maxValue <= cur.value) {
                // neu <= -> tra ve phan tu lon nhat cuoi cung neu max trung nhau
                // < -> tra ve ptu max dau tien
                maxValue = cur.value;
                maxIndex = i;
            }
            i++;
            cur = cur.next;
        }
        return maxIndex;
    }

    void swapMaxMin() {
        if (isEmpty())
            System.out.println("Empty");

        if (head == tail)
            return;
        int maxValue = head.value, minValue = head.value;
        int i = 0, maxIndex = 0, minIndex = 0;
        Node cur = head;
        while (cur != null) {
            if (maxValue < cur.value) {
                maxValue = cur.value;
                maxIndex = i;
            }
            if (minValue > cur.value) {
                minValue = cur.value;
                minIndex = i;
            }
            i++;
            cur = cur.next;
        }
        // swap 2 vi tri min va max index
        if (minIndex == maxIndex)
            return;
        updateAtIndex(maxValue, minIndex);
        updateAtIndex(minValue, maxIndex);
    }

    // selection sort
    void accSort() {
        for (Node i = head; i != tail; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (j.value < i.value) {
                    int temp = i.value;
                    i.value = j.value;
                    j.value = temp;
                }
            }
        }
    }

    void reverse() {
        if (isEmpty() || head == tail)
            return;
        Node cur = head;
        Node next = null;
        Node prev = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(3);
        st.push(5);
        st.push(2);
        st.display();
        st.pop1();
        st.display();
        st.push(10);
        st.display();
        System.out.println("Top = " + st.top());
    }
}
