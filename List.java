package List;

/**
 * Created by Foban on 01/03/14.
 */

final class Node
{
    public String element;
    public Node next;
    public Node previous;

    public Node(String newElement, Node newNext, Node newPrevious)
    {
        element = newElement;
        next = newNext;
        previous = newPrevious;
    }
}

public class List {
    private Node top = null;
    private Node end = null;
    private int count= 0;

    public List(){}

    public void pushFront(String element)
    {
        Node newNode = new Node(element, null, top);
        if(top == null)
        {
            top = end = newNode;
        }
        else
        {
            top.next = newNode;
            top = newNode;
        }
        count++;

    }

    public void pushBack(String element)
    {
        Node newNode = new Node(element, end, null);
        if(end == null)
        {
            top = end = newNode;
        }
        else
        {
            end.previous = newNode;
            end = newNode;
        }
        count++;
    }

    public void popFront()
    {
        if(!isEmpty()){
            top.element = null;
            top = top.previous;
            if(!isEmpty())
            {
                top.next = null;
            }
            else
            {
                end = null;
            }
            --count;
        }
    }

    public void popBack()
    {
        if(!isEmpty()){
            end.element = null;
            end = end.next;
            if(!isEmpty())
            {
                end.previous = null;
            }
            else
            {
                top = null;
            }
            --count;
        }
    }

    public String onFront()
    {
        return isEmpty()?null:top.element;
    }

    public String onBack()
    {
        return isEmpty()?null:end.element;
    }

    public void clear()
    {
        Node remove = top;
        while(remove != null)
        {
            top=top.next;
            remove.element = null;
            remove.previous = null;
            remove = top;
        }
        count = 0;
    }

    public boolean isEmpty()
    {
        return top == null || end == null;
    }

    public int length()
    {
        return count;
    }

    private void move(Node where, Node what)
    {
        if(where != what)
        {
            what.next.previous = what.previous;
            if(what.previous != null)
            {
                what.previous.next = what.next;
            }
            else
            {
                end = what.next;
            }
            what.next = where.next;
            what.previous = where;
            where.next = what;
            if(what.next != null)
            {
                what.next.previous = what;
            }
            else
            {
                top = what;
            }
        }
    }

    public void sort()
    {
        if(top != null)
        {
            for (Node work = top.previous, tmp, oldTmp; work != null; work = work.previous) {
                for (tmp = work.next, oldTmp = work; tmp != null && tmp.element.compareTo(work.element) > 0; oldTmp = tmp, tmp = tmp.next)
                    ;
                move(oldTmp, work);
            }
        }
    }

    public static List merge(List first, List second)
    {
        List newList = new List();
        Node workFirst = first.top, workSecond = second.top;
        while(workFirst != null || workSecond != null)
        {
            if(workFirst != null)
            {
                if(workSecond != null)
                {
                    if(workSecond.element.compareTo(workFirst.element)<0)
                    {
                        newList.pushBack(workSecond.element);
                        workSecond = workSecond.previous;
                    }
                    else
                    {
                        newList.pushBack(workFirst.element);
                        workFirst = workFirst.previous;
                    }
                }
                else
                {
                    while(workFirst != null)
                    {
                        newList.pushBack(workFirst.element);
                        workFirst = workFirst.previous;
                    }
                }
            }
            else
            {
                while(workSecond != null)
                {
                    newList.pushBack(workSecond.element);
                    workSecond = workSecond.previous;
                }
            }
        }

        return newList;
    }
}
