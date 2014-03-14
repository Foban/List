/**
 * Created by Foban on 28/02/14.
 */

package List;

public class Run {
    public static void main(String[] args)
    {
        //ArrayList example = new ArrayList();
        List example = new List();
        List example2 = new List();
        example.pushFront("s");
        example.pushFront("d");
        example.pushFront("a");
        example.pushBack("b");
        example2.pushFront("s");
        example2.pushFront("d");
        example2.pushFront("a");
        example2.pushBack("b");
        example.sort();
        example2.sort();
        List tmps = List.merge(example,example2);
        String tmp = tmps.onFront();
        while(tmp!=null)
        {
            System.out.println(tmp);
            tmps.popFront();
            tmp = tmps.onFront();
        }
        tmps.clear();

    }
}
