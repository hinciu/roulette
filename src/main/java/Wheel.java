import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Wheel {

    private List<Integer> numberSequence = Arrays.asList(0,32,15,19,4,21,2,25,17,34,6,27,13,36,11,30,8,23,10,5,24,16,33,1,20,14,31,9,22,18,29,7,28,12,35,3,26);

    public int spinWheel(){
        Random r = new Random();
        int randomIndex = r.nextInt(numberSequence.size());
        return numberSequence.get(randomIndex);
    }
}
