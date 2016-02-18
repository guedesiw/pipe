package pipe;

import java.util.ArrayList;

public class NumToPipe {

    private ArrayList<Integer> list;

    public ArrayList<Integer> convertNumToPipe(ArrayList pipe) {
        int a = 0;
        this.list = new ArrayList();
        while (pipe.get(a) != null) {
            switch ((int) pipe.get(a)) {
                case 0:
                    this.list.add(011202011);
                case 1:
                    this.list.add(000000011);
                case 2:
                    this.list.add(001222010);
                case 3:
                    this.list.add(000222011);
                case 4:
                    this.list.add(010020011);
                case 5:
                    this.list.add(010222001);
                case 6:
                    this.list.add(011222001);
                case 7:
                    this.list.add(000200011);
                case 8:
                    this.list.add(011222011);
                case 9:
                    this.list.add(010222011);
            }
        }
        return this.list;
    }
}
